package DSACRACKERGRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private final ArrayList<ArrayList<Integer>> adj;
    private final int V;

    public Graph(int v) {
        adj = new ArrayList<>(v);
        V = v;

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }
//Non-static field 'adj' cannot be referenced from a static context - so make funcitons non static
    public void addEdge(int u, int v)
    {

            adj.get(u).add(v);

    }

    public void printGraph(){

    }
//checks if curr graph has a cycle or not -- WORKS
    public boolean isCyclic(){
        //
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        Arrays.fill(parent,-1);

        for (int i = 0; i < V; i++) {

                for (int j = 0; j < adj.get(i).size(); j++) {
                    //if current neighbr is already visited
                    if (visited[adj.get(i).get(j)]){
                        //and if curr neighbr is not a parent of curr vertex
                        if (parent[i]!=adj.get(i).get(j)){
                            return true;
                        }
                    }else {
                        //parent of curr neighbr is curr vetex 'i'
                        parent[adj.get(i).get(j)] = i;
                    }
                }
                visited[i]= true;

        }
        return false;
    }
//WORKS --KAHN ALGO
    public void printTopologicalSort(){
        int[] indegreee = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indegreee[adj.get(i).get(j)] = indegreee[adj.get(i).get(j)]+1;
            }
        }
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i =0;i<indegreee.length;i++) {
            if (indegreee[i]==0)st.push(i);
        }

        while (!st.isEmpty()){
            int temp = st.poll();
            System.out.print(temp+" -> ");
            for (int i=0;i<adj.get(temp).size();i++){
                int in = indegreee[adj.get(temp).get(i)]-1;
                indegreee[adj.get(temp).get(i)] = in;
                if (in==0) st.push(adj.get(temp).get(i));
            }
        }

    }





}

class main{
    public static void main(String[] args) {
        int v = 5;
        Graph g = new Graph(v);

        g.addEdge(0,1);

        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);


        g.addEdge(3,4);
//        g.addEdge(2,1,d);
//        g.addEdge(2,3,d);

        System.out.println(g.isCyclic());
        g.printTopologicalSort();
    }
}


