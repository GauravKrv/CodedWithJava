package StriverDP;

import java.util.Arrays;

public class MakeStringPalindromeQ29 {

//got hint to delete chars instead of inserting from comments
    public static void main(String[] args) {

//        String s1 = "adam";
        String s1 = "wozamanzo";
//        String s1 = "acbbca";

        int n1 = s1.length();
        int[][] dp = new int[n1][n1]; //since dp cannot store 0 as a value of n -- or b ranges from 0->n-1 as value

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(s1,0,n1 - 1)); //WORKS - MINE
        System.out.println(solveMemo(s1,0,n1 - 1,dp)); //WORKS - MINE
        System.out.println(solveTab(s1)); // WRONG
        System.out.println(solve(s1)); //WORKS - USING LCS/longest palindromic subseq






    }

    //works ------- mine -- top down
    private static int solve(String s1, int i, int j) {
        if (i==j) return 0; // if mid element occurs
        if (i==j-1) {  //if string is even and no mid
            if (s1.charAt(i) != s1.charAt(i + 1)) { //if mid even length string elements doesnt matche then one insertion will work
                return 1;
            }else return 0;
        }

        int left = (int) 1e9,right = (int) 1e9,ans = (int) 1e9;
        if (s1.charAt(i) != s1.charAt(j)){ //if not matches current chars, either insert - ith or jth character and check further
            left = 1+solve(s1, i+1, j);
            right = 1+solve(s1, i, j-1);

        }else{
            ans = solve(s1, i+1, j-1); //if matches then increment
        }

        return Math.min(Math.min(left,right),ans); //return min of all
    }


    //works mine top down - memo
    private static int solveMemo(String s1, int i, int j,int dp[][]) {
        if (i==j) return 0; // if mid element occurs
        if (i==j-1) {  //if string is even and no mid
            if (s1.charAt(i) != s1.charAt(i + 1)) { //if mid even length string elements doesnt matche then one insertion will work
                return 1;
            }else return 0;
        }

        if (dp[i][j]!=-1) return dp[i][j];
        int left = (int) 1e9,right = (int) 1e9,ans = (int) 1e9;
        if (s1.charAt(i) != s1.charAt(j)){ //if not matches current chars, either insert - ith or jth character and check further
            left = 1+solve(s1, i+1, j);
            right = 1+solve(s1, i, j-1);

        }else{
            ans = solve(s1, i+1, j-1); //if matches then increment
        }

        dp[i][j] = Math.min(Math.min(left,right),ans); //return min of all

        return dp[i][j];
    }


    //below tabulation made using recursion was wrong ---Doesnt WOrks
    private static int solveTab(String s1) {
        int n1 = s1.length();
        int[][] dp = new int[n1][n1]; //since dp cannot store 0 as a value of n -- or b ranges from 0->n-1 as value

        for (int i = 0; i < n1-1; i++) {
            dp[i][i] = 0;
            dp[i][i+1] = (s1.charAt(i) != s1.charAt(i + 1))?1:0;

        }

        for (int i = 1; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                int left = (int) 1e9,right = (int) 1e9,ans = (int) 1e9;
                if (s1.charAt(i) != s1.charAt(j)){ //if not matches current chars, either insert - ith or jth character and check further
                   if (i+1<n1) left = 1+dp[i+1][j];
                    if (j>0) right = 1+dp[i][j-1];

                }else{
                    if (i+1<n1 && (j>0))  ans = dp[i+1][j-1]; //if matches then increment
                }
                dp[i][j] = Math.min(Math.min(left,right),ans);
            }
        }


        return  dp[n1-1][n1-1];
    }

    //THINKKKKKKKKKKKKKKK ---> ANS = [String length] - [Length of longest palindromic subsequence] -below
    static int solve(String s){
        int lcs = longestPalindromic(s);
        return s.length()-lcs;
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
