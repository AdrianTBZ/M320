package Q2;

/**
 * Die Klasse FussballMannschaftTest ist der Einstiegspunkt für das Programm.
 * Sie erstellt eine Instanz der Klasse Mannschaft und startet das Menü.
 */
public class FussballMannschaftTest {

    /**
     * Der Hauptmethode des Programms. Erstellt eine Mannschaft und startet das Menü.
     *
     * @param args Die Kommandozeilenargumente (nicht verwendet).
     */
    public static void main(String[] args) {
        Mannschaft mannschaft = new Mannschaft();
        Menu menu = new Menu(mannschaft);
        menu.start();
    }
}
