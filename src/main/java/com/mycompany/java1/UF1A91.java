package com.mycompany.java1;

import java.util.Scanner;

public class UF1A91 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);   

    System.out.println("Introduce un numro: ");
        int num = scanner.nextInt();
        int suma = 0;
        while (suma != num){
            suma = suma + 1;
            System.out.println(suma);
        }

    }
}