package StriverGraph;

import java.util.ArrayList;

public class Graph_Disc_Und {


     static void print(ArrayList<Integer> res, int v) {

        for (Integer x: res) {
            System.out.print(x+" ");
        }

    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
