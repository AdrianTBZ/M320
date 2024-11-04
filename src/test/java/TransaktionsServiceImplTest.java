import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransaktionsServiceImplTest {

	private TransaktionsServiceImpl transaktionsService;
	private Bank bankMock;
	private Konto quellKontoMock;
	private Konto zielKontoMock;

	@BeforeEach
	public void setUp() {
		bankMock = mock(Bank.class);
		transaktionsService = new TransaktionsServiceImpl();
		transaktionsService.bank = bankMock;

		quellKontoMock = mock(Konto.class);
		zielKontoMock = mock(Konto.class);
	}


	@Test
	public void testTransaktionNegativerBetrag() throws KontoNichtGefundenException {
		when(bankMock.findeKonto("123")).thenReturn(quellKontoMock);
		when(bankMock.findeKonto("456")).thenReturn(zielKontoMock);

		transaktionsService.transaktionDurchfuehren("123", "456", -100.0);

		verify(quellKontoMock, never()).geldAbheben(anyDouble());
		verify(zielKontoMock, never()).geldEinzahlen(anyDouble());
	}
}
