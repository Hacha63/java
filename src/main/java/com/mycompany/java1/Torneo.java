package com.mycompany.java1;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Torneo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Selección del número de jugadores
        System.out.println("Ingrese el número de jugadores (2, 3 o 4): ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        ArrayList<String> jugadores = new ArrayList<>();
        ArrayList<Double> vidas = new ArrayList<>();

        // Registro de jugadores y asignación de vida
        for (int i = 1; i <= numJugadores; i++) {
            System.out.println("Jugador " + i + ": ");
            String jugador = scanner.nextLine();
            jugadores.add(jugador);
            double vida = random.nextInt(50, 100);
            vidas.add(vida);
        }

        // Inicio de las batallas hasta que quede solo un jugador
        while (jugadores.size() > 1) {
            int indice1 = random.nextInt(jugadores.size());
            int indice2;

            do {
                indice2 = random.nextInt(jugadores.size());
            } while (indice1 == indice2);  // Asegurarse de que no se elija el mismo jugador

            String jugador1 = jugadores.get(indice1);
            String jugador2 = jugadores.get(indice2);
            double vida1 = vidas.get(indice1);
            double vida2 = vidas.get(indice2);

            System.out.println("\n" + jugador1 + " lucha contra " + jugador2);
            double vidaGanador = batalla(jugador1, vida1, jugador2, vida2, scanner, random);

            // Determinar el ganador y actualizar la lista
            if (vida1 > 0) {
                System.out.println(jugador1 + " ha ganado contra " + jugador2);
                jugadores.remove(indice2);
                vidas.remove(indice2);
                vidas.set(indice1, vidaGanador);  // El ganador mantiene su vida
            } else {
                System.out.println(jugador2 + " ha ganado contra " + jugador1);
                jugadores.remove(indice1);
                vidas.remove(indice1);
                vidas.set(indice2, vidaGanador);  // El ganador mantiene su vida
            }
        }

        System.out.println("\n¡El ganador final es " + jugadores.get(0) + " con una vida de " + vidas.get(0) + "!");
    }

    // Función que maneja una batalla entre dos jugadores
    public static double batalla(String us1, double vida1, String us2, double vida2, Scanner scanner, Random random) {
        double daño1, daño2;
        int critico, esquive;
        int turno = 0;
        String pausa;

        System.out.println("Presiona (enter) para continuar con el siguiente turno");

        while (vida1 > 0 && vida2 > 0) {
            // Ataque de us1 a us2
            turno++;
            pausa = scanner.nextLine();
            daño1 = random.nextInt(5, 25);
            critico = random.nextInt(10);
            esquive = random.nextInt(20);
            System.out.println("Turno " + turno + ": " + us1 + " ataca a " + us2);

            if (critico == 0) {
                daño1 *= 1.5;
                System.out.println("¡CRÍTICO!");
            } else if (esquive == 0) {
                daño1 = 0;
                System.out.println("¡ESQUIVE!");
            }

            vida2 -= daño1;
            System.out.println(us2 + " recibe " + daño1 + " de daño, la vida de " + us2 + " es " + vida2);

            if (vida2 <= 0) {
                break;
            }

            // Ataque de us2 a us1
            turno++;
            pausa = scanner.nextLine();
            daño2 = random.nextInt(5, 25);
            critico = random.nextInt(10);
            esquive = random.nextInt(20);
            System.out.println("Turno " + turno + ": " + us2 + " ataca a " + us1);

            if (critico == 0) {
                daño2 *= 1.5;
                System.out.println("¡CRÍTICO!");
            } else if (esquive == 0) {
                daño2 = 0;
                System.out.println("¡ESQUIVE!");
            }

            vida1 -= daño2;
            System.out.println(us1 + " recibe " + daño2 + " de daño, la vida de " + us1 +" es " + vida1);

            if (vida1 <= 0) {
                break;
            }
        }

        return vida1 > 0 ? vida1 : vida2;  // Devuelve la vida del ganador
    }
}
