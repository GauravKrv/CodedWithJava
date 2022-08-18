package StriverDP;

import java.util.Arrays;

public class EditDistance33 {
    public static void main(String[] args) {
        String s2 = "plasma";
        String s1 = "altruism";
//        String s1 = "saturday";
//        String s2 = "sunday";
//        String s1 = "intention";
//        String s2 = "execution";
//        String s1 = "horse";
//        String s2 = "ros";
        int n = s1.length();
        int m = s2.length();
//works
        System.out.println(solve(s1, s2, n - 1, m - 1));

        int dp[][] = new int[n][m];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        //works
        System.out.println(solveMemo(s1, s2, n - 1, m - 1, dp));

        System.out.println(solveTab(s1, s2));

    }

    //converting s1 to s2 -- works - my+hint striver
    private static int solve(String s1, String s2, int i, int j) {
        if (j<0) return i+1; //remove this
        if (i<0) return j+1;//insert these
//FOR BETTER TABULATION APPROACH -- + DO SHIFTING OF INDEXES
//        if (j==0) return i+1;
//        if (i==0) return j+1;

        int insert = (int) 1e9;
        int remove = (int) 1e9;
        int replace = (int) 1e9;
        int proceed = (int) 1e9;

        if (s1.charAt(i)!=s2.charAt(j)){
            insert =1+ solve(s1, s2, i, j-1); //insert after curr pos of s1 and keep i saem, and decrement j since s2[j] is matched with inserted
            remove = 1+solve(s1, s2, i-1, j); //just remove curr position from s1 and dec i and keep j same to look in next round
            replace =1+ solve(s1, s2, i-1, j-1); ///just replace i and decrement both - we know why

        }else {
            proceed = solve(s1, s2, i-1, j-1);
        }
        return Math.min(Math.min(insert,remove),Math.min(replace,proceed));


    }

    private static int solveMemo(String s1, String s2, int i, int j,int dp[][]) {
        if (j<0) return i+1; //remove this
        if (i<0) return j+1;//insert these

        int insert = (int) 1e9;
        int remove = (int) 1e9;
        int replace = (int) 1e9;
        int proceed = (int) 1e9;

        if (dp[i][j]!=-1) return dp[i][j];
        if (s1.charAt(i)!=s2.charAt(j)){
            insert =1+ solveMemo(s1, s2, i, j-1,dp);
            remove = 1+solveMemo(s1, s2, i-1, j,dp);
            replace =1+ solveMemo(s1, s2, i-1, j-1,dp);

        }else {
            proceed = solveMemo(s1, s2, i-1, j-1,dp);
        }
        dp[i][j] = Math.min(Math.min(insert,remove),Math.min(replace,proceed));

        return dp[i][j];
    }

    //WORKS FINE -----
    private static int solveTab(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
//works
        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;   //j-1 is less than 0 here
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;   //j-1 is less than 0 here
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {


                int insert = (int) 1e9;
                int remove = (int) 1e9;
                int replace = (int) 1e9;
                int proceed = (int) 1e9;

                if (s1.charAt(i-1) != s2.charAt(j-1)) {
                    insert = 1 + dp[i][j - 1]; //insert after curr pos of s1 and keep i saem, and decrement j since s2[j] is matched with inserted
                    remove = 1 + dp[i - 1][j]; //just remove curr position from s1 and dec i and keep j same to look in next round
                    replace = 1 + dp[i - 1][j - 1]; ///just replace i and decrement both - we know why

                } else {
                    proceed = dp[i - 1][j - 1];
                }
                dp[i][j] = Math.min(Math.min(insert, remove), Math.min(replace, proceed));

            }

        }
        return dp[n][m];
    }
}
