package no.fint.consumer.config;

import no.fint.consumer.utils.RestEndpoints;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

import no.fint.model.utdanning.vurdering.*;

public class LinkMapper {

    public static Map<String, String> linkMapper(String contextPath) {
        return ImmutableMap.<String,String>builder()
            .put(Eksamensgruppe.class.getName(), contextPath + RestEndpoints.EKSAMENSGRUPPE)
            .put(Eksamensgruppemedlemskap.class.getName(), contextPath + RestEndpoints.EKSAMENSGRUPPEMEDLEMSKAP)
            .put(Fravar.class.getName(), contextPath + RestEndpoints.FRAVAR)
            .put(Karakterverdi.class.getName(), contextPath + RestEndpoints.KARAKTERVERDI)
            .put(Vurdering.class.getName(), contextPath + RestEndpoints.VURDERING)
            .put("no.fint.model.utdanning.elev.Elevforhold", "/utdanning/elev/elevforhold")
            .put("no.fint.model.utdanning.timeplan.Fag", "/utdanning/timeplan/fag")
            .put("no.fint.model.utdanning.utdanningsprogram.Skole", "/utdanning/utdanningsprogram/skole")
            .put("no.fint.model.utdanning.kodeverk.Termin", "/utdanning/kodeverk/termin")
            .put("no.fint.model.utdanning.kodeverk.Skolear", "/utdanning/kodeverk/skolear")
            .put("no.fint.model.utdanning.elev.Undervisningsforhold", "/utdanning/elev/undervisningsforhold")
            .put("no.fint.model.utdanning.elev.Medlemskap", "/utdanning/elev/medlemskap")
            .put("no.fint.model.utdanning.timeplan.Undervisningsgruppe", "/utdanning/timeplan/undervisningsgruppe")
            .put("no.fint.model.utdanning.kodeverk.Fravarstype", "/utdanning/kodeverk/fravarstype")
            .put("no.fint.model.utdanning.kodeverk.Karakterskala", "/utdanning/kodeverk/karakterskala")
            /* .put(TODO,TODO) */
            .build();
    }

}
