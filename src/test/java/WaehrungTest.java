import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WaehrungTest {

	private Waehrung waehrung;

	@BeforeEach
	public void setUp() {
		waehrung = new Waehrung("USD", 1.2);
	}

	@Test
	public void testGetName() {
		assertEquals("USD", waehrung.getName());
	}

	@Test
	public void testGetWechselkursZuBasis() {
		assertEquals(1.2, waehrung.getWechselkursZuBasis());
	}

	@Test
	public void testUmrechnenZuBasis() {
		double betrag = 100.0;
		double erwartet = 100.0 * 1.2;
		assertEquals(erwartet, waehrung.umrechnenZuBasis(betrag), 0.0001);
	}

	@Test
	public void testVonBasisUmrechnen() {
		double betrag = 120.0;
		double erwartet = 120.0 / 1.2;
		assertEquals(erwartet, waehrung.vonBasisUmrechnen(betrag), 0.0001);
	}

	@Test
	public void testUmrechnenZuBasisMitNullBetrag() {
		double betrag = 0.0;
		assertEquals(0.0, waehrung.umrechnenZuBasis(betrag), 0.0001);
	}

	@Test
	public void testVonBasisUmrechnenMitNullBetrag() {
		double betrag = 0.0;
		assertEquals(0.0, waehrung.vonBasisUmrechnen(betrag), 0.0001);
	}
}
