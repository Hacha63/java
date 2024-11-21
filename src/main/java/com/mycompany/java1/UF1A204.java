package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class UF1A204{
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        int cont = 0;
        boolean tamaño = false;

        while (!tamaño) {
            System.out.println("Intoduce el tamaño de matriz, nxn:");
            n = scanner.nextInt();
            if (n >= 2 && n <= 20) {
                tamaño = true;
            }
            else{
                System.out.println("Introduce un numero entre el 2 i el 20.");

            }
        }

        System.out.println("Introduce el numero a buscar");
        int num = scanner.nextInt();

        int[][] T = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                T[i][j] = random.nextInt(1,50);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(T[i][j] + "\t");
                if (T[i][j] == num){
                    cont++;
                }
            }
            System.out.println();
        }
        System.out.println("El numero "+num+" se repite "+cont+" veces");
    }
}











