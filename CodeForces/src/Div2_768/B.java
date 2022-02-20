package Div2_768;

import CodeForces.CodeForces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class B extends CodeForces {
    static void solution(int n,int[] arr){
        int count = 1,op=0;
        int i = n-1;
        while(i>0){
            if (arr[i-1]==arr[i]){
                count++;
                i--;
            }else{
                int temp = i;
                i-=count;
                if (i>=0)
                arr[i] = arr[temp];
                count*=2;
                op++;
            }

        }
        System.out.println(op);
    }

    public static void main(String[] args) {
        int t = I();
        while (t-- > 0) {
            int n = I();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = I();
            }

            solution(n, a);
        }
    }


}

class Cf771A extends CodeForces{


    static void reverse(int[] a,int s,int e){
        while (s<e){
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }

    static void solution(int n,int[] a){

        int min = Integer.MAX_VALUE;
        int idx = 0,start = 0;
        while (start+1<n){
            for (int i = start; i < n; i++) {
//                int t = min;
                if (a[i]<=min){
                    min = a[i];
                    idx = i;
                }

            }
            if (idx==0||idx==start){
                start+=1;
                min = a[start];
                idx = start;
            }else {
                break;
            }
        }
        if (start!=idx) {
            reverse(a, start, idx);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }

    }
    public static void main(String[] args) {
        int t = I();
        while (t-- > 0) {
            int n = I();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = I();
            }

            solution(n, a);
            System.out.println();
        }
    }


}

class Cf771B extends CodeForces{


    static void swap(int[] a,int s,int e){
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;

    }

    static void solution(int n,int[] a){


      while (true){
          boolean swapped = false;
          for (int i = 0; i < n; i++) {
              if (i+1<n && (a[i]+a[i+1])%2==1 && a[i]>a[i+1]){
                  swap(a,i,i+1);
                  swapped = true;
              }
          }
          if (swapped==false){
              break;
          }
      }
     // printArray(a);
      boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (i+1<n&&a[i]>a[i+1]){
                flag = false;
                break;
            }
        }

        if (flag){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
    public static void main(String[] args) {
        int t = I();
        while (t-- > 0) {
            int n = I();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = I();
            }

           // printArray(a);
            solution(n, a);
        }
    }


}

class Cf771C extends CodeForces {
    // Stores the parent of each vertex
    static int []parent = new int[1000000];

    // Function to find the topmost
// parent of vertex a
    static int root(int a)
    {

        // If current vertex is
        // the topmost vertex
        if (a == parent[a])
        {
            return a;
        }

        // Otherwise, set topmost vertex of
        // its parent as its topmost vertex
        return parent[a] = root(parent[a]);
    }

    // Function to connect the component
// having vertex a with the component
// having vertex b
    static void connect(int a, int b)
    {

        // Connect edges
        int ra = root(a);
        int rb = root(b);

        if (ra != rb) {
            parent[rb] = ra;
        }
    }

    // Function to find unique top most parents
    static void connectedComponents(int n)
    {
        HashSet<Integer> s = new HashSet<Integer>();

        // Traverse all vertices
        for (int i = 0; i < n; i++)
        {

            // Insert all topmost
            // vertices obtained
            s.add(parent[i]);
        }

        // Print count of connected components
        System.out.println(s.size());
    }

    // Function to print answer
    static void printAnswer(int N,ArrayList<int[]> edges)
    {

        // Setting parent to itself
        for (int i = 0; i <= N; i++)
        {
            parent[i] = i;
        }

        // Traverse all edges
        for (int i = 0; i < edges.size(); i++)
        {
            connect(edges.get(i)[0], edges.get(i)[1]);
        }

        // Print answer
        connectedComponents(N);
    }

    public static void main(String[] args)
    {
        int t = I();
        while (t-->0){
            int n = I();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = I();
            }
            ArrayList<int[]> ar = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (a[i]>a[j]){
                        int[] ed = {i,j};
                        ar.add(ed);

                    }
                }
            }

            for (int i = 0; i < ar.size(); i++) {
                System.out.println("{ "+ar.get(i)[0]+", "+ar.get(i)[1]+"},");
            }
            printAnswer(n, ar);

//
        }

    }
}

//copied below in my own code
class GFG{

    // Stores the parent of each vertex
    static int []parent = new int[1000000];

    // Function to find the topmost
// parent of vertex a
    static int root(int a)
    {

        // If current vertex is
        // the topmost vertex
        if (a == parent[a])
        {
            return a;
        }

        // Otherwise, set topmost vertex of
        // its parent as its topmost vertex
        return parent[a] = root(parent[a]);
    }

    // Function to connect the component
// having vertex a with the component
// having vertex b
    static void connect(int a, int b)
    {

        // Connect edges
        a = root(a);
        b = root(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    // Function to find unique top most parents
    static void connectedComponents(int n)
    {
        HashSet<Integer> s = new HashSet<Integer>();

        // Traverse all vertices
        for (int i = 0; i < n; i++)
        {

            // Insert all topmost
            // vertices obtained
            s.add(parent[i]);
        }

        // Print count of connected components
        System.out.println(s.size());
    }

    // Function to print answer
    static void printAnswer(int N,int [][] edges)
    {

        // Setting parent to itself
        for (int i = 0; i <= N; i++)
        {
            parent[i] = i;
        }

        // Traverse all edges
        for (int i = 0; i < edges.length; i++)
        {
            connect(edges[i][0], edges[i][1]);
        }

        // Print answer
        connectedComponents(N);
    }

    // Driver Code
    public static void main(String[] args)
    {

        // Given N
        int N = 8;

        // Given edges
        int [][]edges = {{ 1, 0 }, { 0, 2 },
                { 5, 3 }, { 3, 4 },
                { 6, 7 }};

        // Function call
        printAnswer(N, edges);
    }
}

//below didnt worked
class Graph {
    private int V; // No. of vertices in graph.

    private LinkedList<Integer>[] adj; // Adjacency List
    // representation

    ArrayList<ArrayList<Integer> > components
            = new ArrayList<>();

    @SuppressWarnings("unchecked") Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int u, int w)
    {
        adj[u].add(w);
    }

    void DFSUtil(int v, boolean[] visited,
                 ArrayList<Integer> al)
    {
        visited[v] = true;
        al.add(v);
        System.out.print(v + " ");
        Iterator<Integer> it = adj[v].iterator();

        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFSUtil(n, visited, al);
        }
    }

    void DFS()
    {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            if (!visited[i]) {
                DFSUtil(i, visited, al);
                components.add(al);
            }
        }
    }

    int ConnecetedComponents() { return components.size(); }
}