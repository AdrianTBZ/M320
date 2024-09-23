package Q2;

import java.util.Scanner;

/**
 * Die Klasse Menu stellt ein Menü zur Verfügung, um Spieler zu einer Mannschaft
 * hinzuzufügen und die Mannschaft spielen zu lassen.
 */
class Menu {
    private Scanner scanner;
    private Mannschaft mannschaft;

    /**
     * Konstruktor der Klasse Menu.
     *
     * @param mannschaft Die Mannschaft, mit der das Menü interagiert.
     */
    public Menu(Mannschaft mannschaft) {
        this.scanner = new Scanner(System.in);
        this.mannschaft = mannschaft;
    }

    /**
     * Startet das Menü, um Benutzerinteraktionen zu ermöglichen.
     * Das Menü bietet Optionen zum Hinzufügen von Spielern, Starten eines Spiels oder Beenden des Programms.
     */
    public void start() {
        while (true) {
            System.out.println("\n1. Spieler hinzufügen");
            System.out.println("2. Mannschaft spielen lassen");
            System.out.println("3. Beenden");
            System.out.print("Wählen Sie eine Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSpieler();
                    break;
                case 2:
                    mannschaft.spielen();
                    break;
                case 3:
                    System.out.println("Programm wird beendet.");
                    return;
                default:
                    System.out.println("Ungültige Option. Bitte erneut wählen.");
            }
        }
    }

    /**
     * Fragt den Benutzer nach Informationen zu einem neuen Spieler und fügt diesen der Mannschaft hinzu.
     * Der Benutzer wählt den Spielertyp (Goalie, Angreifer, Verteidiger) und gibt dann die entsprechenden Informationen ein.
     */
    private void addSpieler() {
        System.out.println("Spielertyp wählen:");
        System.out.println("1. Goalie");
        System.out.println("2. Angreifer");
        System.out.println("3. Verteidiger");
        System.out.print("Wählen Sie eine Option: ");

        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name des Spielers: ");
        String name = scanner.nextLine();

        boolean added = false;
        switch (type) {
            case 1:
                System.out.print("Körpergrösse des Goalies: ");
                double groesse = scanner.nextDouble();
                added = mannschaft.addGoalie(name, groesse);
                break;
            case 2:
                added = mannschaft.addAngreifer(name);
                break;
            case 3:
                added = mannschaft.addVerteidiger(name);
                break;
            default:
                System.out.println("Ungültiger Spielertyp.");
                return;
        }

        if (added) {
            System.out.println("Spieler wurde zur Mannschaft hinzugefügt.");
        } else {
            System.out.println("Spieler konnte nicht hinzugefügt werden. Maximale Anzahl erreicht.");
        }
    }
}
