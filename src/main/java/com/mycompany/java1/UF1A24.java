package com.mycompany.java1;

import java.util.Scanner;

public class UF1A24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el primer numero:");
        double numero = scanner.nextInt();

        System.out.println("Introduce el segundo numero:");
        double numero2 = scanner.nextInt();


        if (numero != numero2) {
            
            if (numero > numero2){
                if (numero2 == 0){
                    System.out.println("No se puede dividir entre 0.");
                    
                }
                else{
                double resultado = numero / numero2;
                System.out.println("La division entre el numero más grande entre el más pequeño és:\n"+numero+" / "+numero2+" = "+resultado);
            }
        }
            else {
                if (numero == 0){
                    System.out.println("No se puede dividir entre 0.");
                }
                else{
                    double resultado = numero2 / numero;
                    System.out.println("La division entre el numero más grande entre el más pequeño és:\n"+numero2+" / "+numero+" = "+resultado);

            }
        }
        }
        else{
            System.out.println("Son el mismo numero, el resultado es 1.");
        }

    }
}
    
