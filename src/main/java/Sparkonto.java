public class Sparkonto extends Konto {
	private double zinsRate;

	public Sparkonto(String kontonummer, Waehrung waehrung, double zinsRate) {
		super(kontonummer, waehrung);
		this.zinsRate = zinsRate;
	}

	public void zinsenBuchen() {
		double zinsen = getSaldo() * (zinsRate / 100);
		geldEinzahlen(zinsen);
		System.out.println("Zinsen von " + zinsen + " " + getWaehrung().getName() + " wurden auf das Sparkonto gutgeschrieben.");
	}
}
