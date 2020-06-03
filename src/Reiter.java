/**
 * Ein Objekt der Klasse Reiter stellt einen Teilnehmer an einem Polyell dar.
 * 
 * Die Klasse implementiert das Interface Comparable, das ermöglicht, dass
 * Reiterinnen angemessen für das Turnier angeordnet werden.
 * 
 * @author jana
 *
 */
public class Reiter implements Comparable<Reiter> {
	/**
	 * Die Nummer des Reiters abhängig von der Position im Kreis bzw. der pushProb.
	 */
	private int reiterNr;
	/**
	 * Die Aus-dem-Sattel-Stoß-Wahrscheinlichkeit eines Reiters als Zahl zwischen 1
	 * und 100.
	 */
	private int pushProb;
	/**
	 * Die Summe der Siege, die ein Reiter bei einer Menge von Polyellen erreichen
	 * konnte.
	 */
	private int absoluteSiege;
	/**
	 * Der prozentuale Anteil der Siege, die ein Reiter erreicht hat, in
	 * Abhängigkeit der Anzahl der durchgeführten Turniere.
	 */
	private double relativeSiege;

	/**
	 * Der Konstruktor der Klasse Reiter enthält lediglich den Konstruktor pushProb.
	 * Alle anderen Variablen (siehe oben) werden nach Initialisierung eines Reiters
	 * über Methoden zugewiesen. Die Variablen werden standardmäßig mit 0
	 * initialisiert.
	 * 
	 * @param pushProb Weist einem Reiter eine
	 *                 Aus-dem-Sattel-Stoß-Wahrscheinlichkeit zu.
	 */
	public Reiter(int pushProb) {
		this.reiterNr = 0;
		this.pushProb = pushProb;
		this.absoluteSiege = 0;
		this.relativeSiege = 0;
	}

	/**
	 * @return Gibt die Nummer eines Reiters zurück.
	 */
	public int getReiterNr() {
		return reiterNr;
	}

	/**
	 * @param Übergibt eine Nummer, die dem Reiter zugewiesen wird.
	 */
	public void setReiterNr(int reiterNr) {
		this.reiterNr = reiterNr;
	}

	/**
	 * @return Gibt die Summe aller in einer Menge von Polyellen erreichten Siege
	 *         zurück.
	 */
	public int getAbsoluteSiege() {
		return absoluteSiege;
	}

	/**
	 * 
	 * @param Eine Anzahl an Siegen wird übergeben, um sie dem Reiter zuzuweisen,
	 *             bzw. um die Anzahl bisher erreichter Siege zu inkrementieren.
	 */
	public void setAbsoluteSiege(int absoluteSiege) {
		this.absoluteSiege = absoluteSiege;
	}

	/**
	 * 
	 * @return Gibt den prozentualen Anteil an Siegen in Abhängigkeit der Gesamtzahl
	 *         der durchgeführten Turniere zurück.
	 */
	public double getRelativeSiege() {
		return relativeSiege;
	}

	/**
	 * 
	 * @param Übergibt einen errechneten prozentualen Sieg-Anteil, um sie dem Reiter
	 *                 zuzuweisen.
	 */
	public void setRelativeSiege(double relativeSiege) {
		this.relativeSiege = relativeSiege;
	}

	/**
	 * Testet, ob der Stoßversuch eines Reiters auf seinen Vordermann erfolgreich
	 * war. Eine zufällige Zahl zwischen 1 und 100 wird berechnet. Daraufhin wird
	 * getestet, ob die Aus-dem-Sattel-Stoß-Wahrscheinlichkeit eines Reiters, (die
	 * als Zahl zwischen 1 und 100 vorliegt),größer oder gleich dieser Zahl ist.
	 * Falls sie dies ist, ist der Stoßversuch erfolgreich. Andernfalls nicht.
	 * 
	 * @return Gibt zurück, ob der Stoßversuch erfolgreich war (true) oder nicht
	 *         (false).
	 */
	public boolean push() {
		int random = (int) (Math.random() * 101);
		if (this.pushProb >= random) {
			return true;
		} else
			return false;
	}

	/**
	 * compareTo-Methode des implementierten Comparable-Interfaces. Vergleicht
	 * Reiter auf Grundlage ihrer Aus-dem-Sattel-Stoß-Wahrscheinlichkeit, um sie
	 * später mit aufsteigender Wahrscheinlichkeit im Kreis anordnen zu können. Zum
	 * Vergleich wird die compare-Methode der Klasse Integer verwendet.
	 */
	@Override
	public int compareTo(Reiter other) {
		return Integer.compare(this.pushProb, other.pushProb);
	}

	/**
	 * Gibt die Nummer und Aus-dem-Sattel-Stoß-Wahrscheinlichkeit eines Reiters als
	 * String zurück.
	 */
	public String toString() {
		return "Reiter " + this.reiterNr + ", pushProb: " + this.pushProb;
	}

}
