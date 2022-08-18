package AMAZON.Hackon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SQ2 {
    static class PAIR{
        int x;
        int y;
        PAIR(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

   static long special_sol(int N,int M,int[][] Edg){
       HashSet hs = getSpecialEdges(N,M,Edg);
       ArrayList al = getAllPairs(N,M,Edg);
       return 1L;
    }

    private static ArrayList getAllPairs(int n, int m, int[][] edg) {
        return null;
    }

    private static HashSet getSpecialEdges(int n, int m, int[][] edg) {
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
        int numnodes = sc.nextInt();
        int numedges = sc.nextInt();
        int i = 0;
            int[][] ed = new int[numedges][2];
            while (i<numedges){
                ed[i][0] = sc.nextInt();
                ed[i][1] = sc.nextInt();

            }
            special_sol(numnodes,numedges,ed);
        }
    }
}
