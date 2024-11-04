import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class MainTest {


	@Test
	public void testInstanzReturntSingelton() {
		Bank bankInstance1 = Bank.getInstance();
		Bank bankInstance2 = Bank.getInstance();
		assertNotNull(bankInstance1, "getInstance sollte eine Instanz zurückgeben.");
		assertSame(bankInstance1, bankInstance2, "getInstance sollte dieselbe Instanz zurückgeben.");
	}

	@Test
	public void testMenuMethodeOhneException() {
		Bank bankMock = mock(Bank.class);
		bankMock.menue();
		verify(bankMock, times(1)).menue();
	}
}
