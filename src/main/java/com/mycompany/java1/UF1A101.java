package com.mycompany.java1;
import  java.util.Scanner;


public class UF1A101 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el primer numero: ");
        int num1 = scanner.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int num2 = scanner.nextInt();

        int resultado = 0;

        for (int cont = num1 ;cont != 0; cont--){
            resultado = resultado + num2;
        }
        System.out.println(num1+" * "+num2+" = "+resultado);

    }
}
