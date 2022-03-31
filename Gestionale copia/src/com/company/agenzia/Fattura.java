package com.company.agenzia;

import com.company.item_used.Data;
import com.company.item_used.OrdineProduzione;

import java.time.LocalDate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fattura {
    private int numeroProgressivo;
    private OrdineProduzione ordineProduzione;
    private final Data dataDiEmissione;
    private Azienda intestazione;

    public Fattura(Azienda azienda){
        numeroProgressivo = 1;
        ordineProduzione = new OrdineProduzione();
        dataDiEmissione = new Data();
        intestazione = azienda;
    }
    public void setOrdineProduzione(OrdineProduzione o){ordineProduzione = o;}
    public void setIntestazione(Azienda intestazione) { this.intestazione = intestazione; }
    public void setNumeroProgressivo(int numeroProgressivo) { this.numeroProgressivo = numeroProgressivo; }
    public Azienda getIntestazione() { return intestazione; }
    public OrdineProduzione getOrdineProduzione() { return ordineProduzione; }

    public void stampaFattura(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateToStr = dateFormat.format(date);
        System.out.println("Data di emissione: "+ dateToStr);

        LocalDate today = LocalDate.now();
        int currentDate= today.getDayOfMonth();
        dataDiEmissione.setGiorno(currentDate);
        int currentMonth= today.getMonthValue();
        dataDiEmissione.setMese(currentMonth);
        int currentYear= today.getYear();
        dataDiEmissione.setAnno(currentYear);
        this.dataDiEmissione.setData(dateToStr);


        System.out.println("Numero Progressivo "+numeroProgressivo);
        System.out.println("Azienda: "+intestazione.getName());
        System.out.println("numero d'ordine "+ordineProduzione.getId());
        System.out.println("Cliente: "+ordineProduzione.getCliente().getName());
        System.out.println("Prezzo finale: "+ordineProduzione.calcolaPrezzoFinale());
    }
}
