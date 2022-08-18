package StriverDP;

import java.util.Scanner;

public class PartitionEqualSubsetQ15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int[] a = new int[]{10, 20, 30, 10, 30};
        int target = 50;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=a[i];
        }

        int[][] dp = new int[n][sum+1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(solve( a, n-1 , sum,0));
        System.out.println(solveMemo( a, n-1 , sum,0,dp));
        System.out.println(solveTab( a, sum));



    }

    //bottom up - works - mine
    private static boolean solve(int[] a, int i, int sum,int curr) {
        if (sum==curr ) return true;
         if (i<0 || sum<curr) return false;
        boolean notake = solve(a,i-1,sum,curr);//not include curr index
        boolean take = false;
        if (a[i]<=sum) {
            take = solve(a, i - 1,sum-a[i],curr+a[i]); //include curr index element also
        }

        return (take || notake);
    }

    //bottom up - Memo - works - mine
    private static boolean solveMemo(int[] a, int i, int sum,int curr,int[][] dp) {
        if (sum==curr) return true;
        if (i<0 || sum<curr) return false;
        if (dp[i][curr]!=-1) return dp[i][curr] == 1;

        boolean notake = solve(a,i-1,sum,curr);//not include curr index
        boolean take = false;
        if (a[i]<=sum) {
            take = solve(a, i - 1,sum-a[i],curr+a[i]); //include curr index element also
        }

        dp[i][curr] = (take || notake)?1:0;
        return dp[i][curr] == 1;
    }

    //think how ---- mine was garbage -- striver had a shortcut -- below code using Q14SubsetSum solution
    private static boolean solveTab(int[] a,int sum) {
        if (sum%2!=0) return false;
        int target =sum/2; //now just find if this target exist or not

        return subsetSumQ14(a,target);

    }

    //below is the helper Q14
    private static boolean subsetSumQ14(int[] a,int target) {
        boolean[][] dp = new boolean[a.length][target+1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        //base case 1
        for (int i = 0; i < a.length; i++)
            dp[i][0] = true;

        //base case 2 -- critical thinking
        dp[0][a[0]] = true;  //if i==0 && target == a[0] return true

//just look and copy the recursion thing here
        for (int i = 1; i < a.length; i++) { //if i==0 dp[i][j] = false for all except one i the 2nd base case
            for (int j = 1; j <= target; j++) { //if j==0 => target is reached to 0 thus is true
                boolean notake = dp[i-1][j];//not include curr index
                boolean take = false;
                if (a[i]<=j) {
                    take = dp[i - 1][j-a[i]]; //include curr index element also
                }
                dp[i][j] = take||notake;
            }
        }

        return dp[a.length-1][target];
    }



}
