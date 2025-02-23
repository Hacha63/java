package com.mycompany.java1;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RegistreAccessos {
    private static final String FITXER = "registreAcces.txt";
    private static final DateTimeFormatter FORMAT_DATA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio;
        do {
            System.out.println("\nBenvingut al Sistema de Registre d'Accessos.");
            System.out.println("1. Entrada al Sistema");
            System.out.println("2. Consultar Historial d'Accessos");
            System.out.println("3. Quantitat d'usuaris ingressats en un interval");
            System.out.println("4. Sortir");
            System.out.print("Seleccioni una opció: ");
            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1 -> entradaSistema(scanner);
                case 2 -> consultarHistorial();
                case 3 -> usuarisEnInterval(scanner);
                case 4 -> System.out.println("Adeu!!!");
                default -> System.out.println("Opció no vàlida, intenti-ho de nou.");
            }
        } while (opcio != 4);
    }

    private static void entradaSistema(Scanner scanner) {
        System.out.print("Introdueixi el seu nom d'usuari: ");
        String usuari = scanner.nextLine();
        LocalDateTime ara = LocalDateTime.now();

        try (FileWriter fw = new FileWriter(FITXER, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Usuari: " + usuari + " - Data i Hora: " + ara + "\n");
            System.out.println("\n¡Accés amb èxit! S'ha registrat la seva entrada al sistema!\n");
        } catch (IOException e) {
            System.out.println("Error en escriure al fitxer: " + e.getMessage());
        }
    }

    private static void consultarHistorial() {
        System.out.println("\nHistorial d'Accessos:");
        try (BufferedReader br = new BufferedReader(new FileReader(FITXER))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split(" - Data i Hora: ");
                if (parts.length == 2) {
                    LocalDateTime data = LocalDateTime.parse(parts[1]);
                    System.out.println(parts[0] + " " + data.format(FORMAT_DATA));
                }
            }
        } catch (IOException e) {
            System.out.println("Error en llegir el fitxer: " + e.getMessage());
        }
    }

    private static void usuarisEnInterval(Scanner scanner) {
        System.out.print("Introduir l'hora d'inici de l'interval: ");
        int horaInici = scanner.nextInt();
        System.out.print("Introduir els minut d'inici: ");
        int minutInici = scanner.nextInt();
        System.out.print("Introduir l'hora final de l'interval: ");
        int horaFinal = scanner.nextInt();
        System.out.print("Introduir els minuts finals: ");
        int minutFinal = scanner.nextInt();
        scanner.nextLine();

        LocalTime inici = LocalTime.of(horaInici, minutInici);
        LocalTime fi = LocalTime.of(horaFinal, minutFinal);

        System.out.println("\nUsuaris registrats en aquest interval de temps:");
        try (BufferedReader br = new BufferedReader(new FileReader(FITXER))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split(" - Data i Hora: ");
                if (parts.length == 2) {
                    LocalDateTime data = LocalDateTime.parse(parts[1]);
                    LocalTime hora = data.toLocalTime();
                    if (!hora.isBefore(inici) && !hora.isAfter(fi)) {
                        System.out.println(parts[0]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error en llegir el fitxer: " + e.getMessage());
        }
    }
}
