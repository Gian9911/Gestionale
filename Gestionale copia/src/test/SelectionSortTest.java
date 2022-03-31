package test;

import com.company.item_used.Data;
import com.company.item_used.OrdineProduzione;
import com.company.SelectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SelectionSortTest {
    @Test
    public void TestOrdinamentoDate(){
        List<OrdineProduzione> lista = new ArrayList<>();
        List<OrdineProduzione> lista2 = new ArrayList<>();
        Data data1 = new Data(13,2,2026);
        Data data2 = new Data(25,2,2021);
        Data data3 = new Data(2,6,2025);
        OrdineProduzione ordineProduzione1 = new OrdineProduzione();
        ordineProduzione1.setDataConsegna(data1);
        lista.add(ordineProduzione1);
        OrdineProduzione ordineProduzione2 = new OrdineProduzione();
        ordineProduzione2.setDataConsegna(data2);
        lista.add(ordineProduzione2);
        OrdineProduzione ordineProduzione3 = new OrdineProduzione();
        ordineProduzione3.setDataConsegna(data3);
        lista.add(ordineProduzione3);
        lista2.add(ordineProduzione1);
        lista2.add(ordineProduzione3);
        lista2.add(ordineProduzione2);


        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(lista);
        int anno = lista.get(0).getDataConsegna().getAnno();
        int anno1 = lista2.get(0).getDataConsegna().getAnno();
        Assertions.assertEquals(anno,anno1);
    }

}
