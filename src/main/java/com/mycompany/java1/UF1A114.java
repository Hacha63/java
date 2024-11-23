package com.mycompany.java1;
import java.util.Scanner;

public class UF1A114 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cont = 1;
        int num1 = 0;
        int num2 = 1;
        int num3 = 2;
        while (cont != 0) {
            System.out.println("Introduce un numero entero: ");
            num1 = scanner.nextInt();
            if (num1 == num2 && num2 == num3) {
                System.out.println("El numero " + num1 + " se repite 3 veces consecutivas");
                cont = 0;
            } else {
                System.out.println("Introduce un numero entero: ");
                num2 = scanner.nextInt();
                if (num1 == num2 && num2 == num3) {
                    System.out.println("El numero " + num1 + " se repite 3 veces consecutivas");
                    cont = 0;
                } else {
                    System.out.println("Introduce un numero entero: ");
                    num3 = scanner.nextInt();
                    if (num1 == num2 && num2 == num3) {
                        System.out.println("El numero " + num1 + " se repite 3 veces consecutivas");
                        cont = 0;
                    }
                }
            }
        }
    }
}