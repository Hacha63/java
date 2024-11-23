package com.mycompany.java1;

import java.util.Scanner;
import java.util.Random;

public class UF1A205 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Inicialitzar la matriu de notes (3 grups de fins a 15 alumnes)
        double[][] notes = new double[3][15];

        int opcio;
        boolean salir = false;

        while (!salir){
            System.out.println("1. Assignar notas aleatorias a un grupo.");
            System.out.println("2. Modificar la nota de un alumno.");
            System.out.println("3. Calcular la nota media de cada grupo.");
            System.out.println("4. Ver tablas");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");
            opcio = scanner.nextInt();

            switch (opcio) {
                case 1 -> {
                    System.out.print("Introduce el numero del gruo (1, 2, 3): ");
                    int grup = scanner.nextInt();
                    if (grup >= 1 && grup <= 3) {
                        for (int i = 0; i < 15; i++) {
                            notes[grup - 1][i] = random.nextDouble(1,10);
                        }
                        System.out.println("Notas del grupo " + grup + " asignadas aleatoriamente.");
                    } else {
                        System.out.println("Grupo invalido.");
                    }
                }
                case 2 -> {
                    System.out.print("Introduce el numero del gruo (1, 2, 3): ");
                    int grup = scanner.nextInt();
                    System.out.print("Introduce el numero del alumno (1 - 15): ");
                    int alumne = scanner.nextInt();
                    if (grup >= 1 && grup <= 3 && alumne >= 1 && alumne <= 15) {
                        System.out.print("Introduce la nota nueva ");
                        double novaNota = scanner.nextDouble();
                        if (novaNota >= 0 && novaNota <= 10) {
                            notes[grup - 1][alumne - 1] = novaNota;
                            System.out.println("Nota modificada");
                        } else {
                            System.out.println("La nota ha de ser entre 0 y 10.");
                        }
                    } else {
                        System.out.println("Datos no validos.");
                    }
                }
                case 3 -> {
                    for (int grup = 0; grup < 3; grup++) {
                        double suma = 0;
                        for (int alumne = 0; alumne < 15; alumne++) {
                            suma += notes[grup][alumne];
                        }
                        double mitjana = suma / 15;
                        System.out.printf("Nota media %d: %.2f%n", grup + 1, mitjana);
                    }
                }
                case 4 -> {
                    for (int i = 0; i <notes.length;i++){
                        System.out.println("Grupo "+(i+1));
                        for (int j = 0; j <notes[i].length;j++){
                            System.out.printf("%2.2f%n",notes[i][j]);
                        }
                        System.out.println();
                    }
                }
                case 5 -> {
                    salir = true;
                }
                default -> System.out.println("Opcion no valida.");
            }
        }
    }
}
