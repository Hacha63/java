package com.mycompany.java1;

import java.util.Scanner;

    public class UF1A93 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);   
    int cont = 8;
    while (cont != 0){
        System.out.println("Introduce un numero:");
        int num = scanner.nextInt();
        if (num > 0){
            System.out.println("és positiu");
        }
        else if (num < 0){
            System.out.println("és negatiu");
        }
        else{
            System.out.println("és zero");
        }
        cont = cont -1;
}
}
}
