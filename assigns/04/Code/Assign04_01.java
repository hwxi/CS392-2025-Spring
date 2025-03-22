import java.util.Comparator;

public class Assign04_01 {

    // This class should not be instantiated.
    private Assign04_01() { }

    private static <T> void exch(T A[], int i, int j) {
	T tmp;
	tmp = A[i]; A[i] = A[j]; A[j] = tmp; return;
    }

    private static <T extends Comparable<T>> boolean less(T x, T y) {
	return (x.compareTo(y) < 0);
    }

    public static <T extends Comparable<T>> void sort(T A[]) {
	final int n = A.length;
	sortRec(A, 0, n); return;
    }

    private static <T> int getPivot(int l, int r) {
	return l; // HX: FIXME!!!
    }
    private static <T extends Comparable<T>> int split(T A[], int l, int r) {
	int p1 = l;
	T pvt = A[r-1];
	while (true) {
	    if (less(A[p1], pvt)) p1 += 1; else break;
	}
	return splitRec(A, p1, p1+1, pvt); // HX: we have pvt <= A[p1]
    }
    private static <T extends Comparable<T>> int splitRec(T A[], int p1, int p2, T pvt) {
	// Please implement it according to the method presented in Lecture-03-18:
	// p1 and p2 are two pointers that both move from the left to the right
	// The entries ahead of p1 are less than the pivot
	// The entries between p1 and p2 are greater than or equal to the pivot
	// And p1 is finally returned once p2 reaches to the right end of the array A
	return p1;
    }

    private static <T extends Comparable<T>> void sortRec(T A[], int l, int r) {
	if (r <= l+1) return;
	final int p = getPivot(l, r);
	exch(A, p, r-1); // HX: r-1 is good since r >= l+2
	final int m = split(A, l, r);
	exch(A, m, r-1);
	sortRec(A, l, m);
	sortRec(A, m+1, r);
	return;
    }

    public static void main(String[] argv) {
	// Please provide some testing code here
    }

}
