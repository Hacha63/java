package com.mycompany.java1;

import java.time.LocalDate;

public class UF2Ac11 {
    public static void main(String[] args) {
        Actor[] protas = {
                new Actor(1, "Robert Downey Jr.", LocalDate.of(1965, 4, 4)),
                new Actor(2, "Scarlett Johansson", LocalDate.of(1984, 11, 22)),
                new Actor(3, "Chris Evans", LocalDate.of(1981, 6, 13)),
                new Actor(4, "Tom Holland", LocalDate.of(1996, 6, 1))
        };

        Peli[] pelis = {
                new Peli("Avengers: Endgame", "Anthony Russo", 2019, 181, new int[]{1, 2, 3}),
                new Peli("Spider-Man: No Way Home", "Jon Watts", 2021, 148, new int[]{1, 3, 4}),
                new Peli("Black Widow", "Cate Shortland", 2021, 134, new int[]{2, -1, -1})
        };

        pelisActor("Scarlett Johansson", protas, pelis);
        infoPelis("Jon Watts", protas, pelis);
    }

    public static void pelisActor(String nomActor, Actor[] protas, Peli[] pelis) {
        int codiActor = -1;
        for (Actor actor : protas) {
            if (actor.getNom().equals(nomActor)) {
                codiActor = actor.getCodi();
                break;
            }
        }

        if (codiActor == -1) {
            System.out.println("Error: No tenim informació de l'actor " + nomActor);
            return;
        }

        boolean trobat = false;
        for (Peli peli : pelis) {
            for (int codi : peli.getprotagonistes()) {
                if (codi == codiActor) {
                    System.out.println(peli.getTitol());
                    trobat = true;
                    break;
                }
            }
        }

        if (!trobat) {
            System.out.println(nomActor + " no ha participat en cap pel·lícula registrada.");
        }
    }

    public static void infoPelis(String nomDirector, Actor[] protas, Peli[] pelis) {
        boolean trobat = false;

        for (Peli peli : pelis) {
            if (peli.getDirector().equals(nomDirector)) {
                System.out.println("Títol: " + peli.getTitol());
                System.out.println("Any: " + peli.getAny());
                System.out.println("Durada: " + peli.getDurada() + " minuts");
                System.out.print("Protagonistes: ");

                for (int codi : peli.getprotagonistes()) {
                    if (codi != -1) {
                        for (Actor actor : protas) {
                            if (actor.getCodi() == codi) {
                                System.out.print(actor.getNom() + ", ");
                                break;
                            }
                        }
                    }
                }
                System.out.println("\n------------------");
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("Error: No tenim dades de pel·lícules del director " + nomDirector);
        }
    }
}
