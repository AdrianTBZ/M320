import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SparkontoTest {

	private Sparkonto sparkonto;
	private final double zinsRate = 2.5;
	private final String kontonummer = "123456789";
	private Waehrung waehrung;

	@BeforeEach
	public void setUp() {
		waehrung = new Waehrung("Euro", 1.0);
		sparkonto = new Sparkonto(kontonummer, waehrung, zinsRate);
	}

	@Test
	public void testKonstruktor() {
		assertEquals(kontonummer, sparkonto.getKontonummer());
		assertEquals(waehrung, sparkonto.getWaehrung());
		assertEquals(0.0, sparkonto.getSaldo(), 0.01);
		assertEquals(zinsRate, sparkonto.getZinsRate(), 0.01);
	}

	@Test
	public void testZinsenBuchenMitPositiveSaldo() {
		sparkonto.geldEinzahlen(1000);
		sparkonto.zinsenBuchen();
		double erwarteteZinsen = 1000 * (zinsRate / 100);
		assertEquals(1000 + erwarteteZinsen, sparkonto.getSaldo(), 0.01);
	}

	@Test
	public void testZinsenBuchenMitZeroSaldo() {
		sparkonto.zinsenBuchen();
		assertEquals(0.0, sparkonto.getSaldo(), 0.01);
	}
}
