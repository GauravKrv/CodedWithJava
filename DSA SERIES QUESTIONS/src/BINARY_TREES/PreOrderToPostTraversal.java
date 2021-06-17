package BINARY_TREES;
public class PreOrderToPostTraversal {
// Java program for finding postorder
// traversal of BST from preorder traversal
     static class COUNT {
            int data;
            COUNT(int d) { data = d; }
        }

        // Function to find postorder traversal from
        // preorder traversal.
        static void findPostOrderUtil(int pre[], int n,
                                      int minval, int maxval,
                                      COUNT preIndex)
        {

            // If entire preorder array is traversed then
            // return as no more element is left to be
            // added to post order array.
            if (preIndex.data == n)
                return;

            // If array element does not lie in range specified,
            // then it is not part of current subtree.
            if (pre[preIndex.data] < minval
                    || pre[preIndex.data] > maxval) {
                return;
            }

            // Store current value, to be printed later, after
            // printing left and right subtrees. Increment
            // preIndex to find left and right subtrees,
            // and pass this updated value to recursive calls.
            int val = pre[preIndex.data];
            preIndex.data++;

            // All elements with value between minval and val
            // lie in left subtree.
            findPostOrderUtil(pre, n, minval, val, preIndex);

            // All elements with value between val and maxval
            // lie in right subtree.
            findPostOrderUtil(pre, n, val, maxval, preIndex);

            System.out.print(val + " ");
        }

        // Function to find postorder traversal.
        static void findPostOrder(int pre[], int n)
        {

            // To store index of element to be
            // traversed next in preorder array.
            // This is passed by reference to
            // utility function.
            COUNT preIndex = new COUNT(0);

            findPostOrderUtil(pre, n, Integer.MIN_VALUE,
                    Integer.MAX_VALUE, preIndex);
        }


        //METHOD 2 :
       static void getPostOrderBST(int pre[])
        {
            int pivotPoint = 0;

            // run loop from 1 to length of pre
            for (int i = 1; i < pre.length; i++)
            {
                if (pre[0] <= pre[i])
                {
                    pivotPoint = i;
                    break;
                }
            }

            // print from pivot length -1 to zero
            for (int i = pivotPoint - 1; i > 0; i--)
            {
                System.out.print(pre[i] + " ");
            }

            // print from end to pivot length
            for (int i = pre.length - 1; i >= pivotPoint; i--)
            {
                System.out.print(pre[i] + " ");
            }
            System.out.print(pre[0]);
        }


    // Driver code
        public static void main(String args[])
        {
            int pre[] = { 40, 30, 35, 80, 100 };

            int n = pre.length;

            // Calling function  // T.C  = O(N) Both functions
            findPostOrder(pre, n); //S.C = O(N)
            System.out.println();
            getPostOrderBST(pre);//S.C = O(1)
        }
    }
    /*question

 Given an array representing preorder traversal of BST, print its postorder traversal.


Examples:

Input : 40 30 35 80 100
Output : 35 30 100 80 40

Input : 40 30 32 35 80 90 100 120
Output : 35 32 30 120 100 90 80 40
    * */