package com.mycompany.java1;
import java.util.Random;

public class UF1A203 {
    public static void main(String[] args) {
        Random random = new Random();

        int files = 4;
        int columnes = 6;
        int sumaTotal = 0;
        int[] sumaFiles = new int[files];
        int[] sumaColumnes = new int[columnes];
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;

        int[][] T = new int[files][columnes];

        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                T[i][j] = random.nextInt(1, 201);
                sumaFiles[i] += T[i][j];
                sumaColumnes[j] += T[i][j];
                sumaTotal += T[i][j];

                if (T[i][j] > maxElement) {
                    maxElement = T[i][j];
                }
                if (T[i][j] < minElement) {
                    minElement = T[i][j];
                }
            }
        }

        System.out.println("Taula generada:");
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.print(T[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Suma de cada fila:");
        for (int i = 0; i < files; i++) {
            System.out.println("Fila " + (i + 1) + ": " + sumaFiles[i]);
        }
        System.out.println();

        System.out.println("Suma de cada columna:");
        for (int j = 0; j < columnes; j++) {
            System.out.println("Columna " + (j + 1) + ": " + sumaColumnes[j]);
        }
        System.out.println();

        System.out.println("Suma total de tots els elements: " + sumaTotal);
        System.out.println("Element màxim: " + maxElement);
        System.out.println("Element mínim: " + minElement);
    }
}
