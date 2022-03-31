package test;

import com.company.item_used.Pelle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PelleTest {
    @Test
    public void testCreaPelle() {
        Pelle pelle = new Pelle();
        //pelle.compilaPelle();
        Assertions.assertEquals(12, pelle.getPrice());
    }

    @Test
    public void testRemoveColor() {
        Pelle pelle1 = new Pelle();
        pelle1.addColor("Giallo");
        pelle1.removeColor("blu");
        int i = pelle1.cercaPezzi("Giallo");
        List<String> color = new ArrayList<>();
        color.add("Giallo");
        Assertions.assertEquals(pelle1.getByIndex1Color(i), color.get(0));
    }


    @Test
    public void testCercaPezzi() {
        Pelle pelle = new Pelle();
        pelle.addColor("giallo",2);
        pelle.addColor("blu",3);
        int i = pelle.cercaPezzi("blu");
        System.out.println(i);
        Assertions.assertEquals(3, pelle.getColorEpezzo().get(i).getNumeroPezzi());
    }

    @Test
    public void addColor() {
        Pelle pelle = new Pelle();
        pelle.showListPezzo();
        pelle.addColor("giallo",1);
        pelle.showListPezzo();
        int i = pelle.cercaPezzi("giallo");
        Assertions.assertEquals("giallo", pelle.getByIndex1Color(0));//ci puoi mettere anche i
    }

    @Test
    public void testVerifica() {
        Pelle pelle = new Pelle();
        boolean c = pelle.verificaColoreEPezzi("gillo");
        Assertions.assertFalse(c);
    }
    @Test
    public void testConferisciPezzi(){
        Pelle pelle=new Pelle();
        pelle.addColor("blu",3);
        Assertions.assertEquals(3,pelle.getByName1Pezzo("blu"));
    }

}
