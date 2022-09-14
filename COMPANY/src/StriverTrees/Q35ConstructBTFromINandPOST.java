package StriverTrees;

import java.util.HashMap;
import java.util.Map;

public class Q35ConstructBTFromINandPOST {

    public static void main(String[] args) {
        int post[] = {40,50,20,60,30,10};
        int in[] = {40,20,50,10,60,30};

        Node rootSt = buildTree(post,in);
        inOrder(rootSt);


    }

    //STRIVER'S Hashmap method + My learnings
    static Node buildTree(int[] postorder, int[] inorder) {
        Map< Integer, Integer > inMap = new HashMap<>(); //take a map

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i); //store inorder value and its index --> will help to figure out, as i used to iterate always
        }

        Node root = buildTree(postorder, 0, postorder.length - 1, inorder, 0,
                inorder.length - 1, inMap);//now build the tree with given initial values
        return root;
    }

    static Node buildTree(int[] postorder, int postStart, int postEnd, int[]
            inorder, int inStart, int inEnd, Map < Integer, Integer > inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        Node curr = new Node(postorder[postEnd]); //create the new node with pre idx
        int inRoot = inMap.get(curr.data);//get the index of current node from MAP

       // int numsRight = inEnd - inRoot; MY-WRONG - 1
  /*  MY-WRONG - 2    curr.left = buildTree(postorder, postEnd - numsRight, postEnd -1, inorder,
                inStart, inRoot - 1, inMap);// inorder division is same as mine

      MY-WRONG - 3  curr.right = buildTree(postorder,postStart, postEnd - numsRight - 1, inorder,
                inRoot + 1, inEnd, inMap);// inorder division is same as mine

*/
        curr.left = buildTree(postorder, postStart, postStart+inRoot -inStart-1, inorder, //LENGTHS OF LEFT SIDE OF INORDER IS SAME AS POSTEND-POSTSTART
                inStart, inRoot - 1, inMap);// inorder division is same as mine

        curr.right = buildTree(postorder,postStart+inRoot -inStart, postEnd  - 1, inorder,//EXCLUDING CURRENT POST END
                inRoot + 1, inEnd, inMap);// inorder division is same as mine


        return curr;
    }
    public static void inOrder(StriverTrees.Node root){
        if (root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
}
