package com.mycompany.java1;

import java.util.Scanner;

public class UF1A15 {

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Introduce la temperatura en fahrenheit:\nUnicamente el numero:");
    String temperatura = scanner.nextLine();
    
    try {
        float temperaturaFloat = Integer.parseInt(temperatura);
        float temperaturaC = (((temperaturaFloat-32)*5)/9);
        System.out.println(temperatura+" Fahrenheit son "+temperaturaC+" Celcius");
    }
    catch (NumberFormatException e) {
        System.out.println("Eso no es solo el numero.");
      }
}
}