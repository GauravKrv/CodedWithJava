package StriverTrees;

import java.util.ArrayDeque;

public class Q10IterativeInorder {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(7);

        n1.left.left = new Node(3);
        n1.left.right = new Node(4);
        n1.left.right.left = new Node(5);
        n1.left.right.right = new Node(6);


        inOrderStriver(n1); //works

    }

    static void p(String s){
        System.out.print(s+" ");
    }
    //Doesnt works
    static void inOrder(Node root){
        ArrayDeque<Node> ad = new ArrayDeque<>();
        ad.push(root);
        while (!ad.isEmpty()) {
            Node temp = ad.peek(); //adding the top
            while (temp.left!=null){ //then storing left
                ad.push(temp.left);
                temp = temp.left;
            }

            while (temp.right==null){
                System.out.print(temp.data +" ");
                temp = ad.pop();
            }

            ad.push(temp.right);

        }
    }

    static void inOrderStriver(Node root){
        ArrayDeque<Node> ad = new ArrayDeque<>();
        Node t = root;
        while (true) {
            if (t!=null){
                ad.push(t);
                t=t.left;
            }
            else{
                if (ad.isEmpty()){
                    break;
                }
                t = ad.pop();
                System.out.print(t.data+" ");
                t = t.right;
            }

        }
    }
}
