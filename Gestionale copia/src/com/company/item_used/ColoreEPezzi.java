package com.company.item_used;

public class ColoreEPezzi {
    private int numeroPezzi;
    private String color;
    private double fabbisogno;

    public String getColore(){return color;}
    public int getNumeroPezzi(){return numeroPezzi;}
    public void setColor(String colore){color=colore;}
    public void setNumeroPezzi(int prz){numeroPezzi=prz;}
    public double getFabbisogno() {
        return fabbisogno;
    }
    public void setFabbisogno(double fabbisogno) {
        this.fabbisogno = fabbisogno;
    }

    public void setColoreEPezzi(String colore, int pezzi){
        setColor(colore);
        setNumeroPezzi(pezzi);
    }

}
