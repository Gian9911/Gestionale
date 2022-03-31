package com.company.item_used;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Borsa {
    private final List<Item> componenti;
    private Pelle pelle;
    private Pelle fodera;
    private ItemComplessivePrice materialiDiConsumo;
    private ItemComplessivePrice packaging;
    private ItemComplessivePrice lucro;
    private ItemComplessivePrice speseGenerali;
    private ItemComplessivePrice trasporto;
    private ItemComplessivePrice costoLavorazione;
    private String name;
    private double unitPrice;

    public Borsa(){
        name = "nome borsa";
        unitPrice = 0.00;
        componenti = new ArrayList<>();
        pelle = new Pelle();
        fodera = new Pelle();
        costoLavorazione=new ItemComplessivePrice();
        trasporto=new ItemComplessivePrice();
        speseGenerali=new ItemComplessivePrice();
        packaging=new ItemComplessivePrice();
        materialiDiConsumo=new ItemComplessivePrice();
        lucro=new ItemComplessivePrice();
    }
    public Borsa(List<Item> comp, Pelle pell, String nam, Pelle fod, ItemComplessivePrice materialiDiConsum,
                 ItemComplessivePrice pack, ItemComplessivePrice luc, ItemComplessivePrice spes,
                 ItemComplessivePrice tra, ItemComplessivePrice costo,double pr){
        name = nam;
        unitPrice = pr;
        componenti = comp;
        pelle = pell;
        fodera = fod;
        materialiDiConsumo = materialiDiConsum;
        packaging = pack;
        lucro = luc;
        speseGenerali = spes;
        trasporto = tra;
        costoLavorazione = costo;
    }
    public Pelle getPelle() { return pelle; }
    public Pelle getFodera() { return fodera; }
    public void setFodera(Pelle fodera) { this.fodera = fodera; }
    public void setPelle(Pelle pelle) { this.pelle = pelle; }
    public ItemComplessivePrice getMaterialiDiConsumo() {
        return materialiDiConsumo;
    }
    public void setMaterialiDiConsumo(ItemComplessivePrice materialiDiConsumo) { this.materialiDiConsumo = materialiDiConsumo; }
    public ItemComplessivePrice getPackaging() {
        return packaging;
    }
    public void setPackaging(ItemComplessivePrice packaging) {
        this.packaging = packaging;
    }
    public ItemComplessivePrice getLucro() {
        return lucro;
    }
    public List<Item> getComponenti() {return componenti; }
    public void setLucro(ItemComplessivePrice lucro) { this.lucro = lucro; }
    public ItemComplessivePrice getSpeseGenerali() { return speseGenerali; }
    public void setSpeseGenerali(ItemComplessivePrice speseGenerali) { this.speseGenerali = speseGenerali; }
    public ItemComplessivePrice getTrasporto() { return trasporto; }
    public void setTrasporto(ItemComplessivePrice trasporto) { this.trasporto = trasporto; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public ItemComplessivePrice getCostoLavorazione() {return costoLavorazione; }
    public void setCostoLavorazione(ItemComplessivePrice costoLavorazione) { this.costoLavorazione = costoLavorazione; }



    public void extraElements(){
        Scanner ob = new Scanner(System.in);
        Scanner ob1 = new Scanner(System.in);

        ItemFactory factory;
        System.out.println("Inserire elemento extra? se si digita 1 or false digita 0");
        int check = ob.nextInt();
        //int check = 1;
        if (check == 1){
            factory = new ItemFactory();
            int i = 0;
            while (check == 1){
                System.out.println("Digita CI se l oggetto non ha prezzo/unità altrimenti UI");
                String it = ob1.nextLine();
                //String it = "UI";
                componenti.add(i, factory.getItem(it));
                i++;
                System.out.println("Inserire elemento extra? 1 se si or 0 altrimenti");
                check = ob.nextInt();
                //check = 0;
            }
        }
    }

    public double calcolaUnitPrice(){
        double p = 0;
        p += pelle.getPrice()*pelle.getDimension();
        p += fodera.getPrice()*fodera.getDimension();
        p += materialiDiConsumo.getPrice();
        p +=  packaging.getPrice();
        p += lucro.getPrice();
        p += speseGenerali.getPrice();
        p += trasporto.getPrice();
        p += costoLavorazione.getPrice();
        int i = 0;
        while ( i < componenti.size()){
            p += componenti.get(i).getPrice()*componenti.get(i).getDimension();
            i++;
        }
        setUnitPrice(p);
        return p;
    }

    public void mostraInfoBorsa(){
        System.out.println("Nome borsa "+getName());
        System.out.println("Nome pelle "+getPelle().getNome());
        System.out.println("Tipo pelle "+getPelle().getTipoPelle());
        System.out.println("Colore pelle ");
        int i = 0;
        while (i<getPelle().getColorEpezzo().size()){
            i++;
            System.out.println("Colore "+i+": "+getPelle().getColorEpezzo().get(i-1).getColore());
        }
        System.out.println("Nome fodera "+getFodera().getNome());
        System.out.println("Tipo pelle della fodera "+getFodera().getTipoPelle());
        System.out.println("Colore pelle della fodera ");
        i = 0;
        while (i< getFodera().getColorEpezzo().size()){
            i++;
            System.out.println("Colore "+i+": "+getFodera().getColorEpezzo().get(i-1).getColore());
        }
    }
}
