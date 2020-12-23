package BinaryTree.RedBlack_Tree;

public class Node {
	int data;
	Node left, right, parent;
	boolean isBlack;
	boolean isLeftChild;

	public Node(int data) {
		this.data = data;
		left = right = parent = null;
		isBlack = isLeftChild = false;

	}
}
