package bucascs392x1;
import edu.princeton.cs.algs4.*;

public class MyHello {
    public static void main(String[] argv) {
/*
	  StdOut.print("argv.length = "); StdOut.println(argv.length);
*/
	if (argv.length == 0) {
	    StdOut.println("Hello, world!");
	} else {
	    StdOut.print("Hello from "); StdOut.print(argv[0]); StdOut.println("!");
	}
	return;
    }
}
