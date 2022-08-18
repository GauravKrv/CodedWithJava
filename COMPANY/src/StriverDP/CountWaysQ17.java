package StriverDP;

import java.io.FileOutputStream;
import java.util.Scanner;

public class CountWaysQ17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 3;
//        int[] a = new int[]{10, 20, 30, 10, 30};
//        int target = 50;
        int target = 1;
        int[] a = new int[]{0,0,1};//compute number of zeroes[if zeroes are present] -> find ways of reresenting x zeres 2^x -> ans = 2^x * dp[n-1][target]

        int[][] dp = new int[n][target + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(a, n - 1, target));
        System.out.println(solveTab(a, target));

    }

    //Mine Recursion - works
        private static int solve(int[] a, int i, int target) {
        if (target==0) return 1;
        if (i==0) return (target-a[0]==0)?1:0;
        //        if (i<0) return false;  -- also works - mine but little TRICKY to thnk for tabulation after using this
        int notake = solve(a,i-1,target);//not include curr index
        int take = 0;
        if (a[i]<=target) {
            take = solve(a, i - 1,target-a[i]); //include curr index element also
        }

        return (take + notake);
    }

    //Mine Tabulation - works fine
    private static int solveTab(int[] a,int target) {

        int[][] dp = new int[a.length][target + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < a.length; i++) {
            dp[i][0] = 1; //1st base case
        }
        if (a[0]<=target) dp[0][a[0]]=1;

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= target; j++) {
                int notake = dp[i-1][j];//not include curr index
                int take = 0;
                if (a[i]<=j) { //check before subtraction

                    take = dp[i-1][j-a[i]]; //include curr index element also
                }
                dp[i][j] = take+notake; //return operation of recursion
            }
        }


        return dp[a.length-1][target];
    }
}
