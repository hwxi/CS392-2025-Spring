//
import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
//
// typedef LinStream =
// Supplier<LinStrcon<T>>
//
class LinStream<T> {
    private final Supplier<LinStrcon<T>> value;
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

    public LinStream<T> map(UnaryOperator<T> fopr) {
	LinStrcon<T> cxs = value.get();
	while (cxs.consq()) {
	    final T head = cxs.head;
	    final LinStream<T> tail = cxs.tail;
	    return new LinStream<T>(() -> new LinStrcon<T>(fopr.apply(head), tail.map(fopr)));
	}
	return new LinStream<T>(() -> new LinStrcon<T>());
    }

    public LinStream<T> append(LinStream<T> fys) {
	LinStrcon<T> cxs = value.get();
	while (cxs.consq()) {
	    final T head = cxs.head;
	    final LinStream<T> tail = cxs.tail;
	    return new LinStream<T>(() -> new LinStrcon<T>(head, tail.append(fys)));
	}
	return fys;
    }
}
