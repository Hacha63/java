package com.mycompany.java1;
import java.util.Scanner;

public class UF1A181 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce una cadena: ");
        String cadena = scanner.nextLine();
        System.out.println("Introduce la letra a buscar: ");
        char character = scanner.nextLine().charAt(0);
        int cont = 0;

        System.out.print("La letra "+character+" sale en la posición:");
        for (int i = 0; i < cadena.length(); i++){
            if (cadena.charAt(i) == character){
                cont ++;
                System.out.print(" "+i+",");
            }
        }
        System.out.println("\nLa letra "+character+" sale "+cont+" veces en: ("+cadena+")");
    }
}
