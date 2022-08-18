package StriverTrees;

public class Q16DiameterBT {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(7);
        n1.right.right = new Node(7); //makes it balaced
        n1.left.left = new Node(3);
        n1.left.right = new Node(4);
        n1.left.right.left = new Node(5);
        n1.left.right.right = new Node(6);


        getDiameter(n1);
        System.out.println(diameter);
    }
    static int diameter = 0;

    //Works O(N) --
    private static int getDiameter(Node n1) {
        if (n1==null) return 0;
        int lefth = getDiameter(n1.left);
        int righth = getDiameter(n1.right);
        diameter = Math.max(lefth+righth, diameter); //for each node store either max or curr diameter
        return 1+Math.max(lefth,righth);
    }
}
