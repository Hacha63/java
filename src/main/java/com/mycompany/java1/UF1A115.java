package com.mycompany.java1;
import java.util.Scanner;

public class UF1A115 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un numero positivo entero: ");
        int numero = scanner.nextInt();
        if (numero < 0) {
            System.out.println("El numero ha de ser positivo.");
        } else {
            int cifras = 0;
            while (numero > 0) {
                numero /= 10;
                cifras=cifras+1;
            }
            System.out.println("Tiene " + cifras + " cifras");
        }

    }
}
