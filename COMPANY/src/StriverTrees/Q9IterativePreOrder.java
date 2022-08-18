package StriverTrees;

import java.util.ArrayDeque;

public class Q9IterativePreOrder {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(7);

        n1.left.left = new Node(3);
        n1.left.right = new Node(4);
        n1.left.right.left = new Node(5);
        n1.left.right.right = new Node(6);


        preOrder(n1);

    }

    static void p(String s){
        System.out.print(s+" ");
    }
    static void preOrder(Node root){
        ArrayDeque<Node> ad = new ArrayDeque<>();
        ad.push(root);
        while (!ad.isEmpty()) {
            Node temp = ad.pop(); //adding the top

            p(String.valueOf(temp.data));
            if (temp.right!=null){ //first storing right
                ad.push(temp.right);
            }
            if (temp.left!=null){ //then storing left
                ad.push(temp.left);
            }

        }
    }
}
