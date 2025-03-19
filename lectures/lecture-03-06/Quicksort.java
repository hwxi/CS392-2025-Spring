import java.util.Comparator;

public class Quicksort {

    // This class should not be instantiated.
    private Quicksort() { }

    private static <T> void exch(T[] A, int i, int j) {
	T tmp;
	tmp = A[i]; A[i] = A[j]; A[j] = tmp; return;
    }

    private static <T extends Comparable<T>> boolean less(T x, T y) {
	return (x.compareTo(y) < 0);
    }

    public static <T extends Comparable<T>> void sort(T[] A) {
	final int n = A.length;
	sortRec(A, 0, n); return;
    }

    public static <T extends Comparable<T>> void sortRec(T[] A, int l, int r) {
	return;
    }

}
