import java.util.stream.*;
import java.util.function.IntPredicate;

public class MyPrimes2 {

   static IntPredicate isPrime = x -> true;
   static IntStream primes = IntStream
                               .iterate(2, i -> i + 1)
                               .filter(i -> isPrime.test(i))
                               .peek(i -> isPrime = isPrime.and(v -> v % i != 0));

   public static void main(String[] args) {
       // Print out the first 100 primes.
       int nprime = 2500;
       primes.limit(nprime).forEach(p -> System.out.println(p));

   }
}
