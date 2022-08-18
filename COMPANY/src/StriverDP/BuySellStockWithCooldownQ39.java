package StriverDP;

import java.util.Arrays;

public class BuySellStockWithCooldownQ39 {

    public static void main(String[] args) {
//        int arr[] = {7, 1, 5,2, 3, 2, 3}; //ans = 5 for 2 buys
        int arr[] = {3, 3, 5, 0, 0, 3, 1, 4}; //ans = 6 for 2 buys


        int n = arr.length;

        int[][] dp = new int[n][2];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        //works below both
        System.out.println(solve(arr, 0, 0));
        System.out.println(solveMemo(arr, 0, 0, dp));
        System.out.println(solveTabSt(arr));
        //fails
        System.out.println(solveTab(arr));




    }

    //worksss - mine memo
    private static int solveMemo(int[] arr, int i, int buy, int[][] dp) {
        if (i >= arr.length) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];
        if (buy == 0) { //buy now
            dp[i][buy] = Math.max(
                    -arr[i] + solveMemo(arr, i + 1, buy + 1, dp),
                    solveMemo(arr, i + 1, buy, dp)
            );

        } else //sell
            dp[i][buy] = Math.max(
                    arr[i] + solveMemo(arr, i + 2, buy - 1, dp),
                    solveMemo(arr, i + 1, buy, dp)
            );
        return dp[i][buy];

    }


    //    works ---
    private static int solve(int[] arr, int i, int buy) {
        if (i >= arr.length) return 0;

        if (buy == 0) { //buy now
            return Math.max(
                    -arr[i] + solve(arr, i + 1, buy + 1),
                    solve(arr, i + 1, buy)
            );

        } else //sell
            return Math.max(
                    arr[i] + solve(arr, i + 2, buy - 1),
                    solve(arr, i + 1, buy)
            );

    }

    //MY - WORKS FINE NOW --- RETURN DP[0][0] AND NOT DP[0][1] -- THINK WHY LATER

    private static int solveTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 2][2];

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
                            (arr[i] + dp[i + 2][0]),
                            dp[i + 1][1]
                    );

            }

        }
        return dp[0][0];

    }

    //passes
    private static int solveTabSt(int[] Arr) {
        int n = Arr.length;
        int dp[][]=new int[n+2][2];

        for(int ind = n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                int profit=0;

                if(buy==0){// We can buy the stock
                    profit = Math.max(0+dp[ind+1][0], -Arr[ind] + dp[ind+1][1]);
                }

                if(buy==1){// We can sell the stock
                    profit = Math.max(0+dp[ind+1][1], Arr[ind] + dp[ind+2][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        return dp[0][0];

    }

}
