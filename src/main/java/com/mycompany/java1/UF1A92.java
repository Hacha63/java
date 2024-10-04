package com.mycompany.java1;

import java.util.Scanner;

public class UF1A92 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);   

    System.out.println("Introduce un numro: ");
        int num = scanner.nextInt();
        while (num != 0){
            System.out.println(num);
            num = num - 1;
        }

    }
}