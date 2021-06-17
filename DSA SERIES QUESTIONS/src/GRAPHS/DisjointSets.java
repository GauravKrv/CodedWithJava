package GRAPHS;

public class DisjointSets {

    static int v;
    static int[] p;
    static int[] rank;


    static void Make_Set(int v){
        p = new int[v];
        rank = new int[v];
        for (int i=0;i<v;i++){
            p[i] = i;
            rank[i] = 0;

        }

    }
    static void union(int x, int y){
        link(find_set(x),find_set(y));
    }

     static void link(int set1, int set2) {
        if (rank[set1]>rank[set2])
            p[set2] = set1;
        else {
            p[set1] = set2;
            if (rank[set1] == rank[set2])
                rank[set2]++;
        }
    }

    static int find_set(int x){
        if (x != p[x])
            p[x] = find_set(p[x]);

        return p[x];
    }
//TIME COPLEXTITY = O(m.a(n)), a(n) <= 4, so, T.C = O(m)
    public static void main(String[] args) {
        v = 6;
        Make_Set(v);
        System.out.println(find_set(3));
        union(2,3);
        union(3,5);
        System.out.println(find_set(3));
        System.out.println(find_set(2));
        System.out.println(find_set(4));
        System.out.println(find_set(5));

    }

}
