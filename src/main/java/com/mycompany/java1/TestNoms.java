package com.mycompany.java1;

import java.util.Scanner;

class Noms {
    private String[] llista;
    private int capacitat;
    private int quantitat;

    public Noms(int capacitat) {
        this.capacitat = capacitat;
        this.quantitat = 0;
        this.llista = new String[capacitat];
    }

    public int getQuantitat() {
        return quantitat;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public int afegirNom(String nom) {
        if (quantitat >= capacitat) {
            return -1;
        }
        for (int i = 0; i < quantitat; i++) {
            if (llista[i].equals(nom)) {
                return 1;
            }
        }
        llista[quantitat++] = nom;
        return 0;
    }

    public boolean eliminarNom(String nom) {
        for (int i = 0; i < quantitat; i++) {
            if (llista[i].equals(nom)) {
                for (int j = i; j < quantitat - 1; j++) {
                    llista[j] = llista[j + 1];
                }
                llista[--quantitat] = null;
                return true;
            }
        }
        return false;
    }

    public void buidarLlista() {
        for (int i = 0; i < quantitat; i++) {
            llista[i] = null;
        }
        quantitat = 0;
    }

    public String mostrarNom(int posicio) {
        if (posicio >= 0 && posicio < quantitat) {
            return llista[posicio];
        }
        return null;
    }

    public boolean llistaPlena() {
        return quantitat >= capacitat;
    }

    @Override
    public String toString() {
        if (quantitat == 0) {
            return "Llista Buida!!";
        }
        StringBuilder resultat = new StringBuilder();
        for (int i = 0; i < quantitat; i++) {
            resultat.append(i).append("-").append(llista[i]).append("\n");
        }
        return resultat.toString();
    }
}

public class TestNoms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Noms noms = new Noms(5);
        int opcio;
        do {
            System.out.println("\n1) Afegir Nom");
            System.out.println("2) Eliminar Nom");
            System.out.println("3) Buidar Llista");
            System.out.println("4) Mostrar Nom");
            System.out.println("5) Llista Plena?");
            System.out.println("6) Mostrar tota la llista");
            System.out.println("7) Sortir");
            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    System.out.print("Nom:");
                    String nom = scanner.nextLine();
                    int resultat = noms.afegirNom(nom);
                    if (resultat == -1) System.out.println("Llista plena!");
                    else if (resultat == 1) System.out.println("Nom ja existent!");
                    else System.out.println("Afegit correctament!");
                    break;
                case 2:
                    System.out.print("Nom:");
                    nom = scanner.nextLine();
                    if (noms.eliminarNom(nom)) System.out.println("Eliminat correctament!");
                    else System.out.println("Nom no trobat!");
                    break;
                case 3:
                    noms.buidarLlista();
                    System.out.println("Llista buidada!");
                    break;
                case 4:
                    System.out.print("Posició:");
                    int posicio = scanner.nextInt();
                    scanner.nextLine();
                    String nomMostrat = noms.mostrarNom(posicio);
                    if (nomMostrat != null) System.out.println(nomMostrat);
                    else System.out.println("Posició no vàlida!");
                    break;
                case 5:
                    System.out.println(noms.llistaPlena() ? "Llista plena" : "Llista encara no està plena");
                    break;
                case 6:
                    System.out.println(noms);
                    break;
            }
        } while (opcio != 7);
        scanner.close();
    }
}
