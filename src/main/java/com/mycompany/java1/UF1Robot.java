package com.mycompany.java1;

import java.util.Random;

public class UF1Robot {
    public static void main(String[] args) {
        // Constants
        int totalMoviments = 19;
        int tamanyLinia = 20;

        // Inicialització de la línia
        char[] linia = new char[tamanyLinia];
        for (int i = 1; i < tamanyLinia; i++) {
            linia[i] = '-';
        }
        linia[0] = 'R';  // Posició inicial del robot

        int posicioActual = 0;  // El robot comença a la posició 0

        Random random = new Random();

        // Simulació dels moviments
        for (int i = 0; i < totalMoviments; i++) {
            // Selecció aleatòria del moviment: 0 = endavant, 1 = dreta, 2 = esquerra
            int moviment = random.nextInt(3);
            int desplaçament = 1;  // Moviment endavant és sempre 1

            if (moviment == 1) {  // Dreta
                desplaçament = random.nextInt(3) + 1;  // Aleatori entre 1 i 3
                if (posicioActual + desplaçament >= tamanyLinia) {
                    desplaçament = tamanyLinia - 1 - posicioActual;  // Evitar sortir de la línia
                }
                System.out.println("Moviment a la dreta de " + desplaçament + " posicions.");
            } else if (moviment == 2) {  // Esquerra
                desplaçament = random.nextInt(3) + 1;  // Aleatori entre 1 i 3
                if (posicioActual - desplaçament < 0) {
                    desplaçament = posicioActual;  // Evitar sortir de la línia
                }
                System.out.println("Moviment a l'esquerra de " + desplaçament + " posicions.");
            } else {  // Endavant
                System.out.println("Moviment endavant d'1 posició.");
            }

            // Actualitzar la posició del robot
            linia[posicioActual] = '-';  // Esborrem la posició actual
            if (moviment == 0) {
                posicioActual = Math.min(posicioActual + 1, tamanyLinia - 1);  // Moure endavant 1 posició
            } else if (moviment == 1) {
                posicioActual += desplaçament;  // Moure a la dreta
            } else {
                posicioActual -= desplaçament;  // Moure a l'esquerra
            }
            linia[posicioActual] = 'R';  // Actualitzem la nova posició amb 'R'

            // Mostrar la línia després de cada moviment
            System.out.println(new String(linia));
        }

        // Mostrar la posició final
        System.out.println("Posició final del robot: columna " + posicioActual);
    }
}
