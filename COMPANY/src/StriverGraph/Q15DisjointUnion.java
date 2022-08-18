package StriverGraph;

import java.util.Arrays;

public class Q15DisjointUnion {
    int rank[];
     int parent[];
    public static void main(String[] args) {
        Q15DisjointUnion u = new Q15DisjointUnion();
        u.makeSet(4);
        u.union(0,1);
        u.union(0,3);
        u.union(1,3);
        u.union(2,4);

        System.out.println(u.findParent(2));
        u.printa(u.parent);
        System.out.println();
        u.printa(u.rank);
    }
     void printa(int[] a){
        for (int x :
                a) {
            System.out.print(x+" ");
        }
    }

     void makeSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i]=i;
            rank[i]=0;
        }
    }

     int findParent(int u){

        if (parent[u]==u){
            return u;
        }
        int x = findParent(parent[u]);
        parent[u] = x; //path compression
        return x;
    }

    //my way - is fine
     void union(int u,int v){
        int x = findParent(u);
        int y = findParent(v);
        if (rank[x]> rank[y]){
            parent[y] = x;
        }
        else if (rank[x] <rank[y]){
            parent[x] = y;
        }
        else{
            rank[x]++;
            parent[y] = x;
        }
    }

    //strivers way - real way --
    // attach the the parents of u and v together instead of attaching u and v together
     void unionSt(int x,int y){
         x = findParent(x);
         y = findParent(y);
        if (rank[x]> rank[y]){
            parent[y] = x;
        }
        else if (rank[x] <rank[y]){
            parent[x] = y;
        }
        else{
            rank[x]++; //rank is increased only if both u and v have same rank
            parent[y] = x;
        }
    }
}
