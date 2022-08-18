package StriverGraph;

import java.util.ArrayList;

public class Q5CycleDetectDFS_Undirected {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 8;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        Graph_Disc_Und g = new Graph_Disc_Und(); //for using the functions of undirected disconnected graphs

        g.addEdge(adj,1,3);
        g.addEdge(adj,3,4);

        g.addEdge(adj,5,2);
        g.addEdge(adj,8,5);
        g.addEdge(adj,5,6);
        g.addEdge(adj,6,7);

        g.addEdge(adj,7,8);

        System.out.println(isCycle(adj,V));
    }
//WORKS
    private static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v+1];
        for (int i = 1; i <= v; i++) {
            if (!vis[i]){
                if (isCycleDFSUtil(adj,i,vis,-1)) return true;
            }
        }
        return false;
    }

    private static boolean isCycleDFSUtil(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, int par) {

        vis[i] = true;
        for (int x:adj.get(i)){
            if (vis[x]==false){
                if (isCycleDFSUtil(adj, x, vis, i)){
                    return true;
                }
            } else if (x != par) {
                return true;
            }
        }
        return false;
    }
}
