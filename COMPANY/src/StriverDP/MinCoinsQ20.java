package StriverDP;

import java.util.Scanner;

public class MinCoinsQ20 {

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
        System.out.println(solveTab(coins,  target));



    }

    //My + sTRIVER Bottom up
    private static int solve(int[] a, int i, int target) {
        if (i==0) {
            if (target >= a[0] &&(target % a[0] == 0)) {
                  return target / a[0];
            } else return (int) 1e9;
        }
        int notake = solve(a,i-1,target);//not include curr index
        int take = Integer.MAX_VALUE;
        if (a[i]<=target) {
            take = 1 + solve(a, i ,target-a[i]); //dont include curr index element here also
        }

        return Math.min(take , notake);
    }

    //My + sTRIVER Bottom up - memoizatoin
    private static int solveMemo(int[] a, int i, int target,int[][] dp) {
        if (i==0) {
            if (target >= a[0] &&(target % a[0] == 0)) {
                return target / a[0];
            } else return (int) 1e9;
        }
        if (dp[i][target]!=-1) return dp[i][target];

        int notake = solve(a,i-1,target);//not include curr index
        int take = Integer.MAX_VALUE;
        if (a[i]<=target) {
            take = 1 + solve(a, i ,target-a[i]); //dont include curr index element here also
        }

        dp[i][target]= Math.min(take , notake);
        return dp[i][target];
    }

    //Top - down - works
    private static int solveTab(int[] a, int target) {
        int[][] dp = new int[a.length][target + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i <= target; i++) {
            if (i%a[0]==0){  //if i%a[0] and not a[0] %i
                dp[0][i] = i/a[0];
            }else{
                dp[0][i] = (int) 1e9;
            }
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j <= target; j++) {
         int notake = dp[i-1][j];//not include curr index
        int take = Integer.MAX_VALUE;
        if (a[i]<=j) {
            take = 1 + dp[i][j-a[i]]; //dont include curr index element here also
        }

        dp[i][j]= Math.min(take , notake);
            }
        }
        return dp[a.length-1][target];
    }



}
