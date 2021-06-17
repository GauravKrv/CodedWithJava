package BINARY_TREES;
// Java program to insert element in binary tree
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeInsertion {
    /* A binary tree node has key, pointer to
       left child and a pointer to right child */
    static class Node {
        int key;
        Node left, right;

        // constructor
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;

    /* Inorder traversal of a binary tree*/
    static void inorder(Node temp)
    {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    /*function to insert element in binary tree */
    static void insert(Node temp, int key)
    {

        if (temp == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    // Driver code
    public static void main(String args[])
    {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print(
                "Inorder traversal before insertion:");
        inorder(root);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of nodes to be inserted more : ");
        int n = sc.nextInt();
        for (int i=1;i<=n;i++){
            System.out.println("Enter value "+i+" : ");
            int val = sc.nextInt();
            insert(root,val);
        }

       /* int key = 12;
        insert(root, key);*/

        System.out.print(
                "\nInorder traversal after insertion:");
        inorder(root);
    }
}

/*OUTPUT :
Inorder traversal before insertion:7 11 10 15 9 8
Enter no. of nodes to be inserted more : 4
Enter value 1 :
22
Enter value 2 :
33
Enter value 3 :
44
Enter value 4 :
55
Inorder traversal after insertion:33 7 44 11 55 22 10 15 9 8
* */
