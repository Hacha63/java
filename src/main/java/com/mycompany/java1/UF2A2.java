package com.mycompany.java1;
import java.util.Scanner;

public class UF2A2 {

    public static void main(String[] args) {
        UF2A2 prog = new UF2A2();

        String[] parking = new String[10];
        String opcio;

        prog.mostrarMenu();
        opcio = prog.triaOpcio();
        while (!opcio.equals("fi")) {
            switch (opcio) {
                case "aparcar":
                    System.out.println("Introdueix la matrícula per aparcar:");
                    String matriculaAparcar = prog.entraParaula();
                    if (prog.aparcar(parking, matriculaAparcar)) {
                        System.out.println("Cotxe aparcat amb èxit.");
                    } else {
                        System.out.println("No hi ha lloc disponible.");
                    }
                    break;
                case "desaparcar":
                    System.out.println("Introdueix la matrícula per desaparcar:");
                    String matriculaDesaparcar = prog.entraParaula();
                    if (prog.desaparcar(parking, matriculaDesaparcar)) {
                        System.out.println("Cotxe desparcat amb èxit.");
                    } else {
                        System.out.println("No s'ha trobat aquesta matrícula.");
                    }
                    break;
                case "mostrar":
                    prog.mostrarParquing(parking);
                    break;
                default:
                    System.out.println("Opció incorrecta!!");
            }
            prog.mostrarMenu();
            opcio = prog.triaOpcio();
        }
    }

    public void mostrarMenu() {
        System.out.println("Opcions:\n\taparcar\n\tdesaparcar\n\tmostrar\n\tfi");
    }

    public String triaOpcio() {
        Scanner scanner = new Scanner(System.in);
        String opcio;
        do {
            System.out.println("Opció: ");
            opcio = scanner.nextLine();
            if (!opcio.equals("aparcar") && !opcio.equals("desaparcar") && !opcio.equals("mostrar") && !opcio.equals("fi")) {
                System.out.println("Opció invalida");
            }
        } while (!opcio.equals("aparcar") && !opcio.equals("desaparcar") && !opcio.equals("mostrar") && !opcio.equals("fi"));
        return opcio;
    }

    public String entraParaula() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean aparcar(String[] places, String matricula) {
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                places[i] = matricula;
                return true;
            }
        }
        return false;
    }

    public boolean desaparcar(String[] places, String matricula) {
        for (int i = 0; i < places.length; i++) {
            if (matricula.equals(places[i])) {
                places[i] = null;
                return true;
            }
        }
        return false;
    }

    public void mostrarParquing(String[] places) {
        System.out.println("Estat del pàrquing:");
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                System.out.println("Plaça " + (i + 1) + ": buida");
            } else {
                System.out.println("Plaça " + (i + 1) + ": " + places[i]);
            }
        }
    }
}
