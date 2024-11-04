public class Konto {
	private String kontonummer;
	private double saldo;
	private Waehrung waehrung;

	public Konto(String kontonummer, Waehrung waehrung) {
		this.kontonummer = kontonummer;
		this.saldo = 0.0;
		this.waehrung = waehrung;
	}

	public String getKontonummer() {
		return kontonummer;
	}

	public double getSaldo() {
		return saldo;
	}

	public Waehrung getWaehrung() {
		return waehrung;
	}

	public void geldEinzahlen(double betrag) {
		if (betrag <= 0) {
			System.out.println("Betrag muss positiv sein.");
			return;
		}
		this.saldo += betrag;
	}

	public void geldAbheben(double betrag) throws KontoNichtGefundenException {
		if (betrag > saldo) {
			throw new KontoNichtGefundenException("Nicht genug Guthaben vorhanden.");
		}
		if (betrag <= 0) {
			System.out.println("Betrag muss positiv sein.");
			return;
		}
		this.saldo -= betrag;
	}
}
