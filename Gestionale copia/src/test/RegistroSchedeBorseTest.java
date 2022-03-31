package test;

import com.company.item_used.Borsa;
import com.company.agenzia.RegistroSchedeBorse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistroSchedeBorseTest {
    @Test
    public void testCheck1(){
        RegistroSchedeBorse registroSchedeBorse = new RegistroSchedeBorse();
        Borsa borsa1 = new Borsa();
        Borsa borsa2 = new Borsa();
        borsa2.getPelle().addColor("verde");
        registroSchedeBorse.registraBorsa(borsa1);
        registroSchedeBorse.modificaNewBorsa(borsa1.getName());
        Assertions.assertEquals(borsa1.getPelle().getByIndex1Color(0),borsa2.getPelle().getByIndex1Color(0));
    }
    @Test
    public void testCheck2(){
        RegistroSchedeBorse registroSchedeBorse = new RegistroSchedeBorse();
        Borsa borsa1 = new Borsa();
        Borsa borsa2 = new Borsa();
        borsa1.getPelle().addColor("verde");
        borsa1.getPelle().addColor("giallo");
        borsa2.getPelle().addColor("giallo");

        registroSchedeBorse.registraBorsa(borsa1);
        registroSchedeBorse.modificaNewBorsa(borsa1.getName());
        Assertions.assertEquals(registroSchedeBorse.searchByName(borsa1.getName()).getPelle().getByIndex1Color(0)
                ,borsa2.getPelle().getByIndex1Color(0));
    }
    @Test
    public void ctestCheck3(){
        RegistroSchedeBorse registroSchedeBorse = new RegistroSchedeBorse();
        Borsa borsa1 = new Borsa();
        Borsa borsa2 = new Borsa();
        borsa2.getPelle().setNome("BorsaTest");
        registroSchedeBorse.registraBorsa(borsa1);
        registroSchedeBorse.modificaNewBorsa(borsa1.getName());
        Assertions.assertEquals(registroSchedeBorse.searchByName(borsa1.getName()).getPelle().getNome()
                ,borsa2.getPelle().getNome());
    }
    @Test
    public void ctestCheck4(){
        RegistroSchedeBorse registroSchedeBorse = new RegistroSchedeBorse();
        Borsa borsa1 = new Borsa();
        Borsa borsa2 = new Borsa();
        borsa2.getPelle().setTipoPelle("PelleTest");
        registroSchedeBorse.registraBorsa(borsa1);
        registroSchedeBorse.modificaNewBorsa(borsa1.getName());
        Assertions.assertEquals(borsa1.getPelle().getTipoPelle(),borsa2.getPelle().getTipoPelle());
    }
    @Test
    public void genericTestMaterialiConsumo5(){
        RegistroSchedeBorse registroSchedeBorse = new RegistroSchedeBorse();
        Borsa borsa1 = new Borsa();
        Borsa borsa2 = new Borsa();
        borsa2.getMaterialiDiConsumo().setPrice(12);
        registroSchedeBorse.registraBorsa(borsa1);
        registroSchedeBorse.modificaNewBorsa(borsa1.getName());
        Assertions.assertEquals(borsa1.getMaterialiDiConsumo().getPrice(),borsa2.getMaterialiDiConsumo().getPrice());
    }
}
