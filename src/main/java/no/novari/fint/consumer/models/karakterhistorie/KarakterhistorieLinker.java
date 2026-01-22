package no.novari.fint.consumer.models.karakterhistorie;

import no.novari.fint.model.resource.utdanning.vurdering.KarakterhistorieResource;
import no.novari.fint.model.resource.utdanning.vurdering.KarakterhistorieResources;
import no.novari.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class KarakterhistorieLinker extends FintLinker<KarakterhistorieResource> {

    public KarakterhistorieLinker() {
        super(KarakterhistorieResource.class);
    }

    public void mapLinks(KarakterhistorieResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public KarakterhistorieResources toResources(Collection<KarakterhistorieResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public KarakterhistorieResources toResources(Stream<KarakterhistorieResource> stream, int offset, int size, int totalItems) {
        KarakterhistorieResources resources = new KarakterhistorieResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(KarakterhistorieResource karakterhistorie) {
        return getAllSelfHrefs(karakterhistorie).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(KarakterhistorieResource karakterhistorie) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(karakterhistorie.getSystemId()) && !isEmpty(karakterhistorie.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(karakterhistorie.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(KarakterhistorieResource karakterhistorie) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(karakterhistorie.getSystemId()) && !isEmpty(karakterhistorie.getSystemId().getIdentifikatorverdi())) {
            builder.add(karakterhistorie.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

