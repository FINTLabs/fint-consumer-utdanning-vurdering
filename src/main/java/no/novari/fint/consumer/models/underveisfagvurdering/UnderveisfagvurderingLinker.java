package no.novari.fint.consumer.models.underveisfagvurdering;

import no.novari.fint.model.resource.utdanning.vurdering.UnderveisfagvurderingResource;
import no.novari.fint.model.resource.utdanning.vurdering.UnderveisfagvurderingResources;
import no.novari.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class UnderveisfagvurderingLinker extends FintLinker<UnderveisfagvurderingResource> {

    public UnderveisfagvurderingLinker() {
        super(UnderveisfagvurderingResource.class);
    }

    public void mapLinks(UnderveisfagvurderingResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public UnderveisfagvurderingResources toResources(Collection<UnderveisfagvurderingResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public UnderveisfagvurderingResources toResources(Stream<UnderveisfagvurderingResource> stream, int offset, int size, int totalItems) {
        UnderveisfagvurderingResources resources = new UnderveisfagvurderingResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(UnderveisfagvurderingResource underveisfagvurdering) {
        return getAllSelfHrefs(underveisfagvurdering).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(UnderveisfagvurderingResource underveisfagvurdering) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(underveisfagvurdering.getSystemId()) && !isEmpty(underveisfagvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(underveisfagvurdering.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(UnderveisfagvurderingResource underveisfagvurdering) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(underveisfagvurdering.getSystemId()) && !isEmpty(underveisfagvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(underveisfagvurdering.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

