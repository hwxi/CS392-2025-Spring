//
import java.io.*;
import java.util.*;
import java.util.function.Supplier;
//
class LStreamTest {
    Supplier<LStreamCon<Integer>> intsFrom(int i0) {
	return (() -> new LStreamCon<Integer>(i0, intsFrom(i0+1)));
    }

    Supplier<LStreamCon<Integer>> sieve(Supplier<LStreamCon<Integer>> fxs) {
	LStreamCon<Integer> cxs = fxs.get();
	Integer hd = cxs.head;

	return () -> new LStreamCon<Integer>(hd, sieve(cxs.filter(cxs.tail, x0 -> (int)x0 % (int)hd > 0)));
    }

    public static void main(String[] args)
    {
	LStreamTest LST = new LStreamTest();
	Supplier<LStreamCon<Integer>> allPrimes = LST.sieve(LST.intsFrom(2));
	Integer head;
	LStreamCon<Integer> rest;
	rest = allPrimes.get();
	head = rest.head;
	rest = rest.tail.get();
	System.out.println("head = " + head);
	head = rest.head;
	rest = rest.tail.get();
	System.out.println("head = " + head);
	head = rest.head;
	rest = rest.tail.get();
	System.out.println("head = " + head);
	head = rest.head;
	rest = rest.tail.get();
	System.out.println("head = " + head);
	head = rest.head;
	rest = rest.tail.get();
	System.out.println("head = " + head);
	head = rest.head;
	rest = rest.tail.get();
	System.out.println("head = " + head);
	head = rest.head;
	rest = rest.tail.get();
	System.out.println("head = " + head);
	head = rest.head;
	rest = rest.tail.get();
	System.out.println("head = " + head);
	head = rest.head;
	rest = rest.tail.get();
	System.out.println("head = " + head);
	head = rest.head;
	rest = rest.tail.get();
	System.out.println("head = " + head);
	return;
    }

}
