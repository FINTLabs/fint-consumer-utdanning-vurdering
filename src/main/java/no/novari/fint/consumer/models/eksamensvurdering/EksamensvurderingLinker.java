package no.novari.fint.consumer.models.eksamensvurdering;

import no.novari.fint.model.resource.utdanning.vurdering.EksamensvurderingResource;
import no.novari.fint.model.resource.utdanning.vurdering.EksamensvurderingResources;
import no.novari.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class EksamensvurderingLinker extends FintLinker<EksamensvurderingResource> {

    public EksamensvurderingLinker() {
        super(EksamensvurderingResource.class);
    }

    public void mapLinks(EksamensvurderingResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public EksamensvurderingResources toResources(Collection<EksamensvurderingResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public EksamensvurderingResources toResources(Stream<EksamensvurderingResource> stream, int offset, int size, int totalItems) {
        EksamensvurderingResources resources = new EksamensvurderingResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(EksamensvurderingResource eksamensvurdering) {
        return getAllSelfHrefs(eksamensvurdering).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(EksamensvurderingResource eksamensvurdering) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(eksamensvurdering.getSystemId()) && !isEmpty(eksamensvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(eksamensvurdering.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(EksamensvurderingResource eksamensvurdering) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(eksamensvurdering.getSystemId()) && !isEmpty(eksamensvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(eksamensvurdering.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

