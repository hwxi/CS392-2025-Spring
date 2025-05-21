//
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Supplier;
// Main class
public class MyPrimes {
    Supplier<Integer> supplier = new Supplier<Integer>() {
      private int i = 2;
      @Override
      public Integer get() {
	  int j = i; i += 1; return j;
      }
    };
    void sieveAndPrint(Stream<Integer> ns) {
	Iterator<Integer> iterator = ns.iterator();
	Integer head = iterator.next();
	Stream<Integer> tail = Stream.generate(iterator::next);
	System.out.println("prime = " + head);
	sieveAndPrint(tail.filter(x -> x % head > 0)); return;
    }

    // Main driver method
    public static void main(String[] args)
    {
	MyPrimes OBJ = new MyPrimes();
	int N = 100;
	OBJ.sieveAndPrint(Stream.iterate(2, i -> i+1));
    }
}
