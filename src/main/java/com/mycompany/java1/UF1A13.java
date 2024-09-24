package com.mycompany.java1;

import java.util.Scanner;

public class UF1A13 {

    public static void main(String[] args) {
        

    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce tu nombre y apellidos:");
    String nombre = scanner.nextLine();
    System.out.println("Que estudiaste el año pasado?");
    String estudios = scanner.nextLine();
    System.out.println("Cuantos años tienes?");
    String años = scanner.nextLine();

    System.out.println("El meu nom es "+nombre+ "\nL'any passat vaig estudiar "+estudios+"\nTinc "+años+" anys");
    }
}
