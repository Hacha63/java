package com.mycompany.java1;

import java.io.*;
import java.util.*;

public class BuscarIP {
    public static void main(String[] args) {
        String nomFitxer = "C:\\Users\\Usuario\\IdeaProjects\\java\\src\\main\\java\\com\\mycompany\\java1\\aules.txt";//Ruta absoluta, da error si no
        Map<String, String> mapaIP = llegirFitxer(nomFitxer);

        if (mapaIP.isEmpty()) {
            System.out.println("No s'ha pogut llegir el fitxer o està buit.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix una adreça IP: ");
        String ipBuscada = scanner.nextLine();
        scanner.close();

        String ubicacio = mapaIP.get(ipBuscada);
        if (ubicacio != null) {
            System.out.println("L'adreça IP " + ipBuscada + " correspon a: " + ubicacio);
        } else {
            System.out.println("No s'ha trobat cap ubicació per a l'adreça IP donada.");
        }
    }

    private static Map<String, String> llegirFitxer(String nomFitxer) {
        Map<String, String> mapaIP = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomFitxer))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (linia.contains(":")) {
                    String[] parts = linia.split(":");
                    if (parts.length == 2) {
                        String ubicacio = parts[0].trim();
                        String[] ips = parts[1].trim().split(" ");
                        for (String ip : ips) {
                            mapaIP.put(ip, ubicacio);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error en llegir el fitxer: " + e.getMessage());
        }
        return mapaIP;
    }
}
