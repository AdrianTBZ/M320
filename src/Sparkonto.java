public class Sparkonto extends Konto {
	private double zinsRate;

	public Sparkonto(String kontonummer, double zinsRate) {
		super(kontonummer);
		this.zinsRate = zinsRate;
	}

	public void zinsenBuchen() {
		double zinsen = getSaldo() * zinsRate;
		geldEinzahlen(zinsen);
	}
}
