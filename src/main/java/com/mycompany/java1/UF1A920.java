package com.mycompany.java1;
import java.util.Scanner;

public class UF1A920 {
    public static  void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el numero entero: ");
        int num = scanner.nextInt();

        for (int i = 0; i < 10; i++){
            System.out.println(num+" * "+(i+1)+" = "+(num*(i+1)));
        }
    }
}
