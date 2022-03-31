package test;

import com.company.*;
import com.company.agenzia.Azienda;
import com.company.agenzia.Mediator;
import com.company.engineImp.Impiegato;
import com.company.item_used.Borsa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MediatorTest {
    @Test
    public void test1(){
        Borsa borsa = new Borsa();
        borsa.setName("borsa test");
        Azienda azienda = Azienda.getAzienda();
        azienda.getRegistroSchedeBorse().registraBorsa(borsa);
        Cliente cliente = new Cliente("cliente","luogo 1 test",
                "luogo 2 test");
        azienda.getAnagrafe().registraCliente(cliente);
        Impiegato impiegato = new Impiegato();
        Mediator mediator = new Mediator(azienda,impiegato);
        Assertions.assertTrue(mediator.compilaOrdine(azienda.getAnagrafe(), azienda.getRegistroSchedeBorse(),
                azienda.getPurchaseOrder(), cliente));
    }
}
