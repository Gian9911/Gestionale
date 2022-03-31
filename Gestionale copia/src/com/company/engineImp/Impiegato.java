package com.company.engineImp;
import com.company.Cliente;
import com.company.agenzia.Anagrafe;
import com.company.agenzia.RegistroOrdini;
import com.company.agenzia.RegistroSchedeBorse;
import com.company.item_used.Borsa;
import com.company.item_used.ItemComplessivePrice;
import com.company.item_used.OrdineProduzione;
import com.company.item_used.Pelle;

import java.util.Scanner;

public class Impiegato  {
    public void InserisciInStoricoBorse(Borsa b, RegistroSchedeBorse r){ r.registraBorsa(b); }
    public void modificaElementoNelloStorico(Borsa b, RegistroSchedeBorse r){ r.modifica(b); }


    public void inserisciCliente(Anagrafe anagrafe){//tested __20 mar
        Scanner ob = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.println("Inserire nome cliente:");
        String nome = ob.nextLine();
        //String nome = "cliente test";
        cliente.setName(nome);
        System.out.println("Inserire sedeLegale:");
        String sl = ob.nextLine();
        //String sl = "luogo 1 test";
        cliente.setSedeLegale(sl);
        System.out.println("Inserire luogo di destinazione");
        String dest = ob.nextLine();
        //String dest = "luogo 2 test";
        cliente.setLuogoDestinazioneMerce(dest);
        anagrafe.registraCliente(cliente);
    }

    public OrdineProduzione compilaOrdine(Anagrafe a, RegistroSchedeBorse registro, RegistroOrdini registroOrdini) {
        Scanner ob = new Scanner(System.in);
        Scanner obInt = new Scanner(System.in);

        OrdineProduzione ordineProduzione = new OrdineProduzione();
        System.out.println("Procedura guidata per compilazione ordine:");
        System.out.println("Inserire id dell'ordine: ");
        ordineProduzione.setId(ob.nextLine());
        //ordineProduzione.setId("id1");
        System.out.println("Inserire nome cliente: ");
        String nome = ob.nextLine();
        //String nome = "cliente";
        if (a.searchClientByName(nome)==null)
            a.inserisciCliente(nome);
        ordineProduzione.setCliente(a.searchClientByName(nome));
        //ordineProduzione.setCliente(a.searchClientByName("cliente"));
        ordineProduzione.getDataConsegna().inserisciData();
        int i = 1;
        double prezzoFinale=0;
        while(i==1) {
            prezzoFinale+=elaboraNumeroPezzieColoreborsa(registro, ordineProduzione);
            System.out.println("Vuoi inserire un altra borsa? si 1, no 0");
            i = obInt.nextInt();
            //i = 0;
        }
        ordineProduzione.setPrezzoFinale(prezzoFinale);
        for (Borsa b : ordineProduzione.getBorsa())
            ordineProduzione.stampaFabbisogni(b);
        registroOrdini.addOrdine(ordineProduzione);
        return ordineProduzione;
    }
    public double elaboraNumeroPezzieColoreborsa(RegistroSchedeBorse registro, OrdineProduzione ordineProduzione){
        Scanner ob = new Scanner(System.in);
        Scanner obInt = new Scanner(System.in);

        System.out.println("Inserire nome della borsa: ");
        //Borsa b = registro.searchByName("borsa test");
        String nn = ob.nextLine();
        Borsa b = registro.searchByName(nn);
        if (b == null){
            System.out.println("borsa non presente nel registro e inizio a compilare");
            b=this.compilaBorsa(registro,nn);
            //b = this.compilaBorsa(registro,"borsa test");
        }
        b.calcolaUnitPrice();
        ordineProduzione.getPrezzoUnitario().add(b.getUnitPrice());
        int i = 0;
        System.out.println("Inserire numero pezzi per colore: ");
        while (i<b.getPelle().getColorEpezzo().size()){
            System.out.println("Il colore della borsa è: "+b.getPelle().getColorEpezzo().get(i).getColore());
            System.out.println("Inserire il nuemero pezzi: ");
            int v = obInt.nextInt();
            //int v = 2;

            b.getPelle().getColorEpezzo().get(i).setNumeroPezzi(v);


            b.getFodera().getColorEpezzo().get(i).setNumeroPezzi(v);
            System.out.println("Inserire il nuemero pezzi: ");
            i++;
        }
        ordineProduzione.getBorsa().add(b);
        return ordineProduzione.calcolaPrezzoFinale();
    }

