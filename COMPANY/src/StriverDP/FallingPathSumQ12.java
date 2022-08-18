package StriverDP;

public class FallingPathSumQ12 {

    public static void main(String[] args) {

        //Aways a square matrix
        int[][] a = new int[][]{
                {10, 0, 0},
                {5, 1, 0},
                {5, 70, 5}}; //85-MAX path sum
        int m = a.length;
        int n = a[0].length;


        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        // /DOESNT WORKS
        System.out.println(solve(m, n, a, 0, 0));

        //WORKS FINE -Bottom uo only
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, solvebu(m, n, a, a.length - 1, i));
        }

        System.out.println(max);


        //WORKS FINE - MEMOIZED
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max2 = Math.max(max, solvememo(m, n, a, a.length - 1, i,dp));
        }

        System.out.println(max2);

        System.out.println(solvetab(m, n, a));


    }

    //STRIVER + MINE --WORKS FINE
    private static int solvebu(int m, int n, int[][] a, int k, int i) { //m-1,0
        //base cases
        if (i >= n || i < 0) return -99999; //path will become invalid
        if (k == 0) return a[k][i];

        int uright, up, uleft;

        //go up , lefd diag,rfdiag,
        uright = a[k][i] + solvebu(m, n, a, k - 1, i + 1);
        up = a[k][i] + solvebu(m, n, a, k - 1, i);

        uleft = a[k][i] + solvebu(m, n, a, k - 1, i - 1);

        //keep the recursive max of all paths
        int max = Math.max(Math.max(up, uright), uleft);

        return max;

    }


    //STRIVER + MINE --WORKS FINE -MEMO
    private static int solvememo(int m, int n, int[][] a, int i, int j,int dp[][]) { //m-1,0
        //base cases
        if (j >= n || j < 0) return -99999;
        if (i == 0) return a[i][j];
        //check memo
        if (dp[i][j]!=-1) return dp[i][j];

        int uright, up, uleft;

        //go up , lefd diag,rfdiag,
        uright = a[i][j] + solvememo(m, n, a, i - 1, j + 1,dp);
        up = a[i][j] + solvememo(m, n, a, i - 1, j,dp);

        uleft = a[i][j] + solvememo(m, n, a, i - 1, j - 1,dp);

        //keep the recursive max of all paths
        dp[i][j] = Math.max(Math.max(up, uright), uleft);

        return dp[i][j];

    }

    //TABULATION - MINE - WORKS
    private static int solvetab(int m, int n, int[][] a) { //m-1,0
        //base cases
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {  //RECURSION TO LOOP -- already matrix was given

                if (i == 0) dp[i][j] = a[i][j]; //base case

                else {

                    int uright = Integer.MIN_VALUE, u = Integer.MIN_VALUE, uleft = Integer.MIN_VALUE;

                 if (j<n-1)  uright = a[i][j] + dp[i- 1][j + 1]; //corner check + use the base case or previous cmputed dp value

                 u = a[i][j] + dp[i- 1][j];//use the base case or previous cmputed dp value

                 if (j>0)  uleft = a[i][j] + dp[i- 1][j - 1];//corner check + use the base case or previous cmputed dp value

                    dp[i][j] = Math.max(u,Math.max(uleft,uright)); //store the best for each column
                }
            }

        }
        //Returning the maximum value in the last row
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,dp[m-1][i]);
        }
        return max;

    }



    // MY - DOESNT WORKS FINE
    private static int solve(int m, int n, int[][] a, int k, int i) {
        if (i >= n || i < 0) return -99999;
        if (k == a.length - 1) return a[k][i];
        int Max = Integer.MIN_VALUE;
        if (k == 0) {
            for (int j = 0; j < n; j++) {
                int dright = Integer.MIN_VALUE, down = Integer.MIN_VALUE, dleft = Integer.MIN_VALUE;

                dright = a[k][j] + solve(m, n, a, k + 1, j + 1);
                down = a[k][j] + solve(m, n, a, k + 1, j);

                dleft = a[k][j] + solve(m, n, a, k + 1, j - 1);


                Max = Math.max(Math.max(down, dright), dleft);

            }
        } else {
            int dright = Integer.MIN_VALUE, down = Integer.MIN_VALUE, dleft = Integer.MIN_VALUE;

            dright = a[k][i] + solve(m, n, a, k + 1, i + 1);
            down = a[k][i] + solve(m, n, a, k + 1, i);

            dleft = a[k][i] + solve(m, n, a, k + 1, i - 1);


            Max = Math.max(Math.max(down, dright), dleft);

        }
        return Max;

    }


}