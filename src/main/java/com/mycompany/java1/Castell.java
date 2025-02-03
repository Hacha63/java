package com.mycompany.java1;

public class Castell {
    private int codi;
    private String descripcio;
    private int punts_carregats;
    private int punts_descarregats;


    public Castell(int codi, String descripcio, int punts_carregats, int punts_descarregats){
        this.codi = codi;
        this.descripcio = descripcio;
        this.punts_carregats = punts_carregats;
        this.punts_descarregats = punts_descarregats;
    }

    public int getCodi() {
        return codi;
    }

    public int getPunts_carregats() {
        return punts_carregats;
    }

    public int getPunts_descarregats() {
        return punts_descarregats;
    }

    public String getDescripcio() {
        return descripcio;
    }

}
