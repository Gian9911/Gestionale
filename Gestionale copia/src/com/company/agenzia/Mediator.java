package com.company.agenzia;

import com.company.Cliente;
import com.company.engineImp.Impiegato;
import com.company.item_used.OrdineProduzione;

public class Mediator {
    private final Azienda azienda;
    private final Impiegato impiegato;
    public Mediator(Azienda i, Impiegato impiegato){
        azienda = i;
        this.impiegato = impiegato;
    }

    public boolean compilaOrdine(Anagrafe anagrafe, RegistroSchedeBorse registroSchedeBorse,
                                 RegistroOrdini registroOrdini, Cliente cliente){
        if (anagrafe.searchClientByName(cliente.getName())==null)
            anagrafe.registraCliente(cliente);
        OrdineProduzione o = impiegato.compilaOrdine(anagrafe,registroSchedeBorse,registroOrdini);
        azienda.accettaIncarico(o, o.getCliente());
        azienda.emettiFattura(o,cliente);
        return true;
    }
}
