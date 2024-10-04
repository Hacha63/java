package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class UF1A94 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   
        Random random = new Random();
        int cont = 50;
        while (cont != 0){
            int a =  random.nextInt(1,15);
            System.out.println(a);
            cont = cont -1;
        }
}
}