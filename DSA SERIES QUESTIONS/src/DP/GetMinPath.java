package DP;

import java.util.Scanner;

public class GetMinPath {
    static int getMinCostPathRecur(int i, int j, int[][] paths){
        if(i==0&&j==0) return paths[i][j];
        if(i==0) {
            return paths[i][j - 1] + paths[i][j];
        }
        if(j==0) {
            return paths[i - 1][j] + paths[i][j];
            }
        else
            return Math.min(paths[i][j]+ getMinCostPathRecur(i-1,j,paths),
                    paths[i][j]+ getMinCostPathRecur(i,j-1,paths));
    }

    static int getMinCostPathDP(int n, int m, int[][] paths) {
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0) dp[i][j] = paths[i][j];

                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + paths[i][j];
                }
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + paths[i][j];
                } else
                    dp[i][j] = Math.min(paths[i][j] + dp[i-1][j], paths[i][j] + dp[i][j-1]);
            }
        }

        return dp[n-1][m-1];
    }
/*
3 3
5 1 2
1 2 6
7 0 2
* */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m  = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(getMinCostPathRecur(n-1,m-1,arr));
        System.out.println(getMinCostPathDP(n,m,arr));
    }


}
