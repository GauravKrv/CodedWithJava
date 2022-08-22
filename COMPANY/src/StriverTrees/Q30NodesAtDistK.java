package StriverTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
import java.util.Queue;
//WORKS - ---- STRIVERS SOLUTION
public class Q30NodesAtDistK {
    public static void main(String[] args) {
        StriverTrees.Node root = new StriverTrees.Node(3);
        root.left = new StriverTrees.Node(5);
        Node target = root.left;
        root.left.left = new StriverTrees.Node(6);
        root.left.right = new StriverTrees.Node(2);
        root.left.right.left = new StriverTrees.Node(7);
        root.left.right.right = new StriverTrees.Node(4);
        root.right = new StriverTrees.Node(1);
        root.right.left = new StriverTrees.Node(0);
        root.right.right = new StriverTrees.Node(8);

        List<Integer> al = distanceK(root,target,2);

        for (int x :
                al) {
            System.out.print(x+" ");
        }


    }

    private static void nodesAtDistK(StriverTrees.Node root) {

        Queue<StriverTrees.Node> bfs = new LinkedList<>();
        bfs.add(root);//how to store parents of each node?? -- data wise is fine[use hashmap] but node wise we hae to store--how?


    }
 //STRIVERS SOLUTION ----
    private static void markParents(Node root, Map<Node, Node> parent_track, Node target) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.left != null) {
                parent_track.put(current.left, current);//CHILD, PARENT - STORE IN HASHMAP
                queue.offer(current.left);
            }
            if(current.right != null) {
                parent_track.put(current.right, current);//CHILD, PARENT - STORE IN HASHMAP
                queue.offer(current.right);
            }
        }
    }
    public static List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> parent_track = new HashMap<>();
        markParents(root, parent_track, root);//MARKING PARENTS USING NODE
        Map<Node, Boolean> visited = new HashMap<>();//KEEP TRACK OF VISITED USING HASHMAP
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(target); //ADDING THE TARGET NODE
        visited.put(target, true);
        int curr_level = 0; //initial is 0, incr in loop the level first
        while(!queue.isEmpty()) { /*Second BFS to go upto K level from target node and using our hashtable info*/
            int size = queue.size();
            if(curr_level == k) break; //Loop till current level is not equal to K
            curr_level++;

            for(int i=0; i<size; i++) {  //visiting all the nodes in current distance -- both up and downward
                Node current = queue.poll();
                if(current.left != null && visited.get(current.left) == null) { //storing left
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null ) { //storing right
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) { //check if curent node has parent & is not visited
                    queue.offer(parent_track.get(current)); //store the parent of current node
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) { //now the queue will be storing the nodes at distance K only
            Node current = queue.poll();
            result.add(current.data);
        }
        return result;
    }
}
