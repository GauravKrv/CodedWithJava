package StriverTrees;

import java.util.ArrayDeque;

public class IterativePostOrderQ11 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(7);

        n1.left.left = new Node(3);
        n1.left.right = new Node(4);
        n1.left.right.left = new Node(5);
        n1.left.right.right = new Node(6);


        postOrder(n1);

    }

    static void p(String s){
        System.out.print(s+" ");
    }
    static void postOrder(Node root){
        ArrayDeque<Node> ad = new ArrayDeque<>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();

        ad.push(root);
        while (!ad.isEmpty()) {
            Node temp = ad.pop(); //adding the top
            ad2.add(temp.data);

            if (temp.left!=null){ //first storing left
                ad.push(temp.left);
            }

            if (temp.right!=null){ // then storing right
                ad.push(temp.right);
            }

        }

        while (ad2.isEmpty()==false){
            System.out.print(ad2.removeLast()+" ");
        }
    }

}
