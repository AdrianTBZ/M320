package Q2;

import Q2.Spieler;

/**
 * Die Klasse Angreifer stellt einen Spieler dar, der die Rolle eines Angreifers übernimmt.
 * Ein Angreifer ist eine Spezialisierung der Klasse Spieler.
 */
class Angreifer extends Spieler {

    /**
     * Konstruktor zur Initialisierung eines Angreifers mit einem Namen.
     *
     * @param name der Name des Angreifers
     */
    public Angreifer(String name) {
        super(name);
    }

    /**
     * Simuliert das Joggen als Teil des Trainings.
     */
    public void jogTraining() {
        System.out.println(name + " geht Joggen.");
    }

    /**
     * Implementiert das Spielverhalten eines Angreifers.
     * Überschreibt die abstrakte Methode aus der Klasse Spieler.
     */
    @Override
    public void spielen() {
        System.out.println(name + " stürmt nach vorne.");
    }
}
