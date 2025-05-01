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
class LinStream<T> {
    public final Supplier<LinStrcon<T>> value;
    public LinStream(Supplier<LinStrcon<T>> fxs) {
	this.value = fxs;
    }
    public LinStrcon<T> eval() {
	return this.value.get();
    }
    public void forEach(Consumer<T> work) {
	LinStrcon<T> cxs = value.get();
	while (cxs.consq()) {
	    work.accept(cxs.head); cxs = cxs.tail.eval();
	}
    }
    public LinStream<T> filter(Predicate<T> pred) {
	LinStrcon<T> cxs = value.get();
	while (cxs.consq()) {
	    final T head = cxs.head;
	    final LinStream<T> tail = cxs.tail;
	    if (pred.test(head)) {
		return new LinStream<T>(() -> new LinStrcon<T>(head, tail.filter(pred)));
	    } else {
		cxs = cxs.tail.eval();
	    }
	}
	return new LinStream<T>(() -> new LinStrcon<T>());
    }    
}
