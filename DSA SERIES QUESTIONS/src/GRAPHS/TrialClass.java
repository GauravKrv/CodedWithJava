package GRAPHS;

import java.util.*;

public class TrialClass {
   static Scanner sc = new Scanner(System.in);
    static void printAdjacencyMatrix(int vertices, int edges){

        int startVertex,endVertex;
        int[][] arr = new int[vertices][vertices];

        System.out.println("enter the start and end vertex pairs of each edge : ");
        for (int i=0;i<edges;i++){
            startVertex = sc.nextInt();
            endVertex = sc.nextInt();
            arr[startVertex][endVertex] = 1;
            arr[endVertex][startVertex] = 1;

        }

        System.out.println("Adjacency matrix of the entered graph : ");

        System.out.println("\t    0-1-2-3-4");
//        System.out.println("----------------");
        for (int i=0;i<vertices;i++){
            System.out.print("Node "+i+"| ");
            for (int j = 0;j<vertices;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
/*
INPUT
0 1
0 4
1 2
1 3
1 4
2 3
3 4
* */


    static void insertEdges(ArrayList<ArrayList<Integer>> adj,int u,int v,int directed){
        if (directed==1){
            adj.get(u).add(v);
        }
        if (directed==-1){
            adj.get(v).add(u);
        }
        if (directed==0) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for (int i=0;i<adj.size();i++){
            System.out.print(i);
            for (int j =0;j<adj.get(i).size();j++){
                System.out.print(" ->"+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    static void adjacencyList(int vertices){
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        System.out.println("Enter neighbbours of each vertex ");
        for (int i = 1;i<vertices;i++){
            System.out.print("For vertex "+i+" enter its neighbour count and neighbours ");
            int numNeighbr = sc.nextInt();
            ArrayList<Integer> neighbr = new ArrayList<>();
            for (int k=1;k<=numNeighbr;k++){
                neighbr.add(sc.nextInt());
            }


            adjList.put(i,neighbr);
        }
        System.out.println("Adjacency list : ");
      /*  adjList.forEach((vertex, neighbr) ->
              //  neighbr.toArray()
                System.out.println(vertex + " => "+ neighbr));
*/
        Set<Integer> setvertex = adjList.keySet();//Using Set to call KeySet()
        Iterator<Integer> iterator = setvertex.iterator();
        while(iterator.hasNext()) {
            Integer vertex = iterator.next();
            ArrayList<Integer> neighbr = adjList.get(vertex);
            System.out.print(vertex);
            for (int i=0;i<neighbr.size();i++){
                System.out.print("-> "+neighbr.toArray()[i]);

            }
            System.out.println();
        }
       /* for (int i = 1;i<=vertices;i++){*/
          //  System.out.println(adjList.values());

    }

    static void adjacencyList2(int vertices){
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        System.out.println("Enter neighbbours of each vertex ");
        for (int i = 1;i<vertices;i++){
            System.out.print("For vertex "+i+" enter its neighbour count and neighbours ");
            int numNeighbr = sc.nextInt();
            ArrayList<Integer> neighbr = new ArrayList<>();
            for (int k=1;k<=numNeighbr;k++){
                neighbr.add(sc.nextInt());
            }


            adjList.put(i,neighbr);
        }
        System.out.println("Adjacency list : ");
      /*  adjList.forEach((vertex, neighbr) ->
              //  neighbr.toArray()
                System.out.println(vertex + " => "+ neighbr));
*/
        Set<Integer> setvertex = adjList.keySet();//Using Set to call KeySet()
        Iterator<Integer> iterator = setvertex.iterator();
        while(iterator.hasNext()) {
            Integer vertex = iterator.next();
            ArrayList<Integer> neighbr = adjList.get(vertex);
            System.out.print(vertex);
            for (int i=0;i<neighbr.size();i++){
                System.out.print("-> "+neighbr.toArray()[i]);

            }
            System.out.println();
        }
        /* for (int i = 1;i<=vertices;i++){*/
        //  System.out.println(adjList.values());

    }
    public static void main(String[] args) {


        System.out.println("the number of vertices in the graph");
        int vertices = 5;

       // System.out.println("Enter the number of edges in the graph");
       // int edges = sc.nextInt();


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);
        for (int i=0;i<vertices;i++){
             adj.add(new ArrayList<Integer>());
        }
       // printAdjacency(n+1,edges);
        //adjacencyList(vertices+1);
        insertEdges(adj,0,1,0);
        insertEdges(adj,0,4,0);
        insertEdges(adj,1,2,0);
        insertEdges(adj,1,3,0);
        insertEdges(adj,1,4,0);
        insertEdges(adj,2,3,0);
        insertEdges(adj,3,4,0);


       /* System.out.println("ENter the edges in the graph");
        for (int i=0;i<edges;i++){
            insertEdges(adj,sc.nextInt(),sc.nextInt(),0);
        }*/
        printGraph(adj);
        printAdjacencyMatrix(5,7);

        System.out.println();


    }
}
/*INPUT :
Enter the number of vertices in the graph
10
Enter the number of edges in the graph
13
enter the start and end vertex pairs of each edge :

1 2
1 3
1 4
4 5
4 8
5 6
5 7
6 8
6 9
9 10
7 6
8 9
2 3


Adjacency List

Enter the number of vertices in the graph
10
Enter the number of edges in the graph
13
Enter neighbbours of each vertex
For vertex 1 enter its neighbour count and neighbours 3 2 3 4
For vertex 2 enter its neighbour count and neighbours 2 1 3
For vertex 3 enter its neighbour count and neighbours 2
1 2
For vertex 4 enter its neighbour count and neighbours 3 1 5 8
For vertex 5 enter its neighbour count and neighbours 3 4 6 7
For vertex 6 enter its neighbour count and neighbours 4 5 7 8 9
For vertex 7 enter its neighbour count and neighbours 2 5 6
For vertex 8 enter its neighbour count and neighbours 3 4 6 9
For vertex 9 enter its neighbour count and neighbours 3 6 8 10
For vertex 10 enter its neighbour count and neighbours 1 9
For vertex 11 enter its neighbour count and neighbours 0 0
For vertex 12 enter its neighbour count and neighbours For vertex 13 enter its neighbour count and neighbours 0
Adjacency list :
[[2, 3, 4], [1, 3], [1, 2], [1, 5, 8], [4, 6, 7], [5, 7, 8, 9], [5, 6], [4, 6, 9], [6, 8, 10], [9], [], [], []]


*
* */
