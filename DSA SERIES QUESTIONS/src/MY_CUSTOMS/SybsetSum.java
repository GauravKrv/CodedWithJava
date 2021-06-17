package MY_CUSTOMS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SybsetSum {
    static class Node{
        int key;
        int value;
        Node left;
        Node right;
        Node(int key,int value){
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    static void insertVaues(Node node,int size){ //inserting the values in breadth first traersal order
        int num = 2;
        Queue<Node> q = new LinkedList();
        q.add(node);
        while (num<=size && q!=null){
            Node temp = q.poll();
            temp.left = new Node(0,1);
            temp.right = new Node(0,0);
            if (temp.left==null){
                temp.left.key = num;
                num++;
                q.add(temp.left);
            }
            if (temp.right==null){
                temp.right.key = num;
                num++;
                q.add(temp.right);
            }
        }

    }

    static void printPattern(int[] seq,Node node){ //printing the pattern by doing binary search in the tree
        int iter = 0;
        while (iter<seq.length){
            if (node.left.value == seq[iter]){
                System.out.print(node.left.key+" ");
                node = node.left;
            }else {
                System.out.print(node.right.key+" ");
                node = node.right;
            }
            iter++;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1,0);
        //
        System.out.println("Enter the size of number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seq = new int[n];
        System.out.println("enter the pattern of subset sum solution : ");
        for (int i =0;i<n;i++)
            seq[i] = sc.nextInt();

        //creating the bst
        insertVaues(root,n);
        System.out.println("The path to the given solution == ");
        printPattern(seq,root);

    }
}
