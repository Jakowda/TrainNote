package com.example.trening.model;

import javax.persistence.*;

@Entity
@Table(name = "cwiczenie")
public class Cwiczenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "nazwacwiczeniaid")
    private NazwaCwiczenia nazwa_cwiczenia;
    @Column(name = "treningid")
    private int trening_id;

    public Cwiczenie(){}

    public Cwiczenie(NazwaCwiczenia nazwa_cwiczenia, int trening_id) {
        this.nazwa_cwiczenia = nazwa_cwiczenia;
        this.trening_id = trening_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NazwaCwiczenia getNazwa_cwiczenia() {
        return nazwa_cwiczenia;
    }

    public void setNazwa_cwiczenia(NazwaCwiczenia nazwa_cwiczenia) {
        this.nazwa_cwiczenia = nazwa_cwiczenia;
    }

    public int getTrening_id() {
        return trening_id;
    }

    public void setTrening_id(int trening_id) {
        this.trening_id = trening_id;
    }

    @Override
    public String toString() {
        return "Cwiczenie{" +
                "id=" + id +
                ", nazwa_cwiczenia=" + nazwa_cwiczenia +
                ", trening_id=" + trening_id +
                '}';
    }
}
