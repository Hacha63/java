package com.mycompany.java1;
import java.util.Random;

public class UF1A176 {
    static public void main(String [] args){
        Random random = new Random();

        int [] num = new int [100];
        int [] pes = new int [21];

        for (int i = 0; i < 100; i++) {
            num[i] = random.nextInt(30,51);
            pes[num[i] - 30]++;
        }
        System.out.println("Pesos  Nombre de persones");
        for (int j = 0; j < 21; j++) {
            System.out.print((j + 30) + "\t");
            for (int k = 0; k < pes[j]; k++) {
                System.out.print("█");
            }
            System.out.println("");
        }
        }
}
