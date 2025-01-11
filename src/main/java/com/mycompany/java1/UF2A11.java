package com.mycompany.java1;

public class UF2A11{

    public static void main(String[] args) {
        UF2A11 programa = new UF2A11();

        System.out.println("Mitjana de 4 números (4, 8, 15, 16): " + programa.mitjana(4, 8, 15, 16));
        System.out.println("Compta dígits de 12345: " + programa.comptaDigits(12345));
        System.out.println("És múltiple (10, 2): " + programa.esMultiple(10, 2));
        System.out.println("Factorial de 5: " + programa.factorial(5));
        System.out.println("És nombre perfecte (6): " + programa.esNombrePerfecte(6));
    }

    /**
     * Calcula la mitjana aritmètica de quatre números
     * @param n1 un número
     * @param n2 un número
     * @param n3 un número
     * @param n4 un número
     * @return la mitjana aritmètica dels números dels quatre paràmetres
     */
    public double mitjana(double n1, double n2, double n3, double n4) {
        return (n1 + n2 + n3 + n4) / 4.0;
    }

    /**
     * Compta els dígits d'un número
     * @param n un número
     * @return un enter amb el número de dígits de n
     */
    public int comptaDigits(long n) {
        n = Math.abs(n);
        return String.valueOf(n).length();
    }

    /**
     * Comprova si un número és múltiple d'un altre
     * @param n el dividend
     * @param d el divisor
     * @return cert si n és múltiple de d i fals en cas contrari
     */
    public boolean esMultiple(int n, int d) {
        if (d == 0) {
            return false;
        }
        return n % d == 0;
    }

    /**
     * Calcula el factorial d'un nombre enter
     * @param n un número
     * @return el valor de n!
     */
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no està definit per números negatius.");
        }
        int resultat = 1;
        for (int i = 2; i <= n; i++) {
            resultat *= i;
        }
        return resultat;
    }

    /**
     * Comprova si un número és perfecte, és a dir, que el seu valor és igual a
     * la suma dels seus divisors
     * @param n un número
     * @return cert si el número és perfecte i fals en cas contrari
     */
    public boolean esNombrePerfecte(int n) {
        if (n <= 0) {
            return false;
        }
        int sumaDivisors = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sumaDivisors += i;
            }
        }
        return sumaDivisors == n;
    }
}
