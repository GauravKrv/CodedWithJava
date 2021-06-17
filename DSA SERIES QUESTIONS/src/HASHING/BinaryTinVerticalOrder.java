package HASHING;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTinVerticalOrder {
    static class Node{
        int key;
        Node left;
        Node right;
        Node(int data){
            key = data;
            left =null;
            right = null;
        }
    }
// Utility function to store vertical order in map 'm', hd' is horizontal distance of
// current node from root.'hd' is initially passed as 0
    static void getVerticalOrder(Node root, int hd, TreeMap<Integer,ArrayList<Integer>> m)
    {


    //Base case
    if (root == null){
        return;
    }
    //get the vector list at 'hd'
        ArrayList<Integer> get = m.get(hd);//m. get( list at key=hd ) ->

    if (get==null){
        get = new ArrayList<>();
        get.add(root.key);
    }
    else {
        get.add(root.key);
    }

    m.put(hd,get);

    //Stores nodes in left subtree
        getVerticalOrder(root.left, hd-1, m);

        getVerticalOrder(root.right,hd+1,m);
    }

    //mian function to print vertcal order of BT with the given root

    static void printVerticalOrder(Node root){
        // Create a map and store vertical order in map using function getVerticalOrder()
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        int hd =0;
        getVerticalOrder(root,hd,m);

        // Traverse the map and print nodes at every horigontal
        // distance (hd)
        for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) // Get a set of the entries
        {
            System.out.print("HD of "+entry.getKey()+" --> ");
            System.out.println(entry.getValue());
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) {

        // TO DO Auto-generated method stub
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);

        /*OUTPUT
        Vertical Order traversal is
[4]
[2]
[1, 5, 6]
[3, 8]
[7]
[9]
        * */

    }
}
/*TEORY :
Given a binary tree, print it vertically
           1
        /    \
       2      3
      / \   /   \
     4   5  6   7
               /  \
              8   9


The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9

. We need to check the Horizontal Distances from the root for all nodes. If two nodes
have the same Horizontal Distance (HD), then they are on the same vertical line. The
idea of HD is simple. HD for root is 0, a right edge (edge connecting to right subtree)
is considered as +1 horizontal distance and a left edge is considered as -1 horizontal
distance. For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1,
 HD for 5 and 6 is 0 and HD for node 7 is +2.

 We can do preorder traversal of the given Binary Tree. While traversing the tree, we
can recursively calculate HDs. We initially pass the horizontal distance as 0 for root.
For left subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1.
 For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus
 1. For every HD value, we maintain a list of nodes in a hash map. Whenever we see a
 node in traversal, we go to the hash map entry and add the node to the hash map using
 HD as a key in a map
* */
