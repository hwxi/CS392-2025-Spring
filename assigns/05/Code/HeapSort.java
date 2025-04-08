import java.util.*;

public class HeapSort<T extends Comparable<T>> {
    public void sort(T[] myarr) {
	int n = myarr.length;
	Heap<T> myheap = new Heap<T>(myarr);
	for (int i = 0; i < n; i += 1) {
	    myarr[n-1-i] = myheap.remove();
	}
    }
}
