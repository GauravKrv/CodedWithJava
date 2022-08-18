package StriverGraph;

import java.util.ArrayList;
//same as bridges almost - ry rum and understand
public class Q18ArticulationptStriver {
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer> >();

        for (int i = 0; i < n; i++)

                        adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        Q18ArticulationptStriver obj = new Q18ArticulationptStriver();
        obj.printArticulation(adj, n);

    }
    void printArticulation(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int vis[] = new int[n];
        int tin[] = new int[n];
        int low[] = new int[n];

        int isArticulation[] = new int[n];

        int timer = 0;
        for(int i = 0;i<n;i++) {
            if(vis[i] == 0) {
                dfs(i, -1, vis, tin, low, adj, timer, isArticulation);
            }
        }

        for(int i = 0;i<n;i++) {
            if(isArticulation[i] == 1) System.out.println(i);
        }
    }
    private void dfs(int i, int parent, int vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj, int timer, int isArticulation[]) {
        vis[i] = 1;
        tin[i] = low[i] = timer++;
        int child = 0;
        for(Integer x: adj.get(i)) {
            if(x == parent) continue;

            if(vis[x] == 0) {
                dfs(x, i, vis, tin, low, adj, timer, isArticulation);
                low[i] = Math.min(low[i], low[x]);

                if(low[x] >= tin[i] && parent != -1) { //here a diff than bridge
                    isArticulation[i] = 1;
                }
                child++;
            } else {
                low[i] = Math.min(low[i], tin[x]);
            }
        }
        if(parent != -1 && child > 1) isArticulation[i] = 1;//again check if i is articulation or not using second comdidion
        // here a differnc than bridge
    }

}

