package no.fint.consumer.models.halvarsfagvurdering;

import no.fint.model.resource.utdanning.vurdering.HalvarsfagvurderingResource;
import no.fint.model.resource.utdanning.vurdering.HalvarsfagvurderingResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class HalvarsfagvurderingLinker extends FintLinker<HalvarsfagvurderingResource> {

    public HalvarsfagvurderingLinker() {
        super(HalvarsfagvurderingResource.class);
    }

    public void mapLinks(HalvarsfagvurderingResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public HalvarsfagvurderingResources toResources(Collection<HalvarsfagvurderingResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public HalvarsfagvurderingResources toResources(Stream<HalvarsfagvurderingResource> stream, int offset, int size, int totalItems) {
        HalvarsfagvurderingResources resources = new HalvarsfagvurderingResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(HalvarsfagvurderingResource halvarsfagvurdering) {
        return getAllSelfHrefs(halvarsfagvurdering).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(HalvarsfagvurderingResource halvarsfagvurdering) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(halvarsfagvurdering.getSystemId()) && !isEmpty(halvarsfagvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(halvarsfagvurdering.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(HalvarsfagvurderingResource halvarsfagvurdering) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(halvarsfagvurdering.getSystemId()) && !isEmpty(halvarsfagvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(halvarsfagvurdering.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

