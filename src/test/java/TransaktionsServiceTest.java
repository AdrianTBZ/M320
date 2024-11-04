import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TransaktionsServiceTest {

	@Mock
	private TransaktionsService transaktionsService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testTransaktionDurchfuehrenErfolgreich() throws KontoNichtGefundenException {
		doNothing().when(transaktionsService).transaktionDurchfuehren("KontoA", "KontoB", 100.0);
		transaktionsService.transaktionDurchfuehren("KontoA", "KontoB", 100.0);
		verify(transaktionsService, times(1)).transaktionDurchfuehren("KontoA", "KontoB", 100.0);
	}

	@Test
	public void testTransaktionDurchfuehrenKontoNichtGefundenException() throws KontoNichtGefundenException {
		doThrow(new KontoNichtGefundenException("Das Konto konnte nicht ausfindig gemacht werden.")).when(transaktionsService).transaktionDurchfuehren("KontoA", "KontoC", 100.0);
		assertThrows(KontoNichtGefundenException.class, () -> transaktionsService.transaktionDurchfuehren("KontoA", "KontoC", 100.0));
	}
}
