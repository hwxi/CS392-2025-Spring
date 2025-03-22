import java.util.Comparator;

public class Mergesort {

    // This class should not be instantiated.
    private Mergesort() { }

    private static <T> void exch(T A[], int i, int j) {
	T tmp;
	tmp = A[i]; A[i] = A[j]; A[j] = tmp; return;
    }

    private static <T extends Comparable<T>> boolean less(T x, T y) {
	return (x.compareTo(y) < 0);
    }

    public static <T extends Comparable<T>> void sort(T A[]) {
	final int n = A.length;
	T[] B = (T[]) new Comparable[n];
	sortRec1(A, 0, n, B);
	return;
    }

    // HX: A: source and A: result
    private static <T extends Comparable<T>> void sortRec1(T A[], int l, int r, T B[]) {
	if (r <= l+1) return;
	// HX: we have r >= l+2
	final int m = l + (r - l) / 2;
	sortRec2(A, l, m, B); // HX: conquer
	sortRec2(A, m, r, B); // HX: conquer
	mergeRec(B, l, m, r, A); // HX: assemble
	return;
    }

    // HX: A: source and B: result
    private static <T extends Comparable<T>> void sortRec2(T A[], int l, int r, T B[]) {
	if (r <= l+1) {
	    if (l < r) B[l] = A[l];
	}
	// HX: we have r >= l+2
	final int m = l + (r - l) / 2;
	sortRec1(A, l, m, B); // HX: conquer
	sortRec1(A, m, r, B); // HX: conquer
	mergeRec(A, l, m, r, B); // HX: assemble
	return;
    }

    // HX: A: source and B: target
    private static <T extends Comparable<T>> void mergeRec(T A[], int l, int m, int r, T B[]) {
	int bp = l;
	int lp = l;
	int rp = m;
	while (true) {
	    if (lp < m) {
		if (rp < r) {
		    if (less(A[rp], A[lp])) {
			B[bp] = A[rp]; bp++; rp++;
		    } else {
			B[bp] = A[lp]; bp++; lp++;
		    }
		} else {
		    B[bp] = A[lp]; bp++; lp++;
		}
	    } else {
		if (rp < r) {
		    B[bp] = A[rp]; bp++; rp++;
		} else {
		    break;
		}
	    }
	}
	return;
    }
        
    public static void main(String[] argv) {
	System.out.println("Hello from [Mergesort]!");
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
