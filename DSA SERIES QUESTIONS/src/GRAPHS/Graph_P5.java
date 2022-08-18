package GRAPHS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph_P5  {

    static void pln(String s){
        System.out.println(s);
    }
    static void p(String s){System.out.println(s);}
    static Scanner sc = new Scanner(System.in);
    static boolean directed = false;


    static HashMap<Character,Integer> hashMap = new HashMap<>();
   static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
   static int curr = 0;
    public static void main(String[] args) {
        pln("isDirected = "+directed);
        pln("enter # nodes");
        int nodes = sc.nextInt();
        pln("enter # edges");
        int ed = sc.nextInt();
        pln("enter the edges : ");
        makeGraph(ed,nodes);
        printGraph(nodes,ed);


    }

    private static void printGraph(int nodes, int ed) {
        pln("Printing the graph : ");
        for (int i = 0; i < graph.size(); i++) {
//            p(String.valueOf(hashMap.(i))+" -> ");

            for (int j = 0; j < graph.get(i).size(); j++) {
                p(String.valueOf(hashMap.get(graph.get(i).get(j))));
            }
            pln("");
        }
    }

    private static void makeGraph(int ed,int nodes) {
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < ed; i++) {

            char c1 = sc.next().charAt(0);
            char c2 = sc.next().charAt(0);
            adde(c1,c2);

        }

    }

    private static void adde(char c1, char c2) {
        if (hashMap.get(c1)==null){
            hashMap.put(c1,curr);
            curr++;
        }

        if (hashMap.get(c2)==null){
            hashMap.put(c2,curr);
            curr++;

        }



        graph.get(hashMap.get(c1)).add(hashMap.get(c2));
        p("c1 - "+hashMap.get(c1));
        if (directed==false)
            graph.get(hashMap.get(c2)).add(hashMap.get(c1));
        p("c2 - "+hashMap.get(c2));

        pln("");



    }


}
