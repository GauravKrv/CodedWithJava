package StriverGraph;
import java.util.*;

public class Q16KruskalStriver {
    //go thrpugh it --- compare it or test more examples with your solution of q16
    private int findPar(int u, int parent[]) {
        if(u==parent[u]) return u;
        return parent[u] = findPar(parent[u], parent);
    }
    private void union(int u, int v, int parent[], int rank[]) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if(rank[u] < rank[v]) {
            parent[u] = v;
        }
        else if(rank[v] < rank[u]) {
            parent[v] = u;
        }
        else {
            parent[v] = u;
            rank[u]++;
        }
    }
    void KruskalAlgo(ArrayList<NodeK> adj, int N)
    {
        Collections.sort(adj, new SortComparator());//now he edges are sorted according to weight
        int parent[] = new int[N];
        int rank[] = new int[N];

        for(int i = 0;i<N;i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int costMst = 0;
        ArrayList<NodeK> mst = new ArrayList<>();
        for(NodeK it: adj) {
            if(findPar(it.getU(), parent) != findPar(it.getV(), parent)) { //if curr edgs doesnt hv same parens
                costMst += it.getWeight(); //add its cost to mstsum, as occured first time
                mst.add(it); //add the edge to mst set
                union(it.getU(), it.getV(), parent, rank); //union both the nodes of the edge
            }
        }
        System.out.println(costMst);
        for(NodeK it: mst) {
            System.out.println(it.getU() + " - " +it.getV());
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<NodeK> adj = new ArrayList<>();


        adj.add(new NodeK(0, 1, 2));
        adj.add(new NodeK(0, 3, 6));
        adj.add(new NodeK(1, 3, 8));
        adj.add(new NodeK(1, 2, 3));
        adj.add(new NodeK(1, 4, 5));
        adj.add(new NodeK(2, 4, 7));


        Q16KruskalStriver obj = new Q16KruskalStriver();
        obj.KruskalAlgo(adj, n);

    }
}

class NodeK
{
    private int u;
    private int v;
    private int weight;

    NodeK(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }

    NodeK() {}

    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }

}

class SortComparator implements Comparator<NodeK> {
    @Override
    public int compare(NodeK node1, NodeK node2)
    {
        if (node1.getWeight() < node2.getWeight())
            return -1;
        if (node1.getWeight() > node2.getWeight())
            return 1;
        return 0;


    }
}
