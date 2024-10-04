package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class UF1A95 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   
        Random random = new Random();
        int a = 1;
        while (a != 0){
            System.out.println("Introduce un numero:");
            a = scanner.nextInt();

            if (a > 0){
                System.out.println("és positivo");
            }
            else if (a < 0){
                System.out.println("és negativo");
            }
            else{
                System.out.println("Adios");
            }


        }
    }
}
