package com.mycompany.java1;
import java.util.Scanner;

public class UF2A12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int contarmax = Integer.MIN_VALUE;
        String masa = "";
        String frase = "";
        int contar = 1;

        while (contar != -1) {
            contar = 0;
            System.out.println("Escriu una frase:");
            frase = scanner.nextLine();
            if (frase.equals("fi")) {
                contar = -1;
            } else {
                for (int i = 0; i < frase.length(); i++) {
                    if (frase.charAt(i) == 'a') {
                        contar++;
                    }
                }
                if (contar > contarmax){
                    masa = frase;
                    contarmax = contar;
                }
            }
            System.out.println("La frase amb més 'a' és: '"+masa+"' Té "+contarmax+" 'a'");
        }
    }
}



