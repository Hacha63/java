package com.mycompany.java1;
import java.util.Random;

public class mevoy {
    public static void main(String[] args) {
        Random random = new Random();

        int respuesta;

        for (int i = 0; i < 5; i++) {
            respuesta = random.nextInt(1+1);
            if (respuesta ==1){
                System.out.println("Vete");
            }
            else {
                System.out.println("Quedate");
            }
        }
    }
}
