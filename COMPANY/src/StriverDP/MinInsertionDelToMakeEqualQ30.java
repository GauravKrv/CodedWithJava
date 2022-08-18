package StriverDP;

import java.util.Arrays;

public class MinInsertionDelToMakeEqualQ30 {
    // Use LCS - - [ans = (l1 - lcs) + (l2 - lcs)]

    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 6;
        String s1 = "aaaaa";
        String s2 = "aabbaa";
        int[][] dp = new int[n1][n2]; //since dp cannot store 0 as a value of n -- or b ranges from 0->n-1 as value

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(s1, s2));
    }

    static int solve(String s1,String s2){
        int lcs = lcsStriver(s1,s2);
        return s1.length()-lcs + s2.length() - lcs;
    }
    static int lcsStriver(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

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
