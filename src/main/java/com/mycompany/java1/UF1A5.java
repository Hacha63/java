package com.mycompany.java1;

import java.util.Scanner;

public class UF1A5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double precio = 5;
        System.out.println("Es un dia laborable?: 1=S 2=N");
        int dia = scanner.nextInt();
        System.out.println("Tienes el carnet joven?: 1=S 2=N");
        int carnet = scanner.nextInt();

        if (dia>=1 && dia<=2 && carnet>=1 && carnet<=2){
            if (dia==2){
                precio = precio * 1.1;
            }
            if (carnet==1){
                precio = precio - (precio *0.15);
            }
            System.out.println("El precio és: "+precio);
        }
        else{
            System.out.println("No es una respuesta correcta");
        }
}
}