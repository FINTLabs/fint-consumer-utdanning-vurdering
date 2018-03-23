package no.fint.consumer.models.eksamensgruppe;

import no.fint.model.utdanning.vurdering.Eksamensgruppe;
import no.fint.model.relation.FintResource;
import no.fint.relations.FintResourceAssembler;
import no.fint.relations.FintResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class EksamensgruppeAssembler extends FintResourceAssembler<Eksamensgruppe> {

    public EksamensgruppeAssembler() {
        super(EksamensgruppeController.class);
    }


    @Override
    public FintResourceSupport assemble(Eksamensgruppe eksamensgruppe , FintResource<Eksamensgruppe> fintResource) {
        return createResourceWithId(eksamensgruppe.getSystemId().getIdentifikatorverdi(), fintResource, "systemid");
    }
    
    
    
}

