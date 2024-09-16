package V2_SerieB;

class Angreifer extends Spieler {
	public Angreifer(String name) {
		super(name);
	}

	public void jogTraining() {
		System.out.println(name + " geht Joggen.");
	}

	@Override
	public void spielen() {
		System.out.println(name + " stürmt nach vorne.");
	}
}
