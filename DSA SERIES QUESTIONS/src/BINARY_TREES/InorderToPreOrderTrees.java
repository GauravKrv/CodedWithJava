package BINARY_TREES;
import java.util.Vector;

public class InorderToPreOrderTrees {
// Java program to find binary tree with given inorder
// traversal


    /* Class containing left and right child of current
    node and key value*/
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

        Node root;

        // A utility function to do preorder traversal of BST
        void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        // Function for constructing all possible trees with
        // given inorder traversal stored in an array from
        // arr[start] to arr[end]. This function returns a
        // vector of trees.
        Vector<Node> getTrees(int arr[], int start, int end) {

            // List to store all possible trees
            Vector<Node> trees = new Vector<Node>();

		/* if start > end then subtree will be empty so
		returning NULL in the list */
            if (start > end) {
                trees.add(null);
                return trees;
            }

		/* Iterating through all values from start to end
		for constructing left and right subtree
		recursively */
            for (int i = start; i <= end; i++) {
                /* Constructing left subtree */
                Vector<Node> ltrees = getTrees(arr, start, i - 1);

                /* Constructing right subtree */
                Vector<Node> rtrees = getTrees(arr, i + 1, end);

			/* Now looping through all left and right subtrees
			and connecting them to ith root below */
                for (int j = 0; j < ltrees.size(); j++) {
                    for (int k = 0; k < rtrees.size(); k++) {

                        // Making arr[i] as root
                        Node node = new Node(arr[i]);

                        // Connecting left subtree
                        node.left = ltrees.get(j);

                        // Connecting right subtree
                        node.right = rtrees.get(k);

                        // Adding this tree to list
                        trees.add(node);
                    }
                }
            }
            return trees;
        }

        public static void main(String args[]) {
            int in[] = {4, 5, 7};
            int n = in.length;
            InorderToPreOrderTrees tree = new InorderToPreOrderTrees();
            Vector<Node> trees = tree.getTrees(in, 0, n - 1);
            System.out.println("Preorder traversal of different " +
                    " binary trees are:");
            for (int i = 0; i < trees.size(); i++) {
                tree.preOrder(trees.get(i));
                System.out.println("");
            }
        }
    }

    /*QUESTOIN

    Given an array that represents Inorder Traversal, find all possible Binary Trees with the given Inorder traversal and print their preorder traversals.
Examples:

Input:   in[] = {3, 2};
Output:  Preorder traversals of different possible Binary Trees are:
         3 2
         2 3
Below are different possible binary trees
    3        2
     \      /
      2    3

Input:   in[] = {4, 5, 7};
Output:  Preorder traversals of different possible Binary Trees are:
          4 5 7
          4 7 5
          5 4 7
          7 4 5
          7 5 4
Below are different possible binary trees
  4         4           5         7       7
   \          \       /   \      /       /
    5          7     4     7    4       5
     \        /                  \     /
      7      5                    5   4
We strongly recommend you to minimize your browser and try this yourself first.

Let given inorder traversal be in[]. In the given traversal, all nodes in left subtree of in[i] must appear before it and in right subtree must appear after it. So when we consider in[i] as root, all elements from in[0] to in[i-1] will be in left subtree and in[i+1] to n-1 will be in right subtree. If in[0] to in[i-1] can form x different trees and in[i+1] to in[n-1] can from y different trees then we will have x*y total trees when in[i] as root. So we simply iterate from 0 to n-1 for root. For every node in[i], recursively find different left and right subtrees. If we take a closer look, we can notice that the count is basically n’th Catalan number. We have discussed different approaches to find n’th Catalan number here.

The idea is to maintain a list of roots of all Binary Trees. Recursively construct all possible left and right subtrees. Create a tree for every pair of left and right subtree and add the tree to list. Below is detailed algorithm.
    * */


