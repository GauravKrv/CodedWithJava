package StriverGraph;

import java.util.ArrayList;
import java.util.Arrays;
//This also works - use this
public class Q17Bridges {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 4;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        Graph_Disc_Und g = new Graph_Disc_Und(); //for using the functions of undirected disconnected graphs

        g.addEdge(adj, 0, 1);
        g.addEdge(adj, 1, 2);
        g.addEdge(adj, 2, 0);
        g.addEdge(adj, 1, 3);
        g.addEdge(adj, 3, 4);
//        g.addEdge(adj, 2, 6);
//        g.addEdge(adj, 6, 7);
//        g.addEdge(adj, 6, 8);

        ArrayList<Pair> ans = getBridges(adj,V+1);
        System.out.println("Bridges are :");
        for (Pair p :ans) {
            System.out.println(p.node+" -> "+ p.weight);
        }
    }

    private static ArrayList<Pair> getBridges(ArrayList<ArrayList<Integer>> adj, int v) {
        int low[] = new int[v];
        int discovery[] = new int[v];
        boolean vis[] = new boolean[v];
        int timer = 0;
        ArrayList<Pair> bridges = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]){
                dfs(i,adj,v,bridges,vis,-1,discovery,low,timer);
            }
        }

        return bridges;

    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, int v, ArrayList<Pair> bridges,
                            boolean[] vis, int parent, int[] discovery, int[] low, int timer) {
        vis[i] = true;
        discovery[i]=timer;
        low[i]=timer; //minimum low can be discovery[i] only
        timer++;
        //same

        for (int x : adj.get(i)){
            if (parent==x)continue; //if adjacent is parent - ignore

            if (vis[x]==false){
                dfs(x,adj,v,bridges,vis,i,discovery,low,timer); //do dfs if not visited

               low[i] = Math.min(low[i],low[x]);////update the low from Min of (low[self],low[adjacent]) after visiting the adjacent

                if (low[x]>discovery[i]){ //if low[adjacent] is greater than discovery[self] then this is a bridge pair
                    //bridge
                    bridges.add(new Pair(x,i)); //add to bridge list
                }
            } else  {  //if visited and not parent => backedge
                //backedge
                low[i] = Math.min(low[i],discovery[x]); //update the low from Min of (low[self],discovery[adjacent])
            }

        }
    }
}
