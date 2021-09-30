package no.fint.consumer.models.sluttordensvurdering;

import no.fint.model.resource.utdanning.vurdering.SluttordensvurderingResource;
import no.fint.model.resource.utdanning.vurdering.SluttordensvurderingResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class SluttordensvurderingLinker extends FintLinker<SluttordensvurderingResource> {

    public SluttordensvurderingLinker() {
        super(SluttordensvurderingResource.class);
    }

    public void mapLinks(SluttordensvurderingResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public SluttordensvurderingResources toResources(Collection<SluttordensvurderingResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public SluttordensvurderingResources toResources(Stream<SluttordensvurderingResource> stream, int offset, int size, int totalItems) {
        SluttordensvurderingResources resources = new SluttordensvurderingResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(SluttordensvurderingResource sluttordensvurdering) {
        return getAllSelfHrefs(sluttordensvurdering).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(SluttordensvurderingResource sluttordensvurdering) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(sluttordensvurdering.getSystemId()) && !isEmpty(sluttordensvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(sluttordensvurdering.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(SluttordensvurderingResource sluttordensvurdering) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(sluttordensvurdering.getSystemId()) && !isEmpty(sluttordensvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(sluttordensvurdering.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

