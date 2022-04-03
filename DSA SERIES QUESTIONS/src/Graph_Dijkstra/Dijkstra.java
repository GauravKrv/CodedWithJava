package Graph_Dijkstra;

import java.util.HashMap;
import java.util.Scanner;

public class Dijkstra {
    // [same as above] CODE WITHOUT COMMENTS - O[N^2]
    static void dijkstra(HashMap<String, HashMap<String,Integer>> graph, String src)
    {
        HashMap<String,Integer> dist = new HashMap<>();
        HashMap<String,Boolean> fin = new HashMap<>();
        for (String node: graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
            fin.put(node,false);
        }
        dist.put(src,0);
        for (String v:graph.keySet()) {   //O[N]

            String u = minDistance(dist, fin,graph); //O[N]
            fin.put(u,true);
            for (String s : graph.get(u).keySet()) { //O[N] in total
                if (!fin.get(s) && (dist.get(u) + graph.get(u).get(s) < dist.get(s)))
                    dist.put(s, dist.get(u) + graph.get(u).get(s));
            }
        }
    }
    static void addWeightedEdges(HashMap<String,HashMap<String,Integer>> graph, String u, String v, int weight, int directed){
        //First initialising the list inside current key/node position
        if (graph.get(u) == null) {
            graph.put(u, new HashMap<String, Integer>());
        }
        if (graph.get(v) == null) {
            graph.put(v, new HashMap<String, Integer>());
        }
        if (directed==0) {

            graph.get(u).put(v, weight);
            graph.get(v).put(u, weight);
        }else{
            graph.get(u).put(v, weight);
        }
    }
    static String minDistance(HashMap<String, Integer> dist, HashMap<String, Boolean> fin, HashMap<String, HashMap<String, Integer>> graph)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        String min_node = "-1";

        for (String v:graph.keySet()) {
            int vdistfromsrc = dist.get(v);
            if (!fin.get(v) && vdistfromsrc <= min) {
                min = vdistfromsrc;
                min_node = v;
            }
        }

        return min_node;
    }

    public static void main(String[] args) {
        HashMap<String,HashMap<String,Integer>> graph = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of edges : ");
        int n  = sc.nextInt();
        System.out.println("Enter the nodes and weight for each edge : u,v,w");
        int directed = 0;
        for (int i = 0; i < n; i++) {
            //use below if passed things are string
            String u = String.valueOf(sc.nextInt());
            String v = String.valueOf(sc.nextInt());
            int w = sc.nextInt();
            addWeightedEdges(graph,u,v,w,directed);
        }

    }
}
