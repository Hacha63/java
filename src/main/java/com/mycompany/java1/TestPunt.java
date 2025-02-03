package com.mycompany.java1;

class Punt {
    private double x, y;

    public Punt() {
        this.x = 0;
        this.y = 0;
    }

    public Punt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distancia(Punt altre) {
        return Math.sqrt(Math.pow(this.x - altre.x, 2) + Math.pow(this.y - altre.y, 2));
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class TestPunt {
    public static void main(String[] args) {
        Punt p1 = new Punt();
        Punt p2 = new Punt(5, 3);
        Punt p3 = new Punt(2, -1);
        Punt p4 = new Punt((p2.getX() + p3.getX()) / 2, (p2.getY() + p3.getY()) / 2);

        System.out.println("P1 = " + p1);
        System.out.println("P2 = " + p2);
        System.out.println("P3 = " + p3);
        System.out.println("P4 = " + p4);

        Punt p5 = new Punt(4, 3);
        System.out.println("Distància entre " + p5 + " i " + p1 + ": " + p5.distancia(p1));
    }
}
