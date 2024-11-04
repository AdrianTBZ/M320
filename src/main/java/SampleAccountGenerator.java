public class SampleAccountGenerator {

	public void createSampleAccounts() {
		Bank bank = Bank.getInstance();

		bank.erstelleNormalesBeispielKonto("100001", "CHF", 2000);

		bank.erstelltBeispielSparKonto("100002", "USD", 2.0, 1500);

		bank.erstelltBeispielSparKonto("100003", "EUR", 1.75, 2500);
	}
}
