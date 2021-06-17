package GRAPHS;

import java.util.*;

public class Graph {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v, int directed) {
        if (directed == 1) {
            adj.get(u).add(v);
            return;
        }
        if (directed == -1) {
            adj.get(v).add(u);
            return;
        }
        if (directed == 0) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" ->" + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the number of vertices in the graph");
        int vertices = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<Integer>());
        }

     /*  System.out.println("Enter the number of edges in the graph");
        int edges = sc.nextInt();
       System.out.println("ENter the edges in the graph");
        for (int i=0;i<edges;i++){
            insertEdges(adj,sc.nextInt(),sc.nextInt(),0);
        }*/


      /*  addEdge(adj, 0, 1, 0);
        addEdge(adj, 0, 4, 0);
        addEdge(adj, 1, 2, 0);
        addEdge(adj, 1, 3, 0);
        addEdge(adj, 1, 4, 0);
        addEdge(adj, 2, 3, 0);
        addEdge(adj, 3, 4, 0);*/

/*

        addEdge(adj, 5, 2, 1);
        addEdge(adj, 5, 0, 1);
        addEdge(adj, 4, 0, 1);
        addEdge(adj, 4, 1, 1);
        addEdge(adj, 2, 3, 1);
        addEdge(adj, 3, 1, 1);
*/


        //cyclic example :
//        addEdge(adj, 0, 1, 0);
//        addEdge(adj, 1, 2, 0);
//        addEdge(adj, 2, 3, 0);
//        addEdge(adj, 3, 4, 0);
//bfs example
     /*   addEdge(adj,0,1,0);
        addEdge(adj,0,2,0);
        addEdge(adj,1,2,0);
        addEdge(adj,2,0,0);
        addEdge(adj,2,3,0);
        addEdge(adj,3,3,0);*/

        printGraph(adj);

//        bFS(adj, 0);
//
//        System.out.println();
//
//        bFS2(adj, 0);
//
//        System.out.println();
//
        //bFS2(adj,0);
       // dFS(adj,0);
