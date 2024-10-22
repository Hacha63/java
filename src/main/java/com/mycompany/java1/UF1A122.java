package com.mycompany.java1;
import java.util.Random;

public class UF1A122 {
    public static void main(String[] args) {
        Random random = new Random();
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int num6 = 0;
        for (int i = 100; i > 0; i--) {
            int dado = random.nextInt(6);
            switch (dado) {
                case (0):
                    System.out.println("Numero 1");
                    num1++;
                    break;
                case (1):
                    System.out.println("Numero 2");
                    num2++;
                    break;
                case (2):
                    System.out.println("Numero 3");
                    num3++;
                    break;
                case (3):
                    System.out.println("Numero 4");
                    num4++;
                    break;
                case (4):
                    System.out.println("Numero 5");
                    num5++;
                    break;
                case (5):
                    System.out.println("Numero 6");
                    num6++;
                    break;
            }
        }
        System.out.println("Num 1: "+num1+"\nNum 2: "+num2+"\nNum 3: "+num3+"\nNum 4: "+num4+"\nNum 5: "+num5+"\nNum 6: "+num6);
    }
}
