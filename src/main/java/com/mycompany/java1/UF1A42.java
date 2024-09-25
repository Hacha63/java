package com.mycompany.java1;

import java.util.Scanner;

public class UF1A42 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce tu nota:");
        double nota = scanner.nextDouble();
        
        if (nota < 5){
            System.out.println(nota+" és insuficiente.");
        }
        else if (nota >= 5 && nota<6){
            System.out.println(nota+" és suficiente.");
        }
        else if (nota >=6 && nota < 7){
            System.out.println(nota+" és un bien.");
        }
        else if (nota>=7 && nota<9){
            System.out.println(nota+" és notable.");
        }
        else if (nota<=10){
            System.out.println(nota+" és excelente.");
        }
        else {
            System.out.println(nota+" no és una nota valida.");
        }
}
}