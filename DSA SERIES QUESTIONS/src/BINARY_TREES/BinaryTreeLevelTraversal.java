package BINARY_TREES;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelTraversal {
    Node root;
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    void levelOrderTraversal() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        if (root!=null) {

            while (!q.isEmpty()) {
                Node temp = q.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }//--while ending
        }//--if ending
        else {
            System.out.println("No Binary Tree found!");
        }

        /*
Time Complexity: O(n) where n is number of nodes in the binary tree
Space Complexity: O(n) where n is number of nodes in the binary tree
        * */
    }

    public static void main(String[] args) {
        BinaryTreeLevelTraversal bt = new BinaryTreeLevelTraversal();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);

        bt.levelOrderTraversal();
        bt.levelOrderRecursive();

    }


    /* function to print level order traversal of tree*/
    void levelOrderRecursive()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);

        /*
        Time Complexity: O(n^2) in worst case. For a skewed tree, printGivenLevel()
        takes O(n) time where n is the number of nodes in the skewed tree. So time
        complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which
        is O(n^2).
Space Complexity: O(n) in worst case. For a skewed tree, printGivenLevel() uses O(n)
 space for call stack. For a Balanced tree, call stack uses O(log n) space, (i.e.,
 height of the balanced tree).
        * */
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);/*
            e.g :  if heaight = 2, goto rootLeft with height = 2-1 then print data then return here
                    if =3, goto rootLeft->[Left with h=3-1-1  % Right with h=3-1-1] and print data and return as h=1 now
             */
            printGivenLevel(root.right, level-1);/*
            e.g :  if height = 2, goto rootRigh then print data then return finally to forLoop
     if h =3, goto rootRight->[Right till h=1  & Right til h=1] and print data and return as h=1 now
 */
        }
    }



}
