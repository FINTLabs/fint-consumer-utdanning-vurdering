package no.novari.fint.consumer.config;

import java.util.Map;
import com.google.common.collect.ImmutableMap;
import no.novari.fint.consumer.utils.RestEndpoints;
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
            .put("no.novari.fint.model.utdanning.kodeverk.Skolear", "/model/utdanning/kodeverk/skolear")
            .put("no.novari.fint.model.utdanning.timeplan.Eksamen", "/model/utdanning/timeplan/eksamen")
            .put("no.novari.fint.model.utdanning.timeplan.Fag", "/model/utdanning/timeplan/fag")
            .put("no.novari.fint.model.utdanning.utdanningsprogram.Skole", "/model/utdanning/utdanningsprogram/skole")
            .put("no.novari.fint.model.utdanning.kodeverk.Termin", "/model/utdanning/kodeverk/termin")
            .put("no.novari.fint.model.utdanning.kodeverk.Eksamensform", "/model/utdanning/kodeverk/eksamensform")
            .put("no.novari.fint.model.utdanning.elev.Undervisningsforhold", "/model/utdanning/elev/undervisningsforhold")
            .put("no.novari.fint.model.felles.kodeverk.Fylke", "/model/felles/kodeverk/fylke")
            .put("no.novari.fint.model.utdanning.elev.Elevforhold", "/model/utdanning/elev/elevforhold")
            .put("no.novari.fint.model.utdanning.kodeverk.Karakterstatus", "/model/utdanning/kodeverk/karakterstatus")
            .put("no.novari.fint.model.utdanning.kodeverk.Betalingsstatus", "/model/utdanning/kodeverk/betalingsstatus")
            .put("no.novari.fint.model.utdanning.kodeverk.Vitnemalsmerknad", "/model/utdanning/kodeverk/vitnemalsmerknad")
            .put("no.novari.fint.model.utdanning.elev.Skoleressurs", "/model/utdanning/elev/skoleressurs")
            .put("no.novari.fint.model.utdanning.timeplan.Faggruppe", "/model/utdanning/timeplan/faggruppe")
            .put("no.novari.fint.model.utdanning.timeplan.Undervisningsgruppe", "/model/utdanning/timeplan/undervisningsgruppe")
            .put("no.novari.fint.model.utdanning.kodeverk.Fravarstype", "/model/utdanning/kodeverk/fravarstype")
            .put("no.novari.fint.model.utdanning.kodeverk.Karakterskala", "/model/utdanning/kodeverk/karakterskala")
            /* .put(TODO,TODO) */
            .build();
    }

}
