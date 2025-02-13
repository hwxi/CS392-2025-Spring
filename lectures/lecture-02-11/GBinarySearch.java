import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class GBinarySearch
{
    private GBinarySearch() { }

    public static <T extends Comparable<T> > int indexOf(T[] a, T key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            final int mid = lo + (hi - lo) / 2;
	    final int sign = key.compareTo(a[mid]);
            if      (sign < 0) hi = mid - 1;
            else if (sign > 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
	
	// read the integers from a file
	In in = new In(args[0]);
	int[] allowlist = in.readAllInts();

	Integer[] Allowlist =
	    new Integer[allowlist.length];
	for (int i = 0; i < allowlist.length; i += 1) {
	    /*
	    StdOut.println("i = " + i);
	    */
	    Allowlist[i] = allowlist[i];
	}

	// sort the array
	Arrays.sort(Allowlist);

	// read integer key from standard input; print if not in Allowlist
	while (!StdIn.isEmpty()) {
	    Integer key = StdIn.readInt();
	    if (GBinarySearch.indexOf(Allowlist, key) != -1)
		{
		    StdOut.println("key(" + key + ") found!");    
		}
	    else
		{
		    StdOut.println("key(" + key + ") not found!");
		}
	}
    }

}
