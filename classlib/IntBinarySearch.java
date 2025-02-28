import java.util.function.*;

public class IntBinarySearch {
//
    public static int search
	(IntPredicate IP, int lb, int ub)
    {
	// pred(lb) = true and pred(ub) = false
	if (lb + 1 >= ub) {
	    return lb;
	} else {
	    final int mx = lb + (ub - lb);
	    if (IP.test(mx)) {
		return search(IP, mx, ub);
	    } else {
		return search(IP, lb, mx);
	    }
	}
    }
//
    private IntBinarySearch() { } // objectless class
//
} // end of [IntBinarySearch]
