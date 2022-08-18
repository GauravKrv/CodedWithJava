package StriverDP;

import java.util.Scanner;
//This question says that solve the problem in K number of jumps that is
// we are not restricted to only one or two jumps but we can take at most K number of jumps at once
//Then return the minimum value of energy that is wasted when we reach to last index
//Energy is calculated like if we jump from its index to JTH index then change in energy is absolute of a[j]- a[i] index
public class FrogKJumpQ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int[] a = new int[]{10, 20, 30, 10, 30};
        int k = 2;
//MY CODES - WORKS
        System.out.println(solve( a, 0,k,0));
        System.out.println(solvetopdown( a, n-1,k));

        System.out.println(solvedp( n,a,k));


    }
//hav used bottom up here - my code
    private static int solve(int[] a, int i,int k,int energy) {
        if (i == a.length-1) return energy; //return current energy if last index or stair is reached

        int take,min = Integer.MAX_VALUE;
        for (int j = k; j >0; j--) { //for all jumps check
            if (i+j>= a.length) continue; //jump shoould not be out of bounds
            take = solve(a,i+j,k,energy+(Math.abs(a[i]-a[i+j]))); //taking each jump one by one
            min = Math.min(take,min); //store min energy for each level of jump from current index i
        }

        return min;//return the min jump


    }
    //hav used bottom up here - my code dp
    private static int solvedp(int n, int[] a,int k) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <=k; j++) {
                int right = Integer.MAX_VALUE;
                if (i-j >= 0) {
                    right = dp[i - j] + Math.abs(a[i] - a[i - j]);
                }

                dp[i] = Math.min(dp[i], right);
            }
        }
        return dp[n - 1];

    }


    //hav used TOP DOWN here - STRIVER code
    private static int solvetopdown(int[] a, int i,int k) {
        if (i == 0) return 0; //return current energy if last index or stair is reached
        int take =Integer.MAX_VALUE, min = Integer.MAX_VALUE;

        for (int j = 1; j <=k; j++) { //for all jumps check
            if (i-j>= 0)  //jump shoould not be out of bounds
            take =  Math.abs(a[i]-a[i-j]) + solvetopdown(a,i-j,k); //taking each jump one by one

            min = Math.min(take,min); //store min energy for each level of jump from current index i
        }

        return min;//return the min jump


    }
}
