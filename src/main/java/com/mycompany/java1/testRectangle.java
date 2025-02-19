package com.mycompany.java1;

class Rectangle {
    private double base;
    private double altura;
    private double coordenadax;
    private double coordenaday;

    public Rectangle() {
        this(1, 1, 0, 0);
    }

    public Rectangle(double base) {
        this(base, base, 0, 0);
    }

    public Rectangle(double base, double altura) {
        this(base, altura, 0, 0);
    }

    public Rectangle(double base, double altura, double coordenadax, double coordenaday) {
        this.base = (base > 0) ? base : 1;
        this.altura = (altura > 0) ? altura : 1;
        this.coordenadax = coordenadax;
        this.coordenaday = coordenaday;
    }

    public double getBase() { return base; }
    public double getAltura() { return altura; }
    public double getCoordenadax() { return coordenadax; }
    public double getCoordenaday() { return coordenaday; }

    public double area() { return base * altura; }

    public double perimetre() { return 2 * (base + altura); }

    public void trasllada(double dx, double dy) {
        this.coordenadax += dx;
        this.coordenaday += dy;
    }

    public boolean redimensiona(double deltaBase, double deltaAltura) {
        if (base + deltaBase > 0 && altura + deltaAltura > 0) {
            base += deltaBase;
            altura += deltaAltura;
            return true;
        }
        return false;
    }

    public boolean redimensiona(double delta) {
        return redimensiona(delta, delta);
    }

    public void redimensiona() {
        base++;
        altura++;
    }

    @Override
    public String toString() {
        return String.format("base: %.2f\naltura: %.2f\nposició: (%.2f, %.2f)", base, altura, coordenadax, coordenaday);
    }
}

public class testRectangle {
    public static void main(String[] args) {
        // Prova dels constructors
        Rectangle r1 = new Rectangle(2, 3, 1, 1);
        Rectangle r2 = new Rectangle(2, 3);
        Rectangle r3 = new Rectangle(2);
        Rectangle r4 = new Rectangle();

        System.out.println("r1\n------------------------");
        System.out.println(r1);
        System.out.println("àrea: " + r1.area());
        System.out.println("perímetre: " + r1.perimetre());

        System.out.println("\nr2\n------------------------");
        System.out.println(r2);
        System.out.println("àrea: " + r2.area());
        System.out.println("perímetre: " + r2.perimetre());

        System.out.println("\nr3\n------------------------");
        System.out.println(r3);
        System.out.println("àrea: " + r3.area());
        System.out.println("perímetre: " + r3.perimetre());

        System.out.println("\nr4\n------------------------");
        System.out.println(r4);
        System.out.println("àrea: " + r4.area());
        System.out.println("perímetre: " + r4.perimetre());

        System.out.println("\nr1 redimensiona(2, 1)\n-------------------------");
        r1.redimensiona(2, 1);
        System.out.println(r1);
        System.out.println("àrea: " + r1.area());
        System.out.println("perímetre: " + r1.perimetre());

        System.out.println("\nr2 redimensiona(0.5, -1)\n------------------------");
        r2.redimensiona(0.5, -1);
        System.out.println(r2);
        System.out.println("àrea: " + r2.area());
        System.out.println("perímetre: " + r2.perimetre());

        System.out.println("\nr3 redimensiona(-3.25)\n------------------------");
        boolean canvi = r3.redimensiona(-3.25);
        System.out.println("S'ha redimensionat?: " + canvi);
        System.out.println(r3);
        System.out.println("àrea: " + r3.area());
        System.out.println("perímetre: " + r3.perimetre());

        System.out.println("\nr4 redimensiona()\n------------------------");
        r4.redimensiona();
        System.out.println(r4);
        System.out.println("àrea: " + r4.area());
        System.out.println("perímetre: " + r4.perimetre());

        System.out.println("\nr1 trasllada(2.5, -1.5)\n------------------------");
        r1.trasllada(2.5, -1.5);
        System.out.println(r1);
    }
}
