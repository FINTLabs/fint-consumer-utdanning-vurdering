package no.fint.consumer.models.anmerkninger;

import no.novari.fint.model.resource.utdanning.vurdering.AnmerkningerResource;
import no.novari.fint.model.resource.utdanning.vurdering.AnmerkningerResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class AnmerkningerLinker extends FintLinker<AnmerkningerResource> {

    public AnmerkningerLinker() {
        super(AnmerkningerResource.class);
    }

    public void mapLinks(AnmerkningerResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public AnmerkningerResources toResources(Collection<AnmerkningerResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public AnmerkningerResources toResources(Stream<AnmerkningerResource> stream, int offset, int size, int totalItems) {
        AnmerkningerResources resources = new AnmerkningerResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(AnmerkningerResource anmerkninger) {
        return getAllSelfHrefs(anmerkninger).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(AnmerkningerResource anmerkninger) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(anmerkninger.getSystemId()) && !isEmpty(anmerkninger.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(anmerkninger.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(AnmerkningerResource anmerkninger) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(anmerkninger.getSystemId()) && !isEmpty(anmerkninger.getSystemId().getIdentifikatorverdi())) {
            builder.add(anmerkninger.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

