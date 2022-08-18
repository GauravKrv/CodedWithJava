package StriverTrees;

public class Q17MaxPathSum {

    public static void main(String[] args) {
        Node n1 = new Node(-10);
        n1.left = new Node(9);
        n1.right = new Node(20);
//        n1.right.right = new Node(7); //makes it balaced
        n1.right.left = new Node(15);
        n1.right.right = new Node(7);
//        n1.left.right.left = new Node(5);
//        n1.left.right.right = new Node(6);


        getMaxPathSum(n1);
        System.out.println(max);
    }

    //Workss - mine
    private static int getMaxPathSum(Node n) {
        if (n==null) return 0;
        int lpath = getMaxPathSum(n.left);
        int rpath = getMaxPathSum(n.right);

        max = Math.max(max,lpath+rpath + n.data);

        return Math.max(lpath,rpath) + n.data;
    }

    static int max = Integer.MIN_VALUE;
}
