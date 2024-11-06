package com.mycompany.java1;
import java.util.Scanner;
import java.util.Random;

public class UF1A192 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int [] num = new int[6];
        int [] num1 = new int[6];
        boolean end = true;

        for (int i = 0; i<6; i++){
            System.out.println("Num" +i+"\nIntroduce el numero deseado:");
            num[i] = scanner.nextInt();
            num1[i] = random.nextInt(1,49);
        }
        for (int i = 0; i<6;i++){
            while (num1[i] == num1[i+1]){
                num1[i] = random.nextInt(1,49);
            }

        }
    }
}
