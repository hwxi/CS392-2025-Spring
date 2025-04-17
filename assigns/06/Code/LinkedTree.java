import java.util.*;

public class LinkedTree {

    /* ************************ ************************ */
    
    // An inner class for the nodes in the tree
    private class Node {
        private int key;         // the key field
        private LLList data;     // list of data values for this key
        private Node left;       // reference to the left child/subtree
        private Node right;      // reference to the right child/subtree
        
        private Node(int key, Object data) {
            this.key = key;
            this.data = new LLList();
            this.data.addItem(data, 0);
            this.left = null;
            this.right = null;
        }
    }
    
    /* ************************ ************************ */

    private Node root;

    /* ************************ ************************ */

    public void inorderPrint() {
	inorderPrintTree(root); // HX: root may be null
	System.out.println();
    }

    public void preorderPrint() {
	preorderPrintTree(root); // HX: root may be null
	System.out.println();
    }

    public void postorderPrint() {
	postorderPrintTree(root); // HX: root may be null
	System.out.println();
    }
    
    /* ************************ ************************ */

    private static void inorderPrintTree(Node root) {
	if (root != null) {
	    inorderPrintTree(root.left);
	    System.out.print(root.key + " ");
	    inorderPrintTree(root.right);
	}
    }

    private static void preorderPrintTree(Node root) {
	if (root != null) {
	    System.out.print(root.key + " ");	
	    preorderPrintTree(root.left);
	    preorderPrintTree(root.right);
	}
    }

    private static void postorderPrintTree(Node root) {
	if (root != null) {
	    postorderPrintTree(root.left);
	    postorderPrintTree(root.right);
	    System.out.print(root.key + " ");
	}
    }

    /* ************************ ************************ */

    /*
     * Searches for the specified key in the tree.
     * If it finds it, it returns the list of data items associated with the key.
     * Invokes the recursive searchTree method to perform the actual search.
     */
    public LLList search(int key) {
        Node node;
	node = searchTree(root, key);
        if (node == null) {
            return null;
        } else {
            return node.data;
        }
    }
    
    private static Node searchTree(Node root, int key) {
	// HX: recursive version
	if (root == null) return null;
	if (key == root.key) return root;
	if (key < root.key) {
	    // HX: This is tail-recursive!
	    return searchTree(root.left, key);
	}
	if (key > root.key) {
	    // HX: This is tail-recursive!
	    return searchTree(root.right, key);
	}
	return null; // HX: this is DEADCODE!!!
	/*
	Node trav = root;
	while (trav != null) {
	    if (key < trav.key) {
		trav = trav.left; continue;
	    }
	    if (key > trav.key) {
		trav = trav.right; continue;
	    }
	    return trav; // HX: key is found!
	}
	return null; // HX: [key] is not found!
	*/
    }

    /* ************************ ************************ */

    public void insert(int key, Object item) {
	insertTree(key, item, root, null); return;
    }
    
    private void insertTree(int key, Object item, Node trav, Node parent) {
	if (trav == null) {
	    Node newNode = new Node(key, item);
	    if (parent == null) {
		root = newNode; return;
	    } else {
		if (key < parent.key) {
		    parent.left = newNode; return;
		}
		if (key > parent.key) {
		    parent.right = newNode; return;
		}
	    }
	}
	// assert(trav != null);
	if (key == trav.key) {
	    trav.data.addItem(item, 0); return;
	}
	if (key < trav.key) {
	    // HX: this is tail-recursive
	    insertTree(key, item, trav.left, trav); return;
	}
	if (key > trav.key) {
	    // HX: this is tail-recursive
	    insertTree(key, item, trav.right, trav); return;
	}
    }

    /* ************************ ************************ */

    public LLList delete(int key) {
	if (root == null) return null;
	Node parent = null; // HX: root != null
	Node deletedNode = deleteHelper1(key, root, parent);
	if (deletedNode == null) {
	    return null;
	} else {
	    return deletedNode.data;
	}
    }

    /* ************************ ************************ */

    private Node deleteHelper1(int key, Node trav, Node parent) {
	Node replaceNode = null;
	if (trav == null) return null;
	if (key == trav.key) {
	    if (trav.left == null) {
		replaceNode = trav.right;
	    } else if (trav.right == null) {
		replaceNode = trav.left;
	    } else {
		replaceNode = deleteHelper2(trav);
	    }
	    if (parent == null) {
		root = replaceNode;
	    } else {
		if (trav.key < parent.key) {
		    parent.left = replaceNode;
		} else {
		    parent.right = replaceNode;
		}
	    }
	    return trav; // HX: [trav] is the deleted node!
	}
	if (key < trav.key) {
	    return deleteHelper1( key, trav.left, trav);
	}
	if (key > trav.key) {
	    return deleteHelper1(key, trav.right, trav);
	}
	return null; // HX-2024-04-11: this line is DEADCODE!!!
    }

    private Node deleteHelper2(Node trav) {
	// assert (trav != null);
	Node parent = trav;
	Node travmin = trav.right;
	while (travmin.left != null) {
	    parent = travmin;
	    travmin = travmin.left;
	}
	if (travmin.key < parent.key) {
	    parent.left = travmin.right;
	} else {
	    parent.right = travmin.right;
	}
	travmin.left = trav.left;
	travmin.right = trav.right;
	return travmin;
    }
    
    /* ************************ ************************ */

    /*
     * FOR TESTING: Processes the integer keys in the specified array from 
     * left to right, adding a node for each of them to the tree. 
     * The data associated with each key is a string based on the key.
     */
    public void insertKeys(int[] keys) {
        for (int i = 0; i < keys.length; i++) {
            insert(keys[i], "data for key " + keys[i]);
        }
    }

    /* ************************ ************************ */
    
    public static void main(String[] argv) {

	try {
	    LinkedTree tree = new LinkedTree();
	    int[] keys = {37, 26, 42, 13, 35, 56, 30, 47, 70};
	    tree.insertKeys(keys);

	    tree.delete(37);
	    tree.delete(42);
 
	    tree.inorderPrint();
	    tree.preorderPrint();
	    tree.postorderPrint();
         
	} catch (Exception e) {
	    System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
	}

    }

    /* ************************ ************************ */
}
