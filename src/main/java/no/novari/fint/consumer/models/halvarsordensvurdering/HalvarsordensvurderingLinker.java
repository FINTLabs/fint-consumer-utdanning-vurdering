package no.novari.fint.consumer.models.halvarsordensvurdering;

import no.novari.fint.model.resource.utdanning.vurdering.HalvarsordensvurderingResource;
import no.novari.fint.model.resource.utdanning.vurdering.HalvarsordensvurderingResources;
import no.novari.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class HalvarsordensvurderingLinker extends FintLinker<HalvarsordensvurderingResource> {

    public HalvarsordensvurderingLinker() {
        super(HalvarsordensvurderingResource.class);
    }

    public void mapLinks(HalvarsordensvurderingResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public HalvarsordensvurderingResources toResources(Collection<HalvarsordensvurderingResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public HalvarsordensvurderingResources toResources(Stream<HalvarsordensvurderingResource> stream, int offset, int size, int totalItems) {
        HalvarsordensvurderingResources resources = new HalvarsordensvurderingResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(HalvarsordensvurderingResource halvarsordensvurdering) {
        return getAllSelfHrefs(halvarsordensvurdering).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(HalvarsordensvurderingResource halvarsordensvurdering) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(halvarsordensvurdering.getSystemId()) && !isEmpty(halvarsordensvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(halvarsordensvurdering.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(HalvarsordensvurderingResource halvarsordensvurdering) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(halvarsordensvurdering.getSystemId()) && !isEmpty(halvarsordensvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(halvarsordensvurdering.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

