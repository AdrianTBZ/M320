package D2_SeriesA;

import java.util.List;
import java.util.Scanner;

public class TUI {
	private static Scanner scanner = new Scanner(System.in);
	private static Flug flug = new Flug();

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n1. Passagier hinzufügen");
			System.out.println("2. Passagier entfernen");
			System.out.println("3. Passagierliste ausgeben");
			System.out.println("4. Beenden");
			System.out.print("Wähle eine Option: ");

			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1:
					passagierHinzufuegen();
					break;
				case 2:
					passagierEntfernen();
					break;
				case 3:
					flug.passagierListeAusgeben();
					break;
				case 4:
					System.out.println("Programm wird beendet.");
					return;
				default:
					System.out.println("Ungültige Option. Bitte erneut versuchen.");
			}
		}
	}

	private static void passagierHinzufuegen() {
		System.out.print("Geben Sie den Namen des Passagiers ein: ");
		String name = scanner.nextLine();
		Passagier passagier = new Passagier(name);
		flug.passagierHinzufuegen(passagier);
		System.out.println("Passagier hinzugefügt: " + name);
	}

	private static void passagierEntfernen() {
		System.out.print("Gib den Namen des zu entfernenden Passagiers ein: ");
		String name = scanner.nextLine();
		List<Passagier> passagiere = flug.getPassagiere();
		for (Passagier p : passagiere) {
			if (p.getName().equals(name)) {
				flug.passagierEntfernen(p);
				System.out.println("Passagier entfernt: " + name);
				return;
			}
		}
		System.out.println("Passagier nicht gefunden: " + name);
	}
}
