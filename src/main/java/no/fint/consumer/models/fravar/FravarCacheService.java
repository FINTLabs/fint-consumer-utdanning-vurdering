package no.fint.consumer.models.fravar;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import no.fint.cache.CacheService;
import no.fint.cache.model.CacheObject;
import no.fint.consumer.config.Constants;
import no.fint.consumer.config.ConsumerProps;
import no.fint.consumer.event.ConsumerEventUtil;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.utdanning.vurdering.FravarResource;
import no.fint.model.utdanning.vurdering.Fravar;
import no.fint.model.utdanning.vurdering.VurderingActions;
import no.fint.relations.FintResourceCompatibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
@Service
@ConditionalOnProperty(name = "fint.consumer.cache.disabled.fravar", havingValue = "false", matchIfMissing = true)
public class FravarCacheService extends CacheService<FravarResource> {

    public static final String MODEL = Fravar.class.getSimpleName().toLowerCase();

    @Value("${fint.consumer.compatibility.fintresource:true}")
    private boolean checkFintResourceCompatibility;

    @Autowired
    private FintResourceCompatibility fintResourceCompatibility;

    @Autowired
    private ConsumerEventUtil consumerEventUtil;

    @Autowired
    private ConsumerProps props;

    @Autowired
    private FravarLinker linker;

    private JavaType javaType;

    private ObjectMapper objectMapper;

    public FravarCacheService() {
        super(MODEL, VurderingActions.GET_ALL_FRAVAR, VurderingActions.UPDATE_FRAVAR);
        objectMapper = new ObjectMapper();
        javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, FravarResource.class);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    @PostConstruct
    public void init() {
        props.getAssets().forEach(this::createCache);
    }

    @Scheduled(cron = Constants.CACHE_CRON_FRAVAR)
    public void populateCacheAll() {
        Executors.newSingleThreadExecutor()
                .execute(() -> props.getAssets().forEach(asset -> {
                    populateCache(asset);
                    try {
                        Duration duration = Duration.ofMillis(props.getEventWaitFravar());
                        log.info("Waiting for {} minutes and {} seconds before populating cache for next asset. If this is the last asset nothing more will happen until a new schedule 🏁",
                                duration.toMinutes(),
                                duration.minusMinutes(duration.toMinutes()).getSeconds()
                        );
                        Thread.sleep(props.getEventWaitFravar());
                    } catch (InterruptedException e) {
                        log.warn(e.getMessage());
                    }
                }));
    }

    public void rebuildCache(String orgId) {
        flush(orgId);
        populateCache(orgId);
    }

    @Override
    public void populateCache(String orgId) {
        log.info("Populating Fravar has been disabled due to large volumn of data and that it is obsolete ({})", orgId);
        //	log.info("Populating Fravar cache for {}", orgId);
        //  Event event = new Event(orgId, Constants.COMPONENT, VurderingActions.GET_ALL_FRAVAR, Constants.CACHE_SERVICE);
        //  consumerEventUtil.send(event);
    }


    public Optional<FravarResource> getFravarBySystemId(String orgId, String systemId) {
        return getOne(orgId, systemId.hashCode(),
                (resource) -> Optional
                        .ofNullable(resource)
                        .map(FravarResource::getSystemId)
                        .map(Identifikator::getIdentifikatorverdi)
                        .map(systemId::equals)
                        .orElse(false));
    }


    @Override
    public void onAction(Event event) {
        List<FravarResource> data;
        if (checkFintResourceCompatibility && fintResourceCompatibility.isFintResourceData(event.getData())) {
            log.info("Compatibility: Converting FintResource<FravarResource> to FravarResource ...");
            data = fintResourceCompatibility.convertResourceData(event.getData(), FravarResource.class);
        } else {
            data = objectMapper.convertValue(event.getData(), javaType);
        }
        data.forEach(resource -> {
            linker.mapLinks(resource);
            linker.resetSelfLinks(resource);
        });
        if (VurderingActions.valueOf(event.getAction()) == VurderingActions.UPDATE_FRAVAR) {
            if (event.getResponseStatus() == ResponseStatus.ACCEPTED || event.getResponseStatus() == ResponseStatus.CONFLICT) {
                List<CacheObject<FravarResource>> cacheObjects = data
                        .stream()
                        .map(i -> new CacheObject<>(i, linker.hashCodes(i)))
                        .collect(Collectors.toList());
                addCache(event.getOrgId(), cacheObjects);
                log.info("Added {} cache objects to cache for {}", cacheObjects.size(), event.getOrgId());
            } else {
                log.debug("Ignoring payload for {} with response status {}", event.getOrgId(), event.getResponseStatus());
            }
        } else {
            List<CacheObject<FravarResource>> cacheObjects = data
                    .stream()
                    .map(i -> new CacheObject<>(i, linker.hashCodes(i)))
                    .collect(Collectors.toList());
            updateCache(event.getOrgId(), cacheObjects);
            log.info("Updated cache for {} with {} cache objects", event.getOrgId(), cacheObjects.size());
        }
    }
}