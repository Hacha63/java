package com.mycompany.java1;
import java.util.Random;

public class ex {
    public static void main(String[] args) {

        ex e = new ex();
        int [][] array = new int[5][5];
        buscar(array);
    }

    public static void rellenar (int[][] array){
        Random random = new Random();
        for (int  i = 0;  i < array.length;  i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(50);
            }
        }

    }

    public static void print (int [][]array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void buscar (int [][]array){
        boolean encontrado = false;
        int fila = 0, columna = 0;
        while (!encontrado) {
            rellenar(array);
            print(array);

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == 30) {
                        encontrado = true;
                        fila = i;
                        columna = j;
                    }
                }
            }
            if (encontrado) {
                System.out.println("Valor 30 encontrado en fila " + (fila + 1) + " columna " + (columna + 1));
            } else {
                System.out.println("No se ha encontrado el valor");
            }
        }
    }
}

