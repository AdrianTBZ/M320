package D1_SeriesC;

import java.util.Scanner;

public class Konto {

	private int kontoNr;
	private int saldo;
	private int limite;

	public Konto(int kontoNr, int saldo, int limite) {
		this.kontoNr = kontoNr;
		this.saldo = saldo;
		this.limite = limite;
	}

	public int getKontoNr() {
		return kontoNr;
	}

	public int getSaldo() {
		return saldo;
	}

	public void einzahlen(int betrag) {
		saldo += betrag;
		System.out.println(STR."CHF \{betrag} einbezahlt. Neuer Saldo: CHF \{saldo}.");
	}

	public void abheben(int betrag) {
		if (saldo - betrag <= limite) {
			saldo -= betrag;
			System.out.println(STR."CHF \{betrag} abgehoben. Neuer Saldo: CHF \{saldo}.");
		} else {
			System.out.println("Saldo ist zu klein.");
		}

	}

	public void ueberweisen(Konto nachKonto, int betrag) {
		if (saldo - betrag <= limite) {
			saldo -= betrag;
			nachKonto.einzahlen(betrag);
			System.out.println(STR."CHF \{betrag} überwiesen an Konto \{nachKonto.getKontoNr()}.");
		} else {
			System.out.println("Saldo ist zu klein.");
		}
	}


}
