package com.mycompany.java1;
import java.util.Scanner;

public class UF1A117 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = 1;
        int num2;
        System.out.println("Introduce cuantos numeros deseas:");
        int i = scanner.nextInt();
        System.out.print("Secuencia: ");
        for (; i >= 1; i--) {
            System.out.print(num1 + ", ");
            num1 = num1 + 2;
            if (i > 1) {
                num2 = num1 + 2;
                System.out.print(num2 + ", ");
                i = i -1;
            }
        }
    }
}