//
import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Predicate;
//
// typedef LinStream =
// Supplier<LinStrcon<T>>
//
class LinStreamTest {
    public static LinStream<Integer> intFrom(int start) {
	return new LinStream<Integer>(() -> new LinStrcon<Integer>(start, intFrom(start+1)));
    }
    public static LinStream<Integer> sieveMethod(LinStream<Integer> fxs) {
	LinStrcon<Integer> cxs = fxs.eval();
	Integer head = cxs.head;
	LinStream<Integer> tail = cxs.tail;
	return new LinStream<Integer>
	    (() -> new LinStrcon<Integer>(head, sieveMethod(tail.filter((ix) -> ix.intValue() % head > 0))));
    }
    public static void main(String[] args) {
	LinStream<Integer> intFrom2 = intFrom(2);
	LinStream<Integer> thePrimes = sieveMethod(intFrom2);
	thePrimes.forEach((px) -> System.out.println(px));
	return;
    }
}
