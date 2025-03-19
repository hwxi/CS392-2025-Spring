import java.util.Comparator;

public class Quicksort {

    // This class should not be instantiated.
    private Quicksort() { }

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
	return splitRec(A, l+0, r-2, A[r-1]);
    }
    private static <T extends Comparable<T>> int splitRec(T A[], int lp, int rp, T pvt) {
	if (lp < rp) {
	    if (less(A[lp], pvt)) {
		return splitRec(A, lp+1, rp, pvt);
	    } else {
		if (!less(A[rp], pvt)) {
		    return splitRec(A, lp, rp-1, pvt);
		} else {
		    exch(A, lp, rp);
		    return splitRec(A, lp+1, rp-1, pvt);
		}
	    }
	} else {
	    return (!less(A[lp], pvt) ? lp : lp+1); // HX: do you know why?
	}
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
	System.out.println("Hello from [Quicksort]!");
	Integer A[] = new Integer[10];
	A[0] = 9; A[1] = 8; A[2] = 7; A[3] = 6; A[4] = 5;
	A[5] = 4; A[6] = 3; A[7] = 2; A[8] = 1; A[9] = 0;
	for (int i = 0; i < A.length; i += 1) {
	    System.out.println("A[" + i + "] = " + A[i]);
	}
	sort(A);	
	for (int i = 0; i < A.length; i += 1) {
	    System.out.println("A[" + i + "] = " + A[i]);
	}
    }

}
