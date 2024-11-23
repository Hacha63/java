package com.mycompany.java1;

public class UF1A201 {
    public static void main(String[] args) {

        int[][] dades = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                dades[i][j] = i;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(dades[i][j] + " ");
            }
            System.out.println();
        }
    }
}
