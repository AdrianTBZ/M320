import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KontoNichtGefundenExceptionTest {

	@Test
	public void testKontoNichtGefundenExceptionMessage() {
		String errorMessage = "Konto nicht gefunden!";
		KontoNichtGefundenException exception = new KontoNichtGefundenException(errorMessage);

		assertEquals(errorMessage, exception.getMessage());
	}

	@Test
	public void testKontoNichtGefundenExceptionInheritance() {
		KontoNichtGefundenException exception = new KontoNichtGefundenException("Test Nachricht");

		assertTrue(exception instanceof Exception);
	}
} 
