package StriverGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q14MST_Prims {
    //given a weighted graph, find mst
    //n - no of nodes
    //e - no of edges
    //next e lines => n1 n2 weight
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5, e = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();//becoz no pq is used, only weighted grph is used
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
/*
0 1 2
1 2 3
0 3 6
1 4 8
2 4 7
ANS  = 16 Below
0 1 2
0 3 6
1 2 3
1 3 8
1 4 5
2 4 7
*/
        for (int i = 0; i < e; i++) {
            addEdge(adj,sc.nextInt(),sc.nextInt(),sc.nextInt());
        }

        int mst[] = myPrimsOptimised(adj,n);
        int i = 0;
        for (int x :
                mst) {
            System.out.println(i++ + "-> " +x);
        }
    }
    //O (N*N)
    //WORK - MINE
    private static int[] myPrims(ArrayList<ArrayList<Pair>> adj, int v) {
        int parent[] = new int[v]; //to store parent node of any node in the mst set or prev node[index] of the mst path
        int key[] = new int[v]; //stores weight of nodes included in mst
        Arrays.fill(key,(int)1e9);
        Arrays.fill(parent,-1);
        key[0] = 0;
        boolean mst[] = new boolean[v]; //is true if the node is incuded in the path with min possible cost
        //INITIALISATIONS --------------------------------
        int count = 1;
        while (count<v){
            int currNode = getMinKey(key,mst);//get next smallest wieghted node to be added to mst
            mst[currNode] = true;
            System.out.println("currnode = "+currNode);
            count++;
            for (Pair x : adj.get(currNode)) { //get the min key's corresonding node and add to mst, then add its adjacents to key and parent list
                if (!mst[x.node] && key[x.node] > x.weight){
                    parent[x.node]=currNode;
                    key[x.node] = x.weight;
                }
            }
        }
        int mstsum = 0; //get the sum of mst
        for (int x :
                key) {
            mstsum += x;
        }
        System.out.println("Cost of min sanning tree = "+mstsum);
        return parent; //return the mst node set
    }

    private static int getMinKey(int[] key, boolean[] mst) {
        int min = (int) 1e9, node= 0;
        for (int i = 0; i < key.length; i++) {
            if (!mst[i] && (min>key[i])){
                min =  key[i];
                node=i;
            }
        }
        return node; //return node corres to min of all element in key and if it is not in mst
    }

    private static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v, int w) {
        adj.get(u).add(new Pair(v,w));
        adj.get(v).add(new Pair(u,w));
    }


    //O (N*LOGN) -- WORKS optimised - using priority queue in place of min key funciotn
    private static int[] myPrimsOptimised(ArrayList<ArrayList<Pair>> adj, int v) {
        int parent[] = new int[v]; //to store parent node of any node in the mst set or prev node[index] of the mst path
        int dist[] = new int[v]; //stores weight of nodes included in mst
        Arrays.fill(dist,(int)1e9);
        Arrays.fill(parent,-1);
        dist[0] = 0;
        boolean mst[] = new boolean[v]; //is true if the node is incuded in the path with min possible cost
        PriorityQueue<Nod> pq = new PriorityQueue<>(v,new Nod()); //use priority queue to store dist - min dist
        pq.add(new Nod(0,dist[0])); //check implementation of Nod for more understanding
        int count = 1;
        //INITIALISATIONS --------------------------------

//MAIN CODE
        while (count<v){
            int currNode = pq.poll().v;//get next smallest wieghted node to be added to mst
            mst[currNode] = true;
            System.out.println("currnode = "+currNode);
            count++;
            for (Pair x : adj.get(currNode)) { //get the min dist's corresonding node and add to mst, then add its adjacents to dist and parent list
                if (!mst[x.node] && dist[x.node] > x.weight){
                    parent[x.node]=currNode;
                    dist[x.node] = x.weight;
                    pq.add(new Nod(x.node,x.weight)); //store the new weighted edge in the priority queue
                }
            }
        }

        //IF SUM IS ALSO NEEDED
        int mstsum = 0; //get the sum of mst
        for (int x :
                dist) {
            mstsum += x;
        }
        System.out.println("Cost of min sanning tree = "+mstsum);
        return parent; //return the mst node set
    }
}


/*  Nod - implementation
class Nod implements Comparator<Nod>
    {
        public int v;
        public int weight;
        Nod(int _v, int _w) { v = _v; weight = _w; }
        Nod() {}
        @Override
        public int compare(Nod Nod1, Nod Nod2)
        {
            if (Nod1.weight < Nod2.weight)
                return -1;
            if (Nod1.weight > Nod2.weight)
                return 1;
            return 0;
        }
    }*/

