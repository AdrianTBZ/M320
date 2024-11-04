import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KontoTest {

	private Konto konto;
	private Waehrung waehrung;

	@BeforeEach
	public void setUp() {
		waehrung = new Waehrung("CHF", 1.0);
		konto = new Konto("12345", waehrung);
	}

	@Test
	public void testKontoErstellung() {
		assertEquals("12345", konto.getKontonummer());
		assertEquals(0.0, konto.getSaldo(), 0.001);
		assertEquals(waehrung, konto.getWaehrung());
	}

	@Test
	public void testGeldEinzahlen_PositiveBetrag() {
		konto.geldEinzahlen(100.0);
		assertEquals(100.0, konto.getSaldo(), 0.001);
	}

	@Test
	public void testGeldEinzahlen_NegativeBetrag() {
		konto.geldEinzahlen(-50.0);
		assertEquals(0.0, konto.getSaldo(), 0.001);
	}

	@Test
	public void testGeldEinzahlen_NullBetrag() {
		konto.geldEinzahlen(0.0);
		assertEquals(0.0, konto.getSaldo(), 0.001);
	}

	@Test
	public void testGeldAbheben_MitGenugSaldo() throws KontoNichtGefundenException {
		konto.geldEinzahlen(200.0);
		konto.geldAbheben(100.0);
		assertEquals(100.0, konto.getSaldo(), 0.001);
	}

	@Test
	public void testGeldAbheben_NichtGenugSaldo() {
		konto.geldEinzahlen(50.0);
		assertThrows(KontoNichtGefundenException.class, () -> konto.geldAbheben(100.0));
	}

	@Test
	public void testGeldAbheben_NullBetrag() throws KontoNichtGefundenException {
		konto.geldEinzahlen(50.0);
		konto.geldAbheben(0.0);
		assertEquals(50.0, konto.getSaldo(), 0.001);
	}

	@Test
	public void testGeldAbheben_NegativeBetrag() throws KontoNichtGefundenException {
		konto.geldEinzahlen(50.0);
		konto.geldAbheben(-20.0);
		assertEquals(50.0, konto.getSaldo(), 0.001);
	}
}
