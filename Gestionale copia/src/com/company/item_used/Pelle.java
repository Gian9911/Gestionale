package com.company.item_used;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pelle extends ItemUnitPrice {
    private String tipoPelle;
    private final List<ColoreEPezzi> colorEpezzi;

    @Override
    public void associaUnit() { callUnit(); }
    private void callUnit(){ unit = "m2"; }

    public Pelle() {
        colorEpezzi = new ArrayList<>();
        price = 12;
        dimension = 4;
        tipoPelle="tipo1";
    }

    public void removeColor(String s){
        int i = 0;
        while (i < colorEpezzi.size()){
            System.out.println("Inserisci il colore da eliminare: ");
            if (colorEpezzi.get(i).getColore().equals(s)){
                colorEpezzi.remove(colorEpezzi.get(i));
            }
            i++;
        }
    }
    public List<ColoreEPezzi> getColorEpezzo(){ return colorEpezzi;}
    public void showListPezzo(){
        int i = 0;
        while(i<colorEpezzi.size()){
            System.out.println(colorEpezzi.get(i).getColore()+" "+colorEpezzi.get(i).getNumeroPezzi());
            i++;
        }
    }

    public String getByIndex1Color(int i) { return colorEpezzi.get(i).getColore(); }
    public int getByName1Pezzo(String s) {
        int index = 1000000;
        if (verificaColoreEPezzi(s)) {
            index = cercaPezzi(s);
            index = colorEpezzi.get(index).getNumeroPezzi();
        }
        return index;
    }
    public boolean verificaColoreEPezzi(String s){
        boolean check = false;
        int o=0;
        while (o<colorEpezzi.size()){
            if (colorEpezzi.get(o).getColore().equals(s)) {
                check = true;
            }
            o++;
        }
        if(!check)
            System.out.println("Colore non presente nella lista!");
        return check;
    }
    public int get1Pezzo(int i) { return colorEpezzi.get(i).getNumeroPezzi(); }
    public String getTipoPelle() { return tipoPelle; }
    public void setTipoPelle(String p) { tipoPelle = p; }
    public String getUnit(){return unit; }
    public void addColor(String c) {
        ColoreEPezzi colorePezzi = new ColoreEPezzi();
        colorePezzi.setColoreEPezzi(c,1);
        this.colorEpezzi.add(colorePezzi);
    }
    public void addColor(String c, int numero) {
        ColoreEPezzi colorePezzi = new ColoreEPezzi();
        colorePezzi.setColoreEPezzi(c,numero);
        this.colorEpezzi.add(colorePezzi);
    }

    public void fabbisogno() {
        int i = 0;
        double v = 0;
        while (i < colorEpezzi.size()) {
            v = dimension * colorEpezzi.get(i).getNumeroPezzi();
            colorEpezzi.get(i).setFabbisogno(v);
            System.out.println("Fabbisogno per per pelle  " + this.getNome() + " di colore " + this.getColorEpezzo()
                    .get(i).getColore() + " : " + v);
            i++;
        }
    }
    public int cercaPezzi(String colore){
        int i = 0;
        int index=10000;
        while (i<colorEpezzi.size()){
            if(colorEpezzi.get(i).getColore().equals(colore)){
                index=i;
            }
            i++;
        }
        return index;
    }

    public void compilaPelle(){
        associaUnit();
        Scanner o = new Scanner(System.in);
        Scanner o1 = new Scanner(System.in);
        Scanner obInt = new Scanner(System.in);
        System.out.println("Inserire nome");
        String n = o.nextLine();
        //String n = "nome";
        setNome(n);
        System.out.println("Inserire prezzo/"+ unit);
        double p = o1.nextDouble();
        //double p =12;
        setPrice(p);
        System.out.println("Inserire "+ unit);
        double d = o1.nextDouble();
        //double d = 4;
        setDimension(d);
        Scanner ob = new Scanner(System.in);
        System.out.println("Inserisci tipo di pelle");
        tipoPelle = o.nextLine();
        //tipoPelle = "tipopelle";
    }

    public void compilaFodera(){
        associaUnit();
        Scanner o = new Scanner(System.in);
        Scanner o1 = new Scanner(System.in);
        Scanner obInt = new Scanner(System.in);
        System.out.println("Inserire nome");
        String n = o.nextLine();
        //String n = "nome";
        setNome(n);
        System.out.println("Inserire prezzo/"+ unit);
        double p = o1.nextDouble();
        //double p =12;
        setPrice(p);
        System.out.println("Inserire "+ unit);
        double d = o1.nextDouble();
        //double d = 4;
        setDimension(d);
        Scanner ob = new Scanner(System.in);
        System.out.println("Inserisci tipo di pelle");
        tipoPelle = o.nextLine();
        //tipoPelle = "tipopelle";
    }
}