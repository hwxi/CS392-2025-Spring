public class AVL {
    private class Node {
	private Node left;
	private Node right;
    }
    public int ht(Node t0) {
	if (t0 == null)
	    return 0;
	else {
	    int lh = ht(t0.left);
	    int rh = ht(t0.right);
	    return (lh >= rh)? lh+1 : rh+1;
	}
    }

    /*
    // HX-2025-04-17:
    // Easy implementation
    // But it is not efficient!
    public boolean isAVL(Node t0) {
	if (t0 == null)
	    return true;
	else {
	    if (!isAVL(t0.left)) return false;
	    if (!isAVL(t0.right)) return false;
	    int lh = ht(t0.left);
	    int rh = ht(t0.right);
	    return (lh <= rh+1 && rh <= lh+1);
	}
    }
    */

    private class NotAVL extends Exception {
	// empty
    }
    public boolean isAVL(Node t0) {
	try {
	    isAVL2(t0);
	    return true;
	} catch(NotAVL e) {
	    return false;
	}
    }
    private int isAVL2 (Node t0) throws NotAVL {
	if (t0 == null) return 0;
	int lh = isAVL2(t0.left);
	int rh = isAVL2(t0.right);
	if (lh > rh+1 || rh > lh+1) {
	    throw new NotAVL();
	}
	return (lh >= rh ? lh + 1 : rh + 1);
    }
}
