package test;

import com.company.item_used.Borsa;
import com.company.Cliente;
import com.company.item_used.OrdineProduzione;
import com.company.agenzia.RegistroOrdini;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RegistroOrdineTest {
    @Test
    public void test1(){
        RegistroOrdini registroOrdini = new RegistroOrdini();
        OrdineProduzione ordineProduzione = new OrdineProduzione();
        Cliente cliente = new Cliente();
        cliente.setName("c1");
        ordineProduzione.setCliente(cliente);
        Borsa borsa = new Borsa();
        borsa.setName("BorsaTTest1");
        List<Borsa> borsaL = new ArrayList<>();
        borsaL.add(borsa);

        ordineProduzione.setBorsa(borsaL);
        registroOrdini.addOrdine(ordineProduzione);

        OrdineProduzione ordineProduzione1 = new OrdineProduzione();
        Cliente cliente1 = new Cliente();
        cliente1.setName("c2");
        ordineProduzione1.setCliente(cliente1);
        Borsa borsa1 = new Borsa();
        List<Borsa> borsaL1 = new ArrayList<>();
        borsaL1.add(borsa1);
        borsa1.setName("BorsaErroreTest");
        ordineProduzione1.setBorsa(borsaL1);
        registroOrdini.addOrdine(ordineProduzione1);

        Assertions.assertEquals(registroOrdini.searchByNameOfItemAndNameOfClient("c1",
                        "BorsaTTest1").getCliente().getName(),"c1");
    }
}
