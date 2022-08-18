package StriverTrees;

import java.util.ArrayList;

public class Q26RootToNodePath {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(2);
        n1.right.right = new Node(3);
        n1.right.left = new Node(4);

        n1.left.left = new Node(3);
        n1.left.left.left = new Node(7);
        n1.left.left.left.right = new Node(8);
        n1.left.right = new Node(5); //true
//        n1.left.right =  -> false

        int node = 8;
        ArrayList<Integer> al = new ArrayList(); //will store the path
        rootToNodePath(n1,node,al);
        for (int x : al) {
            System.out.print(x+ " -> ");
        }
    }

    private static boolean rootToNodePath(Node root, int node, ArrayList<Integer> al) {
        if (root==null) return false; //null reached => node is not in this path so return false
        if (root.data == node) { //if node is found then print node return true
            al.add(0,root.data);
            return true;
        }
        if (rootToNodePath(root.left, node, al)){ //if path is correct then only print
            al.add(0,root.data);
            return true;
        }
        if (rootToNodePath(root.right, node, al)){
            al.add(0,root.data);
             return true;
        }
        return false; //else return false

    }
}
