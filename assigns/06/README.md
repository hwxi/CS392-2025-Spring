# Assignment 6

It is due Monday, the 28th of April.

## Assignment 6-1 (10 points)

Properties of Red-Black Trees
A Red-Black Tree have the following properties:
Node Color:
Each node is either red or black and each NULL node is considered black.
Red Property:
Red nodes cannot have red children (no two consecutive red nodes on any path).
Black Property:
Every path from a node to its descendant null nodes (leaves) has the same number of black nodes.
// Root Property: The root of the tree is always black. (HX: This is not necessary)

Please implement a method that test whether a tree is a red-black tree

## Assignment 6-2 (20 points)

Please declare a class (Assign06_02) for implementing 2-3-trees. Then
implement a method for testing whether a tree is a valid 2-3-tree. This
one is similar to Assign06_01, but it requires that you do more by declaring
a class for 2-3-trees.

## Assignment 6-3 (100 points)

Please study the code given in LinkedTree.java. You are asked here to
declare a class DLinkedTree (for doubly linked trees) where each node
also contains a field storing the size of the subtree rooted at the node.
In addition to insertion and deletion, please also implement a re-root
method that turn any given node in a tree into the root node of the tree.
