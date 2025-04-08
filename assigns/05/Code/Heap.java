/*
 * BU CAS CS 392
 * For generic array-based heap implementation
 * Please finish the code so that HeapTest (given)
 * can use to code here to run.
 */

/**
 * Heap - a generic collection class that implements 
 * a max-at-top heap using an array
 */
public class Heap<T extends Comparable<T>> {
    private T[] contents;
    private int numItems;
    
    public Heap(int maxSize) {
        contents = (T[])new Comparable[maxSize];
        numItems = 0;
    }
    
    public Heap(T[] arr) {
        // Note that we don't copy the array, so that heapsort can
        // sort the array in place.
        contents = arr;
        numItems = arr.length;
        makeHeap();
    }
    
    /* 
     * makeHeap - turn the elements in the contents array into a
     * representation of a max-at-top heap.
     */
    private void makeHeap() {
       // Please give a recursion-based implementation
       // You may need to introduce a private helper method
       // for this.
    }
    
    /** 
     * insert - add the specified item to the heap and sift it
     * up into its proper position. It returs true if inserted
     * and false if no more room for insertion
     */
    public bool insert(T item) {
    }
    
    /**
     * remove and return the item at the top of the heap, and adjust
     * the remaining items so that we still have a heap.
     */
    public T remove() {
    }
    
    /**
     * isEmpty - does the heap currently have no items?
     */
    public boolean isEmpty() {
        return (numItems == 0);
    }
    
    /**
     * toString - create a string representation of the heap of the form
     * { ( root ) ( items in level 1 ) ( items in level 2 ) ... }
     */
    public String toString() {
        String str = "{ ";
        
        int start = 0;
        int levelSize = 1;
        while (start < numItems) {
            // print all of the items at the current level of the tree
            str += "( ";
            for (int i = start; i < start + levelSize && i < numItems; i++)
                str += (contents[i] + " ");
            str += ") ";
            
            // move down to the next level
            start += levelSize;
            levelSize *= 2;
        }
        
        str += "}";
        return str;
    }

    private void swim(int i) {
	// Please give a loop-based implementation of sift-up
    }

    private void sink(int i) {
	// Please give a loop-based implementation of sift-down
    }

    private void makeHeap() {
	// Please give a loop-based implementation
	// This is just heapfication: turning an array into a heap
    }
}
