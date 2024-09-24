package com.mycompany.java1;

import java.util.Scanner;

public class UF1A16 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce numero A: ");
        int a = scanner.nextInt();

        System.out.print("Introduce numero B: ");
        int b = scanner.nextInt();

        int c = a;
        a = b;
        b = c;

        System.out.println("Ahora son al reves: A = "+a+" y B = "+ b);
    }
}
