package com.mycompany.java1;

import java.util.Scanner;
import java.util.Random;

public class p {


    public static String lucha(String us1, String us2, double vida1, double vida2, Random random, Scanner scanner) {
        int turno = 0;
        int critico, esquive;
        double daño1, daño2;

        while (vida1 > 0 && vida2 > 0) {
            turno++;
            System.out.println("Turno " + turno);

            // Jugador 1 ataca
            System.out.println(us1 + " ataca a " + us2);
            daño1 = random.nextInt(5, 25);
            critico = random.nextInt(10);
            esquive = random.nextInt(20);

            if (critico == 0) {
                daño1 *= 1.5;
                System.out.println("¡CRÍTICO!");
            } else if (esquive == 0) {
                daño1 = 0;
                System.out.println("¡ESQUIVE!");
            }

            vida2 -= daño1;
            System.out.println(us2 + " recibe " + daño1 + " de daño. Vida restante de " + us2 + ": " + vida2);

            if (vida2 <= 0) {
                System.out.println(us1 + " GANA");
                return us1; // Retorna el nombre del ganador
            }

            System.out.println("Presiona Enter para continuar...");
            scanner.nextLine();

            System.out.println(us2 + " ataca a " + us1);
            daño2 = random.nextInt(5, 25);
            critico = random.nextInt(10);
            esquive = random.nextInt(20);

            if (critico == 0) {
                daño2 *= 1.5;
                System.out.println("¡CRÍTICO!");
            } else if (esquive == 0) {
                daño2 = 0;
                System.out.println("¡ESQUIVE!");
            }

            vida1 -= daño2;
            System.out.println(us1 + " recibe " + daño2 + " de daño. Vida restante de " + us1 + ": " + vida1);

            if (vida1 <= 0) {
                System.out.println(us2 + " GANA");
                return us2;
            }

            System.out.println("Presiona Enter para continuar...");
            scanner.nextLine();
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Cuantos jugadores jugarán? (Mínimo 2, Máximo 4)");
        int jugadores = scanner.nextInt();
        scanner.nextLine();

        if (jugadores < 2 || jugadores > 4) {
            System.out.println("El número de jugadores debe ser entre 2 y 4.");
            return;
        }

        String[] nombres = new String[jugadores];

        for (int i = 0; i < jugadores; i++) {
            System.out.println("Introduce el nombre del jugador " + (i + 1) + ":");
            nombres[i] = scanner.nextLine();
        }

        double vidaInicial = 100.0;
        double vida1, vida2;
        String ganador = null;

        if (jugadores == 2) {
            vida1 = random.nextDouble(50, 100);
            vida2 = random.nextDouble(50, 100);
            ganador = lucha(nombres[0], nombres[1], vida1, vida2, random, scanner);
        } else {
            vida1 = random.nextDouble(50, 100);
            vida2 = random.nextDouble(50, 100);
            ganador = lucha(nombres[0], nombres[1], vida1, vida2, random, scanner);

            vida1 = random.nextDouble(50, 100);

            for (int i = 2; i < jugadores; i++) {
                System.out.println(ganador + " luchará ahora contra " + nombres[i]);
                vida2 = random.nextDouble(50, 100);
                ganador = lucha(ganador, nombres[i], vida1, vida2, random, scanner);
                vida1 = random.nextDouble(50, 100);
            }
        }

        System.out.println("¡El ganador final es " + ganador + "!");
    }
}
