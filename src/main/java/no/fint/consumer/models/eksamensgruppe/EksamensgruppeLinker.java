package no.fint.consumer.models.eksamensgruppe;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.vurdering.EksamensgruppeResource;
import no.fint.model.resource.utdanning.vurdering.EksamensgruppeResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class EksamensgruppeLinker extends FintLinker<EksamensgruppeResource> {

    public EksamensgruppeLinker() {
        super(EksamensgruppeResource.class);
    }

    public void mapLinks(EksamensgruppeResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public EksamensgruppeResources toResources(Collection<EksamensgruppeResource> collection) {
        EksamensgruppeResources resources = new EksamensgruppeResources();
        collection.stream().map(this::toResource).forEach(resources::addResource);
        resources.addSelf(Link.with(self()));
        return resources;
    }

    @Override
    public String getSelfHref(EksamensgruppeResource eksamensgruppe) {
        return getAllSelfHrefs(eksamensgruppe).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(EksamensgruppeResource eksamensgruppe) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(eksamensgruppe.getSystemId()) && !isEmpty(eksamensgruppe.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(eksamensgruppe.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(EksamensgruppeResource eksamensgruppe) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(eksamensgruppe.getSystemId()) && !isEmpty(eksamensgruppe.getSystemId().getIdentifikatorverdi())) {
            builder.add(eksamensgruppe.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

