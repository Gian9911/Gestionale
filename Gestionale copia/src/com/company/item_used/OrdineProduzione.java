package com.company.item_used;

import com.company.Cliente;

import java.util.ArrayList;
import java.util.List;

public class OrdineProduzione {
    private String id;
    private Data dataConsegna;
    private final List<Double> prezzoUnitario;
    private final List<Integer> numeroPezzi;
    private List<Borsa> borsa;
    private Cliente cliente;
    private double prezzoFinale;
    private List<Double> fabbisogni;
    private boolean delivered = false;

    public OrdineProduzione() {
        id="prova";
        dataConsegna = new Data();
        borsa = new ArrayList<>();
        cliente = new Cliente();
        fabbisogni = new ArrayList<>();
        prezzoUnitario = new ArrayList<>();
        numeroPezzi = new ArrayList<>();
    }
    public double getPrezzoFinale() { return prezzoFinale; }
    public String getId() { return id; }
    public Data getDataConsegna(){return dataConsegna;}
    public Cliente getCliente() { return cliente; }
    public boolean isDelivered() { return delivered; }
    public List<Double> getFabbisogni() { return fabbisogni; }
    public List<Borsa> getBorsa() { return borsa; }
    public void setPrezzoFinale(double prezzoFinale) { this.prezzoFinale = prezzoFinale; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setDataConsegna(Data d){this.dataConsegna = d;}
    public void setId(String id) { this.id = id; }
    public void setFabbisogni(List<Double> fabbisogni) { this.fabbisogni = fabbisogni; }
    public void setBorsa(List<Borsa> borsa){this.borsa=borsa;}
    public void setDelivered(boolean delivered) { this.delivered = delivered; }
    public List<Double> getPrezzoUnitario() { return prezzoUnitario; }
    public List<Integer> getNumeroPezzi() { return numeroPezzi; }
    public void setAll(OrdineProduzione o){
        setId(o.getId());
        setDelivered(o.isDelivered());
        setCliente(o.getCliente());
        setFabbisogni(o.getFabbisogni());
        setDataConsegna(o.getDataConsegna());
        setPrezzoFinale(o.getPrezzoFinale());
        setBorsa(o.getBorsa());
    }
    public void calcolaFabbisogno(){

        int i = 0;
        while (i<borsa.size()) {
             borsa.get(i).getPelle().fabbisogno();
             for(int y = 0; y < borsa.get(i).getPelle().getColorEpezzo().size(); y++){
                 System.out.println("Calcolo fabbisogni per borsa: "+borsa.get(y).getName());
                fabbisogni.add(borsa.get(i).getPelle().getColorEpezzo().get(y).getFabbisogno());
             }
            i++;
        }
    }
    public void stampaFabbisogni(Borsa b){
        System.out.println("Fabbisogno per pelle");
        b.getPelle().fabbisogno();
        System.out.println("Fabbisogno per fodera");
        b.getFodera().fabbisogno();
    }
    public double calcolaPrezzoFinale(){
        double p = 0;
        for (Borsa value : borsa) {

            for (int j = 0; j < value.getPelle().getColorEpezzo().size();j++) {
                p += value.calcolaUnitPrice() * value.getPelle().get1Pezzo(j);
            }
        }
       setPrezzoFinale(p);
       return p;
    }
}
