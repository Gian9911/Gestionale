package test;

import com.company.*;
import com.company.agenzia.Azienda;
import com.company.item_used.Borsa;
import com.company.item_used.Data;
import com.company.item_used.OrdineProduzione;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AziendaTest {
    @Test
    public void testVisualizza1(){

        Borsa borsa = new Borsa();
        borsa.setName("BorsaTest001");
        borsa.getPelle().addColor("Green",9);
        Data d = new Data(31,8,2022);
        Azienda azienda = Azienda.getAzienda();
        OrdineProduzione ordineProduzione = new OrdineProduzione();
        ordineProduzione.setId("2000");
        ordineProduzione.setDataConsegna( d);
        ordineProduzione.getBorsa().add(borsa);
        Cliente cliente = new Cliente();
        cliente.setName("cliente test==");
        azienda.addObserver(cliente);

         Assertions.assertTrue(azienda.accettaIncarico(ordineProduzione,cliente));
     }
     @Test//fa da test anche a fattura
    public void testEmettiFattura(){
        Borsa borsa = new Borsa();
        borsa.setName("BorsaTest001");
        borsa.getPelle().addColor("Green",9);
        Data d = new Data(31,8,2022);
         Azienda azienda = Azienda.getAzienda();
         OrdineProduzione ordineProduzione = new OrdineProduzione();
         ordineProduzione.setId("2000");
         ordineProduzione.setDataConsegna( d);
         Cliente cliente = new Cliente();
         cliente.setName("cliente test==");
         ordineProduzione.setCliente(cliente);
         azienda.addObserver(cliente);
         Assertions.assertTrue(azienda.emettiFattura(ordineProduzione,cliente));
     }

}
