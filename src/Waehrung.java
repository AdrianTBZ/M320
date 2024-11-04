public class Waehrung {
	private String name;
	private double wechselkursZuBasis;

	public Waehrung(String name, double wechselkursZuBasis) {
		this.name = name;
		this.wechselkursZuBasis = wechselkursZuBasis;
	}

	public String getName() {
		return name;
	}

	public double getWechselkursZuBasis() {
		return wechselkursZuBasis;
	}

	public double umrechnenZuBasis(double betrag) {
		return betrag * wechselkursZuBasis;
	}

	public double vonBasisUmrechnen(double betrag) {
		return betrag / wechselkursZuBasis;
	}
}
