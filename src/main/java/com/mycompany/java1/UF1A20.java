package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class UF1A20 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        double [] tortugas = new double[3];
        boolean victoria = false;

        System.out.println("Presiona ENTER para continuar jugando");
        while (!victoria){
            for (int i = 0; i<3;i++){
                for (int j = 0; j<3; j++){
                    System.out.println("Tortuga "+(j+1)+" posición: "+tortugas[j]);
                }
                System.out.println("");
                double num = random.nextInt(1,3);
                int obstaculo = random.nextInt(6);
                String continuar = scanner.nextLine();

                System.out.println("Turno tortuga: "+(i+1)+"\n");
                switch (obstaculo) {
                    case 0:
                        System.out.println("Tortuga "+(i+1)+" TERRENO RESBALADIZO: Mitad de avance");
                        num = num / 2;
                        break;
                    case 1:
                        if (tortugas[i] > 0){
                            System.out.println("Tortuga "+(i+1)+" en TERRENO PIEDROSO: -1 posicion");
                            num = -1;
                            break;
                        }
                    case 2:
                        if (tortugas[i]>2){
                            num = -3;
                            System.out.println("Tortuga "+(i+1)+" en TRAMPA DE FANGO: -3 posiciones");
                        }
                        else{
                            tortugas[i] = 0;
                            System.out.println("Tortuga "+(i+1)+" en TRAMPA DE FANGO: VUELTA AL PUNTO DE PARTIDA");

                        }
                }
                System.out.println("Tortuga "+(i+1)+" avanza "+num+" posiciones");
                tortugas[i] = tortugas[i] + num;
                if (tortugas[i]>=10){
                    System.out.println("\n\nGANA LA TROTUGA "+(i+1));
                    i = 4;
                    victoria = true;
                }

            }
        }
    }
}
