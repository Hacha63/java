package com.mycompany.java1;

import java.util.Scanner;

class Calculadora {
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
            return;  // Salir del método si hay error
          }
          break;
        default:
          System.out.println("Operación no válida.");
          return;  // Salir del método si la operación no es válida
      }

      // Mostrar el resultado
      System.out.println(num1 + operacion + num2+ "=" +resultado);
    } catch (NumberFormatException e) {
      // Manejar el caso donde la entrada no es un número válido
      System.out.println("Por favor, introduce números válidos.");
    }

  }
}
