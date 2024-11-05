package com.mycompany.java1;
import java.util.Scanner;

public class UF1A191 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String[] poblaciones = {
                "Tarragona", "Altafulla", "Torredembarra", "Creixell", "Roda de Barà", "El Vendrell"
        };

        int[] distancias = {14, 3, 8, 5, 10};
        double precioPorKm = 0.08;

        System.out.println("\n1.Tarragona        2.Altafulla        3.Torredembarra         4.Creixell       5.Roda de Barà        6.El Vendrell\n\n" +
                            "    ■------------------■-------------------■---------------------■------------------■-----------------------■\n\n" +
                            "          14 Km             3 Km                8 Km                 5 Km                 10 Km\n\n");

        System.out.println("Introduce el origen (1 para Tarragona, 2 para Altafulla, ...): ");
        int origen = scanner.nextInt() - 1;

        System.out.println("Introduce el destino (1 para Tarragona, 2 para Altafulla, ...): ");
        int destino = scanner.nextInt() - 1;

        System.out.println("Anada/Tornada (s/n): ");
        boolean idaYVuelta = scanner.next().equalsIgnoreCase("s");

        if (origen < 0 || origen >= poblaciones.length || destino < 0 || destino >= poblaciones.length) {
            System.out.println("Error: La población de origen o destino no es válida.");
            return;
        }

        int distanciaTotal = 0;
        if (origen < destino) {
            for (int i = origen; i < destino; i++) {
                distanciaTotal += distancias[i];
            }
        } else {
            for (int i = origen - 1; i >= destino; i--) {
                distanciaTotal += distancias[i];
            }
        }

        double precio = distanciaTotal * precioPorKm;

        double descuento = 0;
        if (idaYVuelta) {
            descuento = 0.05 * precio;
            precio -= descuento;
            precio = precio *2;
        }
        System.out.println("Origen: " + poblaciones[origen]);
        System.out.println("Destí: " + poblaciones[destino]);
        System.out.println("Km: " + distanciaTotal);
        System.out.println("A/T: " + (idaYVuelta ? "Sí" : "No"));
        System.out.println("Descompte: " + (idaYVuelta ? "5%" : "0%"));
        System.out.printf("Preu: %.3f Є\n", precio);
    }
}
