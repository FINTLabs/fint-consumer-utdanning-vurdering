package no.fint.consumer.models.sensor;

import no.novari.fint.model.resource.utdanning.vurdering.SensorResource;
import no.novari.fint.model.resource.utdanning.vurdering.SensorResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class SensorLinker extends FintLinker<SensorResource> {

    public SensorLinker() {
        super(SensorResource.class);
    }

    public void mapLinks(SensorResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public SensorResources toResources(Collection<SensorResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public SensorResources toResources(Stream<SensorResource> stream, int offset, int size, int totalItems) {
        SensorResources resources = new SensorResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(SensorResource sensor) {
        return getAllSelfHrefs(sensor).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(SensorResource sensor) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(sensor.getSystemId()) && !isEmpty(sensor.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(sensor.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(SensorResource sensor) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(sensor.getSystemId()) && !isEmpty(sensor.getSystemId().getIdentifikatorverdi())) {
            builder.add(sensor.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

