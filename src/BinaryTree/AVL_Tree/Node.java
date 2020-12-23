package BinaryTree.AVL_Tree;

/**
 * 
 *  AVL tree node class - Ariel University, Data structures course, 2020.
 *  @author Asaly Saed, saed.asaly@gmail.com.
 */
public class Node {
	int data;
	Node left, right, parent;

	public Node(int data) {
		this.data = data;
		left = right = parent = null;
	}

	public String toString() {
		return "" + data;
	}
}
