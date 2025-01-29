package com.mycompany.java1;

public class Peli {
    private String titol;
    private String director;
    private int any;
    private int durada;
    private int[] protagonistes;

    public Peli(String titol, String director, int any, int durada, int[] protagonistes){
        this.titol = titol;
        this.director = director;
        this.any = any;
        this.durada = durada;
        this.protagonistes = protagonistes;
    }
    public String getTitol(){return titol;}
    public String getDirector(){return director;}
    public int getAny(){return any;}
    public int getDurada(){return durada;}
    public int[] getprotagonistes(){return protagonistes;}
}
