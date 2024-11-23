package com.mycompany.java1;
import  java.util.Scanner;

public class UF1A930 {
    public  static  void  main(String[] args){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Introduce un numero:");
        int num = scanner.nextInt();
        int max = num;
        int min = num;

        for ( int i = 0; i !=4; i++){
            System.out.println("Introduce un numero:");
            num = scanner.nextInt();

            if (num > max){
                max = num;
            }
            if (num < min){
                min = num;

            }
        }
        System.out.println("El numero más grande és: "+max+"\nEl numero más pequeño és: "+min);

    }
}
