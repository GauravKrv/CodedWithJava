package StriverDP;

import java.util.Arrays;

public class BuySellStocksWithTransactionFee_Q40 {

    public static void main(String[] args) {
//        int arr[] = {7, 1, 5,2, 3, 2, 3}; //ans = 5 for 2 buys
        int arr[] = {1,3,2,8,4,9}; //ans = 6 for 2 buys


        int n = arr.length;
        int fee = 2;
        int[][] dp = new int[n][2];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        //works below both
        System.out.println(solve(arr, 0, 0, fee));
        System.out.println(solveMemo(arr, 0, 0, fee, dp));
        //
//        System.out.println(solveTabSt(arr));
        //WORKS
        System.out.println(solveTab(arr,fee));




    }

    //worksss - mine memo
    private static int solveMemo(int[] arr, int i, int buy,int fee, int[][] dp) {
        if (i >= arr.length) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];
        if (buy == 0) { //buy now
            dp[i][buy] = Math.max(
                    -arr[i] + solveMemo(arr, i + 1, buy + 1,fee, dp),
                    solveMemo(arr, i + 1, buy,fee, dp)
            );

        } else //sell
            dp[i][buy] = Math.max(
                    arr[i] -fee  + solveMemo(arr, i + 1, buy - 1,fee, dp),
                    solveMemo(arr, i + 1, buy,fee, dp)
            );
        return dp[i][buy];

    }

    private static int solve(int[] arr, int i, int buy,int fee) {
        if (i >= arr.length) return 0;

        if (buy == 0) { //buy now
            return Math.max(
                    -arr[i] + solve(arr, i + 1, buy + 1,fee),
                    solve(arr, i + 1, buy,fee)
            );

        } else //sell
            return Math.max(
                    arr[i] - fee  + solve(arr, i + 1, buy - 1,fee),
                    solve(arr, i + 1, buy,fee)
            );

    }

    private static int solveTab(int[] arr,int fee) {
        int n = arr.length;
        int[][] dp = new int[n+1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 0) { //buy now
                    dp[i][buy] = Math.max(
                            -arr[i] + dp[i + 1][1],
                            dp[i + 1][buy]
                    );

                }
                else
                    dp[i][buy] = Math.max(
                            (arr[i] - fee + dp[i + 1][0]),
                            dp[i + 1][1]
                    );

            }

        }
        return dp[0][0];

    }

}
