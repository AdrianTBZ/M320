public class TransaktionsServiceImpl implements TransaktionsService {
	private Bank bank;

	public TransaktionsServiceImpl() {
		this.bank = Bank.getInstance();
	}

	@Override
	public void transaktionDurchfuehren(String vonKonto, String zuKonto, double betrag) throws KontoNichtGefundenException {
		Konto quellKonto = bank.findeKonto(vonKonto);
		Konto zielKonto = bank.findeKonto(zuKonto);

		if (betrag <= 0) {
			System.out.println("Der Betrag für die Überweisung muss positiv sein.");
			return;
		}

		double umgerechneterBetrag = WaehrungsUmrechner.konvertieren(betrag, quellKonto.getWaehrung(), zielKonto.getWaehrung());

		quellKonto.geldAbheben(betrag);
		zielKonto.geldEinzahlen(umgerechneterBetrag);
		System.out.println("Betrag von " + betrag + " " + quellKonto.getWaehrung().getName() +
				" wurde von Konto " + vonKonto + " auf Konto " + zuKonto +
				" überwiesen als " + umgerechneterBetrag + " " + zielKonto.getWaehrung().getName() + ".");
	}
}
