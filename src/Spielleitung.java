import java.util.ArrayList;
import java.util.Scanner;

/**
 * Eine Controller-Klasse, die durchgeführte Polyelle durchführt und verwaltet.
 * 
 * @author jana
 *
 */
public class Spielleitung {
	/** Anzahl der durchzuführenden Polyelle. */
	private int anzahlTurniere;
	/** Ein Array, der alle durchzuführenden Polyelle beinhaltet. */
	private Turnier turniere[];
	/**
	 * Alle an einem oder mehreren Polyellen teilnehmenden Reiter, gespeichert in
	 * einer ArrayList.
	 */
	private ArrayList<Reiter> teilnehmer;
	// *Anzahl aller an einem Polyell teilnehmenden Reiter.*/
	private int anzahlTeilnehmer;

	/**
	 * Konstruktor der Klasse Spielleitung. Es werden keine Parameter übergeben, da
	 * Werte der Variablen durch Nutzerangaben generiert werden. Bei der
	 * Nutzereingabe werden Exceptions abgefangen. (1) Nutzereingabe für Anzahl der
	 * durchzuführenden Polyelle wird abgefragt(anzahlTurniere). Abhängig von der
	 * Turnieranzahl werden entsprechend viele Turniere initialisiert und in den
	 * Turnier-Array eingefügt (turniere[]). (2) Nutzereingabe für Anzahl der
	 * teilnehmenden Reiter wird abgefragt(anzahlTeilnehmer). (3) Nutzereingabe für
	 * Aus-dem-Sattel-Stoß-Wahrscheinlichkeiten für jeden der teilnehmenden Reiter
	 * wird abgefragt (pushProb @see Klasse Reiter). Nach jeder Eingabe einer
	 * Wahrscheinlichkeit wird ein Reiter mit entsprechender pushProb initialisiert
	 * und der Reiter-ArrayList hinzugefügt (teilnehmer).
	 */
	public Spielleitung() {
		this.teilnehmer = new ArrayList<Reiter>();

		System.out.println("Wie viele Turniere sollen durchgeführt werden?");
		System.out.println("Es muss mindestens eins sein. Gib eine Zahl ein, z.B. 6.");
		Scanner scan = new Scanner(System.in);
		boolean acceptInput1 = false;
		while (!acceptInput1) {
			acceptInput1 = true;
			try {
				this.anzahlTurniere = scan.nextInt();
				this.turniere = new Turnier[anzahlTurniere];
				if (this.anzahlTurniere <= 0) {
					System.out.println("Du musst mindestens ein Turnier durchführen lassen. Probier es nochmal.");
					acceptInput1 = false;

				}
			} catch (Exception e) {
				System.out.println("Da ist etwas schiefgelaufen, probier es nochmal!");
				acceptInput1 = false;
				scan.nextLine();
			}
		}

		for (int i = 0; i < anzahlTurniere; i++) {
			turniere[i] = new Turnier();
		}

		boolean acceptInput2 = false;
		while (!acceptInput2) {
			acceptInput2 = true;
			try {
				System.out.println("Wie viele Reiterinnen sollen mitspielen?");
				System.out.println("Es müssen mindestens zwei sein. Gib eine Zahl ein, z.B. 6.");
				this.anzahlTeilnehmer = scan.nextInt();
				if (this.anzahlTeilnehmer <= 0) {
					System.out.println("Es müssen mindestens 2 Reiterinnen sein! Probier es nochmal");
					acceptInput2 = false;
				}
			} catch (Exception e) {
				System.out.println("Da ist etwas schiefgelaufen! Probier es nochmal.");
				acceptInput2 = false;
				scan.nextLine();
			}
		}

		boolean acceptInput3 = false;
		while (!acceptInput3) {
			acceptInput3 = true;
			System.out.println(
					"Bitte gib jeder Reiterin eine Aus-dem-Sattel-Stoß-Wahrscheinlichkeit zwischen 1 und 100.");
			for (int i = 0; i < anzahlTeilnehmer; i++) {
				int num = i + 1;
				try {
					System.out.println("p(" + num + "):");
					String s = scan.next();
					if (s.contentEquals("RETURN")) {
						System.exit(1);

					} else {
						int prob = Integer.parseInt(s);
//					int prob = scan.nextInt();
						if (prob <= 0 || prob > 100) {
							System.out.println(
									"Das hat nicht funktioniert. Gib eine Zahl zwischen 1 und 100 ein, z.B. 65.");
							i = i - 1;
							acceptInput3 = false;
						} else {
							Reiter reiter = new Reiter(prob);
							teilnehmer.add(reiter);
							acceptInput3 = true;
						}
					}
				}

				catch (Exception e) {
					System.out.println("Da ist etwas schiefgelaufen! Probier es noch einmal.");
					acceptInput3 = false;
//					teilnehmer.clear();
					i = i - 1;
					scan.nextLine();
				}
			}
		}
		scan.close();
	}

	/**
	 * 
	 * @return Gibt die Anzahl der durchzuführenden Polyelle zurück.
	 */
	public int getAnzahlTurniere() {
		return anzahlTurniere;
	}

