package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class UF1123 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int num1 = 101;
        int num = random.nextInt(1,100);
        for (int intentos = 20;intentos>0;intentos--){
            System.out.println("Intentos restantes: "+intentos);
            System.out.println("Introduce un numero");
            num1 = scanner.nextInt();
            if (num1 >num){
                System.out.println("El numero es mas pequeño que "+num1);
            } else if (num1<num) {
                System.out.println("El numero es mas grande que "+num1);
            }
            else{
                System.out.println("Correcte, el numero era "+num);
                intentos = intentos - intentos;
            }
        }
        if (num!=num1){
            System.out.println("Se acabaron los intentos, el numero era "+num);
        }
    }
}
