package com.mycompany.java1;
import java.util.Random;

public class UF1A175 {
    public static void main(String[] args){
        Random random = new Random();

        int [] dado = new int[6];
        int num= 0;

        for (int i = 0; i < 100; i++){
            num = random.nextInt(6);
            for (int j = 0; j<7;j++){
                if (num == j){
                    dado[j] = dado[j]+1;
                }
            }
        }
        for (int j = 0; j<6;j++) {
            System.out.println("Num "+(j+1)+": ");
                for (int i = dado[j];i!=0;i--){
                    System.out.print("■");
                }
                System.out.print("\t"+dado[j]);

            System.out.println("");
        }
        }
}
