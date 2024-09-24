package com.mycompany.java1;
import java.util.Scanner;

public class UF1A23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un numero entero:");
        int numero = scanner.nextInt();

        if (numero > 0) {
            System.out.println("El numero és positivo.");
        } else if (numero < 0) {
            System.out.println("El numero és negativo.");
        } else {
            System.out.println("El numero és 0.");
        }
    }
}