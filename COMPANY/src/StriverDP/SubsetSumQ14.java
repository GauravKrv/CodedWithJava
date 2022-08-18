package StriverDP;

import java.util.Scanner;

public class SubsetSumQ14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int[] a = new int[]{10, 20, 30, 10, 30};
        int target = 50;
        int[][] dp = new int[n][target+1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve( a, n-1 , target));
        System.out.println(solveMemo( a, n-1 , target,dp));
        System.out.println(solveTab( a,  target));



    }

    //bottom up - workss
    private static boolean solve(int[] a, int i, int target) {
        if (target==0) return true;
        if (i==0) return (a[0] == target);
        //        if (i<0) return false;  -- also works - mine
        boolean notake = solve(a,i-1,target);//not include curr index
        boolean take = false;
        if (a[i]<=target) {
            target-=a[i];
            take = solve(a, i - 1,target); //include curr index element also
        }

        return (take || notake);
    }

    //workss

    private static boolean solveMemo(int[] a, int i, int target, int[][] dp) {
        if (target==0) return true;
        if (i==0) return (a[0] == target);
        //        if (i<0) return false;  -- also works - mine

        if (dp[i][target]!=-1) return dp[i][target] == 1;

        boolean notake = solve(a,i-1,target);//not include curr index
        boolean take = false;
        if (a[i]<=target) {
            target-=a[i];
            take = solve(a, i - 1,target); //include curr index element also
        }

        dp[i][target] = (take || notake)?1:0;
        return dp[i][target] == 1;
    }

    //top down -> using base case to form answer - works
    private static boolean solveTab(int[] a,int target) {
        boolean[][] dp = new boolean[a.length][target+1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        //base case 1
        for (int i = 0; i < a.length; i++)
                dp[i][0] = true;

        //base case 2 -- critical thinking
        if (a[0]<=target)dp[0][a[0]] = true;  //if i==0 && target == a[0] return true

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

        return dp[a.length-1][target];
    }


}
