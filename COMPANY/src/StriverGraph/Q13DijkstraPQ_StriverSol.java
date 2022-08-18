package StriverGraph;
import java.util.*;

public class Q13DijkstraPQ_StriverSol {
//WORKS
    //in dijkstar the graph will be represente as a weighted node which is neighbr from its given index
        static int[] shortestPath(int s, ArrayList<ArrayList<Nod>> adj, int N)
        {
            int dist[] = new int[N];

            for(int i = 0;i<N;i++) dist[i] = 100000000;
            dist[s] = 0;

            //Priority queue will store the min adjcnt weighted node from src and nexts simultaneously
            PriorityQueue<Nod> pq = new PriorityQueue<Nod>(N, new Nod());
            pq.add(new Nod(s, 0)); //first one

            while(pq.size() > 0) {
                Nod currminnode = pq.poll();//removing the min weighted/distanced node from previous

                for(Nod neigh: adj.get(currminnode.v)) {
                    if(dist[currminnode.v] + neigh.weight < dist[neigh.v]) {
                        dist[neigh.v] = dist[currminnode.v] + neigh.weight;
                        pq.add(new Nod(neigh.v, dist[neigh.v])); //add adjacent from current node which is not finalised
                    }
                }
            }
            return dist;
        }
        public static void main(String args[])
        {
            int n = 5;
            ArrayList<ArrayList<Nod> > adj = new ArrayList<ArrayList<Nod> >();

            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<Nod>());

            addedge(adj,0,1,2);
            addedge(adj,1,2,4);
            addedge(adj,0,3,1);
            addedge(adj,3,2,3);
            addedge(adj,1,4,5);
            addedge(adj,2,4,1);

            int s = 0;
           int dist[] = shortestPath(s, adj, n);

            System.out.println("The distances from source "+s+" are : ");
            for (int i = 0; i < n; i++)
            {
                System.out.print( dist[i] + " ");
            }

        }

        static void addedge(ArrayList<ArrayList<Nod> > adj, int u, int v, int w){
            adj.get(u).add(new Nod(v,w));
            adj.get(v).add(new Nod(u,w));
        }
    }



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
    }