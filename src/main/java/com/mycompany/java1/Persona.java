package com.mycompany.java1;

public class Persona {
    private String nom;
    private String cognom;
    private int telefon;

    public Persona(String nom, String cognom, int telefon) {
        this.nom = nom;
        this.cognom = cognom;
        this.telefon = telefon;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public int getTelefon() {
        return telefon;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Cognom: " + cognom + ", Telefon: " + telefon;
    }
}
