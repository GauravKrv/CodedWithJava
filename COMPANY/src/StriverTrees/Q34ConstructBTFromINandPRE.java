package StriverTrees;

import java.util.HashMap;
import java.util.Map;

public class Q34ConstructBTFromINandPRE {
//DONE ->>> watch video to understand the marked line and
// TODO >> modify your code
    public static void main(String[] args) {
        int pre[] = {10,20,40,50,30,60};
        int in[] = {40,20,50,10,60,30};
        int low = 0;
        int high = in.length-1;
        int preidx = 0;

        //CHECK WHY FAILS--
        Node rootMy = constructBT(preidx,low,high,pre,in);
        inOrder(rootMy);
        System.out.println();

        //WORKS ---
        Node rootSt = buildTree(pre,in);
        inOrder(rootSt);


    }

    //STRIVER'S Hashmap method
    static Node buildTree(int[] preorder, int[] inorder) {
        Map< Integer, Integer > inMap = new HashMap<>(); //take a map

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i); //store inorder value and its index --> will help to figure out, as i used to iterate always
        }

        Node root = buildTree(preorder, 0, preorder.length - 1, inorder, 0,
                inorder.length - 1, inMap);//now build the tree with given initial values
        return root;
    }

    static Node buildTree(int[] preorder, int preStart, int preEnd, int[]
            inorder, int inStart, int inEnd, Map < Integer, Integer > inMap) {
        if (preStart > preEnd || inStart > inEnd) return null; //if low>high return null as mine

        Node curr = new Node(preorder[preStart]); //create the new node with pre idx
        int inRoot = inMap.get(curr.data);//get the index of current node from MAP
        //now what i did was if partition is -1 return null, i.e--> that code is eliminated using this mapping method

       //**** id point -> 15mins
        int numsLeft = inRoot - inStart; //stores the length , left length of the inorder array to be traversed for next
        //we use above length to divide the preorer array [prestart->pre+length && pre+length+1 -> preEnd], but why?,
        //BECAUSE - IF X ELEMENTS ARE ON LEFT , THEN NEXT X IN PREORDER WILL BE REPRESENTING THOSE LEFT ELEMENTS
        //****
        curr.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder,
                inStart, inRoot - 1, inMap);// inorder division is same as mine

        curr.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder,
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
    //dry run your method
    //try the code with map instead of checking always, and if current index doesnt lies bw low and high return null
    private static StriverTrees.Node constructBT(int preidx, int low, int high, int[] pre, int[] in) {
        if (high<=low) return null;
        int partition=-1;
        for (int i = low; i < high + 1; i++) {
            if (in[i]==pre[preidx]){ //if current index element of re is in this side of inorder array
                partition = i;
                break;
            }
        }

        if (partition==-1) return null; //i.e current side of norder doesnt have this element

        StriverTrees.Node curr = new StriverTrees.Node(pre[preidx]);
        curr.left = constructBT(preidx+1,low,partition-1,pre,in);
        curr.right = constructBT(preidx+1,partition+1,high,pre,in);

        return curr;
    }


}
