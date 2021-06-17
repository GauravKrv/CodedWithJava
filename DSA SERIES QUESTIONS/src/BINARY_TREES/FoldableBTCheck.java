package BINARY_TREES;

import java.util.LinkedList;
import java.util.Queue;

public class FoldableBTCheck {

    /* Returns true if the given tree can be folded */
   static boolean foldableCheckRecursive(Node node)
    {
        if (node == null)
            return true;

        return IsFoldableUtil(node.left, node.right);
    }

    /* A utility function that checks if trees with roots as n1 and n2
     are mirror of each other */
   static boolean IsFoldableUtil(Node n1, Node n2)
    {

        /* If both left and right subtrees are NULL,
         then return true */
        if (n1 == null && n2 == null)
            return true;

        /* If one of the trees is NULL and other is not,
         then return false */
        if (n1 == null || n2 == null)
            return false;

        /* Otherwise check if left and right subtrees are mirrors of
         their counterparts */
        return IsFoldableUtil(n1.left, n2.right)
                && IsFoldableUtil(n1.right, n2.left);
    }


    static boolean foldableCheck(Node root){
        Queue<Node> q = new LinkedList<>();

        if (root==null) return true;

        if (root.left==null || root.right==null){
            if (root.right==null && root.left==null)
                return true;
            else return false;
        }

        q.add(root.left);
        q.add(root.right);

        while (q.isEmpty() == false){
         Node ltree = q.poll();
         Node  rtree = q.poll();

            if (ltree.left != null){
                if (rtree.right != null){
                   q.add(ltree.left);
                   q.add(rtree.right);
                  }else {
                    return false;
                }
            }

            if (ltree.right != null || rtree.left != null){
                 if (ltree.right != null && rtree.left != null){
                    q.add(ltree.right);
                    q.add(rtree.left);
                }else {
                    return false;
                }
            }
        }



        return true;
    }

    public static void main(String[] args) {

      Node root = new Node(0);
       /*Check1
       root.left = new Node(20);
      // root.left.left = new Node(30);
        root.left.right = new Node(31);
       root.right = new Node(40);
       root.right.right = new Node(50);
     //  root.right.left = new Node(60);*/

      /*  check 2
      root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.left.right = new Node(5);
*/
   /*   Check 3*/
   root.left = new Node(1);
      root.right =new Node(2);
      root.left.left = new Node(3);
        root.left.right = new Node(3);
      root.left.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.left.right.left = new Node(5);

        root.right.right = new Node(6);
        root.right.left = new Node(6);
        root.right.right.right = new Node(7);
        root.right.right.left = new Node(7);
        root.right.right.left.right = new Node(7);


   //root.right = new Node(20);//Check4 - correct

        if (foldableCheck(root)){   //T(N) && S(N)
            System.out.println("Foldable ");
        }else {
            System.out.println("Unfoldable");
        }

        if (foldableCheckRecursive(root)){ //T(N) && S(1)
            System.out.println("Foldable ");
        }else {
            System.out.println("Unfoldable");
        }

    }
}
//T.C = O(n)
