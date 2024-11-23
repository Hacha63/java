package com.mycompany.java1;
import java.util.Random;

public class UF1A174 {
    public static void main(String[] args){
        Random random = new Random();

        int [] lista = new int [15];
        int [] lista2 = new int [15];
        int j = 0;

        System.out.println("Tabla");
        for (int i = 0; i<15;i++){
            lista[i] = random.nextInt(50,100);
            if (lista[i]%2==0){
                lista2[j] = lista[i];
                j++;
            }
            System.out.print("|\t"+lista[i]+"\t");
        }
        System.out.println("\nTabla de numeros solo pares");
        for (int i = 0; i<15;i++){
            if (lista2[i]==0){
                i = 15;
            }
            else {
                System.out.print("|\t" + lista2[i]+"\t");
            }
        }
    }
}
