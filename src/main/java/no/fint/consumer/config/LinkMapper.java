package no.fint.consumer.config;

import no.fint.consumer.utils.RestEndpoints;
import java.util.Map;
import com.google.common.collect.ImmutableMap;
import no.novari.fint.model.utdanning.vurdering.Anmerkninger;
import no.novari.fint.model.utdanning.vurdering.Eksamensgruppe;
import no.novari.fint.model.utdanning.vurdering.Eksamensgruppemedlemskap;
import no.novari.fint.model.utdanning.vurdering.Eksamensvurdering;
import no.novari.fint.model.utdanning.vurdering.Elevfravar;
import no.novari.fint.model.utdanning.vurdering.Elevvurdering;
import no.novari.fint.model.utdanning.vurdering.Fravarsoversikt;
import no.novari.fint.model.utdanning.vurdering.Fravarsregistrering;
import no.novari.fint.model.utdanning.vurdering.Halvarsfagvurdering;
import no.novari.fint.model.utdanning.vurdering.Halvarsordensvurdering;
import no.novari.fint.model.utdanning.vurdering.Karakterhistorie;
import no.novari.fint.model.utdanning.vurdering.Karakterverdi;
import no.novari.fint.model.utdanning.vurdering.Sensor;
import no.novari.fint.model.utdanning.vurdering.Sluttfagvurdering;
import no.novari.fint.model.utdanning.vurdering.Sluttordensvurdering;
import no.novari.fint.model.utdanning.vurdering.Underveisfagvurdering;
import no.novari.fint.model.utdanning.vurdering.Underveisordensvurdering;

public class LinkMapper {

    public static Map<String, String> linkMapper(String contextPath) {
        return ImmutableMap.<String,String>builder()
            .put(Anmerkninger.class.getName(), contextPath + RestEndpoints.ANMERKNINGER)
            .put(Eksamensgruppe.class.getName(), contextPath + RestEndpoints.EKSAMENSGRUPPE)
            .put(Eksamensgruppemedlemskap.class.getName(), contextPath + RestEndpoints.EKSAMENSGRUPPEMEDLEMSKAP)
            .put(Eksamensvurdering.class.getName(), contextPath + RestEndpoints.EKSAMENSVURDERING)
            .put(Elevfravar.class.getName(), contextPath + RestEndpoints.ELEVFRAVAR)
            .put(Elevvurdering.class.getName(), contextPath + RestEndpoints.ELEVVURDERING)
            .put(Fravarsoversikt.class.getName(), contextPath + RestEndpoints.FRAVARSOVERSIKT)
            .put(Fravarsregistrering.class.getName(), contextPath + RestEndpoints.FRAVARSREGISTRERING)
            .put(Halvarsfagvurdering.class.getName(), contextPath + RestEndpoints.HALVARSFAGVURDERING)
            .put(Halvarsordensvurdering.class.getName(), contextPath + RestEndpoints.HALVARSORDENSVURDERING)
            .put(Karakterhistorie.class.getName(), contextPath + RestEndpoints.KARAKTERHISTORIE)
            .put(Karakterverdi.class.getName(), contextPath + RestEndpoints.KARAKTERVERDI)
            .put(Sensor.class.getName(), contextPath + RestEndpoints.SENSOR)
            .put(Sluttfagvurdering.class.getName(), contextPath + RestEndpoints.SLUTTFAGVURDERING)
            .put(Sluttordensvurdering.class.getName(), contextPath + RestEndpoints.SLUTTORDENSVURDERING)
            .put(Underveisfagvurdering.class.getName(), contextPath + RestEndpoints.UNDERVEISFAGVURDERING)
            .put(Underveisordensvurdering.class.getName(), contextPath + RestEndpoints.UNDERVEISORDENSVURDERING)
            .put("no.novari.fint.model.utdanning.kodeverk.Skolear", "/utdanning/kodeverk/skolear")
            .put("no.novari.fint.model.utdanning.elev.Undervisningsforhold", "/utdanning/elev/undervisningsforhold")
            .put("no.novari.fint.model.utdanning.timeplan.Eksamen", "/utdanning/timeplan/eksamen")
            .put("no.novari.fint.model.utdanning.timeplan.Fag", "/utdanning/timeplan/fag")
            .put("no.novari.fint.model.utdanning.utdanningsprogram.Skole", "/utdanning/utdanningsprogram/skole")
            .put("no.novari.fint.model.utdanning.kodeverk.Termin", "/utdanning/kodeverk/termin")
            .put("no.novari.fint.model.utdanning.kodeverk.Eksamensform", "/utdanning/kodeverk/eksamensform")
            .put("no.novari.fint.model.felles.kodeverk.Fylke", "/felles/kodeverk/fylke")
            .put("no.novari.fint.model.utdanning.elev.Elevforhold", "/utdanning/elev/elevforhold")
            .put("no.novari.fint.model.utdanning.kodeverk.Karakterstatus", "/utdanning/kodeverk/karakterstatus")
            .put("no.novari.fint.model.utdanning.kodeverk.Betalingsstatus", "/utdanning/kodeverk/betalingsstatus")
            .put("no.novari.fint.model.utdanning.kodeverk.Vitnemalsmerknad", "/utdanning/kodeverk/vitnemalsmerknad")
            .put("no.novari.fint.model.utdanning.elev.Skoleressurs", "/utdanning/elev/skoleressurs")
            .put("no.novari.fint.model.utdanning.timeplan.Faggruppe", "/utdanning/timeplan/faggruppe")
            .put("no.novari.fint.model.utdanning.timeplan.Undervisningsgruppe", "/utdanning/timeplan/undervisningsgruppe")
            .put("no.novari.fint.model.utdanning.kodeverk.Fravarstype", "/utdanning/kodeverk/fravarstype")
            .put("no.novari.fint.model.utdanning.kodeverk.Karakterskala", "/utdanning/kodeverk/karakterskala")
            /* .put(TODO,TODO) */
            .build();
    }

}
