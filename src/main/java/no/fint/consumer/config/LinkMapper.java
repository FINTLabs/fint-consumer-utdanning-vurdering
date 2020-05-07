package no.fint.consumer.config;

import com.google.common.collect.ImmutableMap;
import no.fint.consumer.utils.RestEndpoints;
import no.fint.model.utdanning.elev.Elevforhold;
import no.fint.model.utdanning.elev.Undervisningsforhold;
import no.fint.model.utdanning.kodeverk.Karakterskala;
import no.fint.model.utdanning.kodeverk.Skolear;
import no.fint.model.utdanning.kodeverk.Termin;
import no.fint.model.utdanning.timeplan.Fag;
import no.fint.model.utdanning.timeplan.Undervisningsgruppe;
import no.fint.model.utdanning.utdanningsprogram.Skole;
import no.fint.model.utdanning.vurdering.*;

import java.util.Map;

public class LinkMapper {

    public static Map<String, String> linkMapper(String contextPath) {
        return ImmutableMap.<String, String>builder()
                .put(Eksamensgruppe.class.getName(), contextPath + RestEndpoints.EKSAMENSGRUPPE)
                .put(Eksamensgruppemedlemskap.class.getName(), contextPath + RestEndpoints.EKSAMENSGRUPPEMEDLEMSKAP)
                .put(Fravar.class.getName(), contextPath + RestEndpoints.FRAVAR)
                .put(Karakterverdi.class.getName(), contextPath + RestEndpoints.KARAKTERVERDI)
                .put(Vurdering.class.getName(), contextPath + RestEndpoints.VURDERING)
                .put(Karakterskala.class.getName(), "/utdanning/kodeverk/karakterskala")
                .put(Skolear.class.getName(), "/utdanning/kodeverk/skolear")
                .put(Termin.class.getName(), "/utdanning/kodeverk/termin")
                .put(Elevforhold.class.getName(), "/utdanning/elev/elevforhold")
                .put(Undervisningsforhold.class.getName(), "/utdanning/elev/undervisningsforhold")
                .put(Fag.class.getName(), "/utdanning/timeplan/fag")
                .put(Undervisningsgruppe.class.getName(), "/utdanning/timeplan/undervisningsgruppe")
                .put(Skole.class.getName(), "/utdanning/utdanningsprogram/skole")
                .build();
    }

}

