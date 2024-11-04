import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
	private Bank bank;

	@BeforeEach
	public void setup() {
		bank = Bank.getInstance();
	}

	@Test
	public void kontoErstellen() {
		bank.erstelleNormalesBeispielKonto("100001", "CHF", 2000);
		Konto konto = assertDoesNotThrow(() -> bank.findeKonto("100001"));
		assertEquals(2000, konto.getSaldo());
		assertEquals("CHF", konto.getWaehrung().getName());
	}

	@Test
	public void sparkontoErstellen() {
		bank.erstelltBeispielSparKonto("100002", "USD", 1.5, 1500);
		Konto sparkonto = assertDoesNotThrow(() -> bank.findeKonto("100002"));
		assertEquals(1500, sparkonto.getSaldo());
		assertTrue(sparkonto instanceof Sparkonto);
	}

	@Test
	public void geldEinzahlen() throws KontoNichtGefundenException {
		bank.erstelleNormalesBeispielKonto("100003", "EUR", 1000);
		bank.geldEinzahlen("100003", 500);
		Konto konto = bank.findeKonto("100003");
		assertEquals(1500, konto.getSaldo());
	}

	@Test
	public void geldAbheben() throws KontoNichtGefundenException {
		bank.erstelleNormalesBeispielKonto("100004", "EUR", 1000);
		bank.geldAbheben("100004", 200);
		Konto konto = bank.findeKonto("100004");
		assertEquals(800, konto.getSaldo());
	}

	@Test
	public void ueberweisen() throws KontoNichtGefundenException {
		bank.erstelleNormalesBeispielKonto("100005", "CHF", 2000);
		bank.erstelleNormalesBeispielKonto("100006", "CHF", 500);
		TransaktionsService transaktionsService = new TransaktionsServiceImpl();
		transaktionsService.transaktionDurchfuehren("100005", "100006", 500);
		Konto konto1 = bank.findeKonto("100005");
		Konto konto2 = bank.findeKonto("100006");
		assertEquals(1500, konto1.getSaldo());
		assertEquals(1000, konto2.getSaldo());
	}

	@Test
	public void zinsenBuchenFuerSparkonto() throws KontoNichtGefundenException {
		bank.erstelltBeispielSparKonto("100007", "USD", 2.0, 1000);
		Sparkonto sparkonto = (Sparkonto) bank.findeKonto("100007");
		sparkonto.zinsenBuchen();
		assertEquals(1020, sparkonto.getSaldo(), 0.01);
	}

	@Test
	public void kontoNichtGefundenException() {
		Exception exception = assertThrows(KontoNichtGefundenException.class, () -> bank.findeKonto("999999"));
		assertEquals("Konto mit der Nummer 999999 wurde nicht gefunden.", exception.getMessage());
	}
}
