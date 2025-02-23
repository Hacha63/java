package com.mycompany.java1;

import java.io.*;
import java.util.*;

class Joc implements Serializable {
    private String nom;
    private String dataAdquisicio;
    private double preu;
    private int partidesJugades;
    private int record;

    public Joc(String nom, String dataAdquisicio, double preu, int partidesJugades, int record) {
        this.nom = nom;
        this.dataAdquisicio = dataAdquisicio;
        this.preu = preu;
        this.partidesJugades = partidesJugades;
        this.record = record;
    }

    public String getNom() {
        return nom;
    }

    public void sumarPartides(int n) {
        this.partidesJugades += n;
    }

    public void actualitzarRecord(int nouRecord) {
        if (nouRecord > this.record) {
            this.record = nouRecord;
        }
    }

    @Override
    public String toString() {
        return "Nom: " + nom + " | Data: " + dataAdquisicio + " | Preu: " + preu + "€ | Partides: " + partidesJugades + " | Rècord: " + record;
    }
}

public class GestioJocs {
    private static final String FITXER = "jocs.dat";
    private static List<Joc> jocs = new ArrayList<>();

    public static void main(String[] args) {
        carregarJocs();
        Scanner scanner = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n1. Afegir joc");
            System.out.println("2. Sumar partides a un joc");
            System.out.println("3. Actualitzar rècord d'un joc");
            System.out.println("4. Llistar tots els jocs");
            System.out.println("5. Mostrar informació d'un joc");
            System.out.println("6. Sortir");
            System.out.print("Selecciona una opció: ");
            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1 -> afegirJoc(scanner);
                case 2 -> sumarPartides(scanner);
                case 3 -> actualitzarRecord(scanner);
                case 4 -> llistarJocs();
                case 5 -> mostrarJoc(scanner);
                case 6 -> System.out.println("Adeu!");
                default -> System.out.println("Opció no vàlida!");
            }
        } while (opcio != 6);
        guardarJocs();
    }

    private static void carregarJocs() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXER))) {
            jocs = (List<Joc>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No hi ha jocs guardats.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en carregar el fitxer.");
        }
    }

    private static void guardarJocs() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FITXER))) {
            oos.writeObject(jocs);
        } catch (IOException e) {
            System.out.println("Error en guardar els jocs.");
        }
    }

    private static void afegirJoc(Scanner scanner) {
        System.out.print("Nom del joc: ");
        String nom = scanner.nextLine();
        System.out.print("Data d'adquisició (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        System.out.print("Preu: ");
        double preu = scanner.nextDouble();
        System.out.print("Partides jugades: ");
        int partides = scanner.nextInt();
        System.out.print("Rècord: ");
        int record = scanner.nextInt();
        scanner.nextLine();

        jocs.add(new Joc(nom, data, preu, partides, record));
        System.out.println("Joc afegit correctament!");
    }

    private static void sumarPartides(Scanner scanner) {
        System.out.print("Nom del joc: ");
        String nom = scanner.nextLine();
        System.out.print("Nombre de partides a sumar: ");
        int partides = scanner.nextInt();
        scanner.nextLine();

        for (Joc joc : jocs) {
            if (joc.getNom().equalsIgnoreCase(nom)) {
                joc.sumarPartides(partides);
                System.out.println("Partides sumades correctament!");
                return;
            }
        }
        System.out.println("Joc no trobat!");
    }

    private static void actualitzarRecord(Scanner scanner) {
        System.out.print("Nom del joc: ");
        String nom = scanner.nextLine();
        System.out.print("Nou rècord: ");
        int record = scanner.nextInt();
        scanner.nextLine();

        for (Joc joc : jocs) {
            if (joc.getNom().equalsIgnoreCase(nom)) {
                joc.actualitzarRecord(record);
                System.out.println("Rècord actualitzat!");
                return;
            }
        }
        System.out.println("Joc no trobat!");
    }

    private static void llistarJocs() {
        if (jocs.isEmpty()) {
            System.out.println("No hi ha jocs registrats.");
        } else {
            System.out.println("\nLlista de jocs:");
            for (Joc joc : jocs) {
                System.out.println(joc);
            }
        }
    }

    private static void mostrarJoc(Scanner scanner) {
        System.out.print("Nom del joc: ");
        String nom = scanner.nextLine();

        for (Joc joc : jocs) {
            if (joc.getNom().equalsIgnoreCase(nom)) {
                System.out.println(joc);
                return;
            }
        }
        System.out.println("Joc no trobat!");
    }
}