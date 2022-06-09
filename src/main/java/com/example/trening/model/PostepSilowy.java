package com.example.trening.model;

public class PostepSilowy {
    private String data_treningu;
    private double obciazenie;
    private int ilosc_powtorzen;


    public PostepSilowy(Object[] columns) {
        this.data_treningu = columns[0].toString();
        this.obciazenie = (double) columns[1];
        this.ilosc_powtorzen = (int) columns[2];
    }

    public String getData_treningu() {
        return data_treningu;
    }

    public void setData_treningu(String data_treningu) {
        this.data_treningu = data_treningu;
    }

    public double getObciazenie() {
        return obciazenie;
    }

    public void setObciazenie(double obciazenie) {
        this.obciazenie = obciazenie;
    }

    public int getIlosc_powtorzen() {
        return ilosc_powtorzen;
    }

    public void setIlosc_powtorzen(int ilosc_powtorzen) {
        this.ilosc_powtorzen = ilosc_powtorzen;
    }
}
