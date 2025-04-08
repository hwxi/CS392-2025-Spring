import java.util.*;

public class HeapTest {

    static public void main(String[] argv) {

	System.out.println("HeapTest: Welcome!");
	//
	Heap<Integer> myheap;
	myheap = new Heap<Integer>(16);
	//
	myheap.insert(1);
	myheap.insert(2);
	myheap.insert(3);
	myheap.insert(4);
	myheap.insert(5);
	myheap.insert(6);
	myheap.insert(7);
	myheap.insert(8);
	myheap.insert(9);
	myheap.insert(10);
	System.out.println
	    ("HeapTest: myheap = " + myheap.toString());
	System.out.println("HeapTest: Bye-bye!");	

	Integer[] myarr = new Integer[10];
	myarr[0] = 3;
	myarr[1] = 8;
	myarr[2] = 5;
	myarr[3] = 4;
	myarr[4] = 2;
	myarr[5] = 7;
	myarr[6] = 9;
	myarr[7] = 1;
	myarr[8] = 6;
	myarr[9] = 0;
	System.out.println("HeapSort: Welcome!");
	System.out.println
	    ("HeapSort: myarr[] = " + Arrays.toString(myarr));
	(new HeapSort<Integer>( )).sort( myarr );
	System.out.println
	    ("HeapSort: myarr[] = " + Arrays.toString(myarr));	
	System.out.println("HeapSort: Bye-bye!");

    }

}
