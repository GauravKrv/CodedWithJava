package StriverDP;

public class TriangleQ11 {
    /*We are given a Triangular matrix. We need to find the minimum path sum from the first row to the last row.

At every cell we can move in only two directions: either to the bottom cell (↓) or to the bottom-right cell(↘)*/
    public static void main(String[] args) {
        //Always a square matrix
        int[][] a = new int[][]{
                {10,0,0},
                {5,1,0},
                {5,70,5}}; //16-min path sum
        int m = a.length;
        int n = a[0].length;


        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(m,n,a,0,0));
        System.out.println(solvememo(m,n,a,0,0,dp));
        System.out.println(solveTAB(m,n,a));


    }

    //WORKS - BOTTOM - UP [STRIVER]-> MORE EASIER CODE -> As if top down the have to use a loop [for each nth row element]
    private static int solve(int m, int n, int[][] a, int i, int j) {
        if (i==a.length-1) return a[i][j];
        int dright = a[i][j] + solve(m,n,a,i+1,j+1);
        int down = a[i][j] + solve(m,n,a,i+1,j);

        return Math.min(dright,down);

    }

    //MMO WORKS - MINE
    private static int solvememo(int m, int n, int[][] a, int i, int j,int dp[][]) {
        if (i==a.length-1) return a[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        int dright = a[i][j] + solvememo(m,n,a,i+1,j+1,dp);
        int down = a[i][j] + solvememo(m,n,a,i+1,j,dp);

        dp[i][j] = Math.min(dright,down);
        return dp[i][j];

    }
//WORKS - TABULATION - BOTTOM UP - MINE
    private static int solveTAB(int m, int n, int[][] a) {
        int dp[][] = new int[m][n];
        dp[0][0] = a[0][0]; //initial value

        for (int i = 1; i < m; i++) { //loop starts from 1
            for (int j = 0; j <= i; j++) { //j goes till i value as it is a triagle so matrix has diagonal as boundary for crrct vals
                if (i==a.length-1) dp[i][j] = a[i][j]; //Bottom Up base case

                int up=Integer.MAX_VALUE,uleft=Integer.MAX_VALUE;

                if (j>0) uleft = a[i][j] + dp[i-1][j-1]; //Recursion case
                if (i!=j)  up = a[i][j] + dp[i-1][j]; //Recursion case

                dp[i][j] = Math.min(uleft,up); //Storing in dp -> recursion last statement

            }
        }
        return dp[m-1][n-1];

    }

    //STRIVER HAS USED TOP DOWN INTABULATION
    static int minimumPathSum(int n,int[][] triangle){
        int dp[][]= new int[n][n];

        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle[n-1][j];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){

                int down = triangle[i][j]+dp[i+1][j];
                int diagonal = triangle[i][j]+dp[i+1][j+1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];

    }
}