//        System.out.println();
//        if (isCyclic(adj, 0)){
//            System.out.println("Graph is Cylclic");
//        }else {
//            System.out.println("Graph is Not Cylclic");
//
//        }

        System.out.println("Topological sorting : ");
        topologicalSorting(adj);
        System.out.println();
        addEdge(adj,1,0,1);
        addEdge(adj,3,2,1);
        addEdge(adj,0,3,1);
        addEdge(adj,2,4,1);
      //  addEdge(adj,3,4,1);
        addEdge(adj,4,5,1);
        addEdge(adj,4,7,1);
        addEdge(adj,5,6,1);
        addEdge(adj,7,8,1);
        addEdge(adj,6,9,1);
        addEdge(adj,8,9,1);


        System.out.println("Topological order : ");//For a directed acyclic graph
        topologicalOrdering(adj);

        System.out.println("Topological ordering Longest Path : ");//LONGEST PATH IN A DAG REPRESENT MINIMUM NUMBER OF STEPS TO LIST ALL VERTICES IN GRAPH
        topOrderingLongestPath(adj);


    }

    static void bFS(ArrayList<ArrayList<Integer>> adj, int start) {
        System.out.println("BFS TRAVERSAL OF THE GRAPH : ");
        Integer[] visited = new Integer[adj.size()];
        Integer[] parent = new Integer[adj.size()];

        for (int j = 0; j < adj.size(); j++) {
            visited[j] = 0;
            parent[j] = -1;
        }
        visited[start] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        //System.out.print(start+" ");

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");
            for (int k = 0; k < adj.get(temp).size(); k++) {
                int l = adj.get(temp).get(k);
                if (visited[l] == 0) {
                    // System.out.print(adj.get(temp).get(k)+"->");
                    visited[l] = 1;
                    parent[l] = temp;
                    q.add(l);
                    // System.out.print(l+" ");
                }


            }

        }
       /* for (int i=0;i<parent.length;i++){
            System.out.print(parent[i]+"->");
        }*/
    }


    static void bFS2(ArrayList<ArrayList<Integer>> adj, int start) {
        System.out.println("MODIFIED BFS TRAVERSAL OF THE GRAPH : ");
        Integer[] level = new Integer[adj.size()];
        Integer[] parent = new Integer[adj.size()];

        for (int j = 0; j < adj.size(); j++) {
            level[j] = -1;
            parent[j] = -1;
        }
        level[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        //System.out.print(start+" ");

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");
            for (int k = 0; k < adj.get(temp).size(); k++) {
                int l = adj.get(temp).get(k);
                if (level[l] == -1) {
                    // System.out.print(adj.get(temp).get(k)+"->");
                    level[l] = 1 + level[temp];
                    parent[l] = temp;
                    q.add(l);
                    // System.out.print(l+" ");
                }


            }

        }
        // System.out.println("Level of 3rd vertex = "+level[3]);
       /* for (int i=0;i<parent.length;i++){
            System.out.print(parent[i]+"->");
        }*/
    }

    static void dFS(ArrayList<ArrayList<Integer>> adj, int start) {
        System.out.println("DFS TRAVERSAL OF THE GRAPH : ");
        Integer[] visited = new Integer[adj.size()];
        Integer[] parent = new Integer[adj.size()];
        Integer[] pre = new Integer[adj.size()];
        Integer[] post = new Integer[adj.size()];
        int count = 0;

        for (int j = 0; j < adj.size(); j++) {
            visited[j] = 0;
            parent[j] = -1;
            post[j] = -1;
            pre[j] = -1;
        }

        dFSUtil(adj, start, visited, parent, pre,post,count);
        System.out.println("PRE\tPOST");
        for (int j = 0; j < adj.size(); j++) {
            System.out.println(pre[j]+" \t "+post[j]);
        }
    }

    static void dFSUtil(ArrayList<ArrayList<Integer>> adj, int start, Integer[] visited,Integer[] parent, Integer[] pre,Integer[] post,int count) {
        visited[start] = 1;
        pre[start] = count; count++;
        System.out.print(start+" ");
        for (int k = 0; k < adj.get(start).size(); k++) {
            int l = adj.get(start).get(k);
            if (visited[l] == 0) {
                parent[l] = start;
                dFSUtil(adj, l, visited, parent, pre, post, count);
                post[start] = count;
                count++;
            }
        }
    }


    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int start) {
        Integer[] visited = new Integer[adj.size()];
        Integer[] parent = new Integer[adj.size()];

        for (int j = 0; j < adj.size(); j++) {
            visited[j] = 0;
            parent[j] = -1;
        }

        if(isCyclicUtil(adj, start, visited, parent)){
            return true;
        }else {
            return false;
        }    }

    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, int start, Integer[] visited, Integer[] parent) {
        visited[start] = 1;
        System.out.print(start+" ");
        ArrayList<Integer> currList = adj.get(start);
        boolean flag = true;

        for (int k = 0; k < currList.size(); k++) {
            int currChildofStart = currList.get(k);
            if (visited[currChildofStart] == 0) {
                parent[currChildofStart] = start;
              isCyclicUtil(adj, currChildofStart, visited, parent);//here we will visit  "l" using parent of "l"

            }
            if (flag==false) break;

            //Detecting cycle during dfs
            else if (visited[currChildofStart]!=0){
                if (parent[currChildofStart]==start) return false;
            }
        }
        return flag;
    }

    public static void topologicalSorting(ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st = new Stack<>();
        int V = adj.size();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                topologicalSortingUtil(adj, i, visited, st);
            }
        }

            while (!st.isEmpty())
                System.out.print(st.pop()+" ");

    }
    private static void topologicalSortingUtil(ArrayList<ArrayList<Integer>> adj,int v, boolean[] visited, Stack<Integer> st) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortingUtil(adj,i,visited,st);
        }

        st.push(v);
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


    //E.G We can find minimum number of steps to complete a program
    //It is equivalent to finding the longest path in DAG
    static void topOrderingLongestPath(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        Integer[] indegree = new Integer[V];
        Integer[] LPT = new Integer[V];
        for (int i = 0; i < V; i++){
            indegree[i] = 0;
        LPT[i] = 0;
    }

        for (int i=0;i<V;i++){
            for( int l =0;l< adj.get(i).size();l++){
                indegree[adj.get(i).get(l)] = indegree[adj.get(i).get(l)] + 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<V;i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()){

            int j = q.peek();
            System.out.print(j+"->");
            q.remove();

            for (int k = 0;k<adj.get(j).size();k++){
                int l = adj.get(j).get(k);

                indegree[l] = indegree[l] - 1;

               if( LPT[l] <= (LPT[j]+1)) LPT[l] = LPT[j]+1;

               if(indegree[l]==0) q.add(l);
            }


        }
        System.out.println("LONGEST PATH TO EACH VERTEX ARE AS FOLLOWS : ");
        for (int i=0;i<LPT.length;i++) {
            System.out.println(i + "->"+LPT[i]);
        }
    }

}
