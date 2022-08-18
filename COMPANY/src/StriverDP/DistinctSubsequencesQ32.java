package StriverDP;

import java.util.Arrays;

public class DistinctSubsequencesQ32 {
    //HOW MANY WAYS S2 CAN BE FROMED FROM S1
    public static void main(String[] args) {

//        String s1 = "babgbag"; //ans is 5
//        String s2 = "bag";
        String s1 = "rabbbit"; //ans is 3
        String s2 = "rabbit";
        int n = s1.length();
        int m = s2.length();
        //works
        System.out.println(solve(s1,s2,n-1,m-1));

        int dp[][]=new int[n][m];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);

        //works
        System.out.println(solveMemo(s1,s2,n-1,m-1,dp));
        //fails
        System.out.println(solveTab(s1,s2));

        //WORKSS----
        System.out.println(solveStRec(s1,s2,n-1,m-1));
        System.out.println(solveStRecMemo(s1,s2,n-1,m-1,dp));
        System.out.println(solveStTab(s1,s2));

        //space optimised -- 2 here [fails]
        System.out.println(solveSpaceOptim(s1,s2));

        System.out.println(solveSpaceOptimMore(s1,s2));


    }

    //my - correct ans
    private static int solve(String s1, String s2, int i, int j) {
        if (j==0){
            int ans = 0;
            for (int k = 0; k <= i; k++) {
                if (s1.charAt(k)== s2.charAt(j)){
                    ans++;
                }
            }
            return ans;
        }

        if (i==0) return 0;//since if i=0, then j must be 0 to return 1, if so then above if will already be evaluated

        int sum = 0;
        for (int k = i; k >= j; k--) {
            int take =0;
            if (s1.charAt(k)==s2.charAt(j)){
                take=solve(s1, s2, k-1, j-1);
            }
            sum= sum+take;
        }
        return sum;
    }

    //My memoization -- works - bottom up
    private static int solveMemo(String s1, String s2, int i, int j,int dp[][]) {


        if (j==0){
            int ans = 0;
            for (int k = 0; k <= i; k++) {
                if (s1.charAt(k)== s2.charAt(j)){
                    ans++;
                }
            }
            return ans;
        }

        if (i==0) return 0;//since if i=0, then j must be 0 to return 1, if so then above if will already be evaluated

        if (dp[i][j]!=-1) return dp[i][j];
        int sum = 0;
        for (int k = i; k >= j; k--) {
            int take =0;
            if (s1.charAt(k)==s2.charAt(j)){
                take=solve(s1, s2, k-1, j-1);
            }
            sum= sum+take;
        }
        dp[i][j] = sum;
        return dp[i][j];
    }


    //TABULATION -- SOMETHING WRONG -- CHECK YUORSELF + STRIVERS ANSWER
    private static int solveTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][]=new int[n][m];

        for (int i = 0; i < n; i++) {
            int ans = 0;

            if (s1.charAt(i)== s2.charAt(0)){
                ans++;
            }

            dp[i][0] = ans;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int sum = 0;
                for (int k = i; k >= j; k--) {
                    int take =0;
                    if (s1.charAt(k)==s2.charAt(j) && k>0){
                        take=dp[k-1][j-1];
                    }
                    sum= sum+take;
                }
                dp[i][j] = sum;
            }
        }
        return dp[n-1][m-1];

    }


    //STRIVERRRRRR--------------- ALL WORKS
    private static int solveStRec(String s1, String s2, int i, int j) {
        if (j<0) return 1; //if s2 is exhausted ==> can be formed
        if (i<0) return 0; //if s1 is exhausted

        if (s1.charAt(i)==s2.charAt(j)){
                return solveStRec(s1, s2, i-1, j-1)+solveStRec(s1, s2, i-1, j); //take and not take current s1 index if match
            }
        return solveStRec(s1, s2, i-1, j); //not take current index in s1 if not matches
    }

    //memoisation
    private static int solveStRecMemo(String s1, String s2, int i, int j,int dp[][]) {
        if (j<0) return 1; //if s2 is exhausted ==> can be formed
        if (i<0) return 0; //if s1 is exhausted
        if (dp[i][j]!=-1) return dp[i][j];
        if (s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = solveStRecMemo(s1, s2, i-1, j-1,dp)+solveStRecMemo(s1, s2, i-1, j,dp); //take and not take current s1 index if match
        }
        else {
            dp[i][j] = solveStRecMemo(s1, s2, i - 1, j,dp); //not take current index in s1 if not matches
        }
        return dp[i][j];
    }
//Tabulation
    private static int solveStTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1]; //SINCE BASE case has negative values also

        for (int i = 0; i <= n; i++) { //base case for s2
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) { //since loops from 1
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; //copying the recursion
                } else {
                    dp[i][j] = dp[i - 1][j];//copying the recursion
                }
            }
        }
        return dp[n][m];
    }

    //STRIVER WAY - MINE SPACE OPTIMISATION -- NOT WORKING IN MINE -- WORKS FOR ST
    public static int solveSpaceOptim(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int prev[] = new int[m+1];
        int curr[] = new int[m+1];

        prev[0] = 1;
        curr[0] = 1;



        for (int i = 1; i <= n; i++) {
            for (int j = m; j >=1; j--) {//modify this in sace optimisation -- think why
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) { //since loops from 1
                    curr[j] = prev[j - 1] + prev[j]; //copying the recursion
                } else {
                    curr[j] = prev[j];//copying the recursion
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    //MORE OPTIMISING
    public static int solveSpaceOptimMore(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int prev[] = new int[m+1];


        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >=1; j--) { //modify this in sace optimisation -- think why
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) { //since loops from 1
                    prev[j] = prev[j - 1] + prev[j]; //copying the recursion
                } else {
                    prev[j] = prev[j];//copying the recursion
                }
            }
        }
        return prev[m];
    }


}
