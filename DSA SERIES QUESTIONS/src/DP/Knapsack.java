package DP;

public class Knapsack {
    static int knapSackRec(int W,int[] wt,int[] val,int n){
        if (n==0||W==0) return 0;

        if (wt[n-1]>W) return knapSackRec(W,wt,val,n-1);

        else
            return Math.max(knapSackRec(W,wt,val,n-1),val[n-1]+knapSackRec(W-wt[n-1],wt,val,n-1));
    }

    static int knapSackMemo(int W, int[] wt, int[] val, int n, int memo[][]){
        if(n>=0&&W>=0 && memo[n][W]!=-1) return memo[n][W];
        if (n==0||W==0) return 0;

        if (wt[n-1]>W) {

            memo[n][W] = knapSackMemo(W, wt, val, n - 1,memo);
            return memo[n][W];
        }

        else {
            memo[n][W] = Math.max(knapSackMemo(W, wt, val, n - 1,memo), val[n - 1] + knapSackMemo(W - wt[n - 1], wt, val, n - 1,memo));
            return memo[n][W];
        }
    }


    public static void main(String[] args) {
        int v[] = {10,40,30,50};
        int wt[] = {5,4,6,3};
        int W = 10;

        System.out.println(knapSackRec(W,wt,v,v.length));
    }
}
