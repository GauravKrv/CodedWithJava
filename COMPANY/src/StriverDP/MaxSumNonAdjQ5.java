package StriverDP;

import java.util.Scanner;

public class MaxSumNonAdjQ5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int[] a = new int[]{10, 20, 30, 10, 30};


        System.out.println(solve(n, a, 0));
        System.out.println(solveTD(n, a, n-1));
        System.out.println(solveDP(n, a));
        System.out.println(solveDPStriver(n, a));
        System.out.println(solveDPStriverSpace(n, a));







    }
//hav used bottom up here -my code
    private static int solve(int n, int[] a, int i) {
        if (i >= n) return 0;
        int max = Integer.MIN_VALUE;

        for (int j = i; j <n; j++) { //for all non adjacent check
           int take = solve(n,a,j+2) + a[i]; //taking each non adjacent one by one
            max = Math.max(take,max); //store max sum for each level of non adjacency from current index i
        }


        return max;
    }
//hav used top down here - my code

    private static int solveTD(int n, int[] a, int i) {
        if (i < 0) return 0;
        int max = Integer.MIN_VALUE;

        for (int j = i; j >=0; j--) { //for all non adjacent check
            int take = solveTD(n,a,j-2) + a[i]; //taking each non adjacent one by one
            max = Math.max(take,max); //store max sum for each level of non adjacency from current index i
        }


        return max;
    }

//Works -MINE - BOTTOM UP
    private static int solveDP(int n, int[] a) {
        int dp[] = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = Integer.MIN_VALUE;
        }
        dp[0] = a[0];
        dp[1] = Math.max(a[1],a[0]);
        int take=Integer.MIN_VALUE,max=Integer.MIN_VALUE;

         for (int i = 2; i < n; i++) {
             for (int j = i; j-2 >=0; j--) { //for all non adjacent check [from 0 to current only]

                  take = dp[j - 2] + a[i]; //taking each non adjacent one by one
                 max = Math.max(take, max); //store max sum for each level of non adjacency from current index i
             }
             dp[i] = max;
            // System.out.println("dp[i]="+dp[i]);
             max=Integer.MIN_VALUE;

         }


        return dp[n-1];
    }
//WORKS - STRIVER - SINGLE LOOP

    private static int solveDPStriver(int n, int[] a) {
        int dp[] = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = Integer.MIN_VALUE;
        }
        dp[0] = a[0];
        int take,notake;

        for (int i = 1; i < n; i++) {
            take =  a[i]; //taking each non adjacent one by one
            if (i>1)
                take += dp[i - 2];
            notake = dp[i-1];
            dp[i] = Math.max(take,notake);//store the max of curr and prev
            }

        return dp[n-1];
    }
//SPACE OPTIMIZED STRIVER -- USED PREV,PREV2,CURR IN place of dp[i-1] dp[i-2] , dp
    private static int solveDPStriverSpace(int n, int[] a) {

        int prev = a[0];
        int curr,prev2=0,take,notake;

        for (int i = 1; i < n; i++) {
            take =  a[i]; //taking each non adjacent one by one
            if (i>1)
                take += prev2;

            notake = 0+prev;

            curr = Math.max(take,notake);//store the max of curr and prev
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

}
