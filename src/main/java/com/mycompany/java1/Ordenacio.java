package com.mycompany.java1;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordenacio {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean fin = false;

        while (!fin) {
            System.out.print("Introduce un número para añadir al array (0 para terminar): ");
            int numero = scanner.nextInt();
            if (numero == 0) {
                fin = true;
            }
            else {
                lista.add(numero);
                System.out.println("Array actual: " + lista + " | Longitud: " + lista.size());
            }
        }

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i) > lista.get(j)) {
                    int ayuda = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, ayuda);
                }
            }
        }

        System.out.println("Array ordenado: " + lista);
    }
}
