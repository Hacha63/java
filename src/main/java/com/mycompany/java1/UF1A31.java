package com.mycompany.java1;

import java.util.Scanner;

public class UF1A31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el primer numero entero:");
        int numero1 = scanner.nextInt();
        System.out.println("Introduce el segundo numero entero:");
        int numero2 = scanner.nextInt();

        if (numero1 > numero2){
            int z = numero1;
            System.out.println("z = "+z);

        }
        else {
            int z = numero2;
            System.out.println("z = "+z);

        }
}
}
