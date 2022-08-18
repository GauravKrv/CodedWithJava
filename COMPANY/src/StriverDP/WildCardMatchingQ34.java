package StriverDP;

import java.util.Arrays;

public class WildCardMatchingQ34 {
//S2 should have owercase || * || ?  and S1 only lowercase
    public static void main(String[] args) {

//        String s1 = "aa";
//        String s2 = "*";
//        String s1 = "ray";
//        String s2 = "?ay"; //--> example for memo

        String s1 = "abcd";
        String s2 = "**?bcd";

        int n = s1.length();
        int m = s2.length();

        //Works - top down
        System.out.println(solve(s2,s1,m-1,n-1));

        int dp[][] = new int[m][n];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        //works fine - top down
        System.out.println(solveMemo(s2,s1,m-1,n-1, dp));

        //works fne - bottom -up
        System.out.println(solveTab(s2,s1));
    }


    private static boolean solve(String s1, String s2, int i, int j) {

        if (j<0 && i< 0) return true; //if both are exhausted
        if (j<0 && s1.charAt(i) != '*') return false; //if 2nd is exhausted and * is not present in 1st string
        if (i<0) return false; //if 1st itself is exhausted

        if (s1.charAt(i)=='*'){ //if current is *

           boolean take = false,lookahead = false;
           if (j>=0) take = solve(s1, s2, i-1, j-1); //either take and match both
           if (j>=0) lookahead = solve(s1, s2, i, j-1); //either match and take only s2
           boolean exclude = solve(s1, s2, i-1, j); //either take start as null

            return take||lookahead||exclude; //retur true if any one is true

        }

        if (s1.charAt(i)=='?' || s1.charAt(i)==s2.charAt(j)){ //proceed if '?' single char match placeholder occurs
            return solve(s1, s2, i-1, j-1);
        }


        return false; //if nothing matches
    }

    private static boolean solveMemo(String s1, String s2, int i, int j, int[][] dp) {
        if (j<0 && i< 0) return true; //if both are exhausted
        if (i<0) return false; //if 1st itself is exhausted
        if (j<0) {
                while (i>=0){
                    if(s1.charAt(i)!='*') return false;
                    i--;
                }
                return true;
        }
        if (dp[i][j]!=-1) return dp[i][j] == 1;

        if (s1.charAt(i)=='*'){ //if current is *

            boolean take = false,lookahead = false;
            take = solveMemo(s1, s2, i-1, j-1,dp); //either take and match both -- no need striver
            lookahead = solveMemo(s1, s2, i, j-1,dp); //either match and take only s2
            boolean exclude = solveMemo(s1, s2, i-1, j,dp); //either take start as null

            dp[i][j] = (take||lookahead||exclude)? 1 : 0; //store 1 if true else 0

        }

        else if (s1.charAt(i)=='?' || s1.charAt(i)==s2.charAt(j)){ //proceed if '?' single char match placeholder occurs
            dp[i][j] = solveMemo(s1, s2, i-1, j-1,dp)? 1 : 0; //store 1 if true else 0
        }

        else{
            dp[i][j] = 0;
        }

        return dp[i][j]==1;

    }



    //Bottom - up - workss
    private static boolean solveTab(String s1, String s2) { //s1 has *,?
        int n = s1.length();
        int m = s2.length();
        boolean dp[][] = new boolean[n+1][m+1];

        dp[0][0] = true;//if both are exhausted
        for (int i = 1; i <= n ; i++) { //start from 1 , since 0,0 is already utilized //--check memo base 3 for more info
            if (s1.charAt(i-1) =='*') dp[i][0] = dp[i - 1][0];//if 2nd is exhausted and continuous '*' is not present in 1st string
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1)=='*'){ //if current is *

                    boolean take = false,lookahead = false;
                    take = dp[i-1][j-1]; //either take and match both
                    lookahead = dp[i][j-1]; //either match and take only s2
                    boolean exclude = dp[i-1][j];; //either take start as null

                    dp[i][j] = take||lookahead||exclude; //retur true if any one is true

                }

               else if (s1.charAt(i-1)=='?' || s1.charAt(i-1)==s2.charAt(j-1)){ //proceed if '?' single char match placeholder occurs
                    dp[i][j] = dp[i-1][j-1];
                }

            }
        }
        return dp[n][m];

    }


}
