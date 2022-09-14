package StriverTrees;
import java.util.HashMap;
import java.util.*;
public class Q31TimeToBurnTree {
 /*   class BinaryTreeNode{

    }
    private static BinaryTreeNode<Integer> bfsToMapParents(BinaryTreeNode<Integer> root,
                                                           HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, int start) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);
        while(!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();
            if(node.data == start) res = node;
            if(node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
    private static int findMaxDistance(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, BinaryTreeNode<Integer> target) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(target);
        HashMap<BinaryTreeNode<Integer>,Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;

        while(!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;

            for(int i = 0;i<sz;i++) {
                BinaryTreeNode<Integer> node = q.poll();
                if(node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if(node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }

                if(mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if(fl == 1) maxi++;
        }
        return maxi;
    }
    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp = new HashMap<>();
        BinaryTreeNode<Integer> target = bfsToMapParents(root, mpp, start);
        int maxi = findMaxDistance(mpp, target);
        return maxi;
    }*/




    public static void main(String[] args) {
        StriverTrees.Node root = new StriverTrees.Node(3);
        root.left = new StriverTrees.Node(5);
        root.left.left = new StriverTrees.Node(6);
        Node target = root.left;
        root.left.left.right = new StriverTrees.Node(4);

        root.right = new StriverTrees.Node(1);
        root.right.left = new StriverTrees.Node(1);
        root.right.right = new StriverTrees.Node(8);
        //MINE WORKS-----------
        System.out.println(burnBT(root,target));

    }

//The offer method inserts an element if possible, otherwise returning false. This differs from the Collection. add method, which can fail to add an element only by throwing an unchecked exception.
    private static void markParentsofTree(Map<Node,Node> markParents,Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node curr = q.poll();

            if (curr.left!=null){
                q.add(curr.left);
                markParents.put(curr.left,curr);//key is the node,vaue is its parent
            }
            if (curr.right!=null){
                q.offer(curr.right);
                markParents.put(curr.right,curr);//key is the node,vaue is its parent
            }
        }

    }


    private static int burnBT(Node root,Node target){
        Map<Node,Node> nodeparents = new HashMap<>();
        markParentsofTree(nodeparents,root);//mark each node's parent
        //now we need an array to keep track of burnt nodes
        Map<Node,Boolean> isburnt = new HashMap<>();
        //which traversal will suite?? -> DFS will suite no BFS will also work, as now the tree will behave like a graph, and number of levels  = burn time
        Queue<Node> q = new LinkedList<>();
        q.add(target);
        isburnt.put(target,true);
        int time = 0;
        while (!q.isEmpty()){ //move to next level
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) { //iterate through current level
                Node curr = q.poll();
                if (curr.left!=null && isburnt.get(curr.left)==null){//if curr node is not visited, add to queue and mark it visited
                    isburnt.put(curr.left,true);
                    q.add(curr.left);
                }
                if (curr.right!=null && isburnt.get(curr.right)==null){//if curr node is not visited, add to queue and mark it visited
                    isburnt.put(curr.right,true);
                    q.add(curr.right);
                }
                if (nodeparents.get(curr)!=null && isburnt.get(nodeparents.get(curr))==null){//if curr node is not visited, add to queue and mark it visited
                    isburnt.put(nodeparents.get(curr),true);
                    q.add(nodeparents.get(curr));
                }
            }
        }
        return time-1;//since time period is asked and node target to node next takes 1 unit , not 2 unit


    }











}