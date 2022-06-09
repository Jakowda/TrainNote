package com.example.trening.model;

public enum KategoriaCwiczenia {
    PUSH(1, "PUSH"), PULL(2, "PULL");

    private int id;
    private String nazwa;

    KategoriaCwiczenia(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }
}
