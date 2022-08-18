package StriverDP;

import java.util.Arrays;

public class Q48MCM_Partitiondp {
    public static void main(String[] args) {
        int arr[] = {10,30,5,60};
        int n = arr.length;
        System.out.println(solve(arr,1,n-1));

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solveMemo(arr,1,n-1,dp));

        //mine tabulation
        System.out.println(solveTabSt(arr,n));


    }

    //works - strivers pseudocode understanding
    private static int solve(int[] arr, int i, int j) {

        if (i==j) return 0;
        int steps = Integer.MAX_VALUE,min=Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            steps = arr[i-1]*arr[k]*arr[j] +  //[lhs * common * rhs] -> to get no of operations from two matrix,
                    // -> we know how to calculate the  resultant matrix size of any partiion say m1*m2 OR == A(BCD)
                    // -> we know to calculate the size of A & BCD matrices
                    solve(arr, i, k) +
                    solve(arr, k+1, j);
            min = Math.min(steps,min);
        }

        return min;

    }

    //MY - WORKS
    private static int solveMemo(int[] arr, int i, int j,int dp[][]) {

        if (i==j) return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        int steps = Integer.MAX_VALUE,min=Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            steps = arr[i-1]*arr[k]*arr[j] +  //[lhs * common * rhs] -> to get no of operations from two matrix,
                    // -> we know how to calculate the  resultant matrix size of any partiion say m1*m2 OR == A(BCD)
                    // -> we know to calculate the size of A & BCD matrices
                    solveMemo(arr, i, k,dp) +
                    solveMemo(arr, k+1, j,dp);
            min = Math.min(steps,min);
        }

        dp[i][j] = min;
        return dp[i][j];

    }

    private static int solveTab(int[] arr, int n) {

        int[][] dp = new int[n][n];
//        for (int x[] :
//                dp) {
//            Arrays.fill(dp,Integer.MAX_VALUE);
//        }
        for (int i = 1; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                if (i==j) continue;
                int steps = Integer.MAX_VALUE,min=Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                   steps = arr[i-1]*arr[k]*arr[j] +  //[lhs * common * rhs] -> to get no of operations from two matrix,
                            // -> we know how to calculate the  resultant matrix size of any partiion say m1*m2 OR == A(BCD)
                            // -> we know to calculate the size of A & BCD matrices
                            dp[i][k] +
                            dp[k+1][j];
                    min = Math.min(steps,min);
                    dp[i][j] = min;
                }

            }
        }

        Print.print(dp);
        return dp[n-1][n-2];

    }


    //BOTOM UP
    private static int solveTabSt(int[] arr, int n) {

        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 1; i--) {
            for (int j = i+1; j < n; j++) {
                int steps = (int) 1e9,min=(int) 1e9;
                for (int k = i; k < j; k++) {
                   steps = arr[i-1]*arr[k]*arr[j] +  //[lhs * common * rhs] -> to get no of operations from two matrix,
                            // -> we know how to calculate the  resultant matrix size of any partiion say m1*m2 OR == A(BCD)
                            // -> we know to calculate the size of A & BCD matrices
                            dp[i][k] +
                            dp[k+1][j];
                    min = Math.min(steps,min);

                }
                dp[i][j] = min;

            }
        }

        Print.print(dp);
        return dp[1][n-1];

    }

//    static void print(int[][] dp){
//        for (int[] x :
//                dp) {
//            for (int y :
//                    x) {
//                System.out.print(y+" ");
//            }
//            System.out.println();
//        }
//    }


}
