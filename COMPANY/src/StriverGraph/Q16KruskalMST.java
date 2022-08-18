package StriverGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q16KruskalMST {
    //no need to store the graph in adj list, rathre can use a priority queue to store
    //where the nodes will be sorted according to the weights
/*gives answer as 17 --- works
6
9
9 4 5
4 1 5
2 1 2
3 2 4
3 2 3
5 3 4
8 3 6
7 2 6
1 1 4*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numedges = sc.nextInt();
        PriorityQueue<KNode> pq = new PriorityQueue<>(numedges,new KNode());
        ArrayList<KNode> al = new ArrayList<>();
        for (int i = 0; i < numedges; i++) {
            KNode kNode = new KNode(sc.nextInt(),sc.nextInt(),sc.nextInt());
            al.add(kNode);//wont be sorted
            pq.add(kNode); //will be sorted
            //ENTER  -- WEIGHT, U, V
        }
//        for (KNode x:
//             al) {
//            System.out.println(x.weight+" " + x.u +" "+x.v);
//        }

        int mst[] = kruskalMST(pq,numedges,n+1);//send n+1 if index starts with 1

    }

    //BUT -- Mine wont work if the nodes added in each KNode are not sorted i.e w,u,v where u<v will only work
    //-- can put a condition if v or u is not part of mst then add like wise
    //works - mine -- without using any disjoint set -- i used mst boolean array to keep track of
    //whether a node is added to our mst or not
    private static int[] kruskalMST(PriorityQueue<KNode> pq, int numedges, int n) {
        boolean mst[] = new boolean[n]; //only store if the node is not added to mst
        int parent[] = new int[n]; //for storing each node's parent node in the mst
        int weight[] = new int[n]; //for storing distance(weight) used by each node from its parent node

        Q15DisjointUnion u = new Q15DisjointUnion();
//        u.makeSet(n);
        int mstsum=0;
        while (pq.size()>0){ //while there are any edges present in the pq
            KNode temp = pq.poll(); //take the top node
            if (!mst[temp.v]){ //only add to mst if current v node is not part of mst
                mst[temp.v] = true; //include it in mst
                parent[temp.v] = temp.u; //set its parent
                weight[temp.v] = temp.weight; //add its weight
                mstsum+= temp.weight;//take the sum
            }

        }
        System.out.println("mst sum = "+mstsum);
        u.printa(parent);
        return parent;
    }


}

class KNode implements Comparator<KNode>
{
    public int v,u,weight;
    KNode(int _w, int _u, int _v) { v = _v; u = _u; weight = _w; }
    KNode() {}
    @Override
    public int compare(KNode Nod1, KNode Nod2)
    {
        if (Nod1.weight < Nod2.weight)
            return -1;
        if (Nod1.weight > Nod2.weight)
            return 1;
        return 0;
    }
}