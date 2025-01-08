package com.mycompany.java1;

import java.util.Scanner;

public class UF2A5 {
    public static void main(String[] args) {
        UF2A5 programa = new UF2A5();
        Scanner scanner = new Scanner(System.in);

        Llibre[] biblioteca = new Llibre[10];
        int numLlibres = 0;

        biblioteca[numLlibres++] = new Llibre("3", "Títol C", "Autor 1", "Editorial 3");
        biblioteca[numLlibres++] = new Llibre("1", "Títol A", "Autor 2", "Editorial 1");
        biblioteca[numLlibres++] = new Llibre("2", "Títol B", "Autor 3", "Editorial 2");
        biblioteca[numLlibres++] = new Llibre("4", "Títol D", "Autor 1", "Editorial 3");
        biblioteca[numLlibres++] = new Llibre("5", "Títol E", "Autor 2", "Editorial 1");
        biblioteca[numLlibres++] = new Llibre("6", "Títol F", "Autor 3", "Editorial 2");
        biblioteca[numLlibres++] = new Llibre("7", "Títol G", "Autor 1", "Editorial 3");
        biblioteca[numLlibres++] = new Llibre("8", "Títol H", "Autor 2", "Editorial 1");
        biblioteca[numLlibres++] = new Llibre("9", "Títol I", "Autor 3", "Editorial 2");
        biblioteca[numLlibres++] = new Llibre("10", "Títol J", "Autor 3", "Editorial 2");


        boolean sortir = false;
        while (!sortir) {
            System.out.println("\n\tMENÚ");
            System.out.println("1. Ordenar per ISBN");
            System.out.println("2. Llistar llibres");
            System.out.println("3. Buscar llibres d'un autor");
            System.out.println("4. Buscar llibre per ISBN");
            System.out.println("0. Sortir");
            System.out.print("Opció: ");
            int opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    programa.ordenarPerIsbn(biblioteca, numLlibres);
                    System.out.println("Llibres ordenats per ISBN.");
                    break;
                case 2:
                    programa.llistarLlibres(biblioteca, numLlibres);
                    break;
                case 3:
                    System.out.print("Introdueix el nom de l'autor: ");
                    String autor = scanner.nextLine();
                    programa.buscarPerAutor(biblioteca, numLlibres, autor);
                    break;
                case 4:
                    System.out.print("Introdueix l'ISBN del llibre: ");
                    String isbn = scanner.nextLine();
                    programa.buscarPerIsbn(biblioteca, numLlibres, isbn);
                    break;
                case 0:
                    sortir = true;
                    System.out.println("Sortint del programa...");
                    break;
                default:
                    System.out.println("Opció no vàlida. Torna-ho a intentar.");
            }
        }
    }

    public void ordenarPerIsbn(Llibre[] biblioteca, int numLlibres) {
        for (int i = 0; i < numLlibres - 1; i++) {
            int indexMinim = i;
            for (int j = i + 1; j < numLlibres; j++) {
                int isbnActual = Integer.parseInt(biblioteca[j].getIsbn());
                int isbnMinim = Integer.parseInt(biblioteca[indexMinim].getIsbn());
                if (isbnActual < isbnMinim) {
                    indexMinim = j;
                }
            }
            Llibre temp = biblioteca[i];
            biblioteca[i] = biblioteca[indexMinim];
            biblioteca[indexMinim] = temp;
        }
    }


    // Funció per llistar l'array
    public void llistarLlibres(Llibre[] biblioteca, int numLlibres) {
        System.out.println("\n--- LLIBRES A LA BIBLIOTECA ---");
        for (int i = 0; i < numLlibres; i++) {
            System.out.println(biblioteca[i]);
        }
    }

    // Funció per buscar llibres d'un autor
    public void buscarPerAutor(Llibre[] biblioteca, int numLlibres, String autor) {
        boolean trobat = false;
        System.out.println("\n--- LLIBRES DE L'AUTOR: " + autor + " ---");
        for (int i = 0; i < numLlibres; i++) {
            if (biblioteca[i].getAutor().equalsIgnoreCase(autor)) {
                System.out.println(biblioteca[i]);
                trobat = true;
            }
        }
        if (!trobat) {
            System.out.println("No s'han trobat llibres de l'autor " + autor + ".");
        }
    }

    // Funció per buscar un llibre per ISBN (búsqueda lineal)
    public void buscarPerIsbn(Llibre[] biblioteca, int numLlibres, String isbn) {
        boolean trobat = false;
        for (int i = 0; i < numLlibres; i++) {
            if (biblioteca[i].getIsbn().equals(isbn)) {
                System.out.println("\n--- LLIBRE TROBAT ---");
                System.out.println(biblioteca[i]);
                trobat = true;
                break;
            }
        }
        if (!trobat) {
            System.out.println("No s'ha trobat cap llibre amb l'ISBN " + isbn + ".");
        }
    }
}
