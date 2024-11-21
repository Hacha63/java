package com.mycompany.java1;
import java.util.Random;

public class UF1A202 {
    public static void main(String[] args) {
        Random random = new Random();

        int files = 4;
            int columnes = 5;
            int sumaSenars = 0;

            int[][] T = new int[files][columnes];

            for (int i = 0; i < files; i++) {
                for (int j = 0; j < columnes; j++) {
                    T[i][j] = random.nextInt(1,100);
                }
            }
            for (int j = 0; j < columnes; j++) {
                if (j % 2 == 0) {
                    for (int i = 0; i < files; i++) {
                        sumaSenars += T[i][j];
                    }
                }
            }
            for (int i = 0; i < files; i++) {
                for (int j = 0; j < columnes; j++) {
                    System.out.print(T[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println("\nSuma de columnas impares: " + sumaSenars);
        }
    }











