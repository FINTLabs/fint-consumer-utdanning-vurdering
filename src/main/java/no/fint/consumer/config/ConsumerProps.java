package no.fint.consumer.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Component
public class ConsumerProps {

    @Value("${fint.consumer.override-org-id:false}")
    private boolean overrideOrgId;

    @Value("${fint.consumer.default-client:FINT}")
    private String defaultClient;

    @Value("${fint.consumer.default-org-id:fint.no}")
    private String defaultOrgId;

    @Value("${fint.consumer.status.created:false}")
    private boolean useCreated;

    @Value("${fint.consumer.cache.event.wait.elevfravar:600000}")
    private long eventWaitElevfravar;

    @Value("${fint.consumer.cache.event.wait.fravar:600000}")
    private long eventWaitFravar;

    @Value("${fint.consumer.cache.event.wait.fravarsoversikt:600000}")
    private long eventWaitFravarsOversikt;

    @Value("${fint.consumer.cache.event.wait.fravarsregistrering:600000}")
    private long eventWaitFravarsregistrering;

    private Set<String> assets;

    @Autowired
    private void setupOrgs(@Value("${fint.events.orgIds:}") String[] orgs) {
        assets = new HashSet<>(Arrays.asList(orgs));
    }

    public String[] getOrgs() {
        return assets.toArray(new String[0]);
    }

}

