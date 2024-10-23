package com.mycompany.java1;
import java.util.Random;
import java.util.Scanner;

public class UF1A13Avaluable {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int pos1 = 1;
        int pos2 = 1;
        int av1;
        int av2;
        int turno = 1;
        System.out.println("coche1 posición 1\ncoche2 posición 1\nPulsa ENTER para continuar");
        while (pos1 < 10 && pos2 <10 && turno < 11 ){
            String cont = scanner.nextLine();
            System.out.println("Turno "+turno);
            av1 = random.nextInt(1,3);
            av2 = random.nextInt(1,3);
            pos1 = pos1 + av1;
            pos2 = pos2 + av2;
            System.out.println("coche1 avanza: "+av1+"\ncoche2 avanza: "+av2);
            if (pos1%2==0){
                System.out.println("coche1. Curva Cerrada. Retrocede: "+pos1/2);
                pos1 = pos1 - (pos1/2);
            }
            else{
                System.out.println("coche1. Acelera en recta: "+(pos1+1)/2);
                pos1 = pos1 + ((pos1+1)/2);
            }
            if (pos2%2==0){
                System.out.println("coche2. Curva Cerrada. Retrocede: "+pos2/2);
                pos2 = pos2 - (pos2/2);
            }
            else{
                System.out.println("coche2. Acelera en recta: "+(pos2+1)/2);
                pos2 = pos2 + ((pos2+1)/2);
            }
            if (pos1 == 3 || pos1 == 7){
                System.out.println("coche1. Obstaculo. Retrocede: 2");
                pos1 = pos1 -2;
            }
            if (pos2 == 3 || pos2 == 7){
                System.out.println("coche2. Obstaculo. Retrocede: 2");
                pos2 = pos2 -2;
            }
            if (pos1 <0){
                pos1 = 0;
            }
            if (pos2 <0){
                pos2=0;
            }
            System.out.print("Coche 1 (Posición actual: "+pos1+"): ");
            for (int i = pos1;i>0;i--){
                System.out.print("=");}
            System.out.println("");
            System.out.print("Coche 2 (Posición actual: "+pos2+"): ");
            for (int i = pos2;i>0;i--){
                System.out.print("=");}
            System.out.println("");
            turno = turno + 1;
        }
        if (pos1>10 && pos2<10){
            System.out.println("COCHE 1 GANA!");
        }
        else if (pos2>10 && pos1<10) {
            System.out.println("COCHE 2 GANA!");
        }
        else {
            System.out.println("EMPATE");
        }
    }
}
