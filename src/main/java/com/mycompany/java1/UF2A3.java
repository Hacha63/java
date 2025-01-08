package com.mycompany.java1;

import java.util.Scanner;

public class UF2A3 {

    public static void main(String[] args) {
        UF2A3 programa = new UF2A3();
        String[] usuaris = { "jlopez", "rgomez", "amarti" };
        String[] contrasenyes = { "aaa", "bbb", "ccc" };
        double[] saldo = { 1900, 4500, 10800 };
        int[] bitllets = { 10, 10, 10 };

        while (true) {
            int usuariActiu = programa.iniciaSessio(usuaris, contrasenyes);
            if (usuariActiu == -1) {
                System.out.println("Error d'inici de sessió. Sortint del programa.");
                return;
            }
            char opcio = programa.menu();
            while (opcio != '5') {
                switch (opcio) {
                    case '1':
                        programa.consultaSaldo(usuariActiu, saldo);
                        break;
                    case '2':
                        programa.retirarDiners(usuariActiu, saldo, bitllets);
                        break;
                    case '3':
                        programa.ingressar(usuariActiu, saldo);
                        break;
                    case '4':
                        programa.canviarClau(usuariActiu, contrasenyes);
                        break;
                    default:
                        System.out.println("Opció incorrecta. Torna a intentar.");
                }
                opcio = programa.menu();
            }
        }
    }

    int iniciaSessio(String[] usuaris, String[] contrasenyes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvingut al caixer automàtic.");
        System.out.print("Introdueix el nom d'usuari: ");
        String usuari = scanner.nextLine();
        System.out.print("Introdueix la contrasenya: ");
        String clau = scanner.nextLine();

        for (int i = 0; i < usuaris.length; i++) {
            if (usuaris[i].equals(usuari) && contrasenyes[i].equals(clau)) {
                System.out.println("Sessió iniciada correctament.");
                return i;
            }
        }
        return -1;
    }

    char menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nOpcions disponibles:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar diners");
        System.out.println("3. Ingressar diners");
        System.out.println("4. Canviar contrasenya");
        System.out.println("5. Sortir");
        System.out.print("Tria una opció: ");
        return scanner.nextLine().charAt(0);
    }

    void consultaSaldo(int usuariActiu, double[] saldo) {
        System.out.println("El teu saldo actual és: " + saldo[usuariActiu] + " €");
    }

    void retirarDiners(int usuariActiu, double[] saldo, int[] bitllets) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix la quantitat a retirar: ");
        int quantitat = scanner.nextInt();

        if (quantitat > saldo[usuariActiu]) {
            System.out.println("No tens saldo suficient.");
            return;
        }

        int[] valorsBitllets = {50, 20, 10};
        int[] bitlletsUtilitzats = new int[3];
        int resta = quantitat;

        for (int i = 0; i < valorsBitllets.length; i++) {
            while (resta >= valorsBitllets[i] && bitllets[i] > 0) {
                resta -= valorsBitllets[i];
                bitlletsUtilitzats[i]++;
                bitllets[i]--;
            }
        }

        if (resta == 0) {
            saldo[usuariActiu] -= quantitat;
            System.out.println("Retirada completada. Has rebut:");
            for (int i = 0; i < valorsBitllets.length; i++) {
                if (bitlletsUtilitzats[i] > 0) {
                    System.out.println(bitlletsUtilitzats[i] + " bitllet(s) de " + valorsBitllets[i] + " €");
                }
            }
        } else {
            System.out.println("El caixer no pot donar exactament aquesta quantitat. Transacció cancel·lada.");
            // Tornar els bitllets al caixer
            for (int i = 0; i < valorsBitllets.length; i++) {
                bitllets[i] += bitlletsUtilitzats[i];
            }
        }
    }

    void ingressar(int usuariActiu, double[] saldo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix la quantitat a ingressar (múltiple de 50, 20 o 10): ");
        int quantitat = scanner.nextInt();

        if (quantitat % 50 == 0 || quantitat % 20 == 0 || quantitat % 10 == 0) {
            saldo[usuariActiu] += quantitat;
            System.out.println("Has ingressat " + quantitat + " €. Nou saldo: " + saldo[usuariActiu] + " €");
        } else {
            System.out.println("Quantitat no vàlida. Ha de ser múltiple de 50, 20 o 10.");
        }
    }

    void canviarClau(int usuariActiu, String[] contrasenyes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix la nova contrasenya (mínim 4 caràcters): ");
        String novaClau = scanner.nextLine();

        if (novaClau.length() >= 4) {
            contrasenyes[usuariActiu] = novaClau;
            System.out.println("Contrasenya canviada correctament.");
        } else {
            System.out.println("La contrasenya és massa curta. Ha de tenir un mínim de 4 caràcters.");
        }
    }
}
