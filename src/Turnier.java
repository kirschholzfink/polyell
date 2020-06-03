import java.util.ArrayList;
import java.util.List;

/**
 * Ein Objekt der Klasse Turnier stellt ein durchzuführendes Polyell dar.
 * 
 * @author jana
 *
 */
public class Turnier {
	/** Der Sieger eines Polyells */
	private Reiter sieger;

	/**
	 * Konstruktor der Turnier-Klasse. Es werden keine Parameter übergeben, da der
	 * Wert der Variablen erst nach der Initialisierung zugewiesen wird. Der Sieger
	 * wird standardmäßig mit null initialisiert.
	 */
	public Turnier() {
		this.sieger = null;
	}

	/**
	 * 
	 * @return Gibt den Sieger eines Polyells zurück.
	 */
	public Reiter getSieger() {
		return sieger;
	}

	/**
	 * @param sieger Übergibt ein Objekt der Klasse Reiter, @see Klasse Reiter, der
	 *               diesem Turnier-Objekt als Sieger zugewiesen wird.
	 */
	public void setSieger(Reiter sieger) {
		this.sieger = sieger;
	}

	/**
	 * Führt ein Polyell durch.
	 * 
	 * @param teilnehmer        Eine ArrayList von Objekten der @see Klasse Reiter,
	 *                          die am Polyell teilnehmen sollen, wird übergeben.
	 * @param protokollFunktion Eine in der @see Klasse Spielleitung ermittelte
	 *                          boolean-Variable wird übergeben, von der abhängt, ob
	 *                          der Polyell-Verlauf dokumentiert wird oder nicht.
	 *                          (1) Die übergebene ArrayList wird in eine neue Liste
	 *                          kopiert. Dies ermöglicht, dass ein Reiter-Objekt,
	 *                          das von seinem Hintermann aus dem Sattel gestoßen
	 *                          wurde, aus der temporären Polyell-Liste entfernt
	 *                          werden kann, ohne dass der Reiter aus der globalen
	 *                          Teilnehmerliste gelöscht wird. (2) Es wird über die
	 *                          Polyell-Liste iteriert, wobei für jedes
	 *                          Reiter-Objekt die push-Methode aufgerufen wird, bei
	 *                          der versucht wird, das nächste Element in der Liste
	 *                          aus dem Sattel zu stoßen. Ist dieser Stoß
	 *                          erfolgreich, wird das Element, das in der Liste an
	 *                          der nächsthöheren Indexposition steht, aus der
	 *                          Polyell-Liste entfernt. Ist das Reiter-Objekt das
	 *                          letzte Element in der Liste, wird das erste
	 *                          Listen-Element entfernt. (3) Mittels Abfrage der
	 *                          boolean-Variable zur Protokollfunktion werden
	 *                          (nicht) erfolgreiche Stoßversuche ggf.
	 *                          protokolliert. (4) Dieser Prozess wird solange
	 *                          wiederholt, bis die Polyell-Liste nur noch ein
	 *                          Element enthält, das alle anderen Reiter rausgepusht
	 *                          hat. (5) Dieses Reiter-Objekt wird mittels
	 *                          setSieger-Methode dem Turnier-Objekt als Sieger
	 *                          zugewiesen(sieger-Attribut). (6) Für dieses siegende
	 *                          Reiter-Objekt wird mittels Getter die Summe der
	 *                          bisherigen Siege abgefragt, mit 1 addiert, und der
	 *                          neue Wert an den Setter für Gesamtsumme der
	 *                          bisherigen Siege übergeben.
	 */
	public void spiele(ArrayList<Reiter> teilnehmer, boolean protokollFunktion) {

		List<Reiter> reiter = new ArrayList<Reiter>(teilnehmer);
		while (reiter.size() > 1) {
			for (int i = 0; i < reiter.size(); i++) {

				if (reiter.get(i).push()) {
					if (i == reiter.size() - 1) {
						if (protokollFunktion) {
							System.out.println("Reiter " + reiter.get(i).getReiterNr() + " stößt Reiter "
									+ reiter.get(0).getReiterNr() + " aus dem Sattel.");
						}
						reiter.remove(0);
					} else {
						if (protokollFunktion) {
							System.out.println("Reiter " + reiter.get(i).getReiterNr() + " stößt Reiter "
									+ reiter.get(i + 1).getReiterNr() + " aus dem Sattel.");
						}
						reiter.remove(i + 1);
					}

				} else {
					if (protokollFunktion) {
						System.out.println("Reiter " + reiter.get(i).getReiterNr() + " trifft nicht.");
					}
				}
				for (Reiter reiter2 : reiter) {
					System.out.println(reiter2.toString());
				}
			}
		
		}
		setSieger(reiter.get(0));
		reiter.get(0).setAbsoluteSiege(reiter.get(0).getAbsoluteSiege() + 1);
	}
}
