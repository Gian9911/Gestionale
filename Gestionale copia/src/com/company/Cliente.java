package com.company;
import com.company.agenzia.Fattura;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private  String name;
    private  String sedeLegale;
    private  String LuogoDestinazioneMerce;

    public Cliente(){}
    public Cliente(String name, String sedeLegale, String luogoDestinazioneMerce) {
        this.name = name;
        this.sedeLegale = sedeLegale;
        this.LuogoDestinazioneMerce = luogoDestinazioneMerce;
    }
    public String getName() { return name; }
    public String getSedeLegale() { return sedeLegale; }
    public String getLuogoDestinazioneMerce() { return LuogoDestinazioneMerce; }
    public void setName(String name) { this.name = name; }
    public void setLuogoDestinazioneMerce(String luogoDestinazioneMerce) { LuogoDestinazioneMerce
            = luogoDestinazioneMerce; }
    public void setSedeLegale(String sedeLegale) { this.sedeLegale = sedeLegale; }
    public void update1( Fattura arg) {
        System.out.println("Traserferimento all' azienda : "+ arg.getIntestazione().getName());
    }
    @Override
    public void update(Observable azienda, Object fattura) {
        System.out.println("In quanto cliente, appena possibile effettuerò il pagamento");
        update1((Fattura) fattura);
    }
}
