package com.mycompany.java1;

import java.util.Scanner;

class UF1A41 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce el primer número:");

    String numero1 = scanner.nextLine();

    System.out.println("Introduce el segundo número:");

    String numero2 = scanner.nextLine();

    System.out.println("Tipo de operación: Ejemplo. +, -, *, /: ");
    String operacion = scanner.nextLine();

    try {
      int num1 = Integer.parseInt(numero1);
      int num2 = Integer.parseInt(numero2);
      int resultado = 0;

      
      switch (operacion) {
        case "+":
          resultado = num1 + num2;
          break;
        case "-":
          resultado = num1 - num2;
          break;
        case "*":
          resultado = num1 * num2;
          break;
        case "/":
          if (num2 != 0) { 
            resultado = num1 / num2;
          } else {
            System.out.println("Error: División por cero.");
            return;  
          }
          break;
        default:
          System.out.println("Operación no válida.");
          return;  
      }

      
      System.out.println(num1 + operacion + num2+ "=" +resultado);
    } catch (NumberFormatException e) {

      System.out.println("Por favor, introduce números válidos.");
    }

  }
}
