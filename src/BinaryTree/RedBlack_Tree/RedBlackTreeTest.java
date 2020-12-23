package BinaryTree.RedBlack_Tree;
import java.util.Scanner;

public class RedBlackTreeTest
 {
	public static Scanner kelet = new Scanner(System.in);
	public static int choice;
     public static void main(String[] args)
     {            
        
        /* Creating object of RedBlack Tree */
         RBTree rbt = new RBTree(((int)(Math.random()*100)+1));
         //RedBlackTree rbt = new RedBlackTree();
         for(int i = 0; i < 10 ; i++){
             rbt.insert(((int)(Math.random()*100)+1));
             //rbt.insert(node);
         }
         rbt.postorder();
     }
 }


       /* System.out.println("Red Black Tree Test\n");
        char ch;
        /*  Perform tree operations  */
       /* do
        {
            System.out.println("\nRed Black Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. clear tree");

            choice = kelet.nextInt();
            switch (choice)
            {
            case 1 :
                System.out.println("Enter integer element to insert");
                rbt.insert( kelet.nextInt() );
                break;
            case 2 :
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ rbt.search( kelet.nextInt() ));
                break;
            case 3 :
                System.out.println("Nodes = "+ rbt.countNodes());
                break;
            case 4 :
                System.out.println("Empty status = "+ rbt.isEmpty());
                break;
            case 5 :
                System.out.println("\nTree Cleared");
                rbt.makeEmpty();
                break;
            default :
                System.out.println("Wrong Entry \n ");
                break;
            }
            /*  Display tree  *//*
         System.out.print("\nPost order : ");
         rbt.postorder();
         System.out.print("\nPre order : ");
         rbt.preorder();
         System.out.print("\nIn order : ");
         rbt.inorder();

         System.out.println("\nDo you want to continue (Type y or n) \n");
         ch = kelet.next().charAt(0);
     } while (ch == 'Y'|| ch == 'y');        */
