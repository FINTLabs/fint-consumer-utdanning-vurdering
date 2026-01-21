package no.fint.consumer.models.elevvurdering;

import no.novari.fint.model.resource.utdanning.vurdering.ElevvurderingResource;
import no.novari.fint.model.resource.utdanning.vurdering.ElevvurderingResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class ElevvurderingLinker extends FintLinker<ElevvurderingResource> {

    public ElevvurderingLinker() {
        super(ElevvurderingResource.class);
    }

    public void mapLinks(ElevvurderingResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public ElevvurderingResources toResources(Collection<ElevvurderingResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public ElevvurderingResources toResources(Stream<ElevvurderingResource> stream, int offset, int size, int totalItems) {
        ElevvurderingResources resources = new ElevvurderingResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(ElevvurderingResource elevvurdering) {
        return getAllSelfHrefs(elevvurdering).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(ElevvurderingResource elevvurdering) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(elevvurdering.getSystemId()) && !isEmpty(elevvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(elevvurdering.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(ElevvurderingResource elevvurdering) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(elevvurdering.getSystemId()) && !isEmpty(elevvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(elevvurdering.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

