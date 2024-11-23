package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class Batalla1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int intentos = 3;

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
        if (inicio == 0) {
            System.out.println("Empieza " + us1);
            while (vida1 > 0 || vida2 > 0) {

                daño1 = random.nextInt(5, 25);
                daño2 = random.nextInt(5, 25);

                critico = random.nextInt(10);
                esquive = random.nextInt(20);

                turno = turno + 1;
                pausa = scanner.nextLine();
                System.out.println("Truno " + turno);
                System.out.println(us1 + " ataca a " + us2);
                if (critico == 0){
                    daño1 = daño1 * 1.5;
                    System.out.println("CRITICO!");
                }
                else if(esquive == 0){
                    daño1 = daño1 - daño1;
                    System.out.println("ESQUIVE!");
                }
                vida2 = vida2 - daño1;
                System.out.println(us2 + " recibe " + daño1 + " de daño, la vida de " + us2 + " és " + vida2);

                if (vida1 <= 0){
                    System.out.println(us2+" GANA");
                    break;
                }
                else if (vida2 <= 0){
                    System.out.println(us1+" GANA");
                    break;
                }
                pausa = scanner.nextLine();
                turno = turno + 1;
                System.out.println("Truno " + turno);
                System.out.println(us2 + " ataca a " + us1);
                critico = random.nextInt(10);
                esquive = random.nextInt(20);
                if (critico == 0){
                    daño2 = daño2 * 1.5;
                    System.out.println("CRITICO!");
                }
                else if(esquive == 0){
                    daño2 = daño2 - daño2;
                    System.out.println("ESQUIVE!");
                }

                vida1 = vida1 - daño2;
                System.out.println(us1 + " recibe " + daño2 + " de daño, la vida de " + us1 + " és " + vida1);

                if (vida1 <= 0){
                    System.out.println(us2+" GANA");
                    break;
                }
                else if (vida2 <= 0){
                    System.out.println(us1+" GANA");
                    break;
                }
            }
        } else {
            System.out.println("Empieza " + us2);
            while (vida1 > 0 || vida2 > 0) {
                daño1 = random.nextInt(5, 25);
                daño2 = random.nextInt(5, 25);
                turno = turno + 1;
                critico = random.nextInt(10);
                esquive = random.nextInt(20);
                pausa = scanner.nextLine();
                System.out.println("Truno " + turno);
                System.out.println(us2 + " ataca a " + us1);

                if (critico == 0){
                    daño2 = daño2 * 1.5;
                    System.out.println("CRITICO!");
                }
                else if(esquive == 0){
                    daño2 = daño2 - daño2;
                    System.out.println("ESQUIVE!");
                }

                vida1 = vida1 - daño2;
                System.out.println(us1 + " recibe " + daño2 + " de daño, la vida de " + us1 + " és " + vida1);
                if (vida1 <= 0){
                    System.out.println(us2+" GANA");
                    break;
                }
                else if (vida2 <= 0){
                    System.out.println(us1+" GANA");
                    break;
                }
                pausa = scanner.nextLine();
                turno = turno + 1;
                critico = random.nextInt(10);
                esquive = random.nextInt(20);
                System.out.println("Truno " + turno);
                System.out.println(us1 + " ataca a " + us2);
                if (critico == 0){
                    daño1 = daño1 * 1.5;
                    System.out.println("CRITICO!");
                }
                else if(esquive == 0){
                    daño1 = daño1 - daño1;
                    System.out.println("ESQUIVE!");
                }
                vida2 = vida2 - daño1;
                System.out.println(us1 + " recibe " + daño1 + " de daño, la vida de " + us2 + " és " + vida2);
                if (vida1 <= 0){
                    System.out.println(us2+" GANA");
                    break;
                }
                else if (vida2 <= 0){
                    System.out.println(us1+" GANA");
                    break;
                }

            }


        }
    }
    }
