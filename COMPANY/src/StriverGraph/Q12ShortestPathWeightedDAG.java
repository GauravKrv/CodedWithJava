package StriverGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Q12ShortestPathWeightedDAG {
//My code -- works
    public static void main(String[] args) {
        int v = 5;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        Graph_Weighted_DAG g = new Graph_Weighted_DAG();
        g.addEdge(0,new Pair(1,2),adj);
        g.addEdge(0,new Pair(4,1),adj);
        g.addEdge(1,new Pair(2,3),adj);
        g.addEdge(2,new Pair(3,6),adj);
        g.addEdge(4,new Pair(2,2),adj);
        g.addEdge(4,new Pair(5,4),adj);
        g.addEdge(5,new Pair(3,1),adj);

        //g.printGraph(adj);

        Stack<Integer> st = g.topSort(adj,v); //1st top sort traverse the current graph
      //  System.out.println(st);

        int[] shortestPaths = getShortestPathDAG(adj,v,st); // now get the shortest path using the top sorted stack

        System.out.println("Shortest paths from source 0 to ");
        for (int x =0;x<shortestPaths.length;x++) {
            System.out.println(x+" = "+shortestPaths[x]);
        }

    }

    private static int[] getShortestPathDAG(ArrayList<ArrayList<Pair>> adj, int v, Stack<Integer> st) {
        int dist[] = new int[v+1];
        Arrays.fill(dist,(int)1e9); // set as infinite initially
        int curr = st.pop(); //take the 1st node and fill its details explicitly before looping
        dist[curr]=0; //dist to source is 0

        for (Pair neighbr :adj.get(curr)) { //seting the nearest distances for 1st node
            if (dist[neighbr.node]>dist[curr]+neighbr.weight){ //if dist of neigh from source is gt dist to curr + weight of curr->neigh
                dist[neighbr.node] = dist[curr]+neighbr.weight; //then set new dist of neigh
            }
        }

        while (st.size()>0){ //st is the top sort
            curr=st.pop(); //now popping the stack and repeating the above for each node
            for (Pair neighbr :adj.get(curr)) {
                if (dist[neighbr.node]>dist[curr]+neighbr.weight){ //if dist of neigh from source is gt dist to curr + weight of curr->neigh
                    dist[neighbr.node] = dist[curr]+neighbr.weight; //then set new dist of neigh
                }
            }
        }
        return dist;
    }


}
