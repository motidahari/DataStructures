package BinaryTree;

import com.sun.security.jgss.GSSUtil;

public class testBT{
    public void printPostOrder(BTNode root) {
        PrintPostOrder(root);
    }
    private void PrintPostOrder(BTNode root) {
        if (root != null) {
            PrintPostOrder(root.getLeft());
            PrintPostOrder(root.getRight());
            System.out.print(root+" ");
        }
    }
    public static void printBinaryTreeVisualy(BTNode root){
        System.out.println("================================");
        printBinaryTree(root, 0);
        System.out.println("================================");
    }
    public static void printBinaryTree(BTNode root, int level){
        if(root==null)
            return;
        printBinaryTree(root.getRight(), level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|-------"+root.getData());
        }
        else
            System.out.println(root.getData());
        printBinaryTree(root.getLeft(), level+1);
    }

/*
    public static String result = "";
    public static boolean printPath (BTNode root, int sum) {
        result += "the max path is: || <- ";
        if(runByTree(root, sum))
            return true;
        return false;
    }
    public static boolean runByTree (BTNode root, int sum) {
        if (sum == 0) return true;
        if (root == null) return false;
        boolean NodeLeft = runByTree(root.left, sum - root.data);
        boolean NodeRight = runByTree(root.right, sum - root.data);
        if (NodeLeft || NodeRight)
            result += root.data + " <- ";
        return NodeLeft || NodeRight;
    }
    public static int runByTreeToGetTheSum(BTNode root) {
        if (root == null) return 0;
        int valueLeft = runByTreeToGetTheSum(root.left);
        int valueRight = runByTreeToGetTheSum(root.right);
        if(valueLeft > valueRight)
            return valueLeft + root.data;
        else
            return valueRight + root.data;
    }

    public static String maxSumPath(BTNode root) {
        int sum = runByTreeToGetTheSum(root);//O(n)
        result += "the max sum is: " + sum + " ";
        if(printPath(root, sum))//O(n)
            return result;
        else
            return "";
    }

*/


/*
    public static void main(String[] args)
    {
        BTNode root = null;
		/* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		     / \     / \
		    8   4   5   6
           /  \
          10   20
          /\
         22 23
		*/
/*
        root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(8);
        root.left.right = new BTNode(4);
        root.right.left = new BTNode(5);
        root.right.right = new BTNode(6);
        root.left.left.left = new BTNode(10);
        root.left.left.right = new BTNode(20);
        root.left.left.left.left = new BTNode(22);
        root.left.left.left.right = new BTNode(23);







        String a = maxSumPath(root);
        System.out.println(a);
*/

/*
        BinaryTree bt = new BinaryTree();
        BinaryTree bt2 = new BinaryTree();
        bt.Add(50);
        bt.Add(25);
        bt.Add(80);
        bt.Add(20);
        bt.Add(35);
        bt.Add(70);
        bt.Add(90);
        bt.Add(15);
        bt.Add(23);
        bt.Add(30);
        bt.Add(45);
        bt.Add(65);
        bt.Add(75);
        bt.Add(100);
        bt.Add(5);
        bt.Add(18);
        bt.Add(68);
        bt.Add(95);
        bt.Add(150);
        bt.Add(27);

        bt.deleteKey(50);

        System.out.println("min value is: " + bt.getSuccessor(bt));

        bt.printBinaryTreeVisualy();
    }*/




    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80*/
        tree.Add(50);
        tree.Add(30);
        tree.Add(20);
        tree.Add(40);
        tree.Add(70);
        tree.Add(60);
        tree.Add(80);
        tree.isLightning();

       // tree.printBinaryTreeVisualy();
        tree.updateSizeOfNode();
        tree.getSize();
        BTNode node8 = new BTNode(8);
        BTNode node4 = new BTNode(4);
        BTNode node1 = new BTNode(1);
        BTNode node3 = new BTNode(3);
        BTNode node2 = new BTNode(2);
        BTNode node6 = new BTNode(6);
        BTNode node7 = new BTNode(7);
        BTNode node5 = new BTNode(5);

        node8.setLeft(node4);
        node4.setLeft(node1);
        node4.setRight(node6);
        node6.setRight(node7);
        node7.setLeft(node5);
        node1.setRight(node3);
        node3.setLeft(node2);


        tree.printPostOrder2(node8);
        //tree.printStringOfTree();
        printBinaryTreeVisualy(node8);

    }

}
