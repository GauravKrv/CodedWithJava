package StriverDP;

import java.util.Arrays;

public class CountLIS_Q44 {

    public static void main(String[] args) {
//        int ar[] = {1,3,6,7,9,4,10,5,6};
//        int ar[] = {1,4,5,2,3,7}; //WORKS
        int ar[] = {10, 9, 2, 5, 3, 7, 101, 18}; //WORKS


        int size = ar.length;
        int count[] = new int[ar.length];
       /* System.out.println("Size of LIS = " +solve(0,ar,-1,count
        ));*/

//        System.out.println("Size of LIS = " +solveTab(size,ar,count));
//
//        for(int x=size-1;x>=0;x--)
//        if (count[x]>0) {
//            System.out.println("Number of LIS = " + count[x]);
//            break;
//        }

        System.out.println("Number of LIS = " + countLIS___(ar));

    }

    //WORKS FINE
    private static int solve(int i, int[] a, int prev, int[] count) {
        if (i==a.length) return 0;
        int take = 0;
        if (prev==-1||a[i]>a[prev]){
            take = 1+solve(i+1, a, i, count);
        }
        int notake = solve(i+1, a, prev, count);
        int max = Math.max(take,notake);
        if (max>0)count[max-1]++; //using an array to store the counts of variaous lengths of LISs
        return max;

    }
    //MY - SOLUTION -- WRONG
    private static int solveTab(int n, int[] a, int[] count) {
        int dp[][] = new int[n+1][n+1];

        for (int i = n-1; i >= 0; i--) {
            for (int prev = i; prev >= 0 ; prev--) {

        int take = 0;
        if (a[i]>a[prev]){
            take = 1+dp[i+1][i];
        }
        int notake = dp[i+1][prev];
        int max = Math.max(take,notake);

        if (max>0)count[max-1]++; //using an array to store the counts of variaous lengths of LISs
        dp[i][prev] = max;

            }
        }
        printdp(dp);
        return dp[0][0];

    }
    //uSING STRIVERS lis -- works
    private static int solveTabsT(int n, int[] a, int[] count) {
        int dp[][] = new int[n+1][n+1];

        for (int i = n-1; i >= 0; i--) {
            for (int prev = i-1; prev >= -1 ; prev--) {

                int take = 0;
                if (prev == -1 || a[i]>a[prev]){
                    take = 1+dp[i+1][i+1];
                }
                int notake= 0;
                notake = dp[i+1][prev+1];
                int max = Math.max(take,notake);

                if (max>0)count[max-1]++; //using an array to store the counts of variaous lengths of LISs
                dp[i][prev+1] = max;

            }
        }
        printdp(dp);
        return dp[0][0];

    }
   public static void printdp(int[][] dp){
       for (int x[]:dp) {
           for (int y :
                   x) {
               System.out.print(y + " ");
           }
           System.out.println();
       }
   }

   //Striver's video intution -- accepted by leet code but is little tough
    static int countLIS___(int[] a){
        int n = a.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(dp,1); //becoz each alone element can be LIS
        Arrays.fill(count,1); //count can be 1 at least for any subsequence

        int max = 1;

        for (int i = 0; i < n; i++) { //from 0-> n
            for (int prev = 0; prev < i; prev++) { //from 0->current_index-1 check
                if (a[i]>a[prev] && (1+dp[prev]>dp[i])){ //if curr element is greater and [if currelement[1lengthpoint]+prev length > curr length make an inc subseq
                    count[i]=count[prev]; //then for new max length made by using current element, make current count as previous as all previous counts will be inc by same amt
                    dp[i]= 1+dp[prev];//also new length wll be there as the lis would change
                }else if (a[i]>a[prev] && (1+dp[prev]==dp[i])){ //if curr element is greater and [if 1+prevlen and currlen are same
                    count[i] = count[i]+count[prev]; //just take previous count
                }
            }
            max = Math.max(max,dp[i]);
        }
        int c = 0;
        for (int i = n-1; i >= 0; i--) {
            if (dp[i]==max){
                c+=count[i];
            }
        }
        return c;

    }

}
