package com.company;

import com.company.agenzia.Azienda;
import com.company.agenzia.Mediator;
import com.company.engineImp.Impiegato;

public class Main {

    public static void main(String[] args) {
        Azienda a = Azienda.getAzienda();
        Cliente c = new Cliente("ClienteCliente", "lluogo1","lluogo2");

        Impiegato i = new Impiegato();
        Mediator mediator = new Mediator(a,i);
        mediator.compilaOrdine(a.getAnagrafe(),a.getRegistroSchedeBorse(),a.getPurchaseOrder(),c);
    }
}