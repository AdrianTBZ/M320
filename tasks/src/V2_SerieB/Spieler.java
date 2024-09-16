package V2_SerieB;

class Spieler {
	public String name;

	public Spieler(String name) {
		this.name = name;
	}

	public void spielen() {
		System.out.println(name + " spielt Fussball.");
	}
}
