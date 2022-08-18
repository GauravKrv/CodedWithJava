package StriverDP;

import java.util.Arrays;

public class BestTimeBuySell_IV_Q38 {
        //given k
    public static void main(String[] args) {
//        int arr[] = {7, 1, 5,2, 3, 2, 3}; //ans = 5 for 2 buys
        int arr[] = {3, 3, 5, 0, 0, 3, 1, 4}; //ans = 6 for 2 buys


        int n = arr.length;
        int k = 3; //given k
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        int[][][] dp = new int[n][2][3];
        for (int rows[][] : dp)
            for (int rows2[] : rows)
                Arrays.fill(rows2, -1);
        //works below both
        System.out.println(solve(arr, 0, 0, k));
        System.out.println(solveTab(arr, k));

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

    //WORKS -- DECEAREASE COUNT AFTER  selling

    private static int solveTab(int[] arr,int count) {
        int n = arr.length;
        int[][][] dp = new int[n+1][2][count+1];

        for (int i = n-1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int k = 1; k <= count; k++) {

                    if (buy==1){
                        dp[i][buy][k] = Math.max(
                                arr[i] + dp[i+1][0][k-1], //sell and dec
                                dp[i+1][buy][k]); //skip this price
                    }
                    else if(buy==0){
                        dp[i][buy][k] = Math.max(
                                -arr[i] + dp[i+1][1][k],// buy and find selling price
                                dp[i+1][buy][k]); //skio this buy priec
                    }
                }
            }
        }
        return (dp[0][0][count]);

    }
}
