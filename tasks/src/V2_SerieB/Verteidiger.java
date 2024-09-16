package V2_SerieB;

class Verteidiger extends Spieler {
	public Verteidiger(String name) {
		super(name);
	}

	@Override
	public void spielen() {
		System.out.println(name + " verteidigt das Tor.");
	}
}
