//
import java.io.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.function.Predicate;
//
// typedef LStream =
// Supplier<LStrcon<T>>
//
class LinStrcon<T> {
    public final T head;
    public final LinStream<T> tail;
    public LinStrcon() {
	head = null;
	tail = null;
    }
    public LinStrcon
	(T hd, LinStream<T> tl) {
	this.head = hd; this.tail = tl;
    }
    public boolean nilq() {
	return (head == null);
    }
    public boolean consq() {
	return (head != null);
    }
}
