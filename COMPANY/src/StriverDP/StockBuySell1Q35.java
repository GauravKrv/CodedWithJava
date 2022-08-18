package StriverDP;

import java.util.Arrays;

public class StockBuySell1Q35 {

    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};

        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,arr[i]);
        }
        int[][] dp = new int[n][max];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        //works below both
        System.out.println(solve(arr,n-1,arr[n-1]));
        System.out.println(solveMemo(arr,n-1,arr[n-1],dp));
        //fails
        System.out.println(solveTab(arr));

        //strivers
        System.out.println(solveDPStriver(arr));



    }

    private static int solve(int[] a, int i,int curr) {
        if (i==0) return curr - a[i];
        if (curr>=a[i]){
            return Math.max(curr-a[i],solve(a,i-1,curr));
        }
        return Math.max(solve(a,i-1,a[i]),solve(a,i-1,curr));
    }

    private static int solveMemo(int[] a, int i,int curr,int dp[][]) {
        if (i==0) return curr - a[i];
        if (dp[i][curr]!=-1) return dp[i][curr];
        if (curr>=a[i]){
            dp[i][curr]= Math.max(curr-a[i],solve(a,i-1,curr));
        }
        else
            dp[i][curr] = Math.max(solve(a,i-1,a[i]),solve(a,i-1,curr));

        return dp[i][curr];
    }

    private static int solveTab(int[] a) {
        int n = a.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,a[i]);
        }
        int[][] dp = new int[n][max+1];
        for (int i = 1; i <= max; i++) {
            dp[0][i] = i - a[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= max; j++) {
                if (j>=a[i]){
                    dp[i][j] = Math.max(j-a[i],dp[i-1][j]);
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][a[i]],dp[i-1][j]);

                }
            }
        }
        return dp[n-1][max];

    }

    //Strivers -- easy -- just remembering the past [DP] -- wasnt able to think that st will do like this -- i knew this approach athough
    static int solveDPStriver(int a[]){
        int m = a[0];
        int cost = 0,profit = 0;
        for (int i = 1; i < a.length; i++) {
            cost = a[i] -m;
            profit = Math.max(cost,profit);
            m = Math.min(m,a[i]);
        }
        return profit;
    }
}
