package DP;

public class CoinChange {
    //permutation doesnt matter
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


    //permutation matter
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
        int[] coins = {7,3,4};
        int target = 20;
        System.out.println(coinChangeDP(target,coins));
        System.out.println(coinChangeRec(target,coins));

        System.out.println(getCount(coins,coins.length,target));
       // System.out.println(coinChangeRec(target,coins));

    }
}
