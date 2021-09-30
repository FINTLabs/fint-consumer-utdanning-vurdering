package no.fint.consumer.models.sluttfagvurdering;

import no.fint.model.resource.utdanning.vurdering.SluttfagvurderingResource;
import no.fint.model.resource.utdanning.vurdering.SluttfagvurderingResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class SluttfagvurderingLinker extends FintLinker<SluttfagvurderingResource> {

    public SluttfagvurderingLinker() {
        super(SluttfagvurderingResource.class);
    }

    public void mapLinks(SluttfagvurderingResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public SluttfagvurderingResources toResources(Collection<SluttfagvurderingResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public SluttfagvurderingResources toResources(Stream<SluttfagvurderingResource> stream, int offset, int size, int totalItems) {
        SluttfagvurderingResources resources = new SluttfagvurderingResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(SluttfagvurderingResource sluttfagvurdering) {
        return getAllSelfHrefs(sluttfagvurdering).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(SluttfagvurderingResource sluttfagvurdering) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(sluttfagvurdering.getSystemId()) && !isEmpty(sluttfagvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(sluttfagvurdering.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(SluttfagvurderingResource sluttfagvurdering) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(sluttfagvurdering.getSystemId()) && !isEmpty(sluttfagvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(sluttfagvurdering.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

