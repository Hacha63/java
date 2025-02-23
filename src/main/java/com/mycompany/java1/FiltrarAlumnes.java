package com.mycompany.java1;

import java.io.*;
import java.util.*;

class Alumne implements Serializable {
    String dni, nom, adreca, telefon;

    public Alumne(String dni, String nom, String adreca, String telefon) {
        this.dni = dni;
        this.nom = nom;
        this.adreca = adreca;
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return dni + "#" + nom + "#" + adreca + "#" + telefon;
    }
}

class Expedient implements Serializable {
    String dni;
    int codiAssignatura, notaOrdinaria, notaExtraordinaria;

    public Expedient(String dni, int codiAssignatura, int notaOrdinaria, int notaExtraordinaria) {
        this.dni = dni;
        this.codiAssignatura = codiAssignatura;
        this.notaOrdinaria = notaOrdinaria;
        this.notaExtraordinaria = notaExtraordinaria;
    }

    public int obtenirNotaAprovada() {
        if (notaOrdinaria >= 5) return notaOrdinaria;
        if (notaExtraordinaria >= 5) return notaExtraordinaria;
        return -1;
    }
}

public class FiltrarAlumnes {
    private static final String FITXER_ALUMNES = "C:\\Users\\Usuario\\IdeaProjects\\java\\src\\main\\java\\com\\mycompany\\java1\\Alumnes.dat";
    private static final String FITXER_EXPEDIENTS = "C:\\Users\\Usuario\\IdeaProjects\\java\\src\\main\\java\\com\\mycompany\\java1\\Expedients.dat";
    private static final String SORTIDA = "C:\\Users\\Usuario\\IdeaProjects\\java\\src\\main\\java\\com\\mycompany\\java1\\Alumnes_Aprovats.txt";

    private static final int CODI_ASSIGNATURA = 2022;

    public static void main(String[] args) {
        Map<String, Alumne> alumnes = carregarAlumnes();
        List<String> aprovats = processarExpedients(alumnes);
        guardarAprovats(aprovats);
    }

    private static Map<String, Alumne> carregarAlumnes() {
        Map<String, Alumne> alumnes = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXER_ALUMNES))) {
            while (true) {
                try {
                    Alumne alumne = (Alumne) ois.readObject();
                    alumnes.put(alumne.dni, alumne);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error carregant alumnes: " + e.getMessage());
        }
        return alumnes;
    }

    private static List<String> processarExpedients(Map<String, Alumne> alumnes) {
        List<String> aprovats = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXER_EXPEDIENTS))) {
            while (true) {
                try {
                    Expedient expedient = (Expedient) ois.readObject();
                    if (expedient.codiAssignatura == CODI_ASSIGNATURA) {
                        int nota = expedient.obtenirNotaAprovada();
                        if (nota != -1 && alumnes.containsKey(expedient.dni)) {
                            aprovats.add(alumnes.get(expedient.dni) + "#" + nota + "##");
                        }
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error processant expedients: " + e.getMessage());
        }
        return aprovats;
    }

    private static void guardarAprovats(List<String> aprovats) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SORTIDA))) {
            for (String linia : aprovats) {
                writer.write(linia);
                writer.newLine();
            }
            System.out.println("Fitxer " + SORTIDA + " generat correctament.");
        } catch (IOException e) {
            System.out.println("Error en guardar l'arxiu: " + e.getMessage());
        }
    }
}
