package BINARY_TREES;

public class Diameter {
//The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes.
    public static void main(String args[])
    {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.right.left=new Node(40);
        root.right.right=new Node(60);
        root.right.left.left=new Node(50);
        root.right.right.right=new Node(70);

        System.out.print(diameter(root));
    }

    public static int height(Node root){
        if(root==null)
            return 0;
        else
            return (1+Math.max(height(root.left),height(root.right)));
    }

    public static int diameter(Node root){
        if(root==null)return 0;
        int d1=1+height(root.left)+height(root.right);//either inckude curr node in the diameter
        int d2=diameter(root.left); //or include left node in the diameter
        int d3=diameter(root.right);//or include right node in the diameter

        return Math.max(d1,Math.max(d2,d3));
    }
}
