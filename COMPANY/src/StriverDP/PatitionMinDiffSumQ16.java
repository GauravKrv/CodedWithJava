package StriverDP;

import java.util.Scanner;

public class PatitionMinDiffSumQ16 {
    public static void main(String[] args) {
        int n = 4;
        int[] a = new int[]{10, 20, 30, 30};
        int target = 50;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        int[][] dp = new int[n][sum + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(a, n - 1,sum, 0,0));
        System.out.println(solveMemo(a, n - 1,sum, 0,0,dp));
        System.out.println(solveTab(a, sum));



    }

    //recur - myy - works
    private static int solve(int[] a, int i, int sum, int s1, int s2) {
       if (s1+s2==sum) return Math.abs(s1-s2);
       int take = solve(a, i-1, sum, s1+a[i], s2);
       int notake = solve(a, i-1, sum, s1 ,s2+a[i]);
       return Math.min(take,notake);

    }

    //Worked - memo - mine
    private static int solveMemo(int[] a, int i, int sum, int s1, int s2,int[][] dp) {
        if (s1+s2==sum) return Math.abs(s1-s2);
        if (dp[i][s1]!=-1) return Math.abs(dp[i][s1]);

        int take = solveMemo(a, i-1, sum, s1+a[i], s2,dp);
        int notake = solveMemo(a, i-1, sum, s1 ,s2+a[i],dp);
        dp[i][s1] = Math.min(take,notake);
        return dp[i][s1];
    }

    //Tabulation - using subset sum can be solved -- same idea as mine [Algo-Striver, Code-Own] - Works

    private static int solveTab(int[] a, int sum) {
        boolean[][] dp = subsetSumQ14(a,sum); // obtain the dp table made by Q14-subset sum method
        int mindiff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (isSumPossible(dp,i)) //if sum is possible in the dp table
            mindiff = Math.min(mindiff,Math.abs(i-(sum-i))); //check if it gives min difference or partition
        }
        return mindiff;
    }

    //below will check if the given sum can be possible in the dp or is set to true in the dp created by Q14-method
    private static boolean isSumPossible(boolean[][] dp, int i) {
        for (int j = 0; j < dp.length; j++) {
            if (dp[j][i]==true) return true;
        }
        return false;
    }

    //using below function to get its dp table
    private static boolean[][] subsetSumQ14(int[] a,int target) {
        boolean[][] dp = new boolean[a.length][target+1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        //base case 1
        for (int i = 0; i < a.length; i++)
            dp[i][0] = true;

        //base case 2 -- critical thinking
        dp[0][a[0]] = true;  //if i==0 && target == a[0] return true

//just look and copy the recursion thing here
        for (int i = 1; i < a.length; i++) { //if i==0 dp[i][j] = false for all except one i the 2nd base case
            for (int j = 1; j <= target; j++) { //if j==0 => target is reached to 0 thus is true
                boolean notake = dp[i-1][j];//not include curr index
                boolean take = false;
                if (a[i]<=j) {
                    take = dp[i - 1][j-a[i]]; //include curr index element also
                }
                dp[i][j] = take||notake;
            }
        }

        return dp;
    }

}
