//
import java.io.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.function.Predicate;
//
// typedef LStream = Supplier<LStreamCon<T>>
//
class LStreamCon<T> {
    public T head;
    public Supplier<LStreamCon<T>> tail;
    LStreamCon(T hd, Supplier<LStreamCon<T>> tl) {
	this.head = hd; this.tail = tl;
    }

    public Supplier<LStreamCon<T>> filter(Supplier<LStreamCon<T>> xs, Predicate<T> pred) {
	return () -> filterCon(xs.get(), pred);
    }
    public LStreamCon<T> filterCon(LStreamCon<T> xs, Predicate<T> pred) {
	T hd = xs.head;
	if (pred.test(hd)) {
	    return new LStreamCon<T>(hd, filter(xs.tail, pred));
	} else {
	    return filter(xs.tail, pred).get();
	}	
    }

}
