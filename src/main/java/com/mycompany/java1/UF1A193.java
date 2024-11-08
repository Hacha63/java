    package com.mycompany.java1;
    import java.util.Scanner;

    public class UF1A193 {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            String persona [] = new String[20];
            boolean encontrado = false;

            for (int i = 0; i<20;i++){
                System.out.println("Introduce el nombre "+(i+1)+": ");
                persona[i] = scanner.nextLine();
            }

            System.out.println("Introduce el nombre a borrar: ");
            String borrar = scanner.nextLine();
            for (int i = 0; i<20; i++){
                if (borrar.equals(persona[i])){
                    for (int j = i; j < persona.length - 1; j++) {
                        persona[j] = persona[j + 1];
                    }
                    persona[persona.length - 1] = null;
                    System.out.println("Posicion "+i+"\n"+borrar+" eliminado.");
                    encontrado = true;
                    i = 21;
                }
            }
            for (int i = 0; i < persona.length; i++) {
                System.out.print(persona[i] + " ");
            }
            System.out.println("");

                if (!encontrado){
                System.out.println("No se ha encontrado ninguna posicion con ese nombre.");
            }
        }
    }
