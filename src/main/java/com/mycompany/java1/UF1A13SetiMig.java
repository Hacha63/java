package com.mycompany.java1;
import java.util.Scanner;
import java.util.Random;

public class UF1A13SetiMig {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Introduce tu ingreso: ");
        int dinero = scanner.nextInt();
        int apuesta = 1;
        while (apuesta != 0) {
            System.out.println("Saldo: " + dinero + "\nIntroduce tu apuesta:\n0 significa que no quieres jugar más");
            apuesta = scanner.nextInt();
            scanner.nextLine();
            if (apuesta != 0) {
                if (apuesta > dinero) {
                    System.out.println("No tienes suficiente saldo: " + dinero);
                } else {
                    dinero = dinero - apuesta;
                    System.out.println("Saldo: " + dinero + "\nApuesta: " + apuesta);
                    double pcvalor = 0;
                    double cartapc1 = 0;
                    for (int i = 2; i != 0; i--) {
                        cartapc1 = random.nextInt(1, 10);
                        if (cartapc1 == 8 || cartapc1 == 9 || cartapc1 == 10) {
                            pcvalor = pcvalor + 0.5;
                            cartapc1 = 0.5;
                        } else {
                            pcvalor = pcvalor + cartapc1;
                        }
                    }
                    System.out.println("El ordinador té un: " + cartapc1);
                    double cartaus = 0;
                    double usvalor = 0;
                    String otra;
                    boolean plantar = true;
                    while (plantar) {
                        cartaus = random.nextInt(1, 10);
                        if (cartaus == 8 || cartaus == 9 || cartaus == 10) {
                            usvalor = pcvalor + 0.5;

                        } else {
                            usvalor = usvalor + cartaus;
                        }
                        System.out.println("Tu valor és de " + usvalor + "\nDeseas otra carta? (y/n)");
                        otra = scanner.nextLine();
                        if (otra.equals("n")) {
                            System.out.println("El jugador se planta!");
                            plantar = false;
                        }


                    }
                    if ((usvalor <= 7.5 && usvalor > pcvalor) || pcvalor > 7.5) {
                        apuesta = apuesta * 2;
                        dinero = dinero + apuesta;
                        System.out.println("HAS GANADO\nEl PC tenia: " + pcvalor + "\n");
                    } else if (usvalor > 7.5) {
                        System.out.println("Te has pasado");
                        System.out.println("HAS PERDIDO\nEl pc tenia: " + pcvalor + "\n");

                    } else {
                        System.out.println("HAS PERDIDO\nEl pc tenia: " + pcvalor + "\n");

                    }

                }
            }
            else{

            }
        }
    }
}
