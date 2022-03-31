package com.company.item_used;

import com.company.item_used.Item;

import java.util.Scanner;

public class ItemComplessivePrice extends Item {

    public ItemComplessivePrice(String name, double price) {
        this.nome = name;
        this.price=price;
       this.dimension = 1;
    }
    public ItemComplessivePrice(){
        this.nome = "itemComp";
        this.price = 2;
        this.dimension = 1;
    }
    public ItemComplessivePrice(int t){
        this.dimension = 1;
        createComplessive();
    }
    private void createComplessive(){
        Scanner o = new Scanner(System.in);
        Scanner o1 = new Scanner(System.in);
        System.out.println("Inserire nome");
        String n = o.nextLine();
        //String n = "name";
        setNome(n);
        System.out.println("Inserire prezzo complessivo");
        double p = o1.nextDouble();
        //double p = 12;
        setPrice(p);
    }
    public void setName(String n){nome=n;}
    public void setPrice(double p){price=p;}
    public String getName(){return  nome;}
    public double getPrice(){return price;}
}
