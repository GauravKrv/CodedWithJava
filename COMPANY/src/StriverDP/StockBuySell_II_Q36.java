package StriverDP;

import java.util.Arrays;

public class StockBuySell_II_Q36 {
    public static void main(String[] args) {
//        int arr[] = {7,1,5,6,4,9,7,1,5,3,6,4,4,9,7,1,5}; // ans = 26
        int arr[] = {7,1,5,3,6,4}; // ans = 7


        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,arr[i]);
        }
        int[][] dp = new int[n][max+1];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        //works below both
        System.out.println(solve(arr,n-1,0));
        //will give memory limit exceeded on LC
        System.out.println(solveMemo(arr,n-1,0,dp));

        //works
        System.out.println(solveSt(arr,0,0));
        //this failssss -- coz maybe the last stock can be either bought or no bought
//        System.out.println(Math.max(solveStTd(arr,n-1,1),solveStTd(arr,n-1,0))); //still fails
        System.out.println(solveStTd(arr,n-1,1)); //still fails

        //memo also works
        int[][] dp2 = new int[n][2];
        for (int rows[] : dp2)
            Arrays.fill(rows, -1);
        System.out.println(solveStMemo(arr,0,0,dp2));

        //Works
        System.out.println(solveStTab(arr));


    }

    private static int solveMemo(int[] arr, int i, int curr, int[][] dp) {
        if (i==0 && curr>arr[i]) return curr-arr[i];
        if (i==0) return 0;
        if(dp[i][curr]!=-1) return dp[i][curr];
        if (curr!=0) {
            dp[i][curr] = Math.max(solveMemo(arr, i-1, 0,dp) + curr-arr[i]
                    ,solveMemo(arr, i-1, curr,dp));
        }
        else
        dp[i][curr] = Math.max(solveMemo(arr, i-1, arr[i],dp)
                ,solveMemo(arr, i-1, 0,dp));
        return dp[i][curr];

          }

          //top down -- works
    private static int solve(int[] arr, int i, int curr) {
        if (i==0 && curr>arr[i]) return curr-arr[i];
        if (i==0) return 0;

        if (curr!=0) {
            return Math.max(solve(arr, i-1, 0) + curr-arr[i]
                    ,solve(arr, i-1, curr));
        }
        return Math.max(solve(arr, i-1, arr[i])
                ,solve(arr, i-1, 0));
    }

    //strivers Recusrion -------- Works
    private static int solveSt(int[] arr, int i, int buy) {

        if (i==arr.length) return 0;

        int profit = 0;
        if (buy==1) {
            profit =  Math.max( (arr[i] + solveSt(arr, i+1, 0))  //sell at arr[i]
                    ,solveSt(arr, i+1, buy));
        }
        else {
            profit = Math.max(-arr[i] + solveSt(arr, i + 1, 1) //buy at arr[i] [[or buy and -x becoz we need to subtracct this later]]
                    , solveSt(arr, i + 1, 0));
        }
        return profit;
    }

    private static int solveStTd(int[] arr, int i, int buy) {

        if (i<0) return 0;

        int profit = 0;
        if (buy==1) {
            profit =  Math.max( (-arr[i] + solveStTd(arr, i-1, 0))  //sell at arr[i]
                    ,solveStTd(arr, i-1, buy));
        }
        else {
            profit = Math.max(arr[i] + solveStTd(arr, i - 1, 1) //buy at arr[i] [[or buy and -x becoz we need to subtracct this later]]
                    , solveStTd(arr, i - 1, 0));
        }
        return profit;
    }

    private static int solveStMemo(int[] arr, int i, int buy,int dp[][]) {

        if (i==arr.length) return 0;
        if (dp[i][buy]!=-1) return dp[i][buy];
        if (buy==1) {
            dp[i][buy]  =  Math.max( (arr[i] + solveStMemo(arr, i+1, 0,dp))  //sell at arr[i]
                    ,solveStMemo(arr, i+1, buy,dp));
        }
        else {
            dp[i][buy] = Math.max(-arr[i] + solveStMemo(arr, i + 1, 1,dp) //buy at arr[i] [[or buy and -x becoz we need to subtracct this later]]
                    , solveStMemo(arr, i + 1, 0,dp));
        }
        return dp[i][buy];
    }

    //MY CONVERSION OF TABULAITON -- WORKS
    private static int solveStTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][2];

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {


                int profit = 0;
                if (j == 1) {
                    dp[i][j] = Math.max((arr[i] + dp[i + 1][0])  //sell at arr[i]
                            , dp[i + 1][j]);
                } else {
                    dp[i][j] = Math.max(-arr[i] + dp[i + 1][1] //buy at arr[i] [[or buy and -x becoz we need to subtracct this later]]
                            , dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
