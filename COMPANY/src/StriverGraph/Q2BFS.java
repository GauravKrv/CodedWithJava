package StriverGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q2BFS {


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

    ArrayList<Integer> res = dFS(V,adj);

        g.print(res,V);
    }


    public static ArrayList<Integer> dFS(int V, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V];
        ArrayList<Integer> dfsRes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                dFSUtil(adj,dfsRes,i,vis);
            }
        }

        return dfsRes;
    }

    private static void dFSUtil(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsRes, int start, boolean[] vis) {

        vis[start] = true;
        dfsRes.add(start);

            for (Integer it:adj.get(start)){
                if (!vis[it]){
                    dFSUtil(adj, dfsRes, it, vis);
                }
            }
        }
        //while end
    }

