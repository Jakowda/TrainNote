package com.example.trening.model;

import javax.persistence.*;


@Entity
@Table(name = "trening")
public class Trening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "data_treningu")
    private String data_treningu;
    @Column(name = "uzytkownik_id")
    private int uzytkownik_id;
    @Column(name = "opis_treningu")
    private String opis_treningu;

    public Trening(){}

    public Trening(String dataTreningu, int uzytkownikID) {
        this.id = id;
        this.data_treningu = dataTreningu;
        this.uzytkownik_id = uzytkownikID;
    }

    public int getId() { return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data_treningu;
    }

    public void setData(String data) {
        this.data_treningu = data;
    }

    public int getUzytkownik_id() {
        return uzytkownik_id;
    }

    public void setUzytkownik_id(int uzytkownikID) {
        this.uzytkownik_id = uzytkownikID;
    }

    public String getOpis_treningu() {
        return opis_treningu;
    }

    public void setOpis_treningu(String opisTreningu) {
        this.opis_treningu = opisTreningu;
    }

    @Override
    public String toString() {
        return "Trening{" +
                "id=" + id +
                ", data=" + data_treningu +
                ", uzytkownikID=" + uzytkownik_id +
                ", opis= "+ opis_treningu +
                '}';
    }
}