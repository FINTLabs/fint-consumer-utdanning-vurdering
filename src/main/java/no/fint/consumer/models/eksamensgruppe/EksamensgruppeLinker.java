package no.fint.consumer.models.eksamensgruppe;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.vurdering.EksamensgruppeResource;
import no.fint.model.resource.utdanning.vurdering.EksamensgruppeResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;

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
        if (!isNull(eksamensgruppe.getSystemId()) && !isEmpty(eksamensgruppe.getSystemId().getIdentifikatorverdi())) {
            return createHrefWithId(eksamensgruppe.getSystemId().getIdentifikatorverdi(), "systemid");
        }
        
        return null;
    }
    
}

