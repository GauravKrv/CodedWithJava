package StriverGraph;

import java.util.ArrayList;

public class Q8Cycle_Det_Directed_Graph {

        public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int V = 9;
            for (int i = 0; i <= V; i++) {
                adj.add(new ArrayList<>());
            }

            Graph_Disc_Direc g = new Graph_Disc_Direc(); //for using the functions of undirected disconnected graphs

            g.addEdge(adj,1,2);
            g.addEdge(adj,2,3);

            g.addEdge(adj,3,4);
            g.addEdge(adj,4,5);
            g.addEdge(adj,6,5);
            g.addEdge(adj,8,9);
//            g.addEdge(adj,7,9); -- still has cycle
            g.addEdge(adj,9,7);
            g.addEdge(adj,7,8);

            System.out.println(isCycle(adj,V));
        }
//WORKS
        private static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int v) {
            boolean vis[] = new boolean[v+1];
            boolean dfsvis[] = new boolean[v+1];

            for (int i = 1; i <= v; i++) {
                if (!vis[i]){
                    if (isCycleDFSUtil(adj,i,vis,-1,dfsvis)) return true;
                }
            }
            return false;
        }

//        WORKS FINE -- MINE -- [Idea from striver]
    private static boolean isCycleDFSUtil(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, int par, boolean[] dfsvis) {
        vis[i]=dfsvis[i]=true;
        for (int x:adj.get(i)){
            if (!vis[x])
            {
                if (isCycleDFSUtil(adj, x, vis, i, dfsvis)){
                    return true;
                }
            }else if (dfsvis[x]){//since we have reached a node which is already visited in the current dfs traversal
                return true;
            }

        }
        dfsvis[i] = false;//set curr node as false since it is already visited and no cycle occured

        return false;
    }

}
