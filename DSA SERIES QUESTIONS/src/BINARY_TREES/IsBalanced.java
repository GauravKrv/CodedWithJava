package BINARY_TREES;


/*
In a Balanced Binary Tree for every node, the difference between heights of left subtree and right subtree should not be more than one.
* */
public class IsBalanced {

        public static void main(String args[])
        {
            Node root=new Node(10);
            root.left=new Node(5);
            root.right=new Node(30);
            root.right.left=new Node(15);
            root.right.right=new Node(20);

            System.out.print(isBalanced(root));
        }

        public static boolean isBalanced(Node root){
            if(root==null)
                return true;
            int lh=height(root.left);
            int rh=height(root.right);
            return (Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right));
        }

        public static int height(Node root){
            if(root==null)
                return 0;
            else
                return (1+Math.max(height(root.left),height(root.right)));
        }


        //EAZY TO UNDERSTAND FROM 3MINS VIDEO BUT HARD TO THINK FOR THE APPROACH
    public static int isBalanced2(Node root){
        if(root==null)
            return 0;
        int lh=isBalanced2(root.left);
        if(lh==-1)return -1;
        int rh=isBalanced2(root.right);
        if(rh==-1)return -1;

        if(Math.abs(lh-rh)>1)
            return -1;
        else
            return Math.max(lh,rh)+1;
    }

    }

