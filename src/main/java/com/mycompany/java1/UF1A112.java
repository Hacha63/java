package com.mycompany.java1;
import  java.util.Scanner;

public class UF1A112 {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el numero para la tabla:");
        int tabla = scanner.nextInt();
        for (int i = 1;i != 11;i++){
            int errores = 1;
            int respuesta1 = tabla * i;
            System.out.print(tabla+" * "+i+" = ");
            int respuesta = scanner.nextInt();
            if (respuesta != respuesta1){
                System.out.println("incorrecto");
                while (errores > 0){
                    System.out.print(tabla+" * "+i+" = ");
                    respuesta = scanner.nextInt();
                    if (respuesta != respuesta1){
                        System.out.println("incorrecto");
                        errores=errores-1;
                    }
                    else{
                        System.out.println("correcto");
                        errores=errores-2;
                    }
                }
            }
            else{System.out.println("correcto");}
        }
    }
}
