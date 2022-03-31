package com.company.item_used;

import com.company.item_used.Item;

import java.util.Scanner;

public class ItemUnitPrice extends Item {

    protected  String unit;

    public void associaUnit() {
        Scanner ob = new Scanner(System.in);
        if (unit == null) {
            System.out.println("Inserisci untià di misura");
            unit = ob.nextLine();
            //unit = "s";
        }
    }

    public ItemUnitPrice(String name, double price, double dimension) {
        this.nome = name;
        this.price=price;
        this.dimension = dimension;
    }
    public ItemUnitPrice(){ this.nome = "";
        this.price=12.00;
        this.dimension = 4;
    }
    public ItemUnitPrice(int i){
        createUnite();
    }

    private void createUnite(){
        associaUnit();
        Scanner o = new Scanner(System.in);
        Scanner o1 = new Scanner(System.in);
        System.out.println("Inserire nome");
        String n = o.nextLine();
        //String n ="name";
        setNome(n);
        System.out.println("Inserire prezzo/"+ unit);
        double p = o1.nextDouble();
        //double p = 12;
        setPrice(p);
        System.out.println("Inserire "+ unit);
        double d = o1.nextDouble();
        //double d = 4;
        setDimension(d);
    }
}
