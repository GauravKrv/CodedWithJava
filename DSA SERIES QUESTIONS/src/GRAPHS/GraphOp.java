package GRAPHS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphOp {

   public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
  // public static int V = adj.size();

    static void addEdge( int u, int v, int directed) {
        if (directed == 0) {
            adj.get(u).add(v);
        } else if (directed == 1) {
            adj.get(u).add(v);
        } else {
            adj.get(v).add(u);
        }
    }

    static void printGraph() {
        int V = adj.size();
        for (int i = 0; i < V; i++) {
            ArrayList currV = adj.get(i);
            System.out.print(i + "-> ");
            for (int j = 0; j < currV.size(); j++)
                System.out.print(" " + currV.get(j));

            System.out.println();
        }
    }

    static void BFS() {
        System.out.println("BFS TRAVERSAL OF THE GRAPH : ");
        int V = adj.size();
        boolean visited[] = new boolean[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            parent[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {

            int temp = q.poll();

            System.out.print(temp + " ");

            for (int i = 0; i < adj.get(temp).size(); i++) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    parent[i] = temp;
                 }
            }
        }
        System.out.println();
    }

    static void dFS() {

        System.out.println("DFS TRAVERSAL OF THE GRAPH : ");
        int V = adj.size();
        int comp = 1;
        boolean visited[] = new boolean[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            parent[i] = -1;
        }


        for (int i=0; i<V; i++){
            int currVertex = i;
            if (!visited[i]){  //If ith vertex is not visited as in case of disconnected graph then call dfsUtil
                System.out.print("Component "+comp++ +" => ");//will seperate disconnected components
                 dFSUtil(visited,parent,currVertex);
                System.out.println();
            }
        }

        System.out.println();
    }

    static void dFSUtil(boolean[] visited,int[] parent, int currVertex){
     visited[currVertex] = true;
        System.out.print(currVertex+" -> ");
     for (int i=0;i<adj.get(currVertex).size();i++){
         int l = adj.get(currVertex).get(i);
         if (!visited[l]){
             parent[l] = currVertex;
             dFSUtil(visited, parent, l);
         }
     }

     
    }

    static boolean isCyclic(){
        int V = adj.size();
        boolean visited[] = new boolean[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            parent[i] = -1;
        }

        for (int i =0; i<V; i++){
            if(isCyclicUtil(i,parent,visited))
                return true;
        }

        return false;
    }

    private static boolean isCyclicUtil(int currVertex, int[] parent,boolean[] visited) {
        visited[currVertex] = true;

        for (int i=0; i<adj.get(currVertex).size();i++){

            if (!visited[i])
            parent[i] = currVertex;

            if (visited[i] && parent[currVertex]==parent[i]) { //if i is visited and parent of i = parent of currVertex => cycle exists
                return true;
            }
            else
                isCyclicUtil(i, parent, visited);
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("Enter the number of vertices in the graph : ");
        Scanner sc = new Scanner(System.in);



        int v = sc.nextInt();
        for (int i=0;i<v;i++)
            adj.add(new ArrayList<Integer>());

        addEdge(5, 2, 1);
        addEdge(5, 0, 1);
        addEdge(4, 0, 1);
        addEdge( 4, 1, 1);
        addEdge( 2, 3, 1);
        addEdge( 3, 1, 1);

        printGraph();
        BFS();
        dFS();
    }

    /*OP:
    6
0
1
2 ->3
3 ->1
4 ->0 ->1
5 ->2 ->0
    * */
}

