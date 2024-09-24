package com.mycompany.java1;

import java.util.Scanner;

public class UF1A25 {

    public static void main(String[] args) {
        

    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce un numero:\n-500 = 5% descuento\n+500 = 8% descuento\n+1000 = 15% descuento\n+5000 = 25% descuento");
    double n = scanner.nextInt();
    
    if (n<500) {
        double descuento = n * 0.05;
        double resultado = n - descuento;
        System.out.println("5% de "+n+" és "+descuento+", el resultado és: "+resultado);
    }
    else if (n<1000 | n==500){
        double descuento = n * 0.08;
        double resultado = n - descuento;
        System.out.println("8% de "+n+" és "+descuento+", el resultado és: "+resultado);
    }
    else if (n<5000 | n ==1000){
        double descuento = n * 0.15;
        double resultado = n - descuento;
        System.out.println("15% de "+n+" és "+descuento+", el resultado és: "+resultado);
    }
    else if (n>5000){

        double descuento = n * 0.25;
        double resultado = n - descuento;
        System.out.println("25% de "+n+" és "+descuento+", el resultado és: "+resultado);
    }
    }
}
