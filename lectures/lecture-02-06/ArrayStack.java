public class ArrayStack<T> {

    static public class Overflow
	extends Exception {
    }
    static public class Underflow
	extends Exception {
    }
    
    private static final int INIT_CAPACITY = 8;
    private T[] a; // array of items
    private int n; // number of elements on stack

    public ArrayStack() {
	a = (T[]) new Object[INIT_CAPACITY];
    }

    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public boolean isFull() {
        return n >= a.length;
    }

    public
    void push(T item) throws Overflow {
        if (isFull()) throw new Overflow();
	a[n] = item; n += 1; return;
    }
    public T pop() throws Underflow {
        if (isEmpty()) throw new Underflow();
	n -= 1;
        T item = a[n]; a[n] = null; return item;
    }
}
