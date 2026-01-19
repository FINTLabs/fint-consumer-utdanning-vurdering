package no.novari.fint.consumer.models.underveisordensvurdering;

import no.novari.fint.model.resource.utdanning.vurdering.UnderveisordensvurderingResource;
import no.novari.fint.model.resource.utdanning.vurdering.UnderveisordensvurderingResources;
import no.novari.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class UnderveisordensvurderingLinker extends FintLinker<UnderveisordensvurderingResource> {

    public UnderveisordensvurderingLinker() {
        super(UnderveisordensvurderingResource.class);
    }

    public void mapLinks(UnderveisordensvurderingResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public UnderveisordensvurderingResources toResources(Collection<UnderveisordensvurderingResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public UnderveisordensvurderingResources toResources(Stream<UnderveisordensvurderingResource> stream, int offset, int size, int totalItems) {
        UnderveisordensvurderingResources resources = new UnderveisordensvurderingResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(UnderveisordensvurderingResource underveisordensvurdering) {
        return getAllSelfHrefs(underveisordensvurdering).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(UnderveisordensvurderingResource underveisordensvurdering) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(underveisordensvurdering.getSystemId()) && !isEmpty(underveisordensvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(underveisordensvurdering.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(UnderveisordensvurderingResource underveisordensvurdering) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(underveisordensvurdering.getSystemId()) && !isEmpty(underveisordensvurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(underveisordensvurdering.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

