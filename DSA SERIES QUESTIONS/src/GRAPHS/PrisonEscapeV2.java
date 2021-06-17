package GRAPHS;

import java.util.*;

public class PrisonEscapeV2 {
    static class Vertex{
        int l,w,vertexNum;
        Vertex(int l,int w,int vertexNum){
            this.l = l;
            this.w = w;
            this.vertexNum = vertexNum;
        }
    }

    static int sub(int a,int b){
        return Math.abs(a-b);
    }
    static int square(int a){
        return a*a;
    }
    static int sum(int a , int b){
        return a+b;
    }

    static boolean isNeighbour(Vertex v1,Vertex v2){
        if (sum(square(sub(v1.l,v2.l)),square(sub(v1.w,v2.w))) <= square(200))
            return true;
        else
            return false;
    }

    static void addVertex(ArrayList<ArrayList<Vertex>> adj,Vertex v,int vertexCount){
        adj.get(vertexCount).add(v);
    }

    static char isBoundaryVertex(Vertex v,int width){
        if (v.w<=100) return 's';//south boundary vertices
        else if (sub(width, v.w)<=100) return 'n';//north boundary vertices
        else return 'm';//midVertices
    }

    /* static int countNorth=0;
    static int countSouth=0;*/
    static void addBoundary(Vertex v,int width,HashMap<Integer,Vertex> boundNorth,HashMap<Integer,Vertex> boundSouth){
        if (isBoundaryVertex(v,width)=='n'){
            boundNorth.put(v.vertexNum,v);
        }else if (isBoundaryVertex(v,width)=='s'){
            boundSouth.put(v.vertexNum,v);
        }
    }

    static void addNeighbour(ArrayList<ArrayList<Vertex>> adj,Vertex v1,Vertex v2){
        if (isNeighbour(v1,v2)){
            addVertex(adj,v2,v1.vertexNum);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int width = sc.nextInt();
        int V = sc.nextInt();

        ArrayList<ArrayList<Vertex>> adjListArray = new ArrayList<ArrayList<Vertex>>();
        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<Vertex>());
        }

        // System.out.println("Enter coordinates of each soldier : ");
        for (int i =0;i<V;i++){
            Vertex v = new Vertex(sc.nextInt(),sc.nextInt(),i);
            addVertex(adjListArray,v,i);
        }

        //adding neighbours [undirected edges]
        for (int i=0;i<V;i++){
            for (int j=0;j<V;j++){
                if (i!=j){
                    addNeighbour(adjListArray,adjListArray.get(i).get(0),adjListArray.get(j).get(0));
                }
            }
        }

        // printGraph(adjListArray);
        HashMap<Integer,Vertex> boundNorth = new HashMap<Integer, Vertex>();
        HashMap<Integer,Vertex> boundSouth = new HashMap<Integer, Vertex>();

        for (int i=0;i<V;i++){
            addBoundary(adjListArray.get(i).get(0),width,boundNorth,boundSouth);
        }

          connectedComponents(adjListArray,boundNorth,boundSouth);

    }
 

    static void connectedComponents(ArrayList<ArrayList<Vertex>> adj,HashMap<Integer,Vertex> boundNorth,HashMap<Integer,Vertex> boundSouth)
    {
        int V = adj.size();
        ArrayList<Integer> adjFinal =  new ArrayList<Integer>();
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                // print all reachable vertices
                // from v
                DFSUtil(adj,v, visited,adjFinal);
                adjFinal.add((adjFinal.size()*2)*-1);

                // System.out.println();
            }
        }
        if (checkExtremes(boundNorth,boundSouth,adjFinal))
            System.out.println(1);
        else System.out.println(0);

    }

    static boolean checkExtremes(HashMap<Integer,Vertex> boundNorth,HashMap<Integer,Vertex> boundSouth,ArrayList<Integer> adjFinal){
        boolean north = false;
        boolean south = false;
        for (int i=0;i<adjFinal.size();i++){
            if (adjFinal.get(i)<0){
                north = false;
                south = false;
            }
            if (boundNorth.containsKey(adjFinal.get(i))) north = true;
            else if (boundSouth.containsKey(adjFinal.get(i))) south = true;

            if (north && south)
                return true;

        }

        return north && south;
    }
    static void DFSUtil(ArrayList<ArrayList<Vertex>> adj,int v, boolean[] visited,ArrayList<Integer> adjFinal)
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        // System.out.print(v + " ");
        adjFinal.add(v);

        // Recur for all the vertices
        // adjacent to this vertex
        for (Vertex x : adj.get(v)) {
            if (!visited[x.vertexNum])
                DFSUtil(adj,x.vertexNum, visited,adjFinal);

        }
    }

}


