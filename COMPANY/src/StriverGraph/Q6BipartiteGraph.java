package StriverGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q6BipartiteGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 9;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        Graph_Disc_Und g = new Graph_Disc_Und(); //for using the functions of undirected disconnected graphs
        //G1: BIPARTITE
//        g.addEdge(adj,1,2);
//        g.addEdge(adj,2,3);
//        g.addEdge(adj,3,4);
//        g.addEdge(adj,3,5);
//        g.addEdge(adj,4,6);
//        g.addEdge(adj,5,7);
//        g.addEdge(adj,6,8);
//        g.addEdge(adj,7,8);
//        g.addEdge(adj,9,8);

        //G2:--NOT BIPARTITE
        g.addEdge(adj,2,1);
        g.addEdge(adj,3,3);
        g.addEdge(adj,2,4);
        g.addEdge(adj,4,6);
        g.addEdge(adj,5,3);
        g.addEdge(adj,6,5);


        System.out.println(isBipartite(adj,V));
    }

    private static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v+1];
        int color[] = new int[v+1];
        Arrays.fill(color,-1);
        for (int i = 1; i <= v; i++) {
            if (!vis[i]){
                if (!isBipartiteUtil(adj, i, vis, color)) return false;
            }
        }
        return true;
    }
//WORKS
    private static boolean isBipartiteUtil(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, int[] color) {
        color[i]=0;//COLOR INITIAL
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()){
            int curr = q.poll();

            vis[curr] = true;//VISITED AND NOW DO OPEATIONS
            for (int x : adj.get(curr)) { //COLOR ADJACENT NODES
                if (color[x]==-1){   //IF -1 THEN HAVE TO COLOR

                    color[x]=1-color[curr]; //setting opposiite color to adjacents
                    q.add(x); //IF NOT VISITED THEN ADD TO QUEUE

                } else if (color[x] == color[curr]) { //ELSE IF ADJ NODES HVE SAME COLOR
                    return false;
                }

            }
        }
        return true;
    }
}
