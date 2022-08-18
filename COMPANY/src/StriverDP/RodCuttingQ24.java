package StriverDP;

public class RodCuttingQ24 {

    public static void main(String[] args) {
        int n = 5;
        int[] prices = new int[]{2,5,7,8,10};

        int[][] dp = new int[n][n + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(prices,n - 1,n));
        System.out.println(solveMemo(prices,n - 1,n,dp));
        System.out.println(solveTab(prices,n));


    }

    //My Bottom up -- workss
    private static int solve(int[] p, int i, int n) {

        if (i==0){
             return p[i]*n;
        }

        int notake = solve(p, i-1, n);
        int take = Integer.MIN_VALUE;
        if (i<n){
            take = p[i] + solve(p, i, n-i-1);
        }

        return Math.max(take,notake);
    }

    //My memo - works
    private static int solveMemo(int[] p, int i, int n,int[][] dp) {

        if (i==0){
            return p[i]*n;
        }
        if (dp[i][n]!=-1) return dp[i][n];

        int notake = solve(p, i-1, n);
        int take = Integer.MIN_VALUE;
        if (i<n){
            take = p[i] + solve(p, i, n-i-1);
        }

        dp[i][n]= Math.max(take,notake);
        return dp[i][n];
    }

    //my tabulation works [top-down - as base case - end]-> didnt understood from matrix -- but derived from the basic recursion only
    private static int solveTab(int[] p, int n) {

        int[][] dp = new int[n][n + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = p[0]*i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                int notake = dp[i-1][j];

                int take = Integer.MIN_VALUE;
                if (i<j){
                    take = p[i] + dp[i-1][j-i-1];
                }
                dp[i][j] =  Math.max(take,notake);
            }
        }
        return dp[n-1][n];


    }
}
