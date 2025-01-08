package com.mycompany.java1;

public class Llibre {
    private String isbn;
    private String titol;
    private String autor;
    private String editorial;

    public Llibre(String isbn, String titol, String autor, String editorial) {
        this.isbn = isbn;
        this.titol = titol;
        this.autor = autor;
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Títol: " + titol + ", Autor: " + autor + ", Editorial: " + editorial;
    }
}
