package test;

import com.company.agenzia.Anagrafe;
import com.company.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagrafeTest {
    @Test
    public void testAnagrafe(){
        Cliente cliente = new Cliente("nomeCliente","sedeLegale",
                "destinazioneMerce");
        Anagrafe anagrafe = new Anagrafe();
        anagrafe.registraCliente(cliente);
        Cliente c2 = anagrafe.searchClientByName("nomeCliente");
        Assertions.assertEquals(cliente.getLuogoDestinazioneMerce(),c2.getLuogoDestinazioneMerce());
    }
}
