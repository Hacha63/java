package com.mycompany.java1;

import java.util.Scanner;

public class UF2A7 {
    public static void main(String[] args) {
        UF2A7 programa = new UF2A7();
        Scanner scanner = new Scanner(System.in);

        Persona[] personas = new Persona[10];
        int numPersonas = 0;
        boolean sortir = false;

        while (!sortir) {

            System.out.println("\n----------------------------------\n" +
                                "1. Introduir persones a la agenda.\n" +
                                "2. Buscar persona per cognom\n" +
                                "3. Esborrar persona\n" +
                                "4. Llistar persones\n" +
                                "5. Sortir\n" +
                                "----------------------------------");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (numPersonas < 10) {
                        numPersonas = programa.introducirPersona(personas, numPersonas, scanner);
                    } else {
                        System.out.println("Ja hi ha 10 persones");
                    }
                    break;

                case 2:
                    System.out.println("Introdueix el cognom a buscar: ");
                    String cognom = scanner.nextLine();
                    programa.buscarCognom(personas, numPersonas, cognom);
                    break;

                case 3:
                    System.out.println("Introdueix el cognom a eliminar: ");
                    cognom = scanner.nextLine();
                    numPersonas = programa.EliminarPersona(personas, numPersonas, scanner, cognom);
                    break;

                case 4:
                    System.out.println("Llistant...");
                    if (numPersonas == 0){
                        System.out.println("No hi ha contactes");
                    }
                    else {
                        programa.llistarPersonas(personas, numPersonas);
                    }
                    break;

                case 5:
                    System.out.println("Sortint...");
                    sortir = true;
                    break;

                default:
                    System.out.println("Opció no valida");
                    break;
            }
        }


    }

    public int introducirPersona(Persona[] personas, int numPersonas, Scanner scanner) {
        System.out.println("Introdueix el nom de la persona: ");
        String nom = scanner.nextLine();
        System.out.println("Introdueix el cognom de la persona: ");
        String cognom = scanner.nextLine();
        System.out.println("Introdueix l'edat de la persona: ");
        int edat = scanner.nextInt();
        scanner.nextLine();

        personas[numPersonas] = new Persona(nom, cognom, edat);
        numPersonas++;
        System.out.println("Persona afegida: " + personas[numPersonas - 1]);
        return numPersonas;
    }

    public void llistarPersonas(Persona[] personas, int numPersonas) {
        System.out.println("\nContactes: ");
        for (int i = 0; i < numPersonas; i++) {
            System.out.println(personas[i]);
        }
    }

    public void buscarCognom(Persona[] personas, int numPersonas, String cognom) {
        boolean trobat = false;
        for (int i = 0; i < numPersonas; i++) {
            if (personas[i].getCognom().equals(cognom)) {
                System.out.println("\n\tPersona trobada");
                System.out.println(personas[i]);
                trobat = true;
                break;
            }
        }
        if (!trobat) {
            System.out.println("No s'ha trobat cap pesona " + cognom + ".");
        }
    }

    public int EliminarPersona(Persona[] personas, int numPersonas, Scanner scanner, String cognom) {
        boolean trobat = false;
        for (int i = 0; i < numPersonas; i++) {
            if (personas[i].getCognom().equals(cognom)) {
                System.out.println(personas[i]);
                System.out.println("Persona eliminada");

                trobat = true;

                for (int j = i; j < numPersonas - 1; j++) {
                    personas[j] = personas[j + 1];
                }
                personas[numPersonas - 1] = null;
                numPersonas--;
                break;
            }
        }
        if (!trobat) {
            System.out.println("No s'ha trobat cap persona " + cognom + ".");
        }

        return numPersonas;
    }

}
