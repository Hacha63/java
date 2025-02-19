package com.mycompany.java1;
import java.util.Scanner;
import java.util.Random;

class UF1A22 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] paraules = {"programacio", "ordenador", "teclat", "pantalla", "ratoli", "processador", "memoria", "emmagatzematge", "xarxa", "internet"};
        String paraulaSecreta = paraules[random.nextInt(paraules.length)];
        char[] progress = new char[paraulaSecreta.length()];

        for (int i = 0; i < progress.length; i++) {
            progress[i] = '_';
        }

        int intents = 9;
        boolean endevinat = false;

        System.out.println("Benvingut al joc del Penjat!");
        System.out.println("Tens " + intents + " intents per endevinar la paraula.");

        while (intents > 0 && !endevinat) {
            System.out.print("Paraula: ");
            System.out.println(progress);
            System.out.print("Introdueix una lletra: ");
            char lletra = scanner.nextLine().charAt(0);

            boolean encert = false;
            for (int i = 0; i < paraulaSecreta.length(); i++) {
                if (paraulaSecreta.charAt(i) == lletra) {
                    progress[i] = lletra;
                    encert = true;
                }
            }

            if (!encert) {
                intents--;
                System.out.println("Lletra incorrecta! Queden " + intents + " intents.");
            } else {
                System.out.println("Lletra encertada!");
            }

            endevinat = true;
            for (char c : progress) {
                if (c == '_') {
                    endevinat = false;
                    break;
                }
            }
        }
        if (endevinat) {
            System.out.println("Felicitats! Has endevinat la paraula: " + paraulaSecreta);
        } else {
            System.out.println("Has perdut! La paraula era: " + paraulaSecreta);
        }
    }
}
