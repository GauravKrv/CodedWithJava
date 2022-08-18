package StriverDP;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncSubseqQ41 {
    //TOP DOWN WAS FAILING --- HAD TO START FROM 0 INDEXING
    public static void main(String[] args) {
//        int ar[] = {1,3,6,7,9,4,10,5,6};
//        int ar[] = {1,4,5,2,3,7}; //WORKS
        int ar[] = {10, 9, 2, 5, 3, 7, 101, 18}; //WORKS


        int n = ar.length;
        int[][] dp = new int[n][n + 1]; //since dp cannot store 0 as a value of n -- or b ranges from 0->n-1 as value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        //ALL WORKS
        System.out.println(solve(ar, n - 1, n - 1));


        System.out.println(solveTab(ar, n));
        System.out.println(solveTabSOp(ar, n));


//        System.out.println(solveMemo(ar,n-1,n-1,dp));
        System.out.println();
        System.out.println(solveT(ar, 0, -1));
        System.out.println(solveTabSOpT(ar, n));//fails
        System.out.println(solveMemoSt(ar, 0, -1, dp));
//WORKS
        System.out.println(solveTabSt(ar));
//works
        System.out.println(otherBest(ar));
        //works - to print lis
        System.out.println(otherBestprintIS(ar));





    }

    //WORKS -- MINE
    private static int solve(int[] ar, int i, int prev) {

        if (i == 0 && ar[prev] > ar[i]) return 2;
        if (i == 0) return 1;
        int take = 0;
        if (ar[i] < ar[prev]) {
            take = 1 + solve(ar, i - 1, i);
        }

        int notake = solve(ar, i - 1, prev);

        return Math.max(take, notake);
    }

    //WORKS -- MINE
    private static int solveMemo(int[] ar, int i, int prev, int dp[][]) {

        if (i == 0 && ar[prev] > ar[i]) return 2;
        if (i == 0) return 1;
        if (prev != -1 && dp[i][prev] != -1) return dp[i][prev];

        int take = 0;
        if (ar[i] < ar[prev]) {
            take = 1 + solveMemo(ar, i - 1, i, dp);
        }

        int notake = solveMemo(ar, i - 1, prev, dp);

        dp[i][prev] = Math.max(take, notake);
        return dp[i][prev];
    }

    //WORKS -- MINE
    private static int solveTab(int[] ar, int n) {

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (ar[0] < ar[i]) dp[0][i] = 2;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int take = 1;
                if (ar[i] < ar[j]) {
                    take = 1 + dp[i - 1][i];
                }
                int notake = dp[i - 1][j];

                dp[i][j] = Math.max(take, notake);
            }
        }

        return dp[n - 1][n - 1];

    }

    //WORKS -- MINE
    private static int solveTabSOp(int[] ar, int n) {

        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (ar[0] < ar[i]) dp[i] = 2;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int take = 1;
                if (ar[i] < ar[j]) {
                    take = 1 + dp[i];
                }
                int notake = dp[j];

                dp[j] = Math.max(take, notake);
            }
        }

        return dp[n - 1];

    }

    private static int solveT(int[] ar, int i, int prev) {


        if (i == ar.length) return 0;
        int take = 0;
        if (prev == -1 || ar[i] > ar[prev]) {
            take = 1 + solveT(ar, i + 1, i);
        }

        int notake = solveT(ar, i + 1, prev);

        return Math.max(take, notake);
    }

    //failsss
    private static int solveTabSOpT(int[] ar, int n) {
        int len = ar.length;
        int dp[] = new int[len + 1];


        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int take = 0;
                if (ar[i] > ar[j]) {
                    take = 1 + dp[j + 1];
                }
                int notake = dp[j];

                dp[j] = Math.max(take, notake);
            }
        }

        return dp[0];

    }
    //WORKS FINE

    static int solveMemoSt(int[] ar, int i, int prev, int[][] dp) {
        if (i == ar.length) return 0;
        int take = 0;
        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];
        if (prev == -1 || ar[i] > ar[prev]) {
            take = 1 + solveMemoSt(ar, i + 1, i, dp);
        }

        int notake = solveMemoSt(ar, i + 1, prev, dp);

        dp[i][prev + 1] = Math.max(take, notake);
        return dp[i][prev + 1];
    }

    //WORKS FINE
    static int solveTabSt(int[] ar) {
        int n = ar.length;
        int dp[][] = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            //just do prev -> prev+1 everywhere
            for (int j = i - 1; j >= -1; j--) { //since prev starts with 1, i.e 0-1, i.e i-1 in recursition
                int take = 0;
                if (j == -1 || ar[i] > ar[j]) {
                    take = 1 + dp[i + 1][i + 1];
                }
                int notake = dp[i + 1][j + 1];

                dp[i][j + 1] = Math.max(take, notake);
            }
        }

        return dp[0][0];
    }

    //O-N^2
    static int otherBest(int[] ar) {
        int n = ar.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[i] > ar[j]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //TC = O(N^2)
    static int otherBestprintIS(int[] ar) {
        int n = ar.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        int lastIndex = 0;
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (ar[i] > ar[prev] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if (dp[i]>max){
                max  =dp[i];
                 lastIndex = i;
            }

        }
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(ar[lastIndex]);
        int ind = 1;
        while (hash[lastIndex]!=lastIndex){
            lastIndex = hash[lastIndex];
            lis.add(0,ar[lastIndex]);

        }
        System.out.println(lis);
        return max;
    }

}
