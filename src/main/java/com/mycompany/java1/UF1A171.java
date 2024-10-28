package com.mycompany.java1;
import java.util.Scanner;

public class UF1A171 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int suma = 0;
        int [] num = {0,1,2,3,4};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int mid=0;

        for (int i = 0;i < 5;i++){
            System.out.println("Introduce un numero:");
            num[i] = scanner.nextInt();
            suma = suma + num[i];

        }
        for (int i=0;i<5;i++){
            if (i == 0){
                System.out.print("|");
            }
            else if (i == 2) {
                mid = num[i];
            }
            System.out.print("\t"+num[i]+"\t|");
            if (num[i]<=min){
                min = num[i];

            } else if (num[i]>=max) {
                max = num[i];
            }
        }
        System.out.println("");
        System.out.println("El resultado de todos és: "+suma+"\nEl num más grande és: "+max+"\nEl num más pequeño és: "+min+"\nEl valor de la posición del medio és: "+mid);

    }
}
