package Repetition_M319;

import java.util.Scanner;
import java.util.Random;

public class Rate_Spiel {

    private int zuRatendeZahl;
    private int versuche;

    public Rate_Spiel() {
        Random rand = new Random();
        this.zuRatendeZahl = rand.nextInt(100) + 1;
        this.versuche = 0;
    }

    public void starten() {
        Scanner scanner = new Scanner(System.in);
        int benutzerEingabe;
        boolean richtigGeraten = false;

        System.out.println("Willkommen zum Rate-Spiel!");
        System.out.println("Errate die Zahl zwiscchen 1-100!");

        while (!richtigGeraten) {
            System.out.print("Gib eine Zahl ein: ");
            benutzerEingabe = scanner.nextInt();
            versuche++;

            if (benutzerEingabe < zuRatendeZahl) {
                System.out.println("Zu niedrig!");
            } else if (benutzerEingabe > zuRatendeZahl) {
                System.out.println("Zu hoch!");
            } else {
                System.out.println("Glückwunsch! Du hast die Zahl erraten.");
                System.out.println("Du hast " + versuche + " Versuche benötigt.");
                richtigGeraten = true;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Rate_Spiel spiel = new Rate_Spiel();
        spiel.starten();
    }
}
