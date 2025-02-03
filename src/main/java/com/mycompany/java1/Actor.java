package com.mycompany.java1;

import java.time.LocalDate;

public class Actor {
    private int codi;
    private String nom;
    private LocalDate data_naixement;

    public Actor(int codi, String nom, LocalDate data_naixement){
        this.codi = codi;
        this.nom = nom;
        this.data_naixement = data_naixement;
    }

    public int getCodi(){return codi;}
    public String getNom(){return nom;}
    public LocalDate getData_naixement(){return data_naixement;}

}
