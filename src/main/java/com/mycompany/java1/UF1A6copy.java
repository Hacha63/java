package com.mycompany.java1;

import java.util.Scanner;

public class UF1A6copy {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int cen200 = 0;
    int cen100 = 0;
    int cen50 = 0;
    int cen20 = 0;
    int cen10 = 0;
    int cen5 = 0;
    int cen2 = 0;
    int cen1 = 0;

    System.out.print("Introduce la cantidad de centimos: ");
    int amount = scanner.nextInt();

    if (amount>=200){
       cen200 =  amount / 200;
      amount = amount - (cen200 * 200);
    }
    if (amount>=100){
       cen100 = amount /100;
      amount = amount - (cen100 * 100);
    }
    if (amount>=50){
       cen50 = amount / 50;
      amount = amount - (cen50 * 50);
    }
    if (amount >=20){
       cen20 = amount / 20;
      amount = amount - (cen20 * 20);
    }
    if (amount >=10){
       cen10 = amount / 10;
      amount = amount - (cen10 * 10);
    }
    if (amount >=5){
       cen5 = amount / 5;
      amount = amount - (cen5 * 5);
    }
    if (amount >=2){
       cen2 = amount / 2;
      amount = amount - (cen2 * 2);
    }
    if (amount >=1){
       cen1 = amount / 1;
      amount = amount - (cen1 * 1);
    }
    
  
    if (cen200>0){
      System.out.println(cen200+" monedas de 2€");
    }
    if (cen100>0){
      System.out.println(cen100+" monedas de 1€");
    }
    if (cen50>0){
      System.out.println(cen50+" monedas de 50c");
    }
    if (cen20>0){
      System.out.println(cen20+" monedas de 20c");
    }
    if (cen10>0){
      System.out.println(cen10+" monedas de 10c");
    }
    if (cen5>0){
      System.out.println(cen5+" monedas de 5c");
    }
    if  (cen2>0){
      System.out.println(cen2+" monedas de 2c");
    }
    if (cen1>0){
      System.out.println(cen1+" monedas de 1c");
    }
}
}