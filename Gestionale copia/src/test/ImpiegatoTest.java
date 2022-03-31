package test;

import com.company.*;
import com.company.engineImp.Impiegato;
import com.company.agenzia.Anagrafe;
import com.company.agenzia.RegistroOrdini;
import com.company.agenzia.RegistroSchedeBorse;
import com.company.item_used.Borsa;
import com.company.item_used.OrdineProduzione;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImpiegatoTest {
    @Test
    public void testInserisciCliente(){
        Anagrafe anagrafe = new Anagrafe();
        Cliente cliente = new Cliente("cliente test","luogo 1 test","luogo 2 test");
        Impiegato impiegato = new Impiegato();
        impiegato.inserisciCliente(anagrafe);
        Assertions.assertEquals(anagrafe.searchClientByName("cliente test").getLuogoDestinazioneMerce(),
                cliente.getLuogoDestinazioneMerce());
    }
    @Test
    public void testElaboraNumeroPezzieColoreborsa(){
        Impiegato impiegato = new Impiegato();
        Borsa borsa = new Borsa();
        borsa.getPelle().addColor("colore1");
        borsa.getFodera().addColor("colore1");
        borsa.setName("borsa test");
        OrdineProduzione ordineProduzione =new OrdineProduzione();
        borsa.calcolaUnitPrice();
        ordineProduzione.getBorsa().add(borsa);
        RegistroSchedeBorse registroSchedeBorse = new RegistroSchedeBorse();
        impiegato.InserisciInStoricoBorse(borsa,registroSchedeBorse);
        Assertions.assertEquals(impiegato.elaboraNumeroPezzieColoreborsa(
                registroSchedeBorse,ordineProduzione),432);
    }
    @Test
    public void testCompilaBorsa(){
        Impiegato impiegato = new Impiegato();
        RegistroSchedeBorse registroSchedeBorse = new RegistroSchedeBorse();
        Borsa borsa = new Borsa();
        borsa.extraElements();
        double dd = borsa.calcolaUnitPrice();
        impiegato.compilaBorsa(registroSchedeBorse,"borsaTest");
        double d = registroSchedeBorse.searchByName("borsaTest").calcolaUnitPrice();
        Assertions.assertEquals(d,dd);
    }
    @Test
    public void testCompilaOrdine(){
        Anagrafe anagrafe = new Anagrafe();
        Cliente cliente = new Cliente();
        cliente.setName("cliente");
        Borsa borsa = new Borsa();
        borsa.getFodera().addColor("color");
        borsa.getPelle().addColor("color");
        borsa.setName("borsa test");
        RegistroSchedeBorse registroSchedeBorse = new RegistroSchedeBorse();
        RegistroOrdini registroOrdini = new RegistroOrdini();
        registroSchedeBorse.registraBorsa(borsa);
        OrdineProduzione ordineProduzione = new OrdineProduzione();
        Impiegato impiegato = new Impiegato();
        ordineProduzione.getBorsa().add(borsa);
        anagrafe.registraCliente(cliente);
        impiegato.compilaOrdine(anagrafe,registroSchedeBorse,registroOrdini);
        Assertions.assertEquals(registroOrdini.getListaOrdine().get(0).getBorsa().get(0).getName(),
                ordineProduzione.getBorsa().get(0).getName());
    }
}
