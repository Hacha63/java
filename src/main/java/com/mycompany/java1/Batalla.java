package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class Batalla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int intentos = 3;

        System.out.println("Primer jugador: ");
        String us1 = scanner.nextLine();
        System.out.println("Seundo jugador: ");
        String us2 = scanner.nextLine();

        int inicio = random.nextInt(2);

        int vida1 = random.nextInt(50, 100);
        int vida2 = random.nextInt(50, 100);

        int daño1;
        int daño2;

        int turno = 0;

        if (inicio == 0) {
            System.out.println("Empieza " + us1);
            while (vida1 > 0 || vida2 > 0) {
                daño1 = random.nextInt(5, 25);
                daño2 = random.nextInt(5, 25);
                turno = turno + 1;
                System.out.println("Truno " + turno);
                System.out.println(us1 + " ataca a " + us2);
                vida2 = vida2 - daño1;
                System.out.println(us2 + " recibe " + daño1 + " Vida de " + us2 + " és " + vida2);


                turno = turno + 1;
                System.out.println("Truno " + turno);
                System.out.println(us2 + " ataca a " + us1);
                vida1 = vida1 - daño2;
                System.out.println(us1 + " recibe " + daño2 + " Vida de " + us1 + " és " + vida1);

            }
        } else {
            System.out.println("Empieza " + us2);
            while (vida1 > 0 || vida2 > 0) {
                daño1 = random.nextInt(5, 25);
                daño2 = random.nextInt(5, 25);
                turno = turno + 1;
                System.out.println("Truno " + turno);
                System.out.println(us2 + " ataca a " + us1);
                vida1 = vida1 - daño2;
                System.out.println(us1 + " recibe " + daño2 + " Vida de " + us1 + " és " + vida1);


                turno = turno + 1;
                System.out.println("Truno " + turno);
                System.out.println(us1 + " ataca a " + us2);
                vida2 = vida2 - daño1;
                System.out.println(us1 + " recibe " + daño1 + " Vida de " + us2 + " és " + vida2);


            }


        }
    }
    }
