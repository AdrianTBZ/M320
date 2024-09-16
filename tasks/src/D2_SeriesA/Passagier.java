package D2_SeriesA;

class Passagier {
	private String name;

	public Passagier(String name) {
		this.name = name;
	}

	void nameAusgeben() {
		System.out.println(name);
	}

	public String getName() {
		return name;
	}
}
