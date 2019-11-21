package no.fint.consumer.models.karakterverdi;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.vurdering.KarakterverdiResource;
import no.fint.model.resource.utdanning.vurdering.KarakterverdiResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;


@Component
public class KarakterverdiLinker extends FintLinker<KarakterverdiResource> {

    public KarakterverdiLinker() {
        super(KarakterverdiResource.class);
    }

    public void mapLinks(KarakterverdiResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public KarakterverdiResources toResources(Collection<KarakterverdiResource> collection) {
        KarakterverdiResources resources = new KarakterverdiResources();
        collection.stream().map(this::toResource).forEach(resources::addResource);
        resources.addSelf(Link.with(self()));
        return resources;
    }

    @Override
    public String getSelfHref(KarakterverdiResource karakterverdi) {
        if (!isNull(karakterverdi.getSystemId()) && !isEmpty(karakterverdi.getSystemId().getIdentifikatorverdi())) {
            return createHrefWithId(karakterverdi.getSystemId().getIdentifikatorverdi(), "systemid");
        }
        
        return null;
    }

    int[] hashCodes(KarakterverdiResource karakterverdi) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(karakterverdi.getSystemId()) && !isEmpty(karakterverdi.getSystemId().getIdentifikatorverdi())) {
            builder.add(karakterverdi.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

