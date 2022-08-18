package StriverGraph;

import java.util.ArrayList;
import java.util.Stack;

public class Q9TopOrdering {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        Graph_Disc_Direc g = new Graph_Disc_Direc(); //for using the functions of undirected disconnected graphs

        g.addEdge(adj,5,0);
        g.addEdge(adj,4,0);

        g.addEdge(adj,5,2);
        g.addEdge(adj,2,3);
        g.addEdge(adj,3,1);
        g.addEdge(adj,4,1);


        Stack<Integer> st = topOrderDFS(adj,V);
        while (st.isEmpty()==false){
            System.out.print(" -> "+st.pop());
        }
    }
    //WORKS
    private static Stack<Integer> topOrderDFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v+1];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= v; i++) {
            if (!vis[i]){
                topOrderDFS(adj,i,vis,st);
            }
        }
        return st;

    }

    private static void topOrderDFS(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, Stack<Integer> st) {
        vis[i]=true; //make current neighbr visited
        for (int x : adj.get(i)) {
            if (!vis[x]) { //if curr neighbr is not visited
                topOrderDFS(adj, x, vis, st); //do dfs
            }
            }
        st.push(i);//push whichever gets finished or visited first i.e it has visited all its neighbrs then only push
    }
}
