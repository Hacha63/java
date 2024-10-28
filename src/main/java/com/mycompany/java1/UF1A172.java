package com.mycompany.java1;
import java.util.Random;

public class UF1A172 {
    public static void main(String[] args){
    Random random = new Random();

    int [] temp = new int[12];
    int minpos = 0;
    double midtemp = 0;
    int tempsup = 0;
    int min = Integer.MAX_VALUE;

        System.out.print("Temperatures:");
    for (int i = 0;i<12;i++){
        temp[i] = random.nextInt(30);
        midtemp = midtemp + temp[i];
        System.out.print("\t"+temp[i]);
    }
        System.out.println();
    midtemp = midtemp /12;
    for (int i = 0;i<12;i++){
        if (temp[i]>=midtemp){
            tempsup++;
        } else if (temp[i]<min) {
            min = temp[i];
            minpos = (i+1);
        }

    }
        System.out.println("Temperatura mitjana: "+midtemp+"\nTemperatures superior o igual a la mitjana: "+tempsup+"\nTemperatura minima: "+min+"\nPosición temperatura minima: "+minpos);
    }
}
