package BINARY_TREES;

import java.util.LinkedList;
import java.util.Queue;
/*
*
* A tree is a Continuous tree if in each root to leaf path, the absolute difference between keys of two adjacent is 1.
* We are given a binary tree, we need to check if the tree is continuous or not.
* */
public class ContinuousBTCheck {
    static Node root;
    static class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static boolean continuousBT(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()){
            Node temp = q.poll();

            if (temp.left!=null){
               if (Math.abs(temp.data-temp.left.data )== 1){
                   q.add(temp.left);
                }else {
                   flag = false;
                   return flag;
               }
            }  if (temp.right!=null){
                if (Math.abs(temp.data-temp.right.data )== 1){
                    q.add(temp.right);
                }else {
                    flag = false;
                    return flag;
                }

            }
        }
        return flag;
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(100);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(8);
        root.right.right = new Node(8);

        if (continuousBT(root)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }


}
