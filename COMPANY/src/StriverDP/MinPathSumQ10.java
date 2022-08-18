package StriverDP;

import java.util.Scanner;

public class MinPathSumQ10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] a = new int[][]{
                {10,2,1},
                {5,15,60},
                {5,70,5}}; //78-min path sum
        int m = a.length;
        int n = a[0].length;


        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(n,a,m-1,n-1));
        System.out.println(solvememo(n,a,m-1,n-1,dp));
        System.out.println(solvetab(m,a));


    }

    //TOP - DOWN - RECURSIVE - WORKS
    private static int solve(int n, int[][] a, int i, int j) {

        if (i==0&&j==0) return a[i][j];
        if (i==0) return a[i][j]+solve(n,a,i,j-1);
        if (j==0) return a[i][j]+solve(n,a,i-1,j);
        int up  =a[i][j]+solve(n,a,i-1,j);
        int left = a[i][j]+solve(n,a,i,j-1);
        return Math.min(up,left);


    }

    //MEMO - WORKS
    private static int solvememo(int n, int[][] a, int i, int j,int[][] dp) {

        if (i==0&&j==0) return a[i][j];
        if (i<0 || (j<0)) return Integer.MAX_VALUE - (100000);//if we exceed max value of integer and store it, then it will be stored as negative

//        if (i==0) return a[i][j]+solve(n,a,i,j-1);
//        if (j==0) return a[i][j]+solve(n,a,i-1,j);

        if (dp[i][j]!=-1) return dp[i][j];

        int up  =a[i][j]+solvememo(n,a,i-1,j,dp);
        int left = a[i][j]+solvememo(n,a,i,j-1,dp);
        dp[i][j] = Math.min(up,left);
        return dp[i][j];


    }

    //TABULATION - MINE

    private static int solvetab(int m, int[][] a) {
        int[][] dp = new int[m][a[0].length]; //initialisation -> the number of params passed in recursion decides dimension of dp
        //size of dp is det , by when the params reaches base

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < a[0].length; j++) {

                if (i==0&&j==0) dp[i][j] = a[i][j]; //base case

               else {
                    int up=Integer.MAX_VALUE,upleft=Integer.MAX_VALUE;
                    if (i > 0) up =a[i][j] + dp[i-1][j]; //base case converted & recursion

                    if (j > 0) upleft =a[i][j] + dp[i][j-1]; //base case converted & recursion

                    dp[i][j]= Math.min(up,upleft);
                }

            }
        }

        return dp[m-1][a[0].length-1];


    }
}
