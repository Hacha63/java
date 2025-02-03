package com.mycompany.java1;
import  java.util.Scanner;


public class arnolo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nota = scanner.nextInt();

        if (nota < 5){
            System.out.println("Suspes");
        } else if (nota == 5 || nota == 6){
            System.out.println("Aprovat");
        } else if (nota == 7 || nota == 8){
            System.out.println("Notable");
        } else if (nota == 9 || nota == 10){
            System.out.println("Excelent");
        }


    }
}
