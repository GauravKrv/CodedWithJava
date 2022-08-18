package StriverDP;

public class Zero1KnapSackQ19 {
    public static void main(String[] args) {
        int n = 5;
        int[] w = new int[]{1, 2, 3, 6, 4};

        int[] val = new int[]{10, 20, 30, 30, 70};
        int W = 8;

        int[][] dp = new int[n][W + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(w,val, n - 1,W));
        System.out.println(solveMemo(w,val, n - 1,W,dp));
        System.out.println(solveTab(w,val,W));
        System.out.println(knapsack(w,val,W));



    }

    //Recursion --- works - Bottom -Up
    private static int solve(int[] w, int[] val, int i, int W) {
        if (i==0){
            if (w[i]<=W) return val[i];
            else return 0;
        }
        int notake = solve(w, val, i-1, W);
        int take = Integer.MIN_VALUE;
        if (w[i]<=W){
            take = val[i] + solve(w, val, i-1, W-w[i]);
        }

        return Math.max(take,notake);
    }

    //Bottom Up Memoisation -- wprks
    private static int solveMemo(int[] w, int[] val, int i, int W,int[][] dp) {
        if (i==0){
            if (w[i]<=W) return val[i];
            else return 0;
        }
        if (dp[i][W]!=-1) return dp[i][W];
        int notake = solve(w, val, i-1, W);
        int take = Integer.MIN_VALUE;
        if (w[i]<=W){
            take = val[i] + solve(w, val, i-1, W-w[i]);
        }

        dp[i][W]= Math.max(take,notake);
        return dp[i][W];
    }


    //My - tabulation -- works
    private static int solveTab(int[] w, int[] val, int W) {
        int n = w.length;

        int[][] dp = new int[n][W + 1]; //since dp can store 0 as a value of W -- or W ranges from 0-W as value

        for (int i = 0; i <= W; i++) { //except this line
            if (i>=w[0])
            dp[0][i]  = val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
//                int notake = 0 + dp[i-1][W]; --> DUE TO THIS SILLY MISTAKE 'W'
                int notake = 0 + dp[i-1][j];

                int take = Integer.MIN_VALUE;
                if (w[i]<=j){
                    take = val[i] + dp[i-1][j-w[i]];
                }
                dp[i][j] = Math.max(take,notake);
            }
        }

        return dp[n-1][W];
    }


    //STRIVER's - tabulation - same as mine
    static int knapsack(int[] wt,int[] val, int W){
        int n = wt.length;
        int dp[][] = new int[n][W+1];

        //Base Condition

        for(int i=wt[0]; i<=W; i++){ //except this line
            dp[0][i] = val[0];
        }

        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){

                int notTaken = 0 + dp[ind-1][cap];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind-1][cap - wt[ind]];

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n-1][W];
    }

}
