/**
 * Wird von @see Klasse Reiter implementiert, um Reiter aufgrund ihrer
 * Aus-dem-Sattel-Stoß-Wahrscheinlichkeit miteinander zu vergleichen.
 * 
 * @author jana
 *
 * @param <T> Die Objekte, die miteinander verglichen werden sollen, werden
 *            übergeben.
 */
public interface Comparable<T> {
	int compareTo(T other);
}
