package D2_SeriesA;

import java.util.ArrayList;
import java.util.List;

class Flug {
	List<Passagier> passagiere = new ArrayList<Passagier>();

	public void passagierHinzufuegen(Passagier passagier) {
		passagiere.add(passagier);
	}

	public void passagierEntfernen(Passagier passagier) {
		passagiere.remove(passagier);
	}

	public void passagierListeAusgeben() {
		for (Passagier p : passagiere) {
			p.nameAusgeben();
		}
	}

	public List<Passagier> getPassagiere() {
		return passagiere;
	}
}
