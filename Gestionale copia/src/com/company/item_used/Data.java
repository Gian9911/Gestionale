package com.company.item_used;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Data {
    private String data;
    private int giorno;
    private int mese;
    private int anno;

    public Data (){
        data = "1/1/1999";
        giorno = 1;
        mese = 1;
        anno = 1999;
    }
    public Data(int giorno, int mese, int anno){
        data=giorno+"/"+mese+"/"+anno;
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }

    public int getAnno() { return anno; }
    public void setGiorno(int giorno) {
        this.giorno = giorno;
        data = giorno+"/"+mese+"/"+anno;
    }
    public void setMese(int mese) {
        this.mese = mese;
        data = giorno+"/"+mese+"/"+anno;
    }
    public void setAnno(int anno) {
        this.anno = anno;
        data = giorno+"/"+mese+"/"+anno;
    }

    public void setDate(int giorno,int mese,int anno){
        setGiorno(giorno);
        setMese(mese);
        setAnno(anno);
       setData(giorno+"/"+mese+"/"+anno);
    }
    public void setData(String g){this.data = g;}

    public void inserisciData(){
        Scanner ob = new Scanner(System.in);
        System.out.println("Inserire: giorno:");
        setGiorno(ob.nextInt());
        //setGiorno(1);
        System.out.println("Inserire: mese:");
        setMese(ob.nextInt());
        //setMese(3);
        System.out.println("Inserire: anno:");
        setAnno(ob.nextInt());
        //setAnno(2021);
        data = giorno+"/"+mese+"/"+anno;
    }
    public void streamData(){ System.out.println(data); }

    public boolean minus (Data d2){
        boolean r = false;
        if (this.anno < d2.anno)
            r = true;
        else if (this.anno == d2.anno & this.mese < d2.mese)
            r = true;
        else if ((this.anno == d2.anno & this.mese == d2.mese & this.giorno < d2.giorno))
            r = true;
        return r;
    }
    public boolean check(){
        Scanner on = new Scanner(System.in);
        boolean t = true;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateToStr = dateFormat.format(date);
        System.out.println("Data di emissione: "+ dateToStr);

        LocalDate today = LocalDate.now();
        int currentDate= today.getDayOfMonth();
        int currentMonth= today.getMonthValue();
        int currentYear= today.getYear();
        Data dataOdierna = new Data(currentDate,currentMonth,currentYear);
        if (this.minus(dataOdierna)) {
            System.out.println("inserire data corretta, la consegna doveva già essere avvenuta!");
            inserisciData();//mettere come commento per i test
            t = false;
        }

        if (anno < 2000 | anno > 2500){
            System.out.println("inserisci un numero di anno coretto anno troppo vecchio o troppo distante");
            setAnno(on.nextInt());//mettere come commento per i test
            t = false;
        }
        if (mese > 12){
            System.out.println("inserisci un numero di mese coretto perche > 12");
            setMese(on.nextInt());//mettere come commento per test
            t = false;
        }
        if (anno%4==0) {
            if ((anno % 100 == 0 & anno % 400 == 0) | anno % 100 != 0) {
                if (mese == 2) {
                    if (giorno > 29) {
                        System.out.println("inserisci un numero di giorno coretto, febbraio di 29 giorni");
                        setGiorno(on.nextInt());//metti come commento per test
                        t = false;
                    }
                }
            }
        }
        if (anno%4!=0 & mese == 2){
                if (giorno > 28) {
                    System.out.println("inserisci un numero di giorno coretto, febbraio di 28 giorni");
                    setGiorno(on.nextInt());//metti comoe commento per i test
                    t = false;
                }
            }

        if ( mese == 1 | mese==3 | mese == 5 | mese == 7 | mese == 8 | mese == 10 | mese == 12 ) {
            if (giorno>31) {
                System.out.println("inserisci un numero di giorno coretto, mese di 31 giorni");
                setGiorno(on.nextInt());//metti come cpmmento per test
                t = false;
            }
        }
        else  if (mese == 2 | mese==4 |mese == 6| mese == 11) {
            if (giorno > 30) {
                System.out.println("inserisci un numero di giorno coretto mese di 30 giorni");
                setGiorno(on.nextInt());
                setGiorno(1);
                t = false;
            }
        }
        else  {
            System.out.println("inserisci un numero di mese coretto,e inserisci il valore corrispettivo da 1 a 12");
            setMese(on.nextInt());//mettere come commento per i test
            t = false;
        }
        if (t)
            System.out.println("data ok");
        return  t;
    }
}

