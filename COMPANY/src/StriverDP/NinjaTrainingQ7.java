package StriverDP;

import java.util.Scanner;

public class NinjaTrainingQ7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 2;
        int[][] a = new int[][]{{10,50,1},{5,100,11}};

        int[][] dp = new int[n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(n-1, a, 0));
        System.out.println(solveStriver(n-1, a, 3));
        System.out.println(solveStriverMemo(n-1, a, 3,dp));


        System.out.println(solveDP(n,a));
    }

    //top down - works
    private static int solve(int n, int[][] a, int i) {
        if (n<0) return 0;

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < 3; j++) {
            int take = Integer.MIN_VALUE;
            if (j != i ) // checking if the activity passed is not same as current
                take = a[n][j] + solve(n-1, a, j); //taking current days activity
            max = Math.max(max,take); //taking max till current day

        }
        return max;

        }


    //top down - dp doesnt works as it chooses greedily
    private static int solveDP(int n, int[][] a) {
    int dp[] = new int[n+1];
    dp[0] = 0;

        int max = Integer.MIN_VALUE,prev=-1;
        for (int k = 1; k <= n; k++) {
            int temp=-1;
            for (int j = 0; j < 3; j++) {
                int take = Integer.MIN_VALUE;
                if (j != prev ) { // checking if the activity passed is not same as current
                    take = a[k-1][j] + dp[k - 1]; //taking current days activity
                 }
                if (take>dp[k]) temp=j;
                dp[k] = Math.max(dp[k],take); //taking max till current day

            }
            prev = temp;
        }

        return dp[n];

    }


    //top down - STRIVER
    private static int solveStriver(int day, int[][] a, int last) {
        if (day==0) {
            int max = Integer.MIN_VALUE;
            for (int task = 0; task < 3; task++) { //just get the max element which is not last --> reduces extra calls[not in my recursion]
                if (task != last ) // checking if the activity passed is not same as current
                max = Math.max(max,a[0][task]); //taking max till current day

            }
            return max;
        }

        int max = Integer.MIN_VALUE;
        for (int task = 0; task < 3; task++) {
            int point = Integer.MIN_VALUE;
            if (task != last ) // checking if the activity passed is not same as current
                point = a[day][task] + solveStriver(day-1, a, task); //taking current days activity
            max = Math.max(max,point); //taking max till current day

        }
        return max;

    }



    //top down - STRIVER - MEMO -- WORKS
    private static int solveStriverMemo(int day, int[][] a, int last,int dp[][]) {
        if (day==0) {
            int max = Integer.MIN_VALUE;
            for (int task = 0; task < 3; task++) { //just get the max element which is not last --> reduces extra calls[not in my recursion]
                if (task != last ) // checking if the activity passed is not same as current
                    max = Math.max(max,a[0][task]); //taking max till current day

            }
            dp[day][last] = max; //is last element was this then curr days dp = max ***** thinking point
        }

        if (dp[day][last] != -1) return dp[day][last];

        int max = Integer.MIN_VALUE;
        for (int task = 0; task < 3; task++) {
            int point = Integer.MIN_VALUE;
            if (task != last ) // checking if the activity passed is not same as current
                point = a[day][task] + solveStriverMemo(day-1, a, task,dp); //taking current days activity
            max = Math.max(max,point); //taking max till current day

        }

        dp[day][last] = max; //is last element was this then curr days dp = max

        return dp[day][last];

    }
}

