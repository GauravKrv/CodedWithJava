package BINARY_TREES;


/*
Children Sum Property is a property in which the sum of values of the left child and right child should be equal to the value of their node if both children are present. Else if only one child is present then the value of the child should be equal to its node value.
* */

public class ChildSum {
    static class Node
    {
        int key;
        Node left;
        Node right;
        Node(int k){
            key=k;
            left=right=null;
        }
    }
        public static void main(String args[])
        {
            Node root=new Node(21);
            root.left=new Node(9);
            root.right=new Node(12);
            root.right.left=new Node(3);
            root.right.right=new Node(9);

            System.out.print(isCSum(root));
            System.out.println();
            System.out.print(isCSumMy(root));

        }

        public static boolean isCSum(Node root){
            if(root==null)
                return true;
            if(root.left==null && root.right==null)
                return true;
            int sum=0;
            if(root.left!=null)sum+=root.left.key;
            if(root.right!=null)sum+=root.right.key;

            return (root.key==sum && isCSum(root.left) && isCSum(root.right));
        }


    public static boolean isCSumMy(Node root){
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;

        if(root.right==null && root.key!= root.left.key)return false;
        else if(root.left==null&& root.key!= root.right.key)return false;
        else if(root.key!= root.right.key + root.left.key)return false;
        else {
           if (isCSumMy(root.left)==false) return false;
            if (isCSumMy(root.right)==false) return false;
        }
        return true;
    }

}
