package com.mycompany.java1;
import  java.util.Scanner;

public class UF1A940 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letra;
        for (int i = 0; i != 8; i++) {
            System.out.println("Introduce una letra: ");
            letra = scanner.next().charAt(0);
            if (Character.isUpperCase(letra)){
                System.out.println(letra+" és una mayuscula");
            }
            else if (Character.isLowerCase(letra)) {
                System.out.println(letra + " és una minuscula");
            }
            else{
                    System.out.println(letra+" no és una letra");

                }
            }
        }

    }


