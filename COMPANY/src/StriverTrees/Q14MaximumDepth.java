package StriverTrees;

public class Q14MaximumDepth {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(7);

        n1.left.left = new Node(3);
        n1.left.right = new Node(4);
        n1.left.right.left = new Node(5);
        n1.left.right.right = new Node(6);


        System.out.println(heightRecursive(n1));

    }

//    /recursive and levelorder - both same worst cases

    //mine recursive -- works
    private static int heightRecursive(Node n1) {
        if (n1==null) return 0;
        int lefth = heightRecursive(n1.left);
        int righth = heightRecursive(n1.right);

        return 1+Math.max(lefth,righth);

    }
}
