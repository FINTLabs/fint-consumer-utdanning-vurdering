package no.fint.consumer.models.vurdering;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.vurdering.VurderingResource;
import no.fint.model.resource.utdanning.vurdering.VurderingResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;


@Component
public class VurderingLinker extends FintLinker<VurderingResource> {

    public VurderingLinker() {
        super(VurderingResource.class);
    }

    public void mapLinks(VurderingResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public VurderingResources toResources(Collection<VurderingResource> collection) {
        VurderingResources resources = new VurderingResources();
        collection.stream().map(this::toResource).forEach(resources::addResource);
        resources.addSelf(Link.with(self()));
        return resources;
    }

    @Override
    public String getSelfHref(VurderingResource vurdering) {
        if (!isNull(vurdering.getSystemId()) && !isEmpty(vurdering.getSystemId().getIdentifikatorverdi())) {
            return createHrefWithId(vurdering.getSystemId().getIdentifikatorverdi(), "systemid");
        }
        
        return null;
    }
    
}

