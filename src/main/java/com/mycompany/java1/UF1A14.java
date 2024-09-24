package com.mycompany.java1;


import java.util.Scanner;

public class UF1A14 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce un numero:");
    String inputSTR = scanner.nextLine();
    try {
      int num = Integer.parseInt(inputSTR);
      int resultado = (num * 3 + 6) / 3 - num;
      System.out.println("El resultado siempre será: " + resultado);
    } catch (NumberFormatException e) {
      System.out.println("Eso no es un numero");
    }
  }
}