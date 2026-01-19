package no.novari.fint.consumer.models.eksamensgruppemedlemskap;

import no.novari.fint.model.resource.utdanning.vurdering.EksamensgruppemedlemskapResource;
import no.novari.fint.model.resource.utdanning.vurdering.EksamensgruppemedlemskapResources;
import no.novari.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class EksamensgruppemedlemskapLinker extends FintLinker<EksamensgruppemedlemskapResource> {

    public EksamensgruppemedlemskapLinker() {
        super(EksamensgruppemedlemskapResource.class);
    }

    public void mapLinks(EksamensgruppemedlemskapResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public EksamensgruppemedlemskapResources toResources(Collection<EksamensgruppemedlemskapResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public EksamensgruppemedlemskapResources toResources(Stream<EksamensgruppemedlemskapResource> stream, int offset, int size, int totalItems) {
        EksamensgruppemedlemskapResources resources = new EksamensgruppemedlemskapResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(EksamensgruppemedlemskapResource eksamensgruppemedlemskap) {
        return getAllSelfHrefs(eksamensgruppemedlemskap).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(EksamensgruppemedlemskapResource eksamensgruppemedlemskap) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(eksamensgruppemedlemskap.getSystemId()) && !isEmpty(eksamensgruppemedlemskap.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(eksamensgruppemedlemskap.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(EksamensgruppemedlemskapResource eksamensgruppemedlemskap) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(eksamensgruppemedlemskap.getSystemId()) && !isEmpty(eksamensgruppemedlemskap.getSystemId().getIdentifikatorverdi())) {
            builder.add(eksamensgruppemedlemskap.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

