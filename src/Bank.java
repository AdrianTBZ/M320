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
		konten.add(new Konto(kontonummer));
		System.out.println("Konto mit der Nummer " + kontonummer + " wurde erstellt.");
	}

	public void sparkontoErstellen(String kontonummer, double zinsRate) {
		konten.add(new Sparkonto(kontonummer, zinsRate));
		System.out.println("Sparkonto mit der Nummer " + kontonummer + " wurde erstellt.");
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
		Konto konto = findeKonto(kontonummer);
		konto.geldEinzahlen(betrag);
		System.out.println("Betrag von " + betrag + " wurde auf das Konto " + kontonummer + " eingezahlt.");
	}

	public void geldAbheben(String kontonummer, double betrag) throws KontoNichtGefundenException {
		Konto konto = findeKonto(kontonummer);
		konto.geldAbheben(betrag);
		System.out.println("Betrag von " + betrag + " wurde vom Konto " + kontonummer + " abgehoben.");
	}

	public void kontenAnzeigen() {
		if (konten.isEmpty()) {
			System.out.println("Keine Konten vorhanden.");
		} else {
			System.out.println("Liste der Konten:");
			for (Konto konto : konten) {
				System.out.println("Kontonummer: " + konto.getKontonummer() + ", Saldo: " + konto.getSaldo());
			}
		}
	}

	public void menue() {
		Scanner scanner = new Scanner(System.in);
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
			System.out.println("8. Beenden");
			System.out.print("Wählen Sie eine Option: ");

			int wahl = scanner.nextInt();
			scanner.nextLine(); // consume newline

			try {
				switch (wahl) {
					case 1:
						System.out.print("Geben Sie die Kontonummer ein: ");
						String kontonummer = scanner.nextLine();
						kontoErstellen(kontonummer);
						break;
					case 2:
						System.out.print("Geben Sie die Kontonummer ein: ");
						String sparkontoNummer = scanner.nextLine();
						System.out.print("Geben Sie die Zinssatz ein: ");
						double zinsRate = scanner.nextDouble();
						sparkontoErstellen(sparkontoNummer, zinsRate);
						break;
					case 3:
						System.out.print("Geben Sie die Kontonummer ein: ");
						String zuLoeschendesKonto = scanner.nextLine();
						kontoLoeschen(zuLoeschendesKonto);
						break;
					case 4:
						System.out.print("Geben Sie die Kontonummer ein: ");
						String einzahlungKonto = scanner.nextLine();
						System.out.print("Geben Sie den Betrag ein: ");
						double einzahlungBetrag = scanner.nextDouble();
						geldEinzahlen(einzahlungKonto, einzahlungBetrag);
						break;
					case 5:
						System.out.print("Geben Sie die Kontonummer ein: ");
						String abhebungKonto = scanner.nextLine();
						System.out.print("Geben Sie den Betrag ein: ");
						double abhebungBetrag = scanner.nextDouble();
						geldAbheben(abhebungKonto, abhebungBetrag);
						break;
					case 6:
						System.out.print("Geben Sie die Kontonummer des Senders ein: ");
						String senderKonto = scanner.nextLine();
						System.out.print("Geben Sie die Kontonummer des Empfängers ein: ");
						String empfaengerKonto = scanner.nextLine();
						System.out.print("Geben Sie den Betrag ein: ");
						double ueberweisungsBetrag = scanner.nextDouble();
						transaktionsService.transaktionDurchfuehren(senderKonto, empfaengerKonto, ueberweisungsBetrag);
						break;
					case 7:
						kontenAnzeigen();
						break;
					case 8:
						System.out.println("Programm beendet.");
						return;
					default:
						System.out.println("Ungültige Auswahl, bitte versuchen Sie es erneut.");
				}
			} catch (KontoNichtGefundenException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
