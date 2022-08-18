package StriverGraph;
import java.util.*;

public class Q14PrimsStriverNsq {
   static void primsAlgo(ArrayList<ArrayList<Node2>> adj, int N)
    {
        int key[] = new int[N];
        int parent[] = new int[N];
        boolean mstSet[] = new boolean[N];
        for(int i = 0;i<N;i++) {
            key[i] = 100000000;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;


        for(int i = 0;i<N-1;i++) {
            int mini = 100000000, u = 0;
            for(int v = 0;v<N;v++) {
                if(mstSet[v] == false && key[v] < mini) {
                    mini = key[v];
                    u = v;
                }
            }

            mstSet[u] = true;


            for(Node2 it: adj.get(u)) {
                if(mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
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
class Node
{
    private int v;
    private int weight;

    Node(int _v, int _w) { v = _v; weight = _w; }

    Node() {}

    int getV() { return v; }
    int getWeight() { return weight; }
}


