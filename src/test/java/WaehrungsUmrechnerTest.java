import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WaehrungsUmrechnerTest {

	@BeforeEach
	public void setUp() {
	}

	@Test
	public void testKonvertieren() {
		Waehrung chf = WaehrungsUmrechner.getWaehrung("CHF");
		Waehrung usd = WaehrungsUmrechner.getWaehrung("USD");
		double betrag = 100.0;
		double erwartet = 100.0 * 1.0 / 0.85;
		assertEquals(erwartet, WaehrungsUmrechner.konvertieren(betrag, chf, usd), 0.0001);
	}

	@Test
	public void testGetWaehrung() {
		Waehrung eur = WaehrungsUmrechner.getWaehrung("EUR");
		assertNotNull(eur);
		assertEquals("EUR", eur.getName());
		assertEquals(0.92, eur.getWechselkursZuBasis());
	}

	@Test
	public void testWaehrungExists() {
		assertTrue(WaehrungsUmrechner.waehrungExists("USD"));
		assertFalse(WaehrungsUmrechner.waehrungExists("XYZ"));
	}

	@Test
	public void testKonvertierenMitNullBetrag() {
		Waehrung chf = WaehrungsUmrechner.getWaehrung("CHF");
		Waehrung eur = WaehrungsUmrechner.getWaehrung("EUR");
		assertEquals(0.0, WaehrungsUmrechner.konvertieren(0.0, chf, eur), 0.0001);
	}
}
