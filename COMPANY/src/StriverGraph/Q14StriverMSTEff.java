package StriverGraph;
import java.util.*;

public class Q14StriverMSTEff {
   static void primsAlgo(ArrayList<ArrayList<Node2>> adj, int N)
    {
        int key[] = new int[N];
        int parent[] = new int[N];
        boolean mstSet[] = new boolean[N];
        for(int i = 0;i<N;i++) {
            key[i] = 100000000;
            mstSet[i] = false;
        }

        PriorityQueue<Node2> pq = new PriorityQueue<Node2>(N, new Node2());

        key[0] = 0;
        parent[0] = -1;
        pq.add(new Node2(key[0], 0));
        // Run the loop till all the nodes have been visited
        // because in the brute code we checked for mstSet[node] == false while computing the minimum
        // but here we simply take the minimal from the priority queue, so a lot of times a node might be taken twice
        // hence its better to keep running till all the nodes have been taken.
        // try the following case:
        // Credits: Srejan Bera
        // 6 7
        // 0 1 5
        // 0 2 10
        // 0 3 100
        // 1 3 50
        // 1 4 200
        // 3 4 250
        // 4 5 50
        while(!pq.isEmpty()) {
            int u = pq.poll().getV();
            mstSet[u] = true;

            for(Node2 it: adj.get(u)) {
                if(mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                    pq.add(new Node2(it.getV(), key[it.getV()]));
                }
            }
        }

        for(int i = 1;i<N;i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Node2> > adj = new ArrayList<ArrayList<Node2> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node2>());

        adj.get(0).add(new Node2(1, 2));
        adj.get(1).add(new Node2(0, 2));

        adj.get(1).add(new Node2(2, 3));
        adj.get(2).add(new Node2(1, 3));

        adj.get(0).add(new Node2(3, 6));
        adj.get(3).add(new Node2(0, 6));

        adj.get(1).add(new Node2(3, 8));
        adj.get(3).add(new Node2(1, 8));

        adj.get(1).add(new Node2(4, 5));
        adj.get(4).add(new Node2(1, 5));

        adj.get(2).add(new Node2(4, 7));
        adj.get(4).add(new Node2(2, 7));


        primsAlgo(adj, n);

    }
}

class Node2 implements Comparator<Node2>
{
    private int v;
    private int weight;

    Node2(int _v, int _w) { v = _v; weight = _w; }

    Node2() {}

    int getV() { return v; }
    int getWeight() { return weight; }

    @Override
    public int compare(Node2 node1, Node2 node2)
    {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}


