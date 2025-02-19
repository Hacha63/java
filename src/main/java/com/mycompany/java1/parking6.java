package com.mycompany.java1;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

class Vehicle{
    protected String matricula;
    protected Date DataHoraEntrada;

    public Vehicle(String matricula, Date DataHoraEntrada){
        this.matricula = matricula;
        this.DataHoraEntrada = DataHoraEntrada;
    }

    public String getMaticula(){return matricula;}
    public void setMatricula(String matricula){this.matricula = matricula;}

    public Date getDataHoraEntrada(){return DataHoraEntrada;}
    public void setDataHoraEntrada(Date DataHoraEntrada){this.DataHoraEntrada = DataHoraEntrada;}

    public double calcularPreu(){return 0;}

    Date agetDataHoraEntrada(){return DataHoraEntrada;}
    void asetDataHoraEntrada(Date DataHoraEntrada){this.DataHoraEntrada = DataHoraEntrada;}
}

class Plaça{ //No acabado
    private int numero;
    private String ubicacio;

    public Plaça(int numero, String ubicacio){
        this.numero = numero;
        this.ubicacio = ubicacio;
    }

    public int getNumero(){return numero;}
    public void setNumero(int numero){this.numero = numero;}

    public String getUbicacio(){return ubicacio;}
    public void setUbicacio(String ubicacio){this.ubicacio = ubicacio;}

    public boolean isOcupada(){return true;}

}

class Parking{
    private int numPlacesOcupades;
    public double PREU_MINUT;

    public Parking(int numPlacesOcupades, double PREU_MINUT){
        this.numPlacesOcupades = numPlacesOcupades;
        this.PREU_MINUT = PREU_MINUT;
    }

    public int Parking(){return numPlacesOcupades;}

}
public class parking6 {
}
