public interface TransaktionsService {
	void transaktionDurchfuehren(String vonKonto, String zuKonto, double betrag) throws KontoNichtGefundenException;
}
