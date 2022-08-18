package StriverTrees;

import java.util.*;
import java.util.List;
class Tuple {
    Node node;
    int row;
    int col;
    public Tuple(Node _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}
//UNDERSTAND AGAIN THEN PROCEED
public class Q21VerticalOrder__ {

    public static List < List < Integer >> findVertical(Node root) {
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tuple > q = new LinkedList < Tuple > (); //will store the coordinates => (node,direction,level)
        q.offer(new Tuple(root, 0, 0)); //initial configuratoin => inc levelo as we go down, dec direc if goes left, inc dir if right

        while (!q.isEmpty()) { //LEVEL ORDER TRAVERSAL SIMPLE -- MODIFIED
            Tuple tuple = q.poll(); //storing the queue of tupels, first data
            Node node = tuple.node;
            int x = tuple.row; //current x, and y
            int y = tuple.col;


            if (!map.containsKey(x)) {
                map.put(x, new TreeMap < > ()); //if not present create a new Treemap along with current x data
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue < > ()); //if not presen create a new list to store at r level,y col
            }
            map.get(x).get(y).offer(node.data); //insert the data

            if (node.left != null) { //now adding the data [left data] to queue
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) { //now adding the data [right data] to queue
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
            //again iterate
        }
//        STORING DATA ONLY VERTICAL ORDER WISE
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        List <List< Integer >> list;
        list = findVertical(root);

        System.out.println("The Vertical Traversal is : ");
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }

    }
}
