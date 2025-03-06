import java.util.Comparator;

public class Mergesort {

    // This class should not be instantiated.
    private Mergesort() { }

    private static <T> void exch(T[] A, int i, int j) {
	T tmp;
	tmp = A[i]; A[i] = A[j]; A[j] = tmp; return;
    }

    private static <T extends Comparable<T>> boolean less(T x, T y) {
	return (x.compareTo(y) < 0);
    }

}
