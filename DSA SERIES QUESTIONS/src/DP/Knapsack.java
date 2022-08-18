package DP;
//given weights and value f n items, put this items in a knapsack of capacity W to get the maximum total vaclue in hte knapsack
//O/1 Knapsack
public class Knapsack {
    static int knapSackRec(int W,int[] wt,int[] val,int n){
        if (n==0||W==0) return 0;

        if (wt[n-1]>W) return knapSackRec(W,wt,val,n-1);

        else
            return Math.max(knapSackRec(W,wt,val,n-1),val[n-1]+knapSackRec(W-wt[n-1],wt,val,n-1));
    }

    //initially i = n
    static int knapsack6phsir(int[] wt,int[] profit,int n,int W,int i){
        if(i==0){
            if(wt[0]<=W){
                return profit[0];
            }else{
                return 0;
            }
        }

        int not_take = 0+knapsack6phsir(wt,profit,n,W,i-1);

        int take = Integer.MIN_VALUE;
        if(wt[i]<=W){
            take = profit[i] +knapsack6phsir(wt,profit,n,W-wt[i],i-1);
        }
        return Math.max(take,not_take);
    }



    static int knapsack6phsirdp(int[] wt,int[] profit,int n,int W) {

        int i = 0;
        int w = 0;
        int mat[][] = new int[n][W+1];
        for (i = 1; i < n; i++) {
            for (w = 0; w <= W; w++) {
                if (wt[i] > w) {
                    mat[i][w] = mat[i - 1][w];
                } else {
                    mat[i][w] = Math.max(profit[i] + mat[i - 1][w - wt[i]], mat[i - 1][w]);
                }
            }
        }
        return mat[n-1][W];
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
