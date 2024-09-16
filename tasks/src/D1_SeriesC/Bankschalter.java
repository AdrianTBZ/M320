package D1_SeriesC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bankschalter {
	private Scanner scanner;
	private Konto[] konten;

	private Bankschalter() {
		konten = new Konto[3];
		List<String> mylist = new ArrayList<String>();
		// Task a, b
		konten[0] = new Konto(1, 100, 500);
		konten[1] = new Konto(2, 100, 500);
		konten[2] = new Konto(3, 100, 500);
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new Bankschalter().start();
	}

	public void start() {
		while (true) {
			System.out.println("\n");
			System.out.println("1. Kontostand abfragen");
			System.out.println("2. Einzahlen");
			System.out.println("3. Abheben");
			System.out.println("4. Überweisen");
			System.out.println("5. Beenden");
			System.out.print("Wählen Sie eine Option: ");

			int wahl = scanner.nextInt();
			switch (wahl) {
				case 1:
					getKontostand();
					break;
				case 2:
					einzahlen();
					break;
				case 3:
					abheben();
					break;
				case 4:
					ueberweisen();
					break;
				case 5:
					System.out.println("Auf Wiedersehen!");
					return;
				default:
					System.out.println("Ungültige Eingabe.");
			}
		}
	}

	private Konto kontoAuswaehlen() {
		System.out.print("Wählen Sie ein Konto (1-3): ");
		int kontoNr = scanner.nextInt();
		if (kontoNr >= 1 && kontoNr <= 3) {
			return konten[kontoNr - 1];
		} else {
			System.out.println("Falsche Kontonummer.");
			return null;
		}
	}

	// Task c

	private void ueberweisen() {
		System.out.println("Von welchem Konto?");
		Konto vonKonto = kontoAuswaehlen();
		System.out.println("Auf welches Konto?");
		Konto zuKonto = kontoAuswaehlen();
		if (vonKonto != null && zuKonto != null) {
			System.out.print("Überweisungsbetrag: ");
			int betrag = scanner.nextInt();
			vonKonto.ueberweisen(zuKonto, betrag);
		}
	}

	private void abheben() {
		Konto konto = kontoAuswaehlen();
		if (konto != null) {
			System.out.println("Abhebungsbetrag: ");
			int betrag = scanner.nextInt();
			konto.abheben(betrag);
		}
	}


	private void getKontostand() {
		Konto konto = kontoAuswaehlen();
		if (konto != null) {
			System.out.println(STR."Kontostand: CHF \{konto.getSaldo()}");
		}
	}

	private void einzahlen() {
		Konto konto = kontoAuswaehlen();
		if (konto != null) {
			System.out.print("Einzahlungsbetrag: ");
			int betrag = scanner.nextInt();
			konto.einzahlen(betrag);
		}
	}
}
