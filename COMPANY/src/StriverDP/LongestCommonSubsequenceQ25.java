package StriverDP;

import java.util.Arrays;

public class LongestCommonSubsequenceQ25 {
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
        System.out.println(solve(s1,s2,n1 - 1,n2-1));
        System.out.println(solveMemo(s1,s2,n1 - 1,n2-1,dp));
        System.out.println(solveTAB(s1,s2,n1,n2));


        System.out.println(solveSt(s1,s2,n1 - 1,n2-1));
        System.out.println(solveStMemo(s1,s2,n1 - 1,n2-1,dp));
        System.out.println(solveStTab(s1,s2,n1,n2));

        int[][] dp2 = new int[n1+1][n2+1]; //since dp can store 0 as a value of n[for index-1] -- or target ranges from 0-n as value

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                dp2[i][j] = -1;
            }
        }
        //Doesnt works
        System.out.println(solveStShiftedIndex(s1,s2,n1,n2)); //shifted index code- shifted parameter to right side
        System.out.println(solveStShiftedIndexMemo(s1,s2,n1,n2,dp2));
       //works
        System.out.println(lcsStriver(s1,s2)); //shifted index code- shifted parameter to right side




    }
    //mine - bottom up - base optimised
    private static int solve(String s1, String s2, int i,int j) {
        if (i==0||j==0)
            if (s1.charAt(i)== s2.charAt(j)) return 1;
            else return 0;
        int ans = 0;
        if (s1.charAt(i)== s2.charAt(j)) //if matches then add to current and no need to skip [think]
            ans = 1+solve(s1, s2, i-1, j-1);
        else ans = Math.max(solve(s1, s2, i-1, j),solve(s1, s2, i, j-1));

        return ans;
    }

    //mine - bottom up - base optimised - Memo
    private static int solveMemo(String s1, String s2, int i,int j,int[][] dp) {
        if (i==0||j==0)
            if (s1.charAt(i)== s2.charAt(j)) return 1;
            else return 0;

        if (dp[i][j]!=-1) return dp[i][j];

        if (s1.charAt(i)== s2.charAt(j)) //if matches then add to current and no need to skip [think]
            dp[i][j] = 1+solve(s1, s2, i-1, j-1);
        else dp[i][j] = Math.max(solve(s1, s2, i-1, j),solve(s1, s2, i, j-1));

        return dp[i][j];
    }

    //mine - Top down - base optimised -- works
    private static int solveTAB(String s1, String s2, int n,int m) {
        int[][] dp = new int[n][m]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i)== s2.charAt(0)) dp[i][0]= 1;
        }

        for (int i = 0; i < m; i++) {
            if (s1.charAt(0)== s2.charAt(i)) dp[0][i]= 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int ans = 0;
                if (s1.charAt(i)== s2.charAt(j)) //if matches then add to current and no need to skip [think]
                    ans = 1+dp[i-1][j-1];
                else ans = Math.max(dp[i-1][j],dp[i][j-1]);

                dp[i][j] = ans;

            }
        }

        return dp[n-1][m-1];
    }
//---------------------------------------------------------------------------------------------------------
    //striver - typica recursion - works
    private static int solveSt(String s1, String s2, int i,int j) {
        if (i<0||j<0)
          return 0;

        if (s1.charAt(i)== s2.charAt(j)) //if matches then add to current and no need to skip [think]
            return  1+solve(s1, s2, i-1, j-1);

        return Math.max(solve(s1, s2, i-1, j),solve(s1, s2, i, j-1)); // if not matches then only skip

    }

    //striver - typica recursion - Memo - works
    private static int solveStMemo(String s1, String s2, int i,int j,int dp[][]) {
        if (i<0||j<0)
            return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        if (s1.charAt(i)== s2.charAt(j)) //if matches then add to current and no need to skip [think]
            dp[i][j]=  1+solve(s1, s2, i-1, j-1);

        else dp[i][j] = Math.max(solve(s1, s2, i-1, j),solve(s1, s2, i, j-1)); // if not matches then only skip

        return dp[i][j];

    }

    //striver -- tabulation [works] - my way [with shifted recursion -- less lines of code than my tabulation, but extra space than mine]
    private static int solveStTab(String s1, String s2,int n,int m) {

        int[][] dp = new int[n+1][m+1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int ans = 0;
                if (s1.charAt(i-1)== s2.charAt(j-1)) //if matches then add to current and no need to skip [think]
                    ans = 1+dp[i-1][j-1];
                else ans = Math.max(dp[i-1][j],dp[i][j-1]);

                dp[i][j] = ans;

            }
        }

        return dp[n][m];
    }

    //---------------------------------------------------------------------------------------------------------------------
    //shifted recursion is simpy a little mdification n above recursion so as to avoid negative vindexing and tabuation, but gthen also
    //we can write the tabulation

    //striver - shifting index recursion --doesnt works
    private static int solveStShiftedIndex(String s1, String s2, int i,int j) {
        if (i==0||j==0)
            return 0;

        if (s1.charAt(i-1)== s2.charAt(j-1)) //if matches then add to current and no need to skip [think]
            return  1+solve(s1, s2, i-1, j-1);

        return Math.max(solve(s1, s2, i-1, j),solve(s1, s2, i, j-1)); // if not matches then only skip

    }
    //striver - shifting index Memo doesnt works
    private static int solveStShiftedIndexMemo(String s1, String s2, int i,int j,int dp[][]) {
        if (i==0||j==0)
            return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        if (s1.charAt(i-1)== s2.charAt(j-1)) //if matches then add to current and no need to skip [think]
            dp[i][j]=  1+solve(s1, s2, i-1, j-1);

        else dp[i][j] = Math.max(solve(s1, s2, i-1, j),solve(s1, s2, i, j-1)); // if not matches then only skip

        return dp[i][j];

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
