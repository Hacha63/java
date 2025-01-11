package com.mycompany.java1;

import java.util.Random;

public class UF2A13 {

    public static void main(String[] args) {
        UF2A13 program = new UF2A13();

        int[] array = new int[10];
        program.incicialitzaAleatori(array, 1, 100);

        System.out.println("Array inicialitzat:");
        program.imprimir(array);

        System.out.println("Suma dels elements: " + program.suma(array));

        System.out.println("Mitjana dels elements: " + program.mitjana(array));

        System.out.println("Valor màxim: " + program.max(array));
        System.out.println("Valor mínim: " + program.min(array));

        int multiplicador = 2;
        int[] arrayMultiplicat = program.multiplica(array, multiplicador);
        System.out.println("Array multiplicat per " + multiplicador + ":");
        program.imprimir(arrayMultiplicat);

        int[] array2 = new int[10];
        program.incicialitzaAleatori(array2, 1, 100);
        int[] arraySumat = program.suma(array, array2);
        System.out.println("Suma dels dos arrays:");
        program.imprimir(arraySumat);
    }

    /**
     * Inicialitza un array d'enters amb valors aleatoris compresos entre dos
     * valors determinats
     * @param array l'array que cal inicialitzar
     * @param desDe el mínim valor possible
     * @param finsA el màxim valor possible
     */
    public void incicialitzaAleatori(int[] array, int desDe, int finsA) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(finsA - desDe + 1) + desDe;
        }
    }

    /**
     * Imprimeix en una línia tots els valors del vector
     * @param vector un vector d'enters
     */
    public void imprimir(int[] vector) {
        for (int valor : vector) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    /**
     * Suma tots els elements d'un vector
     * @param llista el vector d'enters per sumar
     * @return la suma dels elements del vector
     */
    public int suma(int[] llista) {
        int suma = 0;
        for (int valor : llista) {
            suma += valor;
        }
        return suma;
    }

    /**
     * Calcula la mitjana aritmètica dels elements d'un vector
     * @param llista un vector d'enters
     * @return la mitjana aritmètica del vector
     */
    public double mitjana(int[] llista) {
        return (double) suma(llista) / llista.length;
    }

    /**
     * Obté el valor màxim d'una llista d'enters
     * @param llista un vector d'enters
     * @return el valor màxim trobat en el vector
     */
    public int max(int[] llista) {
        int max = llista[0];
        for (int valor : llista) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }

    /**
     * Obté el valor mínim d'una llista d'enters
     * @param llista un vector d'enters
     * @return el valor mínim trobat en el vector
     */
    public int min(int[] llista) {
        int min = llista[0];
        for (int valor : llista) {
            if (valor < min) {
                min = valor;
            }
        }
        return min;
    }

    /**
     * Multiplica cada element d'un vector per un valor determinat
     * @param array un vector d'enters
     * @param n el número pel qual es multiplicarà
     * @return un vector que conté cada element del vector proporcionat mulitplicat pel valor n
     */
    public int[] multiplica(int[] array, int n) {
        int[] resultat = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultat[i] = array[i] * n;
        }
        return resultat;
    }

    /**
     * Realitza la suma de dos vectors suma[i] = array1[i] + array2[i]
     * @param array1 un vector d'enters
     * @param array2 un vector d'enters
     * @return un vector d'enters que resulta de sumar els valors que hi ha
     * en les mateixes posicions dels dos vectors proporcionats en els arguments
     */
    public int[] suma(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Els dos vectors han de tenir la mateixa mida.");
        }
        int[] suma = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            suma[i] = array1[i] + array2[i];
        }
        return suma;
    }
}
