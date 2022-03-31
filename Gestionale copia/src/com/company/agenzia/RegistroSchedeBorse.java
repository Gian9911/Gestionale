package com.company.agenzia;

import com.company.item_used.Borsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroSchedeBorse {
    private final List<Borsa> storico;
    public RegistroSchedeBorse(){storico = new ArrayList<>(); }
    public void registraBorsa(Borsa b){
       storico.add(b);
    }

   public void modificaNewBorsa(String s) {
       Scanner ob = new Scanner(System.in);
       Scanner obInt = new Scanner(System.in);
       Borsa b = searchByName(s);
       if (b==null){
           System.out.println("borsa non trovata");
           return;
       }
       Borsa newB = new Borsa(b.getComponenti(),b.getPelle(),b.getName(),b.getFodera(),b.getMaterialiDiConsumo(),
               b.getPackaging(),b.getLucro(),b.getSpeseGenerali(),b.getTrasporto(),b.getCostoLavorazione(),
               b.calcolaUnitPrice());
       System.out.println("trovata borsa "+b.getName());
       System.out.println("Inserisci nuovo nome: ");
       //String nome = "nuovo nome borsa";
       //newB.setName(nome);//per test
       newB.setName(ob.nextLine());
       modifica( newB);
   }
   public void modifica(Borsa b){
       Scanner ob = new Scanner(System.in);
       Scanner obInt = new Scanner(System.in);
       System.out.println("Inserisci modifiche: 0 pelle,1 fodera,2 aggiungere elemento extra," +
               " 3 altre spese(packaging ecc..)");
       int scelta = obInt.nextInt();
       //int scelta = 3;// mettere 0 per test 1,2,3,4 -- mettere 3 per test 5
       if (scelta == 0){ modificaPelle(b); }
       else if (scelta == 1){ modificaFoder(b); }//viene già testato sopra
       else if(scelta == 2){ b.extraElements(); }
       else if(scelta == 3){ modificaGeneric(b); }
       b.setUnitPrice(b.calcolaUnitPrice());
       storico.add(b);
       b.mostraInfoBorsa();
   }
   public void modificaPelle(Borsa b){//tested
       Scanner ob = new Scanner(System.in);
       Scanner obInt = new Scanner(System.in);
       System.out.println("Inserisci modifica della pelle: 0 inserire nuovo colore,1 cancellare colore," +
               "2 cambiare nome pelle, 3 cambiare tipo di pelle ");
       int scelta = obInt.nextInt();
       //int scelta = 0;//test 1 mettere 0, per test 2 mettere 1, per test 3 mettere 2, per test4 mettere 3
       if (scelta == 0){
           System.out.println("Inserisci nuovo colore: ");
           b.getPelle().addColor(ob.nextLine());
           //b.getPelle().addColor("verde");//per test1

       }
       else if (scelta == 1){
           System.out.println("Inserisci il colore da eliminare: ");
           b.getPelle().removeColor(ob.nextLine());
           //b.getPelle().removeColor("verde");//per test 2

       }
       else if(scelta == 2){
           System.out.println("Inserisci il nuovo nome: ");
            b.getPelle().setNome(ob.nextLine());
           //b.getPelle().setNome("BorsaTest");//per test 3

       }
       else if (scelta == 3){
           System.out.println("Inserisci il nuovo tipo di pelle: ");
           b.getPelle().setTipoPelle(ob.nextLine());
           //b.getPelle().setTipoPelle("PelleTest");

       }
   }
    public void modificaFoder(Borsa b){
        Scanner ob = new Scanner(System.in);
        Scanner obInt = new Scanner(System.in);
        System.out.println("Inserisci modifica della fodera: 0 inserire nuovo colore,1 cancellare colore," +
                "2 cambiare nome fodera, 3 cambiare tipo di pelle per fodera");
        int scelta = obInt.nextInt();
        if (scelta == 0){
            System.out.println("Inserisci nuovo colore: ");
            b.getFodera().addColor(ob.nextLine());

        }
        else if (scelta == 1){
            System.out.println("Inserisci il colore da eliminare: ");
            b.getFodera().removeColor(ob.nextLine());

        }
        else if(scelta == 2){
            System.out.println("Inserisci il nuovo nome della fodera: ");
            b.getFodera().setNome(ob.nextLine());

        }
        else if (scelta == 3){
            System.out.println("Inserisci il nuovo tipo di pelle per la fodera: ");
            b.getFodera().setTipoPelle(ob.nextLine());

        }

    }

    public List<Borsa> getStorico() { return storico; }

    public Borsa searchByName(String s){
        int i = 0;
        Borsa c = null;
        while (i < storico.size()) {
            if (s.equals(storico.get(i).getName()))
                c = storico.get(i);
            i++;
        }
        return c;
    }
    public void modificaGeneric(Borsa b){
        Scanner ob = new Scanner(System.in);
        Scanner obInt = new Scanner(System.in);
        System.out.println("Inserisci modifica: 0 inserire nuovo costo dei materiali di consumo,1 cambiare prezzo packaging," +
                "2 cambiare lucro, 3 cambiare spese Generali, 4 cambiare prezzo del trasporto, 5 cambiare costo lavorazione");
        int scelta = obInt.nextInt();
        //int scelta = 0;//metti 0 per test 5
        if(scelta == 0){
            System.out.println("Inserisci il nuovo prezzo :");
            b.getMaterialiDiConsumo().setPrice(ob.nextDouble());
            //b.getMaterialiDiConsumo().setPrice(12);
        }
        if(scelta == 1){
            System.out.println("Inserisci il nuovo prezzo:");
            b.getPackaging().setPrice(ob.nextDouble());
        }
        if(scelta == 2){
            System.out.println("Inserisci il nuovo prezzo:");
            b.getLucro().setPrice(ob.nextDouble());
        }
        if(scelta == 3){
            System.out.println("Inserisci il nuovo prezzo:");
            b.getSpeseGenerali().setPrice(ob.nextDouble());
        }
        if(scelta == 4){
            System.out.println("Inserisci il nuovo prezzo:");
            b.getTrasporto().setPrice(ob.nextDouble());
        }
        if(scelta == 5){
            System.out.println("Inserisci il nuovo prezzo:");
            b.getCostoLavorazione().setPrice(ob.nextDouble());
        }
    }
}


