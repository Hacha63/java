package com.mycompany.java1;
import java.util.Scanner;

public class UF1A111 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resultado = 0;
        while (resultado < 21) {
            System.out.println("\nIntroduce un número entre 1 y 5:");
            int num = scanner.nextInt();
            while (num < 1 || num > 5) {
                System.out.println("\nDebe ser un número entre 1 y 5:");
                num = scanner.nextInt();
            }
            System.out.print(resultado + " + " + num + " = ");
            resultado += num;
            System.out.println(resultado);
        }
        System.out.print(resultado + " se pasa de 21.");
    }
}
