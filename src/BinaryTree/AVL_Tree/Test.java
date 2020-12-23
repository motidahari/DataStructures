package BinaryTree.AVL_Tree;

import java.util.Scanner;
/**
 * AVL Tree class simple tester - Ariel University, Data structures course, 2020.
 * @author Asaly Saed, saed.asaly@gmail.com.
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree t = new AVLTree();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of random elements to be added: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * (5 * n));
			if (Math.random() > 0.5) {
				t.Add(x);
				System.out.println((i + 1) + ": " + x + " has been added");
			} else {
				t.Add(-x);
				System.out.println((i + 1) + ": " + (-x) + " has been added");
			}
		}

		System.out.println("In-order:");
		t.inOrder();
		System.out.println("\nBFS:");
		t.BFS();
		System.out.println("\nPlot of the tree:");
		t.printBinaryTreeVisualy();

	}
}
