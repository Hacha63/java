package com.mycompany.java1;

public class Colla {
    private String nom;
    private String Localitat;
    int[] codisCastellsPrincipals;

    public Colla(String nom, String Localitat, int []codisCastellsPrincipals){
        this.nom = nom;
        this.Localitat = Localitat;
        this.codisCastellsPrincipals = codisCastellsPrincipals;
    }

    public String getNom() {return nom;}

    public String getLocalitat() {return Localitat;}

    public int[] getCodisCastellsPrincipals() {return codisCastellsPrincipals;}

}
