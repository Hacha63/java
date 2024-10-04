package com.mycompany.java1;

import java.util.Scanner;

public class UF1A6 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Introdueix una quantitat (cèntims euro): ");
    int amount = scanner.nextInt();

    int count200 = 0;
    int count100 = 0;
    int count50 = 0;
    int count20 = 0;
    int count10 = 0;
    int count5 = 0;
    int count2 = 0;
    int count1 = 0;

    if (amount >= 200) {
      count200 = amount / 200;
      amount -= count200 * 200;
    }
    if (amount >= 100) {
      count100 = amount / 100;
      amount -= count100 * 100;
    }
    if (amount >= 50) {
      count50 = amount / 50;
      amount -= count50 * 50;
    }
    if (amount >= 20) {
      count20 = amount / 20;
      amount -= count20 * 20;
    }
    if (amount >= 10) {
      count10 = amount / 10;
      amount -= count10 * 10;
    }
    if (amount >= 5) {
      count5 = amount / 5;
      amount -= count5 * 5;
    }
    if (amount >= 2) {
      count2 = amount / 2;
      amount -= count2 * 2;
    }
    if (amount >= 1) {
      count1 = amount / 1;
      amount -= count1 * 1;
    }

    if (count200 > 0) {
      System.out.println(count200 + " moneda" + (count200 > 1 ? "s" : "") + " de 200 cèntims");
    }
    if (count100 > 0) {
      System.out.println(count100 + " moneda" + (count100 > 1 ? "s" : "") + " de 100 cèntims");
    }
    if (count50 > 0) {
      System.out.println(count50 + " moneda" + (count50 > 1 ? "s" : "") + " de 50 cèntims");
    }
    if (count20 > 0) {
      System.out.println(count20 + " moneda" + (count20 > 1 ? "s" : "") + " de 20 cèntims");
    }
    if (count10 > 0) {
      System.out.println(count10 + " moneda" + (count10 > 1 ? "s" : "") + " de 10 cèntims");
    }
    if (count5 > 0) {
      System.out.println(count5 + " moneda" + (count5 > 1 ? "s" : "") + " de 5 cèntims");
    }
    if (count2 > 0) {
      System.out.println(count2 + " moneda" + (count2 > 1 ? "s" : "") + " de 2 cèntims");
    }
    if (count1 > 0) {
      System.out.println(count1 + " moneda" + (count1 > 1 ? "s" : "") + " de 1 cèntims");
    }
  }
}