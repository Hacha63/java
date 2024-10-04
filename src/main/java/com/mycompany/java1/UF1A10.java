package com.mycompany.java1;

import java.util.Scanner;

public class UF1A10 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Intoduce las horas: ");
    int horas = scanner.nextInt();
    System.out.print("Intoduce los minutos: ");
    int minutos = scanner.nextInt();
    
    int total = horas * 60 + minutos;
    if  (total<=30) {
        double precio = total * 0.05775;
        System.out.println("El precio es: " + precio);
    }
    else if (total<=120){
        double precio =  total * 0.055;
        System.out.println("El precio  es: " + precio);
    }
    else if (total>=121){
        double precio = total * 0.05;
        if  (precio>=20.95){
            System.out.println("El maximo por dia es de  20.95 "+ precio);
        }
        else{
            System.out.println("El precio es: " + precio);
        }
}
    }
}