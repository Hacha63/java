package com.mycompany.java1;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

public class UF3A1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String fitxerEntrada = "/home/alumnet/Escriptori/java/java/src/main/java/com/mycompany/java1/notes.txt";
        String fitxerSortida = "/home/alumnet/Escriptori/java/java/src/main/java/com/mycompany/java1/resultats.txt";

        try {
            llegirIProcessarNotes(fitxerEntrada, fitxerSortida);
            System.out.println("Les notes han estat processades i guardades al fitxer: " + fitxerSortida);
        } catch (IOException | ParseException e) {
            System.err.println("S'ha produït un error: " + e.getMessage());
        }
    }

    public static void llegirIProcessarNotes(String fitxerEntrada, String fitxerSortida) throws IOException, ParseException {
        try (BufferedReader lector = new BufferedReader(new FileReader(fitxerEntrada));
             BufferedWriter escriptor = new BufferedWriter(new FileWriter(fitxerSortida))) {

            String linia;
            while ((linia = lector.readLine()) != null) {
                if (linia.trim().isEmpty()) continue;
                String[] parts = linia.split(" ");
                if (parts.length < 3) {
                    System.err.println("Línia ignorada (format incorrecte): " + linia);
                    continue;
                }

                String nom = parts[0];
                String cognom = parts[1];

                double sumaNotes = 0;
                int numNotes = parts.length - 2;
                for (int i = 2; i < parts.length; i++) {
                    try {
                        sumaNotes += Double.parseDouble(parts[i]);
                    } catch (NumberFormatException e) {
                        System.err.println("Nota no vàlida ignorada: " + parts[i]);
                        numNotes--;
                    }
                }

                if (numNotes > 0) {
                    // Calcular la mitjana
                    double mitjana = sumaNotes / numNotes;
                    mitjana = formatar(mitjana);

                    escriptor.write(nom + " " + cognom + " - Mitjana: " + mitjana);
                    escriptor.newLine();
                } else {
                    System.err.println("No s'han trobat notes vàlides per a: " + nom + " " + cognom);
                }
            }
        }
    }

    public static double formatar(double n) throws ParseException {
        DecimalFormat formatar = new DecimalFormat("####.##");
        return formatar.parse(formatar.format(n)).doubleValue();
    }
}
