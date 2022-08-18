package DP;
//dp on subsequences [also knapsack is dp on subsequences] -> whenever we have dp on subsequences we have to use the concept of take
//and not take
public class CoinChange {
    //permutation doesnt matter

    /*
    you are given an integer array coins representing coins of different denomination

and an integer amount representing a total amount of money
return the fewest number of coinis that you need to makeup that amount

you can assume that you have an infinite number of each kind of coin


    * */

    //initial - i = n-1
    static int coinChangeMin(int[] coins, int n, int amt, int i){
        if(i==0){
            if (amt%coins[i]==0) return amt/coins[i]; // base case i.e other couins doesnt satisfies and only this satisfies
            else return 1000000;
        }

        int not_take = coinChangeMin(coins,n,amt,i-1);

        int take = Integer.MAX_VALUE;
        if(coins[i]<=amt){
            take = 1 + coinChangeMin(coins,n,amt-coins[i],i);
        }
        return Math.min(take,not_take);
    }

    static int coinChangeMin(int[] coins, int n, int amt){

        int i;
        int AMT = 0;
        int mat[][] = new int[n][amt+1];
        for (i = 0; i < amt; i++) {
            if (i%coins[0]==0){
                mat[0][i] = amt/coins[0];
            }else{
                mat[0][i] = 1000000;
            }
        }

        for (i = 1; i < n; i++) {
            for ( AMT = 1; AMT < amt; AMT++) {
                if (coins[i]>AMT){
                    mat[i][AMT] = mat[i-1][AMT];
                }
                else{
                    mat[i][AMT] = Math.min(1+mat[i][AMT-coins[i]],mat[i-1][AMT]);
                }
            }
        }


        return mat[n-1][amt];

    }

    //permutation matter
    //below just return the number of cons and not the minimum number of coins
    static int coinChangeRec(int target,int[] coins){
        if (target<0) return 0;
        if (target==0) return 1;

        int countAll = 0;
        for (int coin:
             coins) {
            int rem = target-coin;
            int count = coinChangeRec(rem,coins);

            if (count>=1){
                countAll+=count;
            }
        }
        return countAll;
    }

    //permutation matter
    static int coinChangeMemo(int target,int[] coins,int[] memo){
        if (target>=0 && memo[target] != -1) return memo[target];
        if (target<0) return 0;

        int countAll = 0;
        for (int coin: coins) {
            int rem = target-coin;
            int count = coinChangeMemo(rem,coins,memo);

                countAll+=count;

        }
        memo[target] = countAll;
        return countAll;
    }

    static int coinChangeDP(int target,int[] coins){
        int[] memo = new int[target+1];
        memo[0] = 1;
        for (int i = 1; i <= target; i++) {
            memo[i] = -1;
        }
        return coinChangeMemo(target,coins,memo);
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int target = 4;
        System.out.println(coinChangeDP(target,coins));
        System.out.println(coinChangeRec(target,coins));

        System.out.println(getCount(coins,coins.length,target));
        System.out.println(coinChangeMin(coins,coins.length,target));
       // System.out.println(coinChangeRec(target,coins));

    }

    static int getCount(int[] coins,int n,int sum){
        if (sum==0) return 1;
        if (n==0) return 0;

        int res = getCount(coins,n-1,sum);
        if (coins[n-1]<=sum){
            res+=getCount(coins,n,sum-coins[n-1]);
        }

        return res;
    }
    //permutation doesnt matter
    static int getCountDP(int coins[], int n, int sum)
    {
        int dp[][]= new int[sum+1][n+1];

        for(int i=0;i<=n;i++)
        {
            dp[0][i]=1;
        }
        for(int i=1;i<=sum;i++)
        {
            for(int j=1;j<=n;j++)
            {
                dp[i][j] = dp[i][j-1];

                if(coins[j-1]<=i)
                    dp[i][j]+=dp[i-coins[j-1]][j];
            }
        }
        return dp[sum][n];

    }


}
