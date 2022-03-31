package com.company.agenzia;

import com.company.item_used.OrdineProduzione;
import com.company.SelectionSort;

import java.util.ArrayList;
import java.util.List;

public class RegistroOrdini {
    private final List<OrdineProduzione> listaOrdine;

    public RegistroOrdini(){listaOrdine = new ArrayList<>();}

    public void addOrdine(OrdineProduzione o){listaOrdine.add(o);}
    public List<OrdineProduzione> getListaOrdine() { return listaOrdine; }

    public OrdineProduzione searchByNameOfItemAndNameOfClient(String nomeCliente, String nomeBorsa){
        OrdineProduzione o = new OrdineProduzione();
        for (int i = 0; i < listaOrdine.size(); i++) {
            if (listaOrdine.get(i).getCliente().getName().equalsIgnoreCase(nomeCliente)){
            for (int y = 0; y < listaOrdine.get(i).getBorsa().size(); y++) {
                if (listaOrdine.get(i).getBorsa().get(y).getName().equalsIgnoreCase(nomeBorsa)) {
                    o = listaOrdine.get(i);
                    System.out.println(o.getBorsa().get(y).getName());
                }

            }
            }
        }
        return o;
    }
    public void ordina(){
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(listaOrdine);
    }

}
