import java.util.*;

public class DLinkedTree {

    /* ************************ ************************ */
    // HX-2025-04-17: For Assignment 6-3 (100 points)
    /* ************************ ************************ */
    
    // An inner class for the nodes in the tree
    private class Node {
        private int key;         // the key field
	private int size;        // the size field
        private LLList data;     // list of data for this key
        private Node left;       // reference to the left child
        private Node right;      // reference to the right child
	private Node parent;     // reference to the parent node
        
        private Node(int key, Object data) {
            this.key = key;
            this.data = new LLList();
            this.data.addItem(data, 0);
            this.left = null;
            this.right = null;
	    this.parent = null;
        }
    }
    
    /* ************************ ************************ */

    private Node root;

    /* ************************ ************************ */

}
