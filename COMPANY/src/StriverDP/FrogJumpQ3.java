package StriverDP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrogJumpQ3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
//        int[] a = new int[]{10, 20, 30, 10, 40};
        int[] a = new int[]{10, 20, 30, 10, 30};


        System.out.println(solve(n, a, n - 1));
        System.out.println(solvedp(n, a));

        //below is just to check the count of subseq
    }
//hav used top-down here

    private static int solve(int n, int[] a, int i) {
        if (i == 0) return 0;

        int left = solve(n, a, i - 1) + Math.abs(a[i] - a[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1) {

            right = solve(n, a, i - 2) + Math.abs(a[i] - a[i - 2]);

        }

        return Math.min(left, right);
    }

    private static int solvedp(int n, int[] a) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {

            int left = dp[i - 1] + Math.abs(a[i] - a[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {

                right = dp[i - 2] + Math.abs(a[i] - a[i - 2]);

            }

            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];

    }
}
