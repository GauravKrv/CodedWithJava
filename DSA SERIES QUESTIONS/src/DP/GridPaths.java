package DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GridPaths {

    static int V;
    static ArrayList<ArrayList<Vertex>> adjList;
    static class Vertex{
        int x, y,vertexNum;
        Vertex(int x,int y,int vertexNum){
            this.x = x;
            this.y = y;
            this.vertexNum = vertexNum;
        }
    }

    static void addEdge(){

    }
    static int sum(int a , int b){
        return a+b;
    }


    public static void topologicalOrdering(ArrayList<ArrayList<Integer>> adj){
        int V = adj.size();
        Integer[] indegree = new Integer[V];
        for (int i=0;i<V;i++)
            indegree[i] = 0;//initialising each vertexs' indegree as zero as the
        // startig vertex will always have zero indegree so we make all zero and find
        // whether it is neighbour of any vertex, if it is so then we increase its
        // index's value in the indegree array by one

        for (int i=0;i<V;i++){
            for( int l =0;l< adj.get(i).size();l++){
                indegree[adj.get(i).get(l)] = indegree[adj.get(i).get(l)] + 1;
                //adding degrees to each vertex and its neighbours

            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<V;i++) {
            if (indegree[i] == 0) q.add(i);//adding all the vertex with 'zero' indegree in queue
        }

        while (!q.isEmpty()){
            int j = q.peek();
            q.remove();//tkaing the first vertex with zero indegree and iterating its
            // edeged neighbours and decreasing their indegree
            System.out.print(j+"->");//printin the vertex before its neighbours gets visited
            for (int k=0;k<adj.get(j).size();k++){
                indegree[adj.get(j).get(k)]  = indegree[adj.get(j).get(k)] - 1;

                if (indegree[adj.get(j).get(k)] == 0){
                    q.add(adj.get(j).get(k));//when any edeged neighbours' indegree is decreased to 0 then ad it to the queue
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xCoord = sc.nextInt();
        int yCoord = sc.nextInt();
         V = (xCoord+1)*(yCoord+1);

         adjList = new ArrayList<ArrayList<Vertex>>();
        for (int i = 0; i < V; i++) {
            adjList.add(i, new ArrayList<Vertex>());
        }


    }

}
