package com.mycompany.java1;
import java.util.Random;

public class UF1A121 {
    public static void main(String[] args){
        Random random = new Random();

        int cara = 0;
        int cruz = 0;

        for (int i = 100; i > 0;i--){
            int moneda = random.nextInt(2);
            if (moneda == 0){
                System.out.println("CARA!");
                cara = cara + 1;
            }
            else{
                System.out.println("CRUZ!");
                cruz ++;
            }
        }
        System.out.println("Cara ha salido "+cara+" veces\nCruz ha salido "+cruz+" veces");
    }
}
