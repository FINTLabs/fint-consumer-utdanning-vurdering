package no.fint.consumer.models.eksamensgruppemedlemskap;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.vurdering.EksamensgruppemedlemskapResource;
import no.fint.model.resource.utdanning.vurdering.EksamensgruppemedlemskapResources;
import no.fint.relations.FintLinker;
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
        EksamensgruppemedlemskapResources resources = new EksamensgruppemedlemskapResources();
        collection.stream().map(this::toResource).forEach(resources::addResource);
        resources.addSelf(Link.with(self()));
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

