import java.io.*;
import java.util.*;

public class MyGenerator {
    public static Iterator<Integer> fibonacci() {
        return iterator(y -> {
            int t1 = 0;
            int t2 = 1;
            while (true) {
                y.yield(t1);
                final int sum = t1 + t2;
                t1 = t2;
                t2 = sum;
            }
        });
    }

    public static void main(String[] args) {
	Iterator<Integer> fibIter = fibonacci();
	System.out.println("fib(0) = " + fibIter.next());
    }
}