    public Borsa compilaBorsa(RegistroSchedeBorse registroSchedeBorse,String name) {//tested
        Scanner ob = new Scanner(System.in);
        Scanner obInt = new Scanner(System.in);
        Scanner obD = new Scanner(System.in);
        Borsa borsa = new Borsa();
        System.out.println("Stiamo per registrare la nuova borsa");
        borsa.setName(name);
        System.out.println("Inserisci dati della pelle");
        Pelle pelle = new Pelle();
        pelle.compilaPelle();
        borsa.setPelle(pelle);
        boolean endPelle = false;
        while (!endPelle) {

            System.out.println("Si desidera aggiungere un  nuovo colore della pelle?:digita 1 se si o 0 altrimenti");
            int f = obInt.nextInt();
            //int f = 1;
            if (f == 1) {
                System.out.println("Inserisci colore: ");
                borsa.getPelle().addColor(ob.nextLine());
                //borsa.getPelle().addColor("colore 1 test");
                //endPelle = true;
            } else {
                endPelle = true;
            }

        }

        System.out.println("Stiamo per registrare la fodera");
        Pelle fodera = new Pelle();
        fodera.compilaFodera();
        borsa.setFodera(fodera);
        int op = 0;
        while (op<borsa.getPelle().getColorEpezzo().size()) {
                System.out.println("Il colore della pelle è: " + borsa.getPelle().getByIndex1Color(op));
                System.out.println("Inserisci colore della fodera: ");
                borsa.getFodera().addColor(ob.nextLine());
                //borsa.getFodera().addColor("colore fodera test 1");
                op++;
        }
        //double p = 2;
        System.out.println("Inserisci il prezzp dei materiali di consumo");
        ItemComplessivePrice materialiDiConsumo = new ItemComplessivePrice("Materiali Di Consumo", obD.nextDouble());
        //ItemComplessivePrice materialiDiConsumo = new ItemComplessivePrice("Materiali Di Consumo", p);
        borsa.setMaterialiDiConsumo(materialiDiConsumo);
        System.out.println("Inserisci il prezzo del packaging");
        ItemComplessivePrice packaging = new ItemComplessivePrice("Packaging", obD.nextDouble());
        //ItemComplessivePrice packaging = new ItemComplessivePrice("Packaging", p);
        borsa.setPackaging(packaging);
        System.out.println("Inserisci il lucro");
        ItemComplessivePrice lucro = new ItemComplessivePrice("Lucro", obD.nextDouble());
        //ItemComplessivePrice lucro = new ItemComplessivePrice("Lucro", p);
        borsa.setLucro(lucro);
        System.out.println("Inserisci le spese generali");
        ItemComplessivePrice speseGenerali = new ItemComplessivePrice("Spese Generali", obD.nextDouble());
        //ItemComplessivePrice speseGenerali = new ItemComplessivePrice("Spese Generali", p);
        borsa.setSpeseGenerali(speseGenerali);
        System.out.println("Inserisci il costo della lavorazione");
        ItemComplessivePrice costoLavorazione = new ItemComplessivePrice("CostoLavorazione", obD.nextDouble());
        //ItemComplessivePrice costoLavorazione = new ItemComplessivePrice("CostoLavorazione", p);
        borsa.setCostoLavorazione(costoLavorazione);
        System.out.println("Inserisci il costo del trasporto");
        ItemComplessivePrice trasporto = new ItemComplessivePrice("Trasporto", obD.nextDouble());
        //ItemComplessivePrice trasporto = new ItemComplessivePrice("Trasporto", p);
        borsa.setTrasporto(trasporto);

        borsa.extraElements();
        borsa.calcolaUnitPrice();
        System.out.println(borsa.getUnitPrice());
        registroSchedeBorse.registraBorsa(borsa);
        return borsa;
    }
}
