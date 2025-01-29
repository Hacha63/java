package com.mycompany.java1;

import java.util.Scanner;

public class UF2A10 {
    public static void main(String[] args) {
        UF2A10 programa = new UF2A10();
        Scanner scanner = new Scanner(System.in);

        Castell[] arrayCastell={new Castell(1,"Quatre de set",800,980),
                new Castell(27,"Tres de deu amb folre i manilles",12500,13200),
                new Castell(3,"Quatre de set amb l'agulla",1220,1440),
                new Castell(22,"Quatre de nou amb folre i l'agulla",9200,9800),
                new Castell(2,"Tres de set",1000,1200),
                new Castell(21,"Cinc de nou amb folre",8600,9180),
                new Castell(20,"Pilar de vuit amb folre i manilles",8020,8580)};

        int[] codis={21,3,20};
        int[] codis2={2,1,3};
        int[] codis3={22,20,21};
        int[] codis4={27,22,20};

        Colla[] arrayColla={new Colla("Colla Vella dels Xiquets de Valls","Valls",new int[]{21,3,20}),
                new Colla("Xiquets del Serrallo","Tarragona",codis2),
                new Colla("Minyons de Terrassa","Terrassa",codis3),
                new Colla("Xiquets de Vilafranca","Vilafranca",codis4)};

        int opcion = 0;
        int codicastell = 0;
        String collanom;

        while (opcion != 3){
            System.out.println("1. Visualitza nom del castells d'una collla\n2. Visualitza nom de colles que han fet un castell\n3. Sortir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Introdueix el nom de la colla: ");
                    collanom = scanner.nextLine();
                    programa.dadesColla(collanom, arrayColla, arrayCastell);

                    break;
                case 2:
                    System.out.println("Introdueix el codi del castell: ");
                    codicastell = scanner.nextInt();
                    programa.collesCastell(codicastell, arrayCastell, arrayColla);
                    break;
                case 3:
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Selecciona una opció correcta\n");
            }
        }

    }

    public void dadesColla(String nom, Colla[] arrayColla, Castell[] arrayCastell) {
        for (Colla colla : arrayColla) {
            if (colla.getNom().equalsIgnoreCase(nom)) {
                System.out.println("Colla: " + colla.getNom());
                int[] codis = colla.getCodisCastellsPrincipals();
                for (int codi : codis) {
                    for (Castell castell : arrayCastell) {
                        if (castell.getCodi() == codi) {
                            System.out.println("Castell: " + castell.getDescripcio());
                        }
                    }
                }
                return;
            }
        }
        System.out.println("No s'ha trobat cap colla amb el nom: " + nom);
    }

    public void collesCastell(int codicastell,Castell[] arrayCastell, Colla[] arrayColla){

        String descripcio = null;

        for (Castell castell : arrayCastell){
            if (castell.getCodi() == codicastell){
                descripcio = castell.getDescripcio();
                System.out.println("Castell: "+ descripcio);
                break;
            }
        }

        if (descripcio == null){
            System.out.println("No hi ha cap castell amb el codi "+ codicastell);
            return;
        }

        for (Colla colla : arrayColla) {
            for (int codi : colla.getCodisCastellsPrincipals()) {
                if (codi == codicastell){
                    System.out.println("Colla: "+ colla.getNom());
                }
            }
        }
    }
}
