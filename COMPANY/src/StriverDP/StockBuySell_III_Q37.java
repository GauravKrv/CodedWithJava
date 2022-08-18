package StriverDP;

import java.util.Arrays;

public class StockBuySell_III_Q37 {
    public static void main(String[] args) {
//        int arr[] = {7, 1, 5,2, 3, 2, 3}; //ans = 5 for 2 buys
        int arr[] = {3,3,5,0,0,3,1,4}; //ans = 6 for 2 buys


        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        int[][][] dp = new int[n][2][3];
        for (int rows[][] : dp)
            for (int rows2[] : rows)
            Arrays.fill(rows2, -1);
        //works below both
        System.out.println(solve(arr, 0, 0,2));
        System.out.println(solveMemo(arr, 0, 0,2,dp));
        System.out.println(solveTab(arr));


    }

    //Works
    private static int solveMemo(int[] arr, int i, int buy, int count, int[][][] dp) {

        if (i==arr.length) return 0;
        if (dp[i][buy][count]!=-1) return dp[i][buy][count];
        if (buy==0){
            if (count>0){
                dp[i][buy][count] = Math.max(
                        -arr[i] + solveMemo(arr, i+1, buy+1, count-1,dp),
                        solveMemo(arr, i+1, buy, count,dp)
                );
            }else{
                return 0;
            }
        }

else {
            dp[i][buy][count] = Math.max(
                    arr[i] + solveMemo(arr, i + 1, buy - 1, count,dp),
                    solveMemo(arr, i + 1, buy, count,dp)
            );
        }

return dp[i][buy][count];

    }

    private static int solve(int[] arr, int i, int buy,int count) {
        if (i==arr.length) return 0;

        if (buy==0){
            if (count>0){
                return Math.max(
                        -arr[i] + solve(arr, i+1, buy+1, count-1),
                        solve(arr, i+1, buy, count)
                );
            }else{
                return 0;
            }
        }


                return Math.max(
                        arr[i] + solve(arr, i+1, buy-1, count),
                        solve(arr, i+1, buy, count)
                );

    }

    private static int solveTab(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n+1][2][3];

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= 2; k++) {

                      if (j==1){
                       dp[i][j][k] = Math.max(
                               arr[i] + dp[i+1][0][k-1],
                               dp[i+1][j][k]);
                    }
                    else if(j==0){
                       dp[i][j][k] = Math.max(
                                -arr[i] + dp[i+1][1][k],
                                dp[i+1][j][k]);
                    }
                }
            }
        }




        return (dp[0][0][2]);

    }
}
