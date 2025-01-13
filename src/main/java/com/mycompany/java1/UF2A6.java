package com.mycompany.java1;

import java.util.Scanner;

public class UF2A6 {
    public static void main(String[] args) {
        UF2A6 programa = new UF2A6();
        Scanner scanner = new Scanner(System.in);

        String opcio = "A";
        double[] notes = new double[40]; // Array de notas con tamaño fijo de 40
        int index = 0; // Índice para saber cuántas notas hay registradas

        while (!opcio.equals("FI")) {
            System.out.println("Benvingut al gestor de notes\n" +
                    "---------------------------\n" +
                    "[RT] Registrar notes.\n[MJ] Consultar nota mitjana\n" +
                    "[HT] Histograma de notes.\n[FI] Sortir");
            System.out.print("Opció: ");
            opcio = scanner.nextLine().toUpperCase(); // Convertimos la entrada a mayúsculas

            if (opcio.equals("RT")) {
                index = programa.RT(notes, index, scanner); // Llamada al método RT
            }
            else if (opcio.equals("MJ")) {
                if (index == 0) {
                    System.out.println("No hi ha notes registrades.");
                } else {
                    double mitjana = programa.calcularMitjana(notes, index);
                    System.out.println("La nota mitjana és: " + mitjana);
                }
            } else if (opcio.equals("HT")) {
                if (index == 0) {
                    System.out.println("No hi ha notes registrades.");
                } else {
                    programa.mostrarHistograma(notes, index);
                }
            } else if (!opcio.equals("FI")) {
                System.out.println("Opció no vàlida. Si us plau, introdueix una opció vàlida.");
            }
        }

        System.out.println("Gràcies per utilitzar el gestor de notes!");
    }

    /**
     * Método para registrar notas en un array.
     *
     * @param notes El array donde se guardarán las notas.
     * @param index El índice actual del array (número de notas registradas).
     * @param scanner El objeto Scanner para leer entradas del usuario.
     * @return El índice actualizado después de registrar las notas.
     */
    public int RT(double[] notes, int index, Scanner scanner) {
        System.out.println("Escriu les notes, posa -1 per acabar:");

        while (index < notes.length) {
            String input = scanner.nextLine();
            String[] numeros = input.split(" "); // Dividir las notas por espacios

            for (String num : numeros) {
                try {
                    double nota = Double.parseDouble(num.replace(',', '.')); // Convertir a double

                    if (nota == -1) { // Condición de salida
                        System.out.println("Finalització del registre de notes.");
                        return index;
                    }

                    if (index >= notes.length) { // Validación de límite
                        System.out.println("Ja has registrat el màxim de 40 notes.");
                        return index;
                    }

                    notes[index] = nota; // Guardar la nota en el array
                    index++;
                } catch (NumberFormatException e) {
                    System.out.println("Nota no vàlida: " + num);
                }
            }
        }

        System.out.println("Ja has registrat el màxim de 40 notes.");
        return index;
    }

    /**
     * Método para calcular la nota mitjana.
     *
     * @param notes El array donde están las notas.
     * @param index El número de notas registradas.
     * @return La nota mitjana.
     */
    public double calcularMitjana(double[] notes, int index) {
        double suma = 0;
        for (int i = 0; i < index; i++) {
            suma += notes[i];
        }
        return suma / index;
    }

    /**
     * Método para mostrar el histograma de notas.
     *
     * @param notes El array donde están las notas.
     * @param index El número de notas registradas.
     */
    public void mostrarHistograma(double[] notes, int index) {
        System.out.println("Histograma de notes:");
        int[] rangs = new int[11]; // Rango de 0 a 10 (dividido en intervalos enteros)
        for (int i = 0; i < index; i++) {
            int rang = (int) Math.min(notes[i], 10); // Limitar al rango de 0 a 10
            rangs[rang]++;
        }
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < rangs[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
