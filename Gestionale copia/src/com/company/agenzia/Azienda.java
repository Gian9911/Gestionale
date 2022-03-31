package com.company.agenzia;
import com.company.*;
import com.company.item_used.OrdineProduzione;

import java.util.*;

public class Azienda  extends Observable{
    private static final List<Observer> observers = new ArrayList<>();
    private static String name;
    private static boolean accettaIncarico = false;
    private  static Anagrafe anagrafe;
    private  static RegistroSchedeBorse registroSchedeBorse;
    private  static RegistroOrdini purchaseOrder;
    private  static List<Fattura> registroFatture;
    private static Azienda instance = null;

    public static Azienda getAzienda(){
        if (instance == null) {
             instance = new Azienda();
        }
        return instance;
    }

    private Azienda() {
        name = "azienda";
        purchaseOrder = new RegistroOrdini();
        anagrafe = new Anagrafe();
        registroFatture = new ArrayList<>();
        registroSchedeBorse = new RegistroSchedeBorse();
    }

    public RegistroSchedeBorse getRegistroSchedeBorse() { return registroSchedeBorse; }
    public Anagrafe getAnagrafe() { return anagrafe; }
    public String getName() { return name; }
    public RegistroOrdini getPurchaseOrder() {
        return purchaseOrder;
    }


    public boolean accettaIncarico(OrdineProduzione o, Cliente c){//test1
        Scanner ob = new Scanner(System.in);
        System.out.println("Informazioni su ordine "+o.getId());
        System.out.println("Data di consegna: ");
        o.getDataConsegna().streamData();
        System.out.println("Cliente: "+c.getName());
        int i = 0;
        System.out.println(o.getBorsa().size());
        while(i < o.getBorsa().size()){
            System.out.println("Nome borsa: "+o.getBorsa().get(i).getName());
            System.out.println("Prezzo unitario: "+o.getBorsa().get(i).getUnitPrice());
            int j = 0;
            while(j < o.getBorsa().get(i).getPelle().getColorEpezzo().size()) {
                System.out.println("Colore borsa: " + o.getBorsa().get(i).getPelle().getByIndex1Color(j));
                System.out.println("Numero di pezzi richiesti: "+o.getBorsa().get(i).getPelle().get1Pezzo(j));
                j++;
            }
            i++;
        }
        System.out.println("Accettare? si-1, no-0");
        //int iii = 1;
        int iii = ob.nextInt();
        if(iii==1) {
            o.setDelivered(true);
            accettaIncarico = true;
        }else
            System.out.println("Ordine rifiutato");
        return accettaIncarico;
    }
    public void addObserver(Observer observer){
        observers.add(observer);
    }


    public boolean emettiFattura(OrdineProduzione ordine, Cliente cliente){

        Fattura fattura = new Fattura(this);
        fattura.setIntestazione(this);
        fattura.setOrdineProduzione(ordine);

       fattura.setNumeroProgressivo(registroFatture.size());
       registroFatture.add(fattura);
       fattura.stampaFattura();
        for (Observer observer : observers) {
           if(observer.equals(cliente))
            observer.update(this,fattura);
        }
        return true;
    }
}
