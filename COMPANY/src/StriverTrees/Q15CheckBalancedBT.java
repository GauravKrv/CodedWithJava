package StriverTrees;

public class Q15CheckBalancedBT {
    //if |left height - right height|<= 1 ==> balanced BT
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(7);
        n1.right.right = new Node(7); //makes it balaced
        n1.left.left = new Node(3);
        n1.left.right = new Node(4);
        n1.left.right.left = new Node(5);
        n1.left.right.right = new Node(6);


        System.out.println(isBalanced(n1));//-1 if not balanced else returns the height
    }

    //Just think -- we can use height functionality to check the balance factor is <= 1 or not
    private static int isBalanced(Node n1) {
        if (n1==null) return 0;
        int lefth = isBalanced(n1.left);
        int righth = isBalanced(n1.right);

        if (lefth==-1 || righth == -1) return -1;
        if (Math.abs(lefth-righth) > 1) return -1;
        return 1+Math.max(lefth,righth);
    }

}
