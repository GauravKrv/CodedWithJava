package StriverGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q10TopOrdering_KahnBFS {
//IN INTERVIEW BETTER TELL THE DFS SOUTION AS BFS SOL IS A KIND OF HACK
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        Graph_Disc_Direc g = new Graph_Disc_Direc(); //for using the functions of undirected disconnected graphs

        g.addEdge(adj,5,0);
        g.addEdge(adj,4,0);

        g.addEdge(adj,5,2);
        g.addEdge(adj,2,3);
        g.addEdge(adj,3,1);
        g.addEdge(adj,4,1);


      //  Stack<Integer> st = topOrderbFS(adj,V);
//        while (!st.isEmpty()){
//            System.out.print(" -> "+st.pop());
//        }

        System.out.println(isCyclic(V+1,adj)); //-> works  ->  same logic as mine
    }
//MINE - [Not working] JUST DOESNT CALULATED FOR CYCE BU LOGIC IS SAME -
    private static Stack<Integer> topOrderbFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v+1];
        int indeg[] = new int[v+1];
        for (int i = 0; i <= v; i++) { //set the count for incoming weights for each node
            for (int x :
                    adj.get(i)) {
                indeg[x]++;
            }
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= v; i++) { //for each component do bfs
            if (!vis[i]){
                bFS(adj,i,vis,indeg,st);
            }
        }
        return st;

    }

    private static void bFS(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, int[] indeg, Stack<Integer> st) {
        vis[i]=true;
        Queue<Integer> q = new LinkedList<>();

        for (int j=0;j<adj.size();j++) {
            if (indeg[i]==0){
              //  st.push(j);
                q.add(j);
            }
        }

        while (!q.isEmpty()) {
            int currnode = q.poll();
            st.push(currnode);
            System.out.println("Q = "+currnode);
            for (int x : adj.get(currnode)) {
                indeg[x]--;
                if (indeg[x] == 0) {
                  //  System.out.println("x = "+x);
                    q.add(x);
                }
            }

        }
    }


    //WORKS - CYCLE + TOPSORT
    public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[N];
        int indegree[] = new int[N];

        //finding indegree - initialisation
        for(int i = 0;i<N;i++) {
            for(Integer it: adj.get(i)) {
                indegree[it]++;
            }
        }

        //Queue for BFS
        Queue<Integer> q = new LinkedList<Integer>();
        //before BFS //adding nodes to queue with indegree = 0
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;
        int ind=0;

        while(!q.isEmpty()) {
            Integer node = q.poll();
            topo[ind++] = node;//STORING THE NODE
            cnt++;//increase count for each node -- if cycle then the count will be greater than N
            //getting neighbour nodes of popped node and decreasing  their  indegree by1
            for(Integer it: adj.get(node)) {
                indegree[it]--;//DEC FOR EACH VISIT
                if(indegree[it] == 0) { //SUDDEN ADD
                    q.add(it);
                }
            }
        }

        //printing topological ordering of nodes
        System.out.print("THE TOPOSORT ORDER  : ");
        for (int i=0;i< topo.length;i++){
            System.out.print(topo[i]+" ");
        }

        System.out.print("\nisCyclic -> ");

        //BELOW MEANS A CYCLE IS PRESENT - THINK EASY
        if(cnt == N) return false;
        return true;
    }
}


