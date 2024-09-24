package com.mycompany.java1;

import java.util.Scanner;

public class Uf1A22 {
    public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

      System.out.println("Cuantas vacas hay en la granja?");
      int vacas = scanner.nextInt();
  
      System.out.println("Cuantos cerdos hay en la granja?");
      int cerdos = scanner.nextInt();


      int animalestotal = vacas + cerdos;
  
      double porcentajevacas = (double) vacas / animalestotal * 100;
      double porcentajecerdos = (double) cerdos / animalestotal * 100;
  
      System.out.println("El percentatge és:\n"+porcentajevacas+"% de vacas.\n"+porcentajecerdos+"% de cerdos.");
      if (porcentajevacas > porcentajecerdos) {
      System.out.println("Hay más vacas que cerdos.");
      }
      else {
        System.out.println("Hay más cerdos que vacas.");
      }
      
    }
  }