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

    public static <T extends Comparable<T>> void sort(T[] A) {
	final int n = A.length;
	T[] B = (T[]) new Object[n];
	sortRec(A, 0, n, B); return;
    }

    private
	static <T extends Comparable<T>>
	void sortRec(T[] A, int l, int r, T[] B) {
	if (r <= l+1) return;
	final int m = l + (r - l) / 2;
        sortRec(A, l, m, B);
	sortRec(A, m, r, B);
	mergeRec(A, l, m, m, r, B);
    }

    private
	static <T extends Comparable<T>>
	void mergeRec(T[] A, int l1, int r1, int l2, int r2, T[] B) {
    }

}
