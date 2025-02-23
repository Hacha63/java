package com.mycompany.java1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase base Vehicle
abstract class Vehicle {
    protected String matricula;
    protected LocalDateTime dataHoraEntrada;

    public Vehicle(String matricula) {
        this.matricula = matricula;
        this.dataHoraEntrada = LocalDateTime.now(); // Se registra la entrada automáticamente
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public LocalDateTime getDataHoraEntrada() { return dataHoraEntrada; }
    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) { this.dataHoraEntrada = dataHoraEntrada; }

    public abstract double calcularPreu(long minuts);
}

// Subclase Cotxe
class Cotxe extends Vehicle {
    private static final double DESCOMPTE = 0.1;

    public Cotxe(String matricula) {
        super(matricula);
    }

    @Override
    public double calcularPreu(long minuts) {
        return (minuts * Parking.PREU_MINUT) * (1 - DESCOMPTE);
    }
}

// Subclase Motocicleta
class Motocicleta extends Vehicle {
    public Motocicleta(String matricula) {
        super(matricula);
    }

    @Override
    public double calcularPreu(long minuts) {
        return (minuts * Parking.PREU_MINUT) / 2;
    }
}

// Subclase Furgoneta
class Furgoneta extends Vehicle {
    public Furgoneta(String matricula) {
        super(matricula);
    }

    @Override
    public double calcularPreu(long minuts) {
        return (minuts * Parking.PREU_MINUT) * 2;
    }
}

// Clase Plaça
class Plaça {
    private int numero;
    private String ubicacio;
    private Vehicle vehicle;

    public Plaça(int numero, String ubicacio) {
        this.numero = numero;
        this.ubicacio = ubicacio;
        this.vehicle = null; // Plaza inicialmente vacía
    }

    public int getNumero() { return numero; }
    public String getUbicacio() { return ubicacio; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public boolean isOcupada() { return vehicle != null; }

    @Override
    public String toString() {
        return "Plaça " + numero + " en " + ubicacio + " - " + (isOcupada() ? "Ocupada" : "Lliure");
    }
}

// Clase Parking
class Parking {
    private List<Plaça> places;
    private int numPlacesOcupades;
    public static final double PREU_MINUT = 3;

    public Parking(int maxPlaces) {
        places = new ArrayList<>();
        for (int i = 0; i < maxPlaces; i++) {
            String ubicacio = (i < maxPlaces / 2) ? "Planta 1" : "Planta 2";
            places.add(new Plaça(i, ubicacio));
        }
        numPlacesOcupades = 0;
    }

    public boolean aparcar(Vehicle vehicle) {
        for (Plaça plaça : places) {
            if (!plaça.isOcupada()) {
                plaça.setVehicle(vehicle);
                numPlacesOcupades++;
                return true;
            }
        }
        return false; // No hay plazas libres
    }

    public double desaparcar(String matricula) {
        for (Plaça plaça : places) {
            if (plaça.isOcupada() && plaça.getVehicle().getMatricula().equals(matricula)) {
                return processDesaparcar(plaça);
            }
        }
        return -1; // Vehículo no encontrado
    }

    public double desaparcar(int codi) {
        if (codi >= 0 && codi < places.size() && places.get(codi).isOcupada()) {
            return processDesaparcar(places.get(codi));
        }
        return 0; // Plaza inválida o vacía
    }

    private double processDesaparcar(Plaça plaça) {
        Vehicle vehicle = plaça.getVehicle();
        long minuts = Duration.between(vehicle.getDataHoraEntrada(), LocalDateTime.now()).toMinutes();
        double preu = vehicle.calcularPreu(minuts);
        plaça.setVehicle(null);
        numPlacesOcupades--;
        return preu;
    }

    public void llistat() {
        for (Plaça plaça : places) {
            System.out.println(plaça);
        }
    }

    public boolean isPle() {
        return numPlacesOcupades == places.size();
    }

    public int numPlacesLliures() {
        return places.size() - numPlacesOcupades;
    }
}

// Clase principal para probar el programa
public class parking6 {
    public static void main(String[] args) {
        Parking parking = new Parking(10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Aparcar vehicle");
            System.out.println("2. Desaparcar per matrícula");
            System.out.println("3. Desaparcar per plaça");
            System.out.println("4. Llistat de places");
            System.out.println("5. Sortir");
            int opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    System.out.println("Matricula: ");
                    String matricula = scanner.nextLine();
                    System.out.println("Tipus (cotxe, moto, furgoneta): ");
                    String tipus = scanner.nextLine();
                    Vehicle v = switch (tipus.toLowerCase()) {
                        case "cotxe" -> new Cotxe(matricula);
                        case "moto" -> new Motocicleta(matricula);
                        case "furgoneta" -> new Furgoneta(matricula);
                        default -> null;
                    };
                    if (v != null && parking.aparcar(v)) {
                        System.out.println("Vehicle aparcat.");
                    } else {
                        System.out.println("No hi ha places lliures o tipus invàlid.");
                    }
                    break;
                case 2:
                    System.out.println("Matricula: ");
                    matricula = scanner.nextLine();
                    System.out.println("Preu: " + parking.desaparcar(matricula));
                    break;
                case 3:
                    System.out.println("Numero plaça: ");
                    int codi = scanner.nextInt();
                    System.out.println("Preu: " + parking.desaparcar(codi));
                    break;
                case 4:
                    parking.llistat();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opció invàlida.");
            }
        }
    }
}
