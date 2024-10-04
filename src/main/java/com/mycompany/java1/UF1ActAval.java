package com.mycompany.java1;
import java.util.Scanner;

public class UF1ActAval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Benvingut a l'avaluació per al viatge espacial.");
        
        System.out.print("Introdueix la teva edat: ");
        int edat = scanner.nextInt();
        
        System.out.print("Introdueix la teva alçada en cm: ");
        int alcada = scanner.nextInt();
        
        System.out.print("Introdueix el teu pes en kg: ");
        int pes = scanner.nextInt();

        if (edat < 25 || edat > 40 || alcada < 160 || alcada > 190 || pes < 50 || pes > 100) {
            System.out.println("Ho sento, no compleixes amb els criteris bàsics per al viatge espacial.");
            return;
        }

        int perfilPercentual = 15;
        System.out.println("Criteris bàsics superats. Perfil Percentual inicial: " + perfilPercentual + "%");

        System.out.print("Introdueix el temps de carrera de 5 km en minuts: ");
        int tempsCursa = scanner.nextInt();
        
        System.out.print("Introdueix el temps (en segons) en què completes 80 flexions: ");
        int tempsFlexions = scanner.nextInt();
        
        System.out.print("Introdueix el teu salt vertical en cm: ");
        int saltVertical = scanner.nextInt();

        if (tempsCursa >= 30 || tempsFlexions > 60 || saltVertical < 70) {
            System.out.println("Ho sento, no compleixes amb el desafiament d'entrenament físic. Intenta-ho de nou.");
            return;
        }

        perfilPercentual += 30;
        System.out.println("Desafiament físic superat. Perfil Percentual actual: " + perfilPercentual + "%");

        double resistCardio = (edat / (double) tempsCursa) * 7;
        
        if (resistCardio > 10) {
            resistCardio = 10;
        }
        
        System.out.println("Puntuació de resistència cardiovascular: " + (int) resistCardio);

        if (resistCardio < 6) {
            System.out.println("Ho sento, no has superat la prova de resistència cardiovascular.");
            return;
        }

        int incrementPerPunt = ((int) resistCardio - 5) * 10;
        perfilPercentual += incrementPerPunt;
        
        if (resistCardio > 8) {
            perfilPercentual += 5;
            System.out.println("Has rebut una bonificació addicional del 5% per superar la resistència cardiovascular.");
        }

        System.out.println("Perfil Percentual final: " + perfilPercentual + "%");

        if (perfilPercentual >= 90) {
            System.out.println("Classificació final: Rang A (Excel·lent)");
        } else if (perfilPercentual >= 80) {
            System.out.println("Classificació final: Rang B (Molt Bo)");
        } else if (perfilPercentual >= 70) {
            System.out.println("Classificació final: Rang C (Bo)");
        } else {
            System.out.println("Classificació final: Rang D (Necessita Millora)");

        }
    }
}
