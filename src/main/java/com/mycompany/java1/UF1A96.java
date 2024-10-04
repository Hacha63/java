package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class UF1A96 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   
        Random random = new Random();
        int intentos = 3;

        System.out.println("Registra tu usuario: ");
        String reguser =  scanner.nextLine();
        System.out.println("Registra tu contraseña: ");
        String regpass =  scanner.nextLine();
        while (intentos != 0){
            System.out.println("Introduce tu usuario");
            String user =  scanner.nextLine();
            System.out.println("Introduce tu contraseña");
            String pass = scanner.nextLine();

            if (!user.equals(reguser) || !pass.equals(regpass)){
                if (intentos < 2){
                    System.out.println("Usuario bloqueado");
                    intentos = intentos -1;
                }
                else{
                    System.out.println("Error, usuario o contraseña incorrectos");
                    intentos = intentos -1;
                }
                }
            else{
                System.out.println("Correcto, has iniciado sesión");
                intentos = intentos - intentos;
            }
        }
}
}