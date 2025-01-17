package com.mycompany.java1;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class HospitalPacients {

    static class Pacient {
        String nom;
        String codiSS;
        String dni;
        LocalDate dataIngres;
        char radiografia;

        public Pacient(String nom, String codiSS, String dni, LocalDate dataIngres, char radiografia) {
            this.nom = nom;
            this.codiSS = codiSS;
            this.dni = dni;
            this.dataIngres = dataIngres;
            this.radiografia = radiografia;
        }
    }

    static Pacient[] pacients = {
            new Pacient("Pere Sans", "111111111", "44555666", LocalDate.of(2007, 5, 3), 'n'),
            new Pacient("Maria Soler", "222222222", "12345678", LocalDate.of(2021, 3, 10), 's'),
            new Pacient("Joan Puig", "333333333", "87654321", LocalDate.of(2020, 12, 15), 's')
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio = 0;

        while (opcio != 3){
            System.out.println("--- MENÚ ---\n1. Consultar radiografies per període\n2. Consultar dades d'un pacient per codi SS\n" +
                    "3. Sortir\nEscull una opció: ");
            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    System.out.print("Introdueix la data d'inici (dd/MM/yyyy): ");
                    LocalDate dataInici = llegirData(scanner.nextLine());
                    System.out.print("Introdueix la data final (dd/MM/yyyy): ");
                    LocalDate dataFinal = llegirData(scanner.nextLine());
                    radiografiesTemps(dataInici, dataFinal);
                    break;

                case 2:
                    System.out.print("Introdueix el codi SS del pacient: ");
                    String codiSS = scanner.nextLine();
                    dadesPacient(codiSS);
                    break;

                case 3:
                    System.out.println("Sortint del programa...");
                    break;

                default:
                    System.out.println("Opció no vàlida. Torna-ho a intentar.");
            }

        }
    }

    static void radiografiesTemps(LocalDate datainici, LocalDate datafinal) {
        if (datainici == null || datafinal == null) {
            System.out.println("Les dates no són vàlides.");
            return;
        }

        if (!datainici.isBefore(datafinal)) {
            System.out.println("Error: la data d'inici ha de ser anterior a la data final.");
            return;
        }

        boolean trobat = false;
        System.out.println("\nPacients amb radiografies entre " + datainici + " i " + datafinal + ":\n");
        for (Pacient pacient : pacients) {
            if (pacient.radiografia == 's' && (pacient.dataIngres.isEqual(datainici) || pacient.dataIngres.isEqual(datafinal)
                    || (pacient.dataIngres.isAfter(datainici) && pacient.dataIngres.isBefore(datafinal)))) {
                System.out.println("- " + pacient.nom + " (Codi SS: " + pacient.codiSS + ")");
                trobat = true;
            }
            System.out.println();
        }

        if (!trobat) {
            System.out.println("\nNo s'ha trobat cap pacient.\n");
        }
    }

    static void dadesPacient(String numsegsocial) {
        for (Pacient pacient : pacients) {
            if (pacient.codiSS.equals(numsegsocial)) {
                System.out.println("\nDades del pacient amb codi SS: " + pacient.codiSS);
                System.out.println("Nom: " + pacient.nom);
                System.out.println("DNI: " + pacient.dni);
                System.out.println("Data d’ingrés a l’hospital: " + formatDataCatalana(pacient.dataIngres));
                if (pacient.radiografia == 's') {
                    System.out.println("Se li han fet radiografies.\n");
                } else {
                    System.out.println("No li han fet radiografies.\n");
                }
                return;
            }
        }
        System.out.println("\nError: no existeix cap pacient amb el codi donat.\n");
    }

    static LocalDate llegirData(String dataString) {
        try {
            return LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            System.out.println("Error: el format de la data no és vàlid.");
            return null;
        }
    }

    static String formatDataCatalana(LocalDate data) {
        Month mes = data.getMonth();
        String mesCatala = mes.getDisplayName(TextStyle.FULL, new Locale("ca", "ES"));
        return data.getDayOfMonth() + " de " + mesCatala + " de " + data.getYear();
    }
}
