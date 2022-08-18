package StriverGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q4CycleDetectBFS_Undirected {
   static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 8;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        Graph_Disc_Und g = new Graph_Disc_Und(); //for using the functions of undirected disconnected graphs

        g.addEdge(adj,1,2);
        g.addEdge(adj,4,2);
        g.addEdge(adj,7,2);
        g.addEdge(adj,7,6);
        g.addEdge(adj,6,4);


        g.addEdge(adj,5,3);

        System.out.println(isCycle(adj,V));
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v];
        for (int i = 1; i <= v; i++) {
            if (!vis[i]){
                if (isCycleUtil(adj,i,v,vis)) return true;
            }
        }
        return false;
    }

    private static boolean isCycleUtil(ArrayList<ArrayList<Integer>> adj, int start, int v, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,-1));
        vis[start] = true;

        while (!q.isEmpty()){

            int currnode = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (Integer x : adj.get(currnode)) {
                if (!vis[x]) {
                   q.add(new Pair(x,currnode)); //if x is not visited -- add to queue with its info as its parent = currnode
                   vis[x] = true;
                }
                else if (parent != x) return true; //if x is already visited & since x is adjacent of currnode and still x is not parent of currnode
            }
        }
        return false;

    }
}
