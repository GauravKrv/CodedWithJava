package StriverDP;

import java.util.Scanner;

public class TargetPlusMinusAssignSumQ21 {
//    BETTER WAY -> CONVERT THIS PROBLEM TO dIFF Between two sibset = target => DP Q18 problm
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 4;
        int[] a = new int[]{1, 2, 2, 4};
        int target = 5;

        int[][] dp = new int[n][target + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(a, n - 1, target));
        System.out.println(solveMemo(a, n - 1, target, dp));
        System.out.println(solveTab(a,  target));



    }

    //My + Bottom up - works
    private static int solve(int[] a, int i, int target) {
        if (i == 0) {
            int c=0;
            if (target - a[0] == 0) {
                c+= 1;
            }
            if (target + a[0] == 0) {
                c+= 1;
            }
            return c;

        }
        int plus = solve(a, i - 1, target - a[i]);//assign posetive to current index => curr+a[i] || can do target - a[i] to make target 0 instead

        int minus = solve(a, i - 1, target + a[i]); //assign negative to current index => curr-a[i] || can do target + a[i] to make target 0 instead


        return plus + minus;
    }

    //My + Bottom up Memozation - works
    private static int solveMemo(int[] a, int i, int target, int[][] dp) {
        if (i == 0) {
            int c=0;
            if (target - a[0] == 0) {
                c+= 1;
            }
            if (target + a[0] == 0) {
                c+= 1;
            }
            return c;
        }
        if (dp[i][target] != -1)
            return dp[i][target]; //-> will work because if -1, then next lines will calculate all possible ways from
        //that particular index thus no need to worry
        int plus = solve(a, i - 1, target - a[i]);//assign posetive to current index => curr+a[i] || can do target - a[i] to make target 0 instead

        int minus = solve(a, i - 1, target + a[i]); //assign negative to current index => curr-a[i] || can do target + a[i] to make target 0 instead


        dp[i][target] = plus + minus;
        return dp[i][target];
    }


    //DOESNT WORKS --- AS NEGATIVE INDEXING OR SIGN IS TOO COMPLEX THING -- BETTER WAY -> CONVERT THIS PROBLEM TO dIFF Between two sibset = target => DP Q18 problm
    private static int solveTab(int[] a, int target) {
        int[][][] dp = new int[a.length][target + 1][2]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i <= target; i++) {
            if (i-a[0]==0){
                dp[0][i][0] = 1;
            }
            if (i+a[0]==0)
            dp[0][i][1] = 1;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j <= target; j++) {

                int sign = -1;
                //how to assign negative indexing --> j-a[i] can be -ve
                if (j-a[i]>0) sign = 1;
                else sign = 0;
                int plus = dp[i - 1][ Math.abs(j - a[i])][sign];//assign posetive to current index => curr+a[i] || can do target - a[i] to make target 0 instead

                if (j + a[i]>0) sign = 1;
                else sign = 0;
                int minus = dp[i - 1][j+a[i]][sign]; //assign negative to current index => curr-a[i] || can do target + a[i] to make target 0 instead


                if (plus + minus > 0) sign = 1;
                else sign = 0;
                dp[i][j][sign] = Math.abs(plus + minus);
            }
        }
        return (dp[a.length-1][target][0]!=0)?dp[a.length-1][target][0]:dp[a.length-1][target][1];

    }
}
