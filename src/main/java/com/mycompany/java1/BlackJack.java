package com.mycompany.java1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackJack {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Carta> baraja = crearBaraja();
        Collections.shuffle(baraja);
        
        ArrayList<Carta> manoJugador = new ArrayList<>();
        ArrayList<Carta> manoDealer = new ArrayList<>();
        
        // Repartir dos cartas al jugador y al dealer
        manoJugador.add(baraja.remove(0));
        manoJugador.add(baraja.remove(0));
        manoDealer.add(baraja.remove(0));
        manoDealer.add(baraja.remove(0));
        
        System.out.println("Tus cartas: " + manoJugador + " (Total: " + calcularValorMano(manoJugador) + ")");
        System.out.println("Carta visible del dealer: " + manoDealer.get(0));
        
        // Turno del jugador
        boolean jugadorSePlanta = false;
        while (!jugadorSePlanta) {
            System.out.print("¿Deseas otra carta? (si/no): ");
            String respuesta = scanner.nextLine();
            
            if (respuesta.equalsIgnoreCase("si")) {
                manoJugador.add(baraja.remove(0));
                System.out.println("Tus cartas: " + manoJugador + " (Total: " + calcularValorMano(manoJugador) + ")");
                
                if (calcularValorMano(manoJugador) > 21) {
                    System.out.println("Te pasaste de 21. ¡Perdiste!");
                    return;
                }
            } else {
                jugadorSePlanta = true;
            }
        }
        
        // Turno del dealer
        System.out.println("Las cartas del dealer: " + manoDealer + " (Total: " + calcularValorMano(manoDealer) + ")");
        while (calcularValorMano(manoDealer) < 17) {
            manoDealer.add(baraja.remove(0));
            System.out.println("El dealer toma otra carta: " + manoDealer + " (Total: " + calcularValorMano(manoDealer) + ")");
        }
        
        int totalJugador = calcularValorMano(manoJugador);
        int totalDealer = calcularValorMano(manoDealer);
        
        System.out.println("Total del jugador: " + totalJugador);
        System.out.println("Total del dealer: " + totalDealer);
        
        // Determinar el ganador
        if (totalDealer > 21 || totalJugador > totalDealer) {
            System.out.println("¡Ganaste!");
        } else if (totalJugador < totalDealer) {
            System.out.println("El dealer gana.");
        } else {
            System.out.println("Es un empate.");
        }
    }
    
    // Función para crear una baraja de cartas
    public static ArrayList<Carta> crearBaraja() {
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        ArrayList<Carta> baraja = new ArrayList<>();
        
        for (String palo : palos) {
            for (String valor : valores) {
                baraja.add(new Carta(valor, palo));
            }
        }
        return baraja;
    }
    
    // Función para calcular el valor total de una mano
    public static int calcularValorMano(ArrayList<Carta> mano) {
        int total = 0;
        int ases = 0;
        
        for (Carta carta : mano) {
            int valor = carta.obtenerValor();
            total += valor;
            if (valor == 11) {
                ases++;
            }
        }
        
        // Si el total excede 21 y hay ases, se cuentan como 1
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }
        
        return total;
    }
}

// Clase Carta
class Carta {
    private String valor;
    private String palo;
    
    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }
    
    // Obtener el valor numérico de la carta
    public int obtenerValor() {
        switch (this.valor) {
            case "A":
                return 11;
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(this.valor);
        }
    }
    
    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
