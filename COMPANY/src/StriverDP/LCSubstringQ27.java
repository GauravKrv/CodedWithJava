package StriverDP;

import java.util.Arrays;

public class LCSubstringQ27 {

    public static void main(String[] args) {

        String s1 = "aacabdkacaa";
        String s2 = "aacakdbacaa";
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2]; //since dp cannot store 0 as a value of n -- or b ranges from 0->n-1 as value

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = -1;
            }
        }
//        System.out.println(solve(s1,s2,n1 - 1,n2-1));
//        System.out.println(solve3p(s1,s2,n1 - 1,n2-1,0));
             System.out.println(solveLcsTab(s1,s2,n1 ,n2));



    }
    //mine - bottom up - fails with 2 parameters
    private static int solve(String s1, String s2, int i,int j) {

        if (i==0||j==0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                return 1;
            } else {
                return 0;
            }
        }

        int ans = 0;
        if (s1.charAt(i)!=s2.charAt(j)) {
            return Math.max(solve(s1, s2, i, j-1),solve(s1, s2, i-1, j));

        }
        else {
            ans = 1 + solve(s1, s2, i - 1, j - 1);
        }
        return ans;

    }

    //3 parameter recursion - works fine
    private static int solve3p(String s1, String s2, int i,int j,int len) {

        if (i< 0 || j<0) {
            return len;
        }

        int match=0;
        if (s1.charAt(i)!=s2.charAt(j)) { //if not match -- assign new length
            match= Math.max(solve3p(s1, s2, i, j-1,0),solve3p(s1, s2, i-1, j,0));

        }
        else { //increment current length
            match = solve3p(s1, s2, i - 1, j - 1,len+1);
            len+=1;
        }
        return Math.max(match,len);

    }

    //my -- bottom up - using lcs - modifying it a bit - works
    private static int solveLcsTab(String s1, String s2,int n,int m) {
        int max = (int) -1e9;

        int[][] dp = new int[n + 1][m + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int ans = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) //if matches then add to current and no need to skip [think]
                    ans = 1 + dp[i - 1][j - 1]; //if curr indexes matches then look for up left i.e whether prev elements were also same, if yes
                //add prev value to 1
                else ans = 0; //else set or leave current to 0

                dp[i][j] = ans;
                max = Math.max(max, ans); //storing max value

            }
        }
        System.out.println("PRINTING DP .... ");
        Print.print(dp);
        System.out.println("PRINTING LCSUB .... ");

        int i=0,j=0,mx=0;
        for (int k = 0; k <= s1.length(); k++) {
            for (int l = 0; l <= s2.length(); l++) {
                if (dp[k][l]>mx){
                    mx = dp[k][l];
                    i = k;
                    j = l;

                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        while (i>0&&j>0) {
            if (dp[i][j] > dp[i - 1][j - 1] && s1.charAt(i -1)==s2.charAt(j-1)) {
                sb.append(s2.charAt(j - 1));
            }
            if (dp[i][j] == 0) {
                break;
            }
            i-=1;
            j-=1;
        }
        System.out.println("String = "+sb);

        return max;

    }


}
