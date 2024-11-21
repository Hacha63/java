package com.mycompany.java1;

public class BuscarArray {
    public static void main(String[] args) {
        double[] arrayNotes = {4, 6.5, 8.5, 10, 6.9, 8, 8.5, 7, 10, 6.6, 5};

        boolean trobat = false;
        int index = 0;
        while ((index < arrayNotes.length) && (!trobat)) {
            if (arrayNotes[index] == 10) {
                trobat = true;
            }
            index = index + 1;
        }
        if (trobat) {
            System.out.println("Algú ha tret un 10.");
        } else {
            System.out.println("Ningú ha tret un 10");
        }
    }
}
