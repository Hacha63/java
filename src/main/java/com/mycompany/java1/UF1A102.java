package com.mycompany.java1;

public class UF1A102 {
    public  static void main(String[] args){
        for(int contador = 0;contador!=100;) {
            System.out.print(" \n---------------------------------------------------------------\n");
            for (int linea = 0; linea != 8 && contador!=100; linea++) {
                contador = contador + 1;
                System.out.print("\t|" + contador+"\t|");

                }
            }
        }
    }

