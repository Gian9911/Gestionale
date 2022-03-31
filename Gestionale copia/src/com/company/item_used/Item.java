package com.company.item_used;

public abstract class Item {
    protected String nome;
    protected double price;
    protected double dimension;

    public String getNome(){return nome;}
    public double getPrice() { return price; }
    public double getDimension() { return dimension; }

    public void setPrice(double p){price=p;}
    public void setNome(String n){nome = n; }
    public void setDimension(double dimension) { this.dimension = dimension; }
}
