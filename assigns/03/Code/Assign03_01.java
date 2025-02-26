public class Assign03_01 {
    /*
      HX-2025-02-25:
      The following implementation is recursive
     */
    public static int mystery(int x) {
	return (x < 100 ? 100 - x : mystery(mystery(x-11)));
    }
    public static void main(String[] argv) {
	// Please write some code (based on binary search) that
	// outputs the largest integer N such that mystery(N) returns
	// normally (without raising the StackOverflowError exception)
    }
}
