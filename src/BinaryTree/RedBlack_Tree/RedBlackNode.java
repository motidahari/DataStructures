
package BinaryTree.RedBlack_Tree;

import BinaryTree.BTNode;

/* Class Node */
 class RedBlackNode
 {    
     RedBlackNode left, right;
     int element; // info
     int color;
 
     /* Constructor */
     public RedBlackNode(int theElement)
     {
         this( theElement, null, null );
     } 
     /* Constructor */
     public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
     {
         left = lt;
         right = rt;
         element = theElement;
         color = 1;
     }
 }
 
 /* Class RBTree */