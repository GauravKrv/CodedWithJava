package StriverDP;

import java.util.Scanner;

public class CoinChangeQ22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 6;
        int[] coins = new int[]{45, 20, 15,35, 5, 40};
        int target = 50;

        int[][] dp = new int[n][target + 1]; //since dp can store 0 as coins value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(coins, n - 1, target));
        System.out.println(solveMemo(coins, n - 1, target,dp));
        System.out.println(solveTab(coins, target));


    }

    //My Bottom up -- workss
    private static int solve(int[] a, int i, int target) {
        if(target==0) return 1;
        if (i==0) {
            if (target>=a[0]&&(target % a[0] == 0)) {
                return 1;
            } else return 0;
        }
        int notake = solve(a,i-1,target);//not include curr index
        int take = 0;
        if (a[i]<=target) {
            take = solve(a, i ,target-a[i]); //dont include curr index element here also
        }

        return take+notake;
    }

    //My Bottom up [memo] -- workss
    private static int solveMemo(int[] a, int i, int target,int[][] dp) {
        if(target==0) return 1;
        if (i==0) {
            if (target>=a[0]&&(target % a[0] == 0)) {
                return 1;
            } else return 0;
        }
        if (dp[i][target]!=-1) return dp[i][target];
        int notake = solve(a,i-1,target);//not include curr index
        int take = 0;
        if (a[i]<=target) {
            take = solve(a, i ,target-a[i]); //dont include curr index element here also
        }

        dp[i][target]= take+notake;
        return dp[i][target];
    }

    //My - Tabulation - worksss
    private static int solveTab(int[] a, int target) {
        int[][] dp = new int[a.length][target + 1]; //since dp can store 0 as coins value of target -- or target ranges from 0-target as value

        for (int i = 0; i <= target; i++) {
                if (i>=a[0]&&(i % a[0] == 0))
                    dp[0][i] =1;
        }
        dp[0][0] = 1;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j <= target; j++) {
                int notake = dp[i-1][j];//not include curr index
                int take = 0;
                if (a[i]<=j) {
                    take = dp[i][j-a[i]]; //dont include curr index element here also
                }
                dp[i][j] = take+notake;
            }
        }


        return dp[a.length-1][target];
    }

}
