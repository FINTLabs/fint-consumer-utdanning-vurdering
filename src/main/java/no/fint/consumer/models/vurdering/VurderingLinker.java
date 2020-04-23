package no.fint.consumer.models.vurdering;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.vurdering.VurderingResource;
import no.fint.model.resource.utdanning.vurdering.VurderingResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        return getAllSelfHrefs(vurdering).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(VurderingResource vurdering) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(vurdering.getSystemId()) && !isEmpty(vurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(vurdering.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(VurderingResource vurdering) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(vurdering.getSystemId()) && !isEmpty(vurdering.getSystemId().getIdentifikatorverdi())) {
            builder.add(vurdering.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

