package V2_SerieB;

public class FussballMannschaftTest {
	public static void main(String[] args) {
		Mannschaft mannschaft = new Mannschaft();
		Menu menu = new Menu(mannschaft);
		menu.start();
	}
}
