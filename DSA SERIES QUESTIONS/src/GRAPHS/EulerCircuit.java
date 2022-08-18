package GRAPHS;
import java.util.*;
import java.util.LinkedList;
/*given directed graph print/find euler circuit,
Euler ckt : start and ending vertex of the path is same,
need to visit every edge of the graph onlly one time

Given: graph is singly strongly connected graph
-- can only find euler circuit if graph has eulerian cycle
-- two conditions for eulerian cycle :
1]all vertex in the graph need to have non-zero degree [ belongs to single strongly connected graph]
2]each and every vertex, indegree and out degree need to be same

HIERHLoZERS

-- use two stack
//stact sizes : #edges + 1



 * */
public class EulerCircuit {

    static void pln(String s){
        System.out.println(s);
    }
    static void p(String s){System.out.println(s);}

    static void pf(String s,Object args){System.out.printf(s);}



    public static void main(String[] args) {
        p("helloooo");
    }
}

// A Java program to check if a given directed graph is Eulerian or not

// A class that represents an undirected graph


// This class represents a directed graph using adjacency list
class Graph5
{
    private int V; // No. of vertices
    private LinkedList<Integer> adj[];//Adjacency List
    private int in[];		 //maintaining in degree

    //Constructor
    Graph5(int v)
    {
        V = v;
        adj = new LinkedList[v];
        in = new int[V];
        for (int i=0; i<v; ++i)
        {
            adj[i] = new LinkedList();
            in[i] = 0;
        }
    }

    //Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        in[w]++;
    }

    // A recursive function to print DFS starting from v
    void DFSUtil(int v,Boolean visited[])
    {
        // Mark the current node as visited
        visited[v] = true;

        int n;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i =adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }

    // Function that returns reverse (or transpose) of this graph
    Graph5 getTranspose()
    {
        Graph5 g = new Graph5(V);
        for (int v = 0; v < V; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {
                g.adj[i.next()].add(v);
                (g.in[v])++;
            }
        }
        return g;
    }

    // The main function that returns true if graph is strongly
    // connected
    Boolean isSC()
    {
        // Step 1: Mark all the vertices as not visited (For
        // first DFS)
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Step 2: Do DFS traversal starting from the first vertex.
        DFSUtil(0, visited);

        // If DFS traversal doesn't visit all vertices, then return false.
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                return false;

        // Step 3: Create a reversed graph
        Graph5 gr = getTranspose();

        // Step 4: Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Step 5: Do DFS for reversed graph starting from first vertex.
        // Starting Vertex must be same starting point of first DFS
        gr.DFSUtil(0, visited);

        // If all vertices are not visited in second DFS, then
        // return false
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                return false;

        return true;
    }

    /* This function returns true if the directed graph has a eulerian
    cycle, otherwise returns false */
    Boolean isEulerianCycle()
    {
        // Check if all non-zero degree vertices are connected
        if (isSC() == false)
            return false;

        // Check if in degree and out degree of every vertex is same
        for (int i = 0; i < V; i++)
            if (adj[i].size() != in[i])
                return false;

        return true;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Graph5 g = new Graph5(5);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);

        if (g.isEulerianCycle())
            System.out.println("Given directed graph is eulerian ");
        else
            System.out.println("Given directed graph is NOT eulerian ");
    }
}
//This code is contributed by Aakash Hasija
