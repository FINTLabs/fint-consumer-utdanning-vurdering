package no.fint.consumer.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ConsumerProps {
    
    @Value("${fint.consumer.override-org-id:false}")
    private boolean overrideOrgId;

    @Value("${fint.consumer.default-client:FINT}")
    private String defaultClient;

    @Value("${fint.consumer.default-org-id:fint.no}")
    private String defaultOrgId;
    
    @Value("${fint.events.orgIds:fint.no}")
    private String[] orgs;

    
    public static final String CACHE_INITIALDELAY_EKSAMENSGRUPPE = "${fint.consumer.cache.initialDelay.eksamensgruppe:60000}";
    public static final String CACHE_FIXEDRATE_EKSAMENSGRUPPE = "${fint.consumer.cache.fixedRate.eksamensgruppe:900000}";
    
    public static final String CACHE_INITIALDELAY_KARAKTERVERDI = "${fint.consumer.cache.initialDelay.karakterverdi:70000}";
    public static final String CACHE_FIXEDRATE_KARAKTERVERDI = "${fint.consumer.cache.fixedRate.karakterverdi:900000}";
    

}
