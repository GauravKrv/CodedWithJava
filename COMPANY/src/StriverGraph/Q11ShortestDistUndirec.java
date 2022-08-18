package StriverGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q11ShortestDistUndirec {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 8;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        Graph_Disc_Und g = new Graph_Disc_Und(); //for using the functions of undirected disconnected graphs

        g.addEdge(adj, 0, 1);
        g.addEdge(adj, 0, 3);
        g.addEdge(adj, 1, 2);
        g.addEdge(adj, 3, 4);
        g.addEdge(adj, 5, 4);
        g.addEdge(adj, 5, 6);
        g.addEdge(adj, 2, 6);
        g.addEdge(adj, 6, 7);
        g.addEdge(adj, 6, 8);

        int[] dist = shortestPath(adj, V, 0);
        for (int i = 0; i <= V; i++) {
            System.out.println("dist from "+i+" = "+dist[i]);
        }

    }

    private static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int N, int src) {

        int[] dist = new int[N+1];
        for (int i = 0; i <= N; i++)
            dist[i] = 1000000000; //initialise initial dist[i] (i.e distance bw source and ith vertex) as infinite

        Queue<Integer> q = new LinkedList<>();
        q.add(src); //start from source
        dist[src]  = 0; //dist of src from src is 0
        while (!q.isEmpty()) {
            int currentnode = q.poll(); //is fine till here -> simple bfs steps

            for (int neighbour : adj.get(currentnode)) { //neightbr
                if (dist[neighbour] >  dist[currentnode]+1) { //yes if dist(x) +1 < distx
                    dist[neighbour] = dist[currentnode] + 1; //update nodes distance
                    q.add(neighbour); //add neighbour to queue
                }
            }
        }


        return dist;
    }

}
