package StriverTrees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Q28MaxWidthBw2Nod {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.right = new Node(4);
        root.left.left.left = new Node(8);
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(15);
       int maxWidthBwNodOnALevel = widthOfBinaryTree(root);
        System.out.println(maxWidthBwNodOnALevel);

    }


//    below function just returns the max no of nodes present on a level in a tree
//    but we have to find the max no of nodes possible bw two nodes on a level, including the two nodes
    private static int getmaxnodes(Node root) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(root);
        int max = -1;
        while (!q.isEmpty()){
            //lev 1  - root
            //lev 2 - left,right
            Node temp = q.pollFirst();
            if (temp.left!=null){
                q.add(temp.left);
            }

            if (temp.right!=null){
                q.add(temp.right);
            }

            int curr_size =  q.size();
            max = Math.max(curr_size,max);

        }
        return max;

    }


    //gives correct solution - of finding width
    public static int widthOfBinaryTree(Node root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();//storing each node with its index number or pair
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;    //to make the id starting from zero
            int first = 0,last = 0;
            for(int i=0; i<size; i++){ //removing or traversing or evaluating all nodes in a level
                int cur_id = q.peek().num-mmin;//for setting currents id
                Node node = q.peek().node;
                q.poll();
                if(i==0) first = cur_id;//setting first index value on the current level
                if(i==size-1) last = cur_id;//setting the last index value on the current level
                if(node.left != null)
                    q.offer(new Pair(node.left, cur_id*2+1));//adding left with left formula--MAIN
                if(node.right != null)
                    q.offer(new Pair(node.right, cur_id*2+2));//adding right with right formula--MAIN
            }
            ans = Math.max(ans, last-first+1);//evaluating the width
        }
        return ans;
    }
}
