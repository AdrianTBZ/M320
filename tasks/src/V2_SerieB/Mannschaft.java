package V2_SerieB;

import java.util.ArrayList;
import java.util.List;

class Mannschaft {
	private Goalie goalie;
	private List<Angreifer> angreifer;
	private List<Verteidiger> verteidiger;

	public Mannschaft() {
		this.angreifer = new ArrayList<>();
		this.verteidiger = new ArrayList<>();
	}

	public boolean addGoalie(String name, double koerperGroesse) {
		if (goalie == null) {
			goalie = new Goalie(name, koerperGroesse);
			return true;
		}
		return false;
	}

	public boolean addAngreifer(String name) {
		if (angreifer.size() < 16) {
			angreifer.add(new Angreifer(name));
			return true;
		}
		return false;
	}

	public boolean addVerteidiger(String name) {
		if (verteidiger.size() < 4) {
			verteidiger.add(new Verteidiger(name));
			return true;
		}
		return false;
	}

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
