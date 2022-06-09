package com.example.trening.model;

import javax.persistence.*;

@Entity
@Table(name = "nazwacwiczenia")
public class NazwaCwiczenia {

    @Id
    @GeneratedValue
    private int id;
    @Column(name="nazwa")
    private String nazwa;
    @Column(name = "opis")
    private String opis_cwiczenia;
//    @Enumerated(EnumType.STRING)
//    private PartieMiesni partiaMeisni;
//    @Enumerated(EnumType.STRING)
//    private KategoriaCwiczenia kategoriaCwiczenia;

    public NazwaCwiczenia(String nazwa) {
        this.nazwa = nazwa;
    }

    public NazwaCwiczenia(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

//    public String getOpisCwiczenia() {
//        return opis_cwiczenia;
//    }

//    public void setOpisCwiczenia(String opisCwiczenia) {
//        this.opis_cwiczenia = opisCwiczenia;
//    }

//    public PartieMiesni getPartiaMeisni() {
//        return partiaMeisni;
//    }
//
//    public void setPartiaMeisni(PartieMiesni partiaMeisni) {
//        this.partiaMeisni = partiaMeisni;
//    }
//
//    public KategoriaCwiczenia getKategoriaCwiczenia() {
//        return kategoriaCwiczenia;
//    }
//
//    public void setKategoriaCwiczenia(KategoriaCwiczenia kategoriaCwiczenia) {
//        this.kategoriaCwiczenia = kategoriaCwiczenia;
//    }

    @Override
    public String toString() {
        return "NazwaCwiczenia{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
//                ", opisCwiczenia='" + opis_cwiczenia + '\'' +
//                ", partiaMeisni=" + partiaMeisni +
//                ", kategoriaCwiczenia=" + kategoriaCwiczenia +
                '}';
    }
}
