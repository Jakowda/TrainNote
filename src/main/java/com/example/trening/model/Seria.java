package com.example.trening.model;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;

@Entity
@Table(name = "serie")
public class Seria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "iloscpowtorzen")
    private int ilosc_powtorzen;
    @Column(name = "obciazenie")
    private double obciazenie;
    @ManyToOne
    @JoinColumn(name = "cwiczenieid")
    private Cwiczenie cwiczenie;

    public Seria(int ilosc_powtorzen, double obciazenie, Cwiczenie cwiczenie) {
        this.ilosc_powtorzen = ilosc_powtorzen;
        this.obciazenie = obciazenie;
        this.cwiczenie = cwiczenie;
    }

    public Seria(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIlosc_powtorzen() {
        return ilosc_powtorzen;
    }

    public void setIlosc_powtorzen(int ilosc_powtorzen) {
        this.ilosc_powtorzen = ilosc_powtorzen;
    }

    public double getObciazenie() {
        return obciazenie;
    }

    public void setObciazenie(double obciazenie) {
        this.obciazenie = obciazenie;
    }

    public Cwiczenie getCwiczenie() {
        return cwiczenie;
    }

    public void setCwiczenie(Cwiczenie cwiczenie) {
        this.cwiczenie = cwiczenie;
    }

    @Override
    public String toString() {
        return "Seria{" +
                "id=" + id +
                ", ilosc_powtorzen=" + ilosc_powtorzen +
                ", obciazenie=" + obciazenie +
                ", cwiczenie=" + cwiczenie +
                '}';
    }
}
