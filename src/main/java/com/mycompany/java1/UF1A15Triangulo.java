package com.mycompany.java1;
import java.util.Scanner;

public class UF1A15Triangulo {
    static public void main(String[] args){
        System.out.println("Elige tu estructura: \n1. 9x8\n2. Escalera numeros\n3. Escalera *\n4. 9x9 con E\n5. Escalera invertida *");
        Scanner scanner = new Scanner(System.in);
        int estructura = scanner.nextInt();
        switch (estructura){
            case (1):
                for (int i=1;i<9;i++){
                    for (int j=1;j<10;j++){
                        System.out.print(j+" ");
                    }
                    System.out.println("");
                }
                break;
            case (2):
                for (int i = 1, n = 9; i<=n;i++){
                    for (int j = 1; j<=i;j++){
                        System.out.print(j+" ");
                    }
                    System.out.println("");
                }
                break;
            case (3):
                for (int i = 1, n = 9; i<=n;i++){
                    for (int j = 1; j<=i;j++){
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                break;
            case (4):
                for (int i = 0,n=9; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j) {
                            System.out.print("E ");
                        } else {
                            System.out.print("* ");
                        }
                    }
                    System.out.println("");
                }
                break;
            case (5):
                for (int i =9,n=i;i>=1;i--){
                    for (int j = 1; j<=i;j++){
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
        }

    }
}
