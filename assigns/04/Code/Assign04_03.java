import java.util.Comparator;

public class Assign04_03 {

    // This class should not be instantiated.
    private Assign04_03() { }

    private static <T extends Comparable<T>> boolean less(T x, T y) {
	return (x.compareTo(y) < 0);
    }

    public static <T extends Comparable<T>> void listSort(LList<T> xs) {
	// Please implement [mergesort] on a linked list
	// Note that no extra heap memory is needed for list-mergesort
    }

    public static void main(String[] argv) {
	// Please provide some testing code here	
    }
}
