package no.novari.fint.consumer.models.fravarsregistrering;

import no.novari.fint.model.resource.utdanning.vurdering.FravarsregistreringResource;
import no.novari.fint.model.resource.utdanning.vurdering.FravarsregistreringResources;
import no.novari.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class FravarsregistreringLinker extends FintLinker<FravarsregistreringResource> {

    public FravarsregistreringLinker() {
        super(FravarsregistreringResource.class);
    }

    public void mapLinks(FravarsregistreringResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public FravarsregistreringResources toResources(Collection<FravarsregistreringResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public FravarsregistreringResources toResources(Stream<FravarsregistreringResource> stream, int offset, int size, int totalItems) {
        FravarsregistreringResources resources = new FravarsregistreringResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(FravarsregistreringResource fravarsregistrering) {
        return getAllSelfHrefs(fravarsregistrering).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(FravarsregistreringResource fravarsregistrering) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(fravarsregistrering.getSystemId()) && !isEmpty(fravarsregistrering.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(fravarsregistrering.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(FravarsregistreringResource fravarsregistrering) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(fravarsregistrering.getSystemId()) && !isEmpty(fravarsregistrering.getSystemId().getIdentifikatorverdi())) {
            builder.add(fravarsregistrering.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

