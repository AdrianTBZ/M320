import java.util.HashMap;
import java.util.Map;

public class WaehrungsUmrechner {
	private static Map<String, Waehrung> waehrungen = new HashMap<>();

	static {
		waehrungen.put("CHF", new Waehrung("CHF", 1.0));
		waehrungen.put("USD", new Waehrung("USD", 0.85));
		waehrungen.put("EUR", new Waehrung("EUR", 0.92));
		waehrungen.put("GBP", new Waehrung("GBP", 1.15));
		waehrungen.put("JPY", new Waehrung("JPY", 0.0077));
		waehrungen.put("CAD", new Waehrung("CAD", 0.66));
		waehrungen.put("AUD", new Waehrung("AUD", 0.62));
		waehrungen.put("NZD", new Waehrung("NZD", 0.58));
		waehrungen.put("CNY", new Waehrung("CNY", 0.13));
		waehrungen.put("INR", new Waehrung("INR", 0.011));
		waehrungen.put("BRL", new Waehrung("BRL", 0.17));
		waehrungen.put("RUB", new Waehrung("RUB", 0.009));
		waehrungen.put("ZAR", new Waehrung("ZAR", 0.056));
		waehrungen.put("SEK", new Waehrung("SEK", 0.087));
		waehrungen.put("NOK", new Waehrung("NOK", 0.089));
		waehrungen.put("DKK", new Waehrung("DKK", 0.124));
		waehrungen.put("HKD", new Waehrung("HKD", 0.11));
		waehrungen.put("SGD", new Waehrung("SGD", 0.63));
		waehrungen.put("KRW", new Waehrung("KRW", 0.00064));
		waehrungen.put("TRY", new Waehrung("TRY", 0.036));
		waehrungen.put("MXN", new Waehrung("MXN", 0.048));
		waehrungen.put("PLN", new Waehrung("PLN", 0.21));
		waehrungen.put("CZK", new Waehrung("CZK", 0.042));
		waehrungen.put("HUF", new Waehrung("HUF", 0.0025));
	}

	public static double konvertieren(double betrag, Waehrung von, Waehrung zu) {
		double betragInBasis = von.umrechnenZuBasis(betrag);
		return zu.vonBasisUmrechnen(betragInBasis);
	}

	public static Waehrung getWaehrung(String name) {
		return waehrungen.get(name);
	}

	public static boolean waehrungExists(String name) {
		return waehrungen.containsKey(name);
	}
}
