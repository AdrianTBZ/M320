/**
 * Die Klasse Verteidiger repräsentiert einen Spieler, der in der Verteidigung spielt.
 */
package Q2;

class Verteidiger extends Spieler {
    /**
     * Konstruktor für die Klasse Verteidiger.
     *
     * @param name der Name des Verteidigers
     */
    public Verteidiger(String name) {
        super(name);
    }

    /**
     * Führt die Spielaktion des Verteidigers aus.
     */
    @Override
    public void spielen() {
        System.out.println(name + " verteidigt das Tor.");
    }
}
