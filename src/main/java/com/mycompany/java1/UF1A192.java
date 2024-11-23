package com.mycompany.java1;
import java.util.Scanner;
import java.util.Random;

public class UF1A192 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] numJugador = new int[6];
        int[] numLoteria = new int[6];
        boolean ganador = false;

        System.out.println("Introduce 6 números únicos entre 1 y 49 para tu apuesta:");
        for (int i = 0; i < 6; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            int numero = scanner.nextInt();

            boolean repetit = false;
            if (numero < 1 || numero > 49) {
                System.out.println("Número fuera de rango. Introduce un número entre 1 y 49.");
                i--;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (numJugador[j] == numero) {
                    System.out.println("Número repetido. Introduce un número diferente.");
                    repetit = true;
                    break;
                }
            }
            if (repetit) {
                i--;
            } else {
                numJugador[i] = numero;
            }
        }

        for (int i = 0; i < 6; i++) {
            int numero = random.nextInt(49) + 1;

            boolean repetit = false;
            for (int j = 0; j < i; j++) {
                if (numLoteria[j] == numero) {
                    repetit = true;
                    break;
                }
            }
            if (repetit) {
                i--;
            } else {
                numLoteria[i] = numero;
            }
        }

        System.out.println("\nCombinación ganadora de la lotería:");
        for (int num : numLoteria) {
            System.out.print(num + " ");
        }
        System.out.println();

        int encerts = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (numJugador[i] == numLoteria[j]) {
                    System.out.println("Número acertado: " + numJugador[i]);
                    encerts++;
                    break;
                }
            }
        }
        if (encerts > 0) {
            System.out.println("Has acertado " + encerts + " número(s).");
        } else {
            System.out.println("No has ganado nada :(");
        }
    }
}
