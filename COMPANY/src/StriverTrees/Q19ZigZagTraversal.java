package StriverTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q19ZigZagTraversal {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(7);
        n1.left.left = new Node(3);
        n1.left.right = new Node(4);
        n1.left.right.left = new Node(5);
        n1.left.right.right = new Node(6);

        traverseZigZag(n1);
    }
//WORKS - MINE
    private static void traverseZigZag(Node n) {
        Stack<Node> st = new Stack<>();
        Queue<Node> q = new LinkedList<>();

        boolean flag = true; //go right then left

        q.add(n);

        while (q.size()!=0){
            while (q.size()!=0){
                st.push(q.poll()); //POP OUT ALL THE CURRENT LEVEL NODES FROM QUEUE AND STORE IN STACK
            }
            if (flag==false){ //TRAVERSE RIGHT -> LEFT
                while (st.size()!=0){
                    Node temp = st.pop();
                    System.out.print(temp.data+ " => ");
                    if (temp.right!=null){  //go right first and then left
                        q.add(temp.right);
                    }

                    if (temp.left!=null){
                        q.add(temp.left);
                    }
                }
                System.out.println();
                flag = true;
            }
            else  if (flag==true){  //TRAVERSE LEFT -> RIGHT
                while (st.size()!=0){
                    Node temp = st.pop();
                    System.out.print( " <= " + temp.data);

                    if (temp.left!=null){ //go left first and then right
                        q.add(temp.left);
                    }
                    if (temp.right!=null){
                        q.add(temp.right);
                    }

                }
                flag = false;
                System.out.println();
            }
        }
    }

}
