package BINARY_TREES;
// { Driver Code Starts
import java.util.HashMap;
import java.util.Scanner;
public class PreInGivenPrintPost {

 public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                Node root = null;
                int inorder[] = new int[n];
                int preorder[] = new int[n];
                for (int i = 0; i < n; i++)
                    inorder[i] = sc.nextInt();

                for (int i = 0; i < n; i++)
                    preorder[i] = sc.nextInt();

                Solution ob = new Solution();
                root = ob.buildTree(inorder,preorder,n);
                //root = ob.buildTree(inorder, preorder, n);
                postOrdrer(root);
                System.out.println();
            }
        }

        public static void postOrdrer(Node root) {
            if (root == null)
                return;

            postOrdrer(root.left);
            postOrdrer(root.right);
            System.out.print(root.data + " ");
        }
    }// } Driver Code Ends


    class Solution {
        static HashMap<Integer, Integer> hmap = new HashMap<>();

        static int prevIndex = 0;

        public  Node buildTreeUtil(int in[], int pre[], int start, int end) {
//add code here.
            if (start > end) return null;
            int currElement = pre[prevIndex++];
            Node temp = new Node(currElement);

            if (start == end)
                return temp;

            int currIndex = hmap.get(currElement);

            temp.left = buildTreeUtil(in, pre, start, currIndex - 1);
            temp.right = buildTreeUtil(in, pre, currIndex + 1, end);

            return temp;

        }

        public  Node buildTree(int in[], int pre[], int n) {

            for (int i = 0; i < n; i++) {
                hmap.put(in[i], i);
            }
                return buildTreeUtil(in, pre, 0, n - 1);

        }


    }

