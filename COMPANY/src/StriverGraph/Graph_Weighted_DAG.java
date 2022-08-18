package StriverGraph;

import java.util.ArrayList;
import java.util.Stack;

public class Graph_Weighted_DAG {
     void printGraph(ArrayList<ArrayList<Pair>> adj){
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (Pair p :
                    adj.get(i)) {
                System.out.print(p.node + ", ");
            }
            System.out.println();
        }
    }

     void addEdge(int x, Pair y, ArrayList<ArrayList<Pair>> adj){
        adj.get(x).add(y);
    }

    public Stack<Integer> topSort(ArrayList<ArrayList<Pair>> adj,int v){
         boolean vis[] = new boolean[v+1];
         Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= v; i++) {
            if (!vis[i]){
                dfs(adj,v,st,vis,i);
            }
        }
        return st;
    }

    private void dfs(ArrayList<ArrayList<Pair>> adj, int v, Stack<Integer> st, boolean[] vis, int i) {
        vis[i]=true;
        for (Pair pair:
             adj.get(i)) {
            if (!vis[pair.node]){
                dfs(adj, v, st, vis, pair.node);
            }
        }
        st.push(i);
    }
}
