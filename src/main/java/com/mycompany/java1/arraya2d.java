package com.mycompany.java1;

public class arraya2d {
    public static void main(String[] args){
        int fil = 4;
        int col = 4;
        int v[] = new int[fil*col];
        int m[][] = new int[fil][col];

        for (int f = 0; f<fil;f++){
            for (int c = 0; c<col; c++){
                m[f][c] = v[f*fil+c];
            }
        }
    }
}
