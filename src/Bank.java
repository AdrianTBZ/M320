import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
	private static Bank instance;
	private List<Konto> konten;

	private Bank() {
		konten = new ArrayList<>();
	}

	public static Bank getInstance() {
		if (instance == null) {
			instance = new Bank();
		}
		return instance;
	}

	public void kontoErstellen(String kontonummer) {
		Scanner scanner = new Scanner(System.in);
		String waehrungName;
		Waehrung waehrung;

		do {
			System.out.print("Geben Sie die Währung ein (z.B. CHF, USD): ");
			waehrungName = scanner.nextLine();
			waehrung = WaehrungsUmrechner.getWaehrung(waehrungName);
			if (waehrung == null) {
				System.out.println("Ungültige Währung. Bitte versuchen Sie es erneut.");
			}
		} while (waehrung == null);

		konten.add(new Konto(kontonummer, waehrung));
		System.out.println("Konto mit der Nummer " + kontonummer + " und Währung " + waehrung.getName() + " wurde erstellt.");
	}



	public void sparkontoErstellen(String kontonummer, double zinsRate) {
		Scanner scanner = new Scanner(System.in);
		String waehrungName;
		Waehrung waehrung;

		do {
			System.out.print("Geben Sie die Währung ein (z.B. CHF, USD): ");
			waehrungName = scanner.nextLine();
			waehrung = WaehrungsUmrechner.getWaehrung(waehrungName);
			if (waehrung == null) {
				System.out.println("Ungültige Währung. Bitte versuchen Sie es erneut.");
			}
		} while (waehrung == null);

		konten.add(new Sparkonto(kontonummer, waehrung, zinsRate));
		System.out.println("Sparkonto mit der Nummer " + kontonummer + ", Währung " + waehrung.getName() + " und Zinssatz " + zinsRate + "% wurde erstellt.");
	}

	public Konto findeKonto(String kontonummer) throws KontoNichtGefundenException {
		return konten.stream()
				.filter(konto -> konto.getKontonummer().equals(kontonummer))
				.findFirst()
				.orElseThrow(() -> new KontoNichtGefundenException("Konto mit der Nummer " + kontonummer + " wurde nicht gefunden."));
	}

	public void kontoLoeschen(String kontonummer) throws KontoNichtGefundenException {
		Konto konto = findeKonto(kontonummer);
		konten.remove(konto);
		System.out.println("Konto mit der Nummer " + kontonummer + " wurde gelöscht.");
	}



	public void geldEinzahlen(String kontonummer, double betrag) throws KontoNichtGefundenException {
		if (betrag <= 0) {
			System.out.println("Der Betrag muss positiv sein.");
			return;
		}
		Konto konto = findeKonto(kontonummer);
		konto.geldEinzahlen(betrag);
		System.out.println("Betrag von " + betrag + " wurde auf das Konto " + kontonummer + " eingezahlt.");
	}

	public void geldAbheben(String kontonummer, double betrag) throws KontoNichtGefundenException {
		if (betrag <= 0) {
			System.out.println("Der Betrag muss positiv sein.");
			return;
		}
		Konto konto = findeKonto(kontonummer);
		konto.geldAbheben(betrag);
		System.out.println("Betrag von " + betrag + " wurde vom Konto " + kontonummer + " abgehoben.");
	}
	public void kontenAnzeigen() {
		if (konten.isEmpty()) {
			System.out.println("Keine Konten vorhanden. Erstelle Beispielkonten...");
			SampleAccountGenerator generator = new SampleAccountGenerator();
			generator.createSampleAccounts();
		}

		if (konten.isEmpty()) {
			System.out.println("Keine Konten vorhanden.");
		} else {
			System.out.println("Liste der Konten:");
			for (Konto konto : konten) {
				System.out.println("Kontonummer: " + konto.getKontonummer() + ", Saldo: " + konto.getSaldo() + " " + konto.getWaehrung().getName());
			}
		}
	}


	public void zinsenBuchenFuerAlleSparkonten() {
		for (Konto konto : konten) {
			if (konto instanceof Sparkonto) {
				((Sparkonto) konto).zinsenBuchen();
			}
		}
		System.out.println("Zinsen für alle Sparkonten wurden gebucht.");
	}

	public double getValidDoubleInput(String message) {
		Scanner scanner = new Scanner(System.in);
		double value;
		while (true) {
			System.out.print(message);
			if (scanner.hasNextDouble()) {
				value = scanner.nextDouble();
				scanner.nextLine();
				break;
			} else {
				System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
				scanner.nextLine();
			}
		}
		return value;
	}

	public int getValidIntInput(String message) {
		Scanner scanner = new Scanner(System.in);
		int value;
		while (true) {
			System.out.print(message);
			if (scanner.hasNextInt()) {
				value = scanner.nextInt();
				scanner.nextLine();
				break;
			} else {
				System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
				scanner.nextLine();
			}
		}
		return value;
	}

	public void erstelleNormalesBeispielKonto(String kontonummer, String waehrungName, double startBetrag) {
		Waehrung waehrung = WaehrungsUmrechner.getWaehrung(waehrungName);
		if (waehrung != null) {
			Konto konto = new Konto(kontonummer, waehrung);
			konto.geldEinzahlen(startBetrag);
			konten.add(konto);
			System.out.println("Beispielkonto erstellt: Kontonummer " + kontonummer + ", Währung " + waehrungName + ", Saldo " + startBetrag + " " + waehrungName);
		} else {
			System.out.println("Fehler: Ungültige Währung für Beispielkonto.");
		}
	}

	public void erstelltBeispielSparKonto(String kontonummer, String waehrungName, double zinsRate, double startBetrag) {
		Waehrung waehrung = WaehrungsUmrechner.getWaehrung(waehrungName);
		if (waehrung != null) {
			Sparkonto sparkonto = new Sparkonto(kontonummer, waehrung, zinsRate);
			sparkonto.geldEinzahlen(startBetrag);
			konten.add(sparkonto);
			System.out.println("Beispiel-Sparkonto erstellt: Kontonummer " + kontonummer + ", Währung " + waehrungName + ", Zinssatz " + zinsRate + "%, Saldo " + startBetrag + " " + waehrungName);
		} else {
			System.out.println("Fehler: Ungültige Währung für Beispielkonto.");
		}
	}





	public void menue() {
		TransaktionsService transaktionsService = new TransaktionsServiceImpl();

		while (true) {
			System.out.println("\nBank Menü:");
			System.out.println("1. Konto erstellen");
			System.out.println("2. Sparkonto erstellen");
			System.out.println("3. Konto löschen");
			System.out.println("4. Geld einzahlen");
			System.out.println("5. Geld abheben");
			System.out.println("6. Geld überweisen");
			System.out.println("7. Konten anzeigen");
			System.out.println("8. Zinsen für alle Sparkonten buchen");
			System.out.println("9. Beenden");

			int wahl = getValidIntInput("Wählen Sie eine Option: ");

			switch (wahl) {
				case 1:
					System.out.print("Geben Sie die Kontonummer ein: ");
					String kontonummer = new Scanner(System.in).nextLine();
					kontoErstellen(kontonummer);
					break;
				case 2:
					System.out.print("Geben Sie die Kontonummer ein: ");
					String sparkontoNummer = new Scanner(System.in).nextLine();
					double zinsRate = getValidDoubleInput("Geben Sie den Zinssatz ein: ");
					sparkontoErstellen(sparkontoNummer, zinsRate);
					break;
				case 4:
					System.out.print("Geben Sie die Kontonummer ein: ");
					String einzahlungKonto = new Scanner(System.in).nextLine();
					double einzahlungBetrag = getValidDoubleInput("Geben Sie den Betrag ein: ");
					try {
						geldEinzahlen(einzahlungKonto, einzahlungBetrag);
					} catch (KontoNichtGefundenException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					System.out.print("Geben Sie die Kontonummer ein: ");
					String abhebungKonto = new Scanner(System.in).nextLine();
					double abhebungBetrag = getValidDoubleInput("Geben Sie den Betrag ein: ");
					try {
						geldAbheben(abhebungKonto, abhebungBetrag);
					} catch (KontoNichtGefundenException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					System.out.print("Geben Sie die Kontonummer des Senders ein: ");
					String senderKonto = new Scanner(System.in).nextLine();
					System.out.print("Geben Sie die Kontonummer des Empfängers ein: ");
					String empfaengerKonto = new Scanner(System.in).nextLine();
					double ueberweisungsBetrag = getValidDoubleInput("Geben Sie den Betrag ein: ");
					try {
						transaktionsService.transaktionDurchfuehren(senderKonto, empfaengerKonto, ueberweisungsBetrag);
					} catch (KontoNichtGefundenException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 7:
					kontenAnzeigen();
					break;
				case 8:
					zinsenBuchenFuerAlleSparkonten();
					break;
				case 9:
					System.out.println("Programm beendet.");
					return;
				default:
					System.out.println("Ungültige Auswahl, bitte versuchen Sie es erneut.");
			}
		}
	}
}
