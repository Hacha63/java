package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class Torneo {





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Primer jugador: ");
        String us1 = scanner.nextLine();
        System.out.println("Seundo jugador: ");
        String us2 = scanner.nextLine();

        int inicio = random.nextInt(2);

        double vida1 = random.nextInt(50, 100);
        double vida2 = random.nextInt(50, 100);

        double daño1;
        double daño2;

        int critico;
        int esquive;

        int turno = 0;

        System.out.println("Presiona (enter) para continuar con el siguiente turno");
        String pausa;







    }
    }
