import java.util.Iterator;

public class MyIterable<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
	return new MyIterator();
    }

    class MyIterator implements Iterator<T> {
	public MyIterator() {
	}
	public boolean hasNext() 
	{ 
	    return false;
	}
	public T next() { return null; }
    }
    
    public static void main(String[] argv) {
	System.out.println("Hello from [MyIterable]!");
    }
}
