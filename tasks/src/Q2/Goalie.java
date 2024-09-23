package Q2;

import Q2.Spieler;

/**
 * Die Klasse Goalie repräsentiert einen Torhüter, der eine spezielle Art von Spieler ist.
 */
class Goalie extends Spieler {
    private double koerperGroesse;

    /**
     * Konstruktor für die Goalie-Klasse.
     *
     * @param name Der Name des Torhüters.
     * @param koerperGroesse Die Körpergrösse des Torhüters in Metern.
     */
    public Goalie(String name, double koerperGroesse) {
        super(name);
        this.koerperGroesse = koerperGroesse;
    }

    /**
     * Implementierung der Spielmethode für den Torhüter.
     * Gibt aus, dass der Torhüter das Tor hütet.
     */
    @Override
    public void spielen() {
        System.out.println(name + " hütet das Tor.");
    }
}
