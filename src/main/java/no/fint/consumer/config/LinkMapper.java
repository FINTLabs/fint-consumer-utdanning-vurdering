package no.fint.consumer.config;

import no.fint.consumer.utils.RestEndpoints;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

import no.fint.model.utdanning.elev.Medlemskap;
import no.fint.model.utdanning.kodeverk.Karakterskala;
import no.fint.model.utdanning.timeplan.Fag;

import no.fint.model.utdanning.vurdering.*;
import no.fint.model.felles.*;

public class LinkMapper {

	public static Map<String, String> linkMapper(String contextPath) {
		return ImmutableMap.<String,String>builder()
			.put(Eksamensgruppe.class.getName(), contextPath + RestEndpoints.EKSAMENSGRUPPE)
			.put(Fravar.class.getName(), contextPath + RestEndpoints.FRAVAR)
			.put(Karakterverdi.class.getName(), contextPath + RestEndpoints.KARAKTERVERDI)
			.put(Vurdering.class.getName(), contextPath + RestEndpoints.VURDERING)
            .put(Karakterskala.class.getName(), "/utdanning/kodeverk/karakterskala")
            .put(Medlemskap.class.getName(), "/utdanning/elev/medlemskap")
            .put(Fag.class.getName(), "/utdanning/timeplan/fag")
			.build();
	}

}
