package com.company.agenzia;

import com.company.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagrafe {
    private final List<Cliente> listaCliente;

    public Anagrafe(){listaCliente = new ArrayList<>(); }

    public void inserisciCliente(String name){
        Cliente c = new Cliente();
        Scanner ob = new Scanner(System.in);
        c.setName(name);
        System.out.println("Inserire la sede legale del nuovo cliente:");
        c.setSedeLegale(ob.nextLine());
        System.out.println("Inserire il luogo destinazione merce del nuovo cliente:");
        c.setLuogoDestinazioneMerce(ob.nextLine());
        registraCliente(c);
    }
    public Cliente searchClientByName(String s){
        int i = 0;
        Cliente c = null;
        while (i < listaCliente.size()) {
            if (s.equals(listaCliente.get(i).getName()))
                c = listaCliente.get(i);
            i++;
        }
        return c;
    }
    public void registraCliente(Cliente c){ listaCliente.add(c); }

    public String trovaSedeLegale(String d){
        Cliente c = searchClientByName(d);
        return c.getSedeLegale();
    }
    public String trovaLuogoConsegna(String d){
        Cliente c = searchClientByName(d);
        return c.getLuogoDestinazioneMerce();
    }
}
