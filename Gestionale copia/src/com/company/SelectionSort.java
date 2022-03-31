package com.company;

import com.company.item_used.OrdineProduzione;

import java.util.List;
public class SelectionSort {
    public void selectionSort(List<OrdineProduzione> lista) {
        for(int i = 0; i < lista.size()-1; i++) {
            int minimo = i;
            for(int j = i+1; j < lista.size(); j++) {
                if(lista.get(minimo).getDataConsegna().minus(lista.get(j).getDataConsegna())) {
                    minimo = j;
                }
            }
            if(minimo!=i) {
                OrdineProduzione k = new OrdineProduzione();
                k.setAll(lista.get(minimo));
                lista.get(minimo).setAll(lista.get(i));
                lista.get(i).setAll(k);
            }
        }
    }
}



