package test;

import com.company.item_used.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BorsaTest {
    @Test
    public void testExtraElName(){
        Borsa borsa = new Borsa();
        System.out.println("2");
        borsa.extraElements();
        System.out.println("2");
        Item it = borsa.getComponenti().get(0);
        ItemUnitPrice it1 = new ItemUnitPrice("name",12,4);
        Assertions.assertEquals(it.getNome(),it1.getNome() );
    }
    @Test
    public void testExtraElementDimension(){//cambia itemUnitePrice x versione test
        Borsa borsa = new Borsa();
        borsa.extraElements();
        Item it = borsa.getComponenti().get(0);
        ItemUnitPrice it1 = new ItemUnitPrice("name",12,4);
        Assertions.assertEquals(it.getDimension(),it1.getDimension() );
    }
    @Test
    public void testPrezzo(){
        List<Item> listaExtra = new ArrayList<>();
        ItemComplessivePrice borchie = new ItemComplessivePrice("borchie",2);//2
        listaExtra.add(borchie);
        String nome = "borsa";
        Pelle pelle = new Pelle();//48+2=50
        Pelle fodera = new Pelle();//50+48=98
        ItemComplessivePrice it1 = new ItemComplessivePrice("borchie",5);//98+5
        ItemComplessivePrice it2 = new ItemComplessivePrice("borchie",5);//98+10=108
        ItemComplessivePrice it3 = new ItemComplessivePrice("borchie",5);//108/+5
        ItemComplessivePrice it4 = new ItemComplessivePrice("borchie",5);//108+10=118
        ItemComplessivePrice it5 = new ItemComplessivePrice("borchie",5);//118+5
        ItemComplessivePrice it6 = new ItemComplessivePrice("borchie",5);//118+10=128
        Borsa borsa = new Borsa(listaExtra,pelle,nome,fodera,it1,it2,it3,it4,it5,it6,0);
        Assertions.assertEquals(128,borsa.calcolaUnitPrice());
    }

    @Test
    public void testPresentaInfo(){
        Borsa borsa = new Borsa();
        Pelle pelle = new Pelle();
        pelle.setNome("PellePelle");
        pelle.addColor("Red",3);
        Pelle fodera = new Pelle();
        fodera.addColor("Nera");
        fodera.setNome("pelleFodera");
        borsa.setPelle(pelle);
        borsa.setFodera(fodera);
        ItemComplessivePrice itemTest = new ItemComplessivePrice("ItemTest",5.00);
        borsa.setLucro(itemTest);
        borsa.setPackaging(itemTest);
        borsa.setCostoLavorazione(itemTest);
        borsa.setTrasporto(itemTest);
        borsa.setMaterialiDiConsumo(itemTest);
        borsa.setSpeseGenerali(itemTest);
        ItemComplessivePrice itemTest2 = new ItemComplessivePrice("ItemTest",2.00);
        borsa.getComponenti().add(itemTest2);
        borsa.mostraInfoBorsa();
        Assertions.assertEquals(borsa.calcolaUnitPrice(),128);


    }
}
