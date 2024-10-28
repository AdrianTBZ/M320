public class Konto {
	private String kontonummer;
	public double saldo;

	public Konto(String kontonummer) {
		this.kontonummer = kontonummer;
		this.saldo = 0.0;
	}

	public String getKontonummer() {
		return kontonummer;
	}

	public double getSaldo() {
		return saldo;
	}

	public void geldEinzahlen(double betrag) {
		this.saldo -= betrag;
	}

	public void geldAbheben(double betrag) {
		this.saldo -= betrag;
	}
}
