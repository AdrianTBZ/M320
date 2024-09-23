package Q2;

/**
 * Diese Klasse repräsentiert einen Spieler im Fussball.
 */
class Spieler {
    public String name;

    /**
     * Konstruktor zur Erstellung eines neuen Spielers.
     *
     * @param name Der Name des Spielers.
     */
    public Spieler(String name) {
        this.name = name;
    }

    /**
     * Methode, die anzeigt, dass der Spieler Fussball spielt.
     */
    public void spielen() {
        System.out.println(name + " spielt Fussball.");
    }
}
