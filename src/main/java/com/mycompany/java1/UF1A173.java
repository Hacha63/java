package com.mycompany.java1;
import java.util.Random;

public class UF1A173 {
    public static void main(String[] args){
        Random random = new Random();

        int [] lista = new int [12];
        int [] lista2 = new int [12];

        System.out.println("Tabla 1:");
        for (int i = 0; i<12;i++){
            lista[i] = random.nextInt(1,100);
            lista2[i] = lista[i] * 2;
            System.out.print("|\t"+lista[i]+"\t");
        }
        System.out.println("\nTabla 2:");
        for (int i = 0; i<12;i++){
            System.out.print("|\t"+lista2[i]+"\t");
        }
    }
}

