package BinaryTree.AVL_Tree;

/**
 * AVL Tree class - Data structures course.
 */
public class AVLTree {
	Node root;
	int size;
	/**
	 * Create an empty AVL tree
	 */
	public AVLTree() {
		root = null;
		size = 0;
	}
	/**
	 * 
	 * @param n AVL tree node.
	 * @return the height of n's subtree.
	 */
	public int height(Node n) {
		if (n == null)
			return -1;
		return 1 + Math.max(height(n.left), height(n.right));
	}

	/**
	 * 
	 * @param n a node to be rotated (grand-parent).
	 * @return A pointer to the new node to replace n as a result of left rotation.
	 */
	public Node LeftRotation(Node n) {
		Node tmp = n.right;// 1
		tmp.parent = n.parent;
		n.right = tmp.left;// 2
		if (n.right != null) {
			n.right.parent = n;
		}
		tmp.left = n;// 3
		n.parent = tmp;
		if (tmp.parent != null) {
			if (tmp.parent.right == n) {
				tmp.parent.right = tmp;
			} else if (tmp.parent.left == n) {
				tmp.parent.left = tmp;
			}
		}
		return tmp;// 4
	}

	/**
	 * 
	 * @param n A node to be rotated (grand-parent).
	 * @return A pointer to the new node to replace n as a result of right rotation.
	 */
	public Node RightRotation(Node n) {
		Node tmp = n.left;
		tmp.parent = n.parent;
		n.left = tmp.right;
		if (n.left != null)
			n.left.parent = n;
		tmp.right = n;
		n.parent = tmp;
		if (tmp.parent != null) {
			if (tmp.parent.right == n) {
				tmp.parent.right = tmp;
			} else if (tmp.parent.left == n) {
				tmp.parent.left = tmp;
			}
		}
		return tmp;
	}

	/**
	 * 
	 * @param n A node to be rotated (grand-parent).
	 * @return A pointer to the new node to replace n as a result of right-left rotation.
	 */
	public Node RightLeftRotation(Node n) {
		n.right = RightRotation(n.right);
		return LeftRotation(n);
	}

	/**
	 * 
	 * @param n A node to be rotated (grand-parent).
	 * @return A pointer to the new node to replace n as a result of left-right rotation.
	 */
	public Node LeftRightRotation(Node n) {
		n.left = LeftRotation(n.left);
		return RightRotation(n);
	}

	/**
	 * Adds data to the tree
	 * @param data the data to be added
	 */
	public void Add(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
			size++;
			return;
		}
		add(newNode, root);
	}

	/**
	 * Adds recursively newNode to the subtree of parent in the appropriate place.
	 * @param newNode new node contains the data to be added.
	 * @param parent the potential parent for the new node.
	 */
	private void add(Node newNode, Node parent) {
		if (newNode.data > parent.data) {
			if (parent.right == null) {
				parent.right = newNode;
				newNode.parent = parent;
				size++;
				return;
			} else {
				add(newNode, parent.right);
			}
		} else {
			if (parent.left == null) {
				parent.left = newNode;
				newNode.parent = parent;
				size++;
				return;
			} else {
				add(newNode, parent.left);
			}
		}
		CheckBalance(newNode);
	}

	/**
	 * Checks recursively n and its parent and grandparents against balance.
	 * @param n a node to be checked for the balance 
	 */
	private void CheckBalance(Node n) {
		int diff = (height(n.left)) - (height(n.right));
		if (diff > 1 || diff < -1) {
			rebalance(n);
		}
		if (n.parent == null)
			return;
		else
			CheckBalance(n.parent);
	}
	/**
	 * 
	 * Re-balance the node n appropriately.
	 * @param n a node to be re-balanced.
	 */
	private void rebalance(Node n) {
		int diff = (height(n.left)) - (height(n.right));
		if (diff > 1) {// left subtree is higher than right subtree
			if (height(n.left.left) > height(n.left.right)) {
				n = RightRotation(n);
			} else {
				n = LeftRightRotation(n);
			}
		} else {
			if (height(n.right.left) > height(n.right.right)) {
				n = RightLeftRotation(n);
			} else {
				n = LeftRotation(n);
			}
		}
		if (n.parent == null) {
			root = n;
		}
	}
	/**
	 * In order traversal.
	 */
	public void inOrder() {
		inOrder(root);

	}

	private void inOrder(Node n) {
		if (n != null) {
			inOrder(n.left);
			System.out.print(n.data + " ");
			inOrder(n.right);
		}
	}
	/**
	 * BFS traversal.
	 */
	public void BFS() {
		Node p = root;
		QueueArr q = new QueueArr(size);
		q.Enqueue(p);
		while (!q.IsEmpty()) {
			p = q.Dequeue();
			System.out.print(p + " ");
			if (p.left != null)
				q.Enqueue(p.left);
			if (p.right != null)
				q.Enqueue(p.right);
		}
	}
	/**
	 * Plots the tree (L - left subtree of the node, R- right subtree of the node).
	 */
	public void plotTree() {
		plotTree("", root, false);
	}

	public void plotTree(String prefix, Node n, boolean isRight) {

		if (n != null) {
			System.out.println(prefix + (isRight ? "R-- " : "L-- ") + n.data);
			plotTree(prefix + (isRight ? "|   " : "    "), n.right, true);
			plotTree(prefix + (isRight ? "|   " : "    "), n.left, false);
		}
	}

	/* Printing the tree visualy */
	public void printBinaryTreeVisualy(){
		System.out.println("================================");
		printBinaryTree(root, 0);
		System.out.println("================================");
	}
	public void printBinaryTree(Node root, int level){
		if(root==null)
			return;
		printBinaryTree(root.right, level+1);
		if(level!=0){
			for(int i=0;i<level-1;i++)
				System.out.print("|\t");
			System.out.println("|-------"+root.data);
		}
		else
			System.out.println(root.data);
		printBinaryTree(root.left, level+1);
	}





}