	/**
	 * Ermittelt, ob (abhängig von der Anzahl durchzuführender Polyelle) der Verlauf
	 * des Polyells protokolliert werden soll oder nicht. In diesem Fall wird die
	 * Protokollfunktion ausgeschaltet, sobald mehr als ein Polyell mit den selben
	 * Reitern durchgeführt wird.
	 * 
	 * @param anzahlTurniere Die Zahl der durchzuführenden Polyelle wird übergeben.
	 * @return Gibt zurück, ob protokolliert werden soll (true) oder nicht (false).
	 */
	public boolean protokollieren(int anzahlTurniere) {
		if (anzahlTurniere == 1) {
			return true;
		} else
			return false;
	}

	/**
	 * Ordnet die teilnehmenden Reiter entsprechend ihrer
	 * Aus-dem-Sattel-Stoß-Wahrscheinlichkeit an, sodass der Reiter mit der
	 * geringsten Wahrscheinlichkeit die Nr. 1 erhält, der nächste Reiter mit der
	 * nächstgeringsten die Nr. 2 usw. (1) Die sort-Methode der ArrayList-Library
	 * sortiert die teilnehmer-ArrayList auf Grundlage der compareTo-Methode in @see
	 * Klasse Reiter. (2) Nach der Sortierung wird über die Liste iteriert, während
	 * derer dem ersten Element die Reiternr. 1 zugewiesen wird usw.
	 */
	public void sortTeilnehmer() {
		this.teilnehmer.sort(Reiter::compareTo);

		for (int i = 0; i < teilnehmer.size(); i++) {
			teilnehmer.get(i).setReiterNr(i + 1);
		}

	}

	/**
	 * Gibt die Summe der Siege eines Reiters in einer Menge durchgeführter Polyelle
	 * zurück.
	 * 
	 * @param teilnehmer Der Methode wird ein Objekt der Reiter-Klasse übergeben,
	 *                   für das der Wert ermittelt werden soll.
	 * @return Die Summe der Siege wird zurückgegeben, in dem für das Reiter-Objekt
	 *         die Getter-Methode für die Summe der Siege aufgerufen wird.
	 */
	public int calcAbsoluteSiege(Reiter teilnehmer) {
		return teilnehmer.getAbsoluteSiege();
	}

	/**
	 * Berechnet den prozentualen Anteil der Summe der Siege eines Reiters bei einer
	 * Menge durchgeführter Polyelle. Die Summe der Siege wird durch die Anzahl
	 * durchgeführter Polyelle geteilt.
	 * 
	 * @param teilnehmer Der Methode wird ein Objekt der Reiter-Klasse übergeben,
	 *                   für das der Wert ermittelt werden soll.
	 * @return Ein Wert zwischen 0 und 1 je nach prozentualem Siegesanteil wird
	 *         zurückgegeben.
	 */
	public double calcRelativeSiege(Reiter teilnehmer) {
		double x = (double) teilnehmer.getAbsoluteSiege();
		double y = (double) this.anzahlTurniere;
		double result = (x / y) * 100;
		return result;
	}

	/**
	 * Für jedes Reiter-Objekt, das in der teilnehmer-Liste enthalten ist, wird die
	 * Nummer, die Summe der Siege sowie der prozentuale Anteil der Siege bei einer
	 * Menge von Polyellen auf der Konsole ausgegeben.
	 */
	public void printAlleSiege() {

		for (Reiter reiter : teilnehmer) {
			System.out.println("Reiter " + reiter.getReiterNr() + " : Absolute Siege: " + reiter.getAbsoluteSiege()
					+ " Prozentuale Siege: " + reiter.getRelativeSiege());
		}

	}

	/**
	 * (1) Es wird mittels der protokollieren-Methode ermittelt, ob für diesen
	 * Durchlauf protokolliert werden soll oder nicht. Der Rückgabewert wird in
	 * einer boolean-Variable gespeichert. (2) Alle in der ArrayList teilnehmer
	 * enthaltenen Reiter-Objekte werden mittels der sortTeilnehmer-Methode
	 * angeordnet. (3) Es wird durch den Array turniere[] iteriert, wobei für jedes
	 * Turnier die spiele-Methode, @see Klasse Turnier, aufgerufen wird. In dieser
	 * findet auch der Protokollierungsprozess statt. Der Methode wird hierbei die
	 * teilnehmer-ArrayList sowie die zuvor gespeicherte boolean-Variable zur
	 * Protokollierung übergeben. (4) Nach Durchführung des Turniers wird durch die
	 * Reiter-ArrayList iteriert. Für jeden Reiter werden absolute und relative
	 * Siege berechnet. (5) Falls nur ein Polyell durchgeführt wurde, wird das
	 * Reiter-Objekt mittels to-String ausgegeben, das Sieger geworden ist. Falls
	 * mehrere durchgeführt wurden, werden mittels printAlleSiege-Methode alle
	 * Reiter mit absoluten und prozentualen Siegen ausgegeben.
	 */
	public void execute() {

		boolean protokollFunktion = this.protokollieren(this.anzahlTurniere);

		this.sortTeilnehmer();
		for (int i = 0; i < turniere.length; i++) {
			turniere[i].spiele(this.teilnehmer, protokollFunktion);
		}
		for (Reiter reiter : teilnehmer) {
			this.calcAbsoluteSiege(reiter);
			reiter.setRelativeSiege(this.calcRelativeSiege(reiter));
		}
		if (this.anzahlTurniere == 1) {
			System.out.println("Der Sieger ist: " + this.turniere[0].getSieger().toString());
		} else {
			this.printAlleSiege();
		}
	}

}
