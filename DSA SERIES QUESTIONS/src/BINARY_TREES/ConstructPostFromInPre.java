package BINARY_TREES;
/* Java program to construct tree using inorder
   and preorder traversals */
import java.util.HashMap;

public class ConstructPostFromInPre {

    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class Node
    {
        char data;
        Node left,right;
        Node(char item)
        {
            data = item;
            left = right = null;
        }
    }


        public static Node root;

        // Store indexes of all items so that we
        // we can quickly find later
        static HashMap<Character,Integer> mp = new HashMap<>();
        static int preIndex = 0;

        /* Recursive function to construct binary of size
          len from Inorder traversal in[] and Preorder traversal
          pre[]. Initial values of inStrt and inEnd should be
          0 and len -1. The function doesn't do any error
          checking for cases where inorder and preorder
          do not form a tree */
        public static Node buildTree(char[] in, char[] pre, int inStrt, int inEnd)
        {

            if(inStrt > inEnd)
            {
                return null;
            }

    /* Pick current node from Preorder traversal using preIndex
        and increment preIndex */
            char curr = pre[preIndex++];
            Node tNode;
            tNode = new Node(curr);

            /* If this node has no children then return */
            if (inStrt == inEnd)
            {
                return tNode;
            }

            /* Else find the index of this node in Inorder traversal */
            int inIndex = mp.get(curr);

    /* Using index in Inorder traversal, construct left and
        right subtress */
            tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
            tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
            return tNode;
        }

        // This function mainly creates an unordered_map, then
        // calls buildTree()
        public static Node buldTreeWrap(char[] in, char[] pre, int len)
        {
            for(int i = 0; i < len; i++)
            {
                mp.put(in[i], i);
            }
            return buildTree(in, pre, 0, len - 1);
        }

        /* This funtcion is here just to test buildTree() */
        static void printInorder(Node node)
        {
            if(node == null)
            {
                return;
            }
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }

        /* Driver code */
        public static void main (String[] args)
        {
            char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
            char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
            int len = in.length;

            ConstructPostFromInPre.root=buldTreeWrap(in, pre, len);

    /* Let us test the built tree by printing
        Insorder traversal */
            System.out.println("Inorder traversal of the constructed tree is");
            printInorder(root);
        }
    }
