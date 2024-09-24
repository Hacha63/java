package com.mycompany.java1;


import java.util.Scanner;

public class CalcAño {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce tu edad:");
    String edadStr = scanner.nextLine();
    try {
      int edad = Integer.parseInt(edadStr);
      int añoActual = 2024;
      int añoNacimiento = añoActual - edad;
      System.out.println("Naciste en el: " + añoNacimiento);
    } catch (NumberFormatException e) {
      System.out.println("No puedes tener letras de edad.");
    }
  }
}