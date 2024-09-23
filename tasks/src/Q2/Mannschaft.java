package Q2;

import Q2.Verteidiger;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repräsentiert eine Mannschaft im Spiel.
 * Sie enthält einen Goalie, Angreifer und Verteidiger.
 */
class Mannschaft {
    private Goalie goalie;
    private List<Angreifer> angreifer;
    private List<Verteidiger> verteidiger;

    /**
     * Konstruktor für die Mannschaft.
     * Initialisiert die Listen der Angreifer und Verteidiger.
     */
    public Mannschaft() {
        this.angreifer = new ArrayList<>();
        this.verteidiger = new ArrayList<>();
    }

    /**
     * Fügt einen Goalie zur Mannschaft hinzu, wenn noch keiner existiert.
     *
     * @param name Der Name des Goalies.
     * @param koerperGroesse Die Körpergrösse des Goalies.
     * @return true, wenn der Goalie hinzugefügt wurde, false, wenn bereits ein Goalie existiert.
     */
    public boolean addGoalie(String name, double koerperGroesse) {
        if (goalie == null) {
            goalie = new Goalie(name, koerperGroesse);
            return true;
        }
        return false;
    }

    /**
     * Fügt einen Angreifer zur Mannschaft hinzu, wenn weniger als 16 Angreifer existieren.
     *
     * @param name Der Name des Angreifers.
     * @return true, wenn der Angreifer hinzugefügt wurde, false, wenn bereits 16 Angreifer existieren.
     */
    public boolean addAngreifer(String name) {
        if (angreifer.size() < 16) {
            angreifer.add(new Angreifer(name));
            return true;
        }
        return false;
    }

    /**
     * Fügt einen Verteidiger zur Mannschaft hinzu, wenn weniger als 4 Verteidiger existieren.
     *
     * @param name Der Name des Verteidigers.
     * @return true, wenn der Verteidiger hinzugefügt wurde, false, wenn bereits 4 Verteidiger existieren.
     */
    public boolean addVerteidiger(String name) {
        if (verteidiger.size() < 4) {
            verteidiger.add(new Verteidiger(name));
            return true;
        }
        return false;
    }

    /**
     * Simuliert das Spielen der gesamten Mannschaft.
     * Jeder Spieler, der zur Mannschaft gehört, wird aufgefordert zu spielen.
     */
    public void spielen() {
        if (goalie != null) {
            goalie.spielen();
        }
        for (Angreifer angreifer : angreifer) {
            angreifer.spielen();
        }
        for (Verteidiger verteidiger : verteidiger) {
            verteidiger.spielen();
        }
    }
}
