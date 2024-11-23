package com.mycompany.java1;
import java.util.Scanner;

public class UF1A182 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean incorrecto = true;

        while (incorrecto) {
            System.out.println("Introduce la matricula: (XXXX-XXX)");
            String matricula = scanner.nextLine().toUpperCase();

            if (matricula.length() != 8) {
                System.out.println("La matrícula ha de contener 8 caracteres");
                continue;
            }

            incorrecto = false;

            for (int i = 0; i < 4; i++) {
                if (!Character.isDigit(matricula.charAt(i))) {
                    System.out.println("Posición " + i + " no es un número");
                    incorrecto = true;
                }
            }

            if (matricula.charAt(4) != '-') {
                System.out.println("Después de los 4 números ha de haber un (-)");
                incorrecto = true;
            }

            for (int i = 5; i < 8; i++) {
                if (!Character.isLetter(matricula.charAt(i))) {
                    System.out.println("Posición " + i + " no es una letra");
                    incorrecto = true;
                }
            }

            if (incorrecto) {
                System.out.println("Matrícula incorrecta. Inténtalo de nuevo.");
            }
        }
        System.out.println("Matrícula correcta");
        scanner.close();
    }
}
