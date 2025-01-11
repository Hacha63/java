package com.mycompany.java1;

import java.util.Scanner;

public class UF2A6 {
    public static void main(String[] args) {
        UF2A6 programa = new UF2A6();
     Scanner scanner = new Scanner(System.in);

     String opcio = "A";

     while (!opcio.equals("FI")){
         System.out.println("Benvingut al gestor de notes\n" +
                             "---------------------------\n" +
                            "[RT] Registrar notes.\n[MJ] Consultar nota mitjana\n" +
                            "[HT] Histograma de notes.\n[FI] Sortir");
         System.out.print("Opció: ");
         opcio = scanner.nextLine();

         if (opcio.equals("RT")){

         }


     }
    }
}
