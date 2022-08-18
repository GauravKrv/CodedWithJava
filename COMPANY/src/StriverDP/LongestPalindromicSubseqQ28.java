package StriverDP;

import java.util.Arrays;

public class LongestPalindromicSubseqQ28 {
    public static void main(String[] args) {

        String s1 = "bbbab";
        int n1 = s1.length();
        int[][] dp = new int[n1][n1]; //since dp cannot store 0 as a value of n -- or b ranges from 0->n-1 as value

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(s1,0,n1 - 1));
        System.out.println(longestPalindromic(s1));



    }

    //my recursion try -- failssssssssssssss
    private static int solve(String s1, int i, int j) {
        if (i==j) return 1;
        if (i>j) return 0;
        int len = 0,notake;
        if (s1.charAt(i)==s1.charAt(j)){
           len = 1 + solve(s1,i+1,j-1);
        }else{
            len = Math.max(solve(s1, i+1, j),solve(s1, i, j-1));
        }
        return len;
    }

    //Modification of lcs -- strivers method -- workssss
    static int longestPalindromic(String s1) {

        int n=s1.length();
        String s2 =String.valueOf((new StringBuilder(s1)).reverse());
        int m = n;
        int dp[][]=new int[n+1][m+1];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }

        return dp[n][m];
    }
}
