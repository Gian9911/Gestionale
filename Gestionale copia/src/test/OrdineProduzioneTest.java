package test;

import com.company.*;
import com.company.item_used.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrdineProduzioneTest {
    @Test
    public void testCalcoloFabbisogni(){
        Borsa borsa1 = new Borsa();
        Borsa borsa2 = new Borsa();
        Pelle pelle = new Pelle();
        Pelle pelle1 = new Pelle();
        pelle1.addColor("marrone",3);
        pelle1.setDimension(5);
        pelle.setDimension(5);
        pelle.addColor("rosso",5);
       borsa1.setPelle(pelle);
        borsa2.setPelle(pelle1);
        OrdineProduzione ordineProduzione = new OrdineProduzione();
        ordineProduzione.getBorsa().add(borsa1);
        ordineProduzione.getBorsa().add(borsa2);
        ordineProduzione.calcolaFabbisogno();
        double d = 0;
        for(int i = 0; i < ordineProduzione.getFabbisogni().size(); i++){
            System.out.println(ordineProduzione.getFabbisogni().get(i));
            d+=ordineProduzione.getFabbisogni().get(i);
        }

        Assertions.assertEquals(d,40);
    }
    @Test
    public void testCalcolaPrezzoFinale(){
        OrdineProduzione ordineProduzione = new OrdineProduzione();
        Borsa borsa = new Borsa();
        borsa.getPelle().addColor("rosso",3);
        borsa.getFodera().addColor("rosso",3);
        ordineProduzione.getBorsa().add(borsa);
        double r1 = ordineProduzione.calcolaPrezzoFinale();
        double r2 = borsa.calcolaUnitPrice()*3;
        System.out.println(borsa.getPelle().getColorEpezzo().get(0).getNumeroPezzi());
        Assertions.assertEquals(r1,r2);
    }
    @Test
    public void testVisualizza(){
        ItemComplessivePrice it = new ItemComplessivePrice("it",1);//1
        List<Item> listaItem = new ArrayList<>();
        listaItem.add(it);//1
        Pelle pelle = new Pelle();//48+1=49
        Pelle fodera = new Pelle();//48+49=97
        ItemComplessivePrice it1 = new ItemComplessivePrice("it1",5);//97+5=102
        ItemComplessivePrice it3 = new ItemComplessivePrice("it3",5);//107
        ItemComplessivePrice it2 = new ItemComplessivePrice("it2",5);
        ItemComplessivePrice it4 = new ItemComplessivePrice("it4",5);//117
        ItemComplessivePrice it5 = new ItemComplessivePrice("it5",5);
        ItemComplessivePrice it6 = new ItemComplessivePrice("it6",5);//127
        String nam = "Dyson";

        Borsa b = new Borsa(listaItem,pelle,nam, fodera,it1,it2,it3, it4,it5,it6,0);
        Borsa c = new Borsa(listaItem,pelle,nam, fodera,it1,it2,it3, it4,it5,it6,0);
        b.calcolaUnitPrice();
        c.calcolaUnitPrice();
        b.getPelle().addColor("giallo",1);
        c.getPelle().addColor("giallo",0);

        Cliente cliente = new Cliente("nome","sede1","sede2");
        Data d = new Data(13,5,2020);
        List<Borsa> listaBorsa = new ArrayList<>();
        listaBorsa.add(b);//127
        listaBorsa.add(c);

        OrdineProduzione ordineProduzione = new OrdineProduzione();
        ordineProduzione.setBorsa(listaBorsa);
        ordineProduzione.setDataConsegna(d);
        ordineProduzione.setCliente(cliente);
        Assertions.assertEquals(254,ordineProduzione.calcolaPrezzoFinale());
    }
}
