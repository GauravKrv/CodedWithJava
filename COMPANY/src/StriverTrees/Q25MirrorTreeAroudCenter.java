package StriverTrees;

import java.util.List;

public class Q25MirrorTreeAroudCenter {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(2);
        n1.right.right = new Node(3);
        n1.right.left = new Node(4);

        n1.left.left = new Node(3);
        n1.left.right = new Node(4); //true
//        n1.left.right =  -> false


        System.out.println(isMirror(n1.left,n1.right));
    }

    private static boolean isMirror(Node left, Node right) {
//        if (left==null && right==null) return true; //if bth is nul then ok
        if (left==null || right==null) return left==right; //if only one is null then false -- above line is not nexessary
        if (left.data!=right.data) return false; //if data is not same - not ok
        return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }
}
