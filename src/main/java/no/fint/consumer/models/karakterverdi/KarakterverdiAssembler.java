package no.fint.consumer.models.karakterverdi;

import no.fint.model.utdanning.vurdering.Karakterverdi;
import no.fint.model.relation.FintResource;
import no.fint.relations.FintResourceAssembler;
import no.fint.relations.FintResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class KarakterverdiAssembler extends FintResourceAssembler<Karakterverdi> {

    public KarakterverdiAssembler() {
        super(KarakterverdiController.class);
    }


    @Override
    public FintResourceSupport assemble(Karakterverdi karakterverdi , FintResource<Karakterverdi> fintResource) {
        return createResourceWithId(karakterverdi.getSystemId().getIdentifikatorverdi(), fintResource, "systemid");
    }
    
    
    
}

