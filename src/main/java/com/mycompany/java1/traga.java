package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class traga {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        Random random = new Random();

        int ti = 50;
        boolean  flag = true;
        while (flag ==  true && ti >0) {
            int mes = scanner.nextInt();
            if (mes == 1) {
                ti = ti -5;
                System.out.println("\n \n \n \n \n \n \n \n");
                System.out.println("Dinero = "+ti);
                int a =  random.nextInt(3);
                int b = random.nextInt(3);
                int c = random.nextInt(3);
                System.out.println("\n \n \n \n \n");
                System.out.println(a+" "+b+" "+c);
                if (a==b && b==c){
                    System.out.println("GANASTE");
                    ti = ti + 50;
                    System.out.println("Dinero = "+ti);
                }
                else{
                    System.out.println("PERDISTE");
                }
            }  
            else{
                flag = false;
            }  
            
}
System.out.println("No dejes de apostar");
    }
}