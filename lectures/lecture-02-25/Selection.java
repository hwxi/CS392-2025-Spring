import java.util.Comparator;

public class Selection {

    // This class should not be instantiated.
    private Selection() { }

    private static <T> void exch(T[] A, int i, int j) {
	T tmp;
	tmp = A[i]; A[i] = A[j]; A[j] = tmp; return;
    }

    // array segment style: left inclusive and right exclusive
    private static <T extends Comparable<T>> int indexMin(T[] A, int i, int j) {
	assert (i < j);
        if (i + 1 >= j) {
	    return i;
	} else {
	    int r = indexMin(A, i+1, j);
	    return less(A[i], A[r]) ? i : r;
	}
    }

    private static <T extends Comparable<T>> boolean less(T x, T y) {
	return (x.compareTo(y) < 0);
    }

    public static <T extends Comparable<T>> void sort(T[] A) {
        final int len = A.length;
        for (int i = 0; i < len; i++) {
            exch(A, i, indexMin(A, i, len));
        }
    }

    /*
    public static <T extends Comparable<T>> void sort(T[] a) {
        final int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
    */
}
