package com.mycompany.java1;
import java.util.Scanner;
import java.util.Random;

public class PreguntasMat {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int pregunta = 0;

        System.out.println("Cauntas preguntas quieres? ");
        int preguntas = scanner.nextInt();
        double porcentajetotal = preguntas;
        double porcentaje = 0;

        for (; preguntas != 0;preguntas--){
            int sim = random.nextInt(4);
            int num1 = random.nextInt(0,10);
            int num2 = random.nextInt(0,10);

            double respuesta;
            double correcto;

            pregunta ++;

            switch (sim){
                case 0:
                    System.out.print("Pregunta "+pregunta+ ". "+num1+" + "+num2+ " = ");
                     respuesta = scanner.nextDouble();
                     correcto = num1 + num2;
                    if (respuesta == correcto){
                        System.out.println("CORRECTO");
                        porcentaje = porcentaje+1;

                    }
                    else{
                        System.out.println("INCORRECTO, era "+correcto);
                    }
                    break;
                case 1:
                    System.out.print("Pregunta "+pregunta+ ". "+num1+" - "+num2+ " = ");
                     respuesta = scanner.nextDouble();
                     correcto = num1 - num2;
                    if (respuesta == correcto){
                        System.out.println("CORRECTO");
                        porcentaje = porcentaje+1;
                    }
                    else{
                        System.out.println("INCORRECTO, era "+correcto);
                    }
                    break;
                case 2:
                    System.out.print("Pregunta "+pregunta+ ". "+num1+" * "+num2+ " = ");
                     respuesta = scanner.nextDouble();
                     correcto = num1 * num2;
                    if (respuesta == correcto){
                        System.out.println("CORRECTO");
                        porcentaje = porcentaje+1;
                    }
                    else{
                        System.out.println("INCORRECTO, era "+correcto);
                    }
                    break;
                case 3:
                    if (num1 > num2 && num2 != 0) {
                        System.out.print("Pregunta " + pregunta + ". " + num1 + " / " + num2 + " = ");
                        respuesta = scanner.nextDouble();
                        correcto = num1 / num2;
                    }
                    else{
                        System.out.print("Pregunta "+pregunta+ ". "+num2+" / "+num1+ " = ");
                        respuesta = scanner.nextDouble();
                        correcto = num2 / num1;
                        }
                    if (respuesta == correcto){
                        System.out.println("CORRECTO");
                        porcentaje = porcentaje + 1;
                    }
                    else{
                        System.out.println("INCORRECTO, era "+correcto);
                    }
                    break;

            }

        }

        System.out.println("El porcentaje és de: "+porcentaje/porcentajetotal*100+"%");
    }
}
