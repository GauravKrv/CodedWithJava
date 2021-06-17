package GRAPHS;

    // A Java Program to detect cycle in an undirected graph
import java.util.Iterator;
import java.util.LinkedList;
    // This class represents a
// directed graph using adjacency list
// representation
   public class UndirectedCycle
    {

        // No. of vertices
        private int V;

        // Adjacency List Represntation
        private LinkedList<Integer> adj[];

        // Constructor
        UndirectedCycle(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for(int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge
        // into the graph
        void addEdge(int v,int w)
        {
            adj[v].add(w);
            adj[w].add(v);
        }

        // A recursive function that
        // uses visited[] and parent to detect
        // cycle in subgraph reachable
        // from vertex v.
        Boolean isCyclicUtil(int currListHead,
                             Boolean visited[], int parent)
        {
            // Mark the current node as visited
            visited[currListHead] = true;
            Integer currHeadNeighbour;

            // Recur for all the vertices
            // adjacent to this vertex
            Iterator<Integer> it =
                    adj[currListHead].iterator();
            while (it.hasNext())
            {
                currHeadNeighbour = it.next();

      // If an adjacent is not visited, then recur for that adjacent
                if (!visited[currHeadNeighbour])
                {
                    if (isCyclicUtil(currHeadNeighbour, visited, currListHead))//1 0 , 2, 1
                        return true;
                }

     // If an adjacent is visited and not parent of current vertex, then there is a cycle.
                else if (currHeadNeighbour != parent)
                    return true;
            }
            return false;
        }

        // Returns true if the graph
        // contains a cycle, else false.
        Boolean isCyclic()
        {

            // Mark all the vertices as
            // not visited and not part of
            // recursion stack
            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper
            // function to detect cycle in
            // different DFS trees
            for (int currListHead = 0; currListHead < V; currListHead++)
            {

                // Don't recur for u if already visited
                if (visited[currListHead]==false) {
                    if  (isCyclicUtil(currListHead, visited, -1))
                        return true;
                }
            }

            return false;
        }


        // Driver method to test above methods
        public static void main(String args[])
        {

            // Create a graph given
            // in the above diagram
            UndirectedCycle g1 = new UndirectedCycle(5);
            g1.addEdge(1, 0);
            g1.addEdge(0, 2);
            g1.addEdge(2, 1);
            g1.addEdge(0, 3);
            g1.addEdge(3, 4);
            if (g1.isCyclic())
                System.out.println("Graph contains cycle");
            else
                System.out.println("Graph doesn't contains cycle");

            UndirectedCycle g2 = new UndirectedCycle(3);
            g2.addEdge(0, 1);
            g2.addEdge(1, 2);
            if (g2.isCyclic())
                System.out.println("Graph contains cycle");
            else
                System.out.println("Graph doesn't contains cycle");
        }
    }
// This code is contributed by Aakash Hasija


