package StriverDP;

public class CherryPickup3DdpQ13 {

    public static void main(String[] args) {
//FIXED TO VARIABLE POINT TYPE PROBLEM
        //Aways a square matrix
        int[][] a = new int[][]{
                {10, 2, 1},
                {5, 15, 60},
                {5, 70, 5}}; //85-MAX path sum
        int m = a.length;
        int n = a[0].length;


        int[][][] dp = new int[m][n][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    dp[i][j][k] = -1;
                }
            }
        }

        // WORKS
        System.out.println(solve(m, n, a, 0, 0, m - 1)); //i1,i2,j1,j2
        System.out.println(solveMemo(m, n, a, 0, 0, m - 1, dp)); //i1,i2,j1,j2
        System.out.println(solveTab(m, n, a)); //i1,i2,j1,j2



    }


    //DONE BOTTOM UP APPROACH -- OR FIXED POINT APPROACH,
    private static int solve(int m, int n, int[][] a, int i, int j1, int j2) { //both alic eand bob will be on same row at each istance

        //base cases
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) return -99999;
        //when to stop
        if (i == n - 1) {
            if (j1 == j2) return a[i][j1];
            else return a[i][j1] + a[i][j2];
        }
        int[] x = {-1, 0, 1}; //declaring for recururring on all possible 9 paths , i.e [j1 = -1 , j2 = (-1,0,1} ],[j1 = 0 , j2 = (-1,0,1} ] , and so on}

        int max = Integer.MIN_VALUE;
        //looping to recur on all paths --> either write all 9 * 2 lines for all combintion of recurrence or
        // picturise the recurrence like this and make it an array instead
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                //if both alice and bob are on same cell
                if (j1 == j2) max = Math.max(max, a[i][j1] + solve(m, n, a, i + 1, j1 + x[j], j2 + x[k]));
                    //if both alice and bob are on different cell
                else max = Math.max(max, a[i][j1] + a[i][j2] + solve(m, n, a, i + 1, j1 + x[j], j2 + x[k]));

            }
        }
        return max;
    }


    //BOTTOM UP - wORKS - MINE -- Same as striver
    // HAVE TO TAKE 3D DP BECAUSE OF COMBINATIONS OF I J1 AND J2 AND BOTH ARE DEPENDENT ON EAH OTHER
    private static int solveMemo(int m, int n, int[][] a, int i, int j1, int j2, int[][][] dp) { //both alic eand bob will be on same row at each istance

        //base cases
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) return -99999;
        //when to stop
        if (i == n - 1) {
            if (j1 == j2) return a[i][j1];
            else return a[i][j1] + a[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int[] x = {-1, 0, 1}; //declaring for recururring on all possible 9 paths , i.e [j1 = -1 , j2 = (-1,0,1} ],[j1 = 0 , j2 = (-1,0,1} ] , and so on}

        int max = Integer.MIN_VALUE;
        //looping to recur on all paths --> either write all 9 * 2 lines for all combintion of recurrence or
        // picturise the recurrence like this and make it an array instead
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                //if both alice and bob are on same cell
                if (j1 == j2) {
                    max = Math.max(max, a[i][j1] + solveMemo(m, n, a, i + 1, j1 + x[j], j2 + x[k], dp));
                    //if both alice and bob are on different cell
                } else max = Math.max(max, a[i][j1] + a[i][j2] + solveMemo(m, n, a, i + 1, j1 + x[j], j2 + x[k], dp));

            }
        }
        dp[i][j1][j2] = max;
        return dp[i][j1][j2];
    }



    //issues -- solve later
    private static int solveTab(int m, int n, int[][] a) { //both alic eand bob will be on same row at each istance

        int[][][] dp = new int[m][n][n];


        int[] x = {-1, 0, 1};

        //just fill dp[0][i][j]


        for (int i = 1; i < m; i++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = n - 1; j2 >= 0; j2--) {

                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {

                            if ((x[j]==-1  && j1==0)||( x[k] == -1 && j2==0)) continue;
                            if ((x[j]==1  && j1==n-1)||( x[k] == 1 && j2==n-1)) continue;

                            if (j1 == j2) {
                                  dp[i][j1][j2] = Math.max(dp[i][j1][j2], a[i][j1] + dp[i - 1][ j1 + x[j]][j2 + x[k]]);
                                //if both alice and bob are on different cell
                            } else
                            dp[i][j1][j2] = Math.max(dp[i][j1][j2], a[i][j1] + a[i][j2] +dp[i - 1][ j1 + x[j]][j2 + x[k]]);

                        }

                    }
                }
            }
        }
        //getting max value from bottom most matrix
        int max = Integer.MIN_VALUE;
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = n - 1; j2 >= 0; j2--) {
                max = Math.max(dp[n - 1][j1][j2], max);
            }
        }
        return max;

    }
}


