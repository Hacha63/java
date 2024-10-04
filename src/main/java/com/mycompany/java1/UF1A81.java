package com.mycompany.java1;

import java.util.Scanner;

public class UF1A81 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Introduce un numero de mes (1 al 12): ");
        int mes = scanner.nextInt();
        switch (mes) {
            case 1:
                System.out.println("1 = Enero");
                break;
            case 2:
                System.out.println("2 = Febrero");
                break;
            case 3:
                System.out.println("3 = Marzo");
                break;
            case 4:
                System.out.println("4 = Abril");
                break;
            case 5:
                System.out.println("5 = Mayo");
                break;
            case 6:
                System.out.println("6 = Junio");
                break;
            case 7:
                System.out.println("7 = Julio");
                break;
            case 8:
                System.out.println("8 = Agosto");
                break;
            case 9:
                System.out.println("9 = Septiembre");
                break;
            case 10:
                System.out.println("10 = Octubre");
                break;
            case 11:
                System.out.println("11 =  Noviembre");
                break;
            case 12:
                System.out.println("12 =  Diciembre");
                break;
            default:
                System.out.println("No es un numero entre el 1 y el 12.");
        }
}
}