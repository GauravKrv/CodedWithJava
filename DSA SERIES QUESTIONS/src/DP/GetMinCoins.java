package DP;

import java.util.Arrays;

public class GetMinCoins {
    static int getMin(int target,int coins[]){
        if (target==0) return 0;
        if (target<0) return Integer.MAX_VALUE;

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            int rem = target-coins[i];

            int currCoin = getMin(rem,coins);

            if ((count==0 || currCoin<count) && currCoin!=Integer.MAX_VALUE ){
                count = currCoin+1;


            }
        }
        return count;

    }

    static int getMinMemo(int target,int coins[],int[] memo){
        if (target>=0 && memo[target]!=-1) return memo[target];
        if (target<0) return Integer.MAX_VALUE;

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            int rem = target-coins[i];
            int currCoin = Integer.MAX_VALUE;
            if (rem>=0) {
                if (memo[rem] != -1) {
                    currCoin = memo[rem];
                } else {
                    currCoin = getMinMemo(rem, coins,memo);
                    memo[rem] = currCoin;
                }
            }

            if ((count==0 || currCoin<count) && currCoin!=Integer.MAX_VALUE ){
                count = currCoin+1;
            }
        }
        memo[target] = count;
        return memo[target];

    }

    static int getMinSir(int n,int t,int coins[]){
        if (t==0) return 0;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i]<=t){
                int temp = getMinSir(n,t-coins[i],coins);
                if (temp!=Integer.MAX_VALUE){
                    res=Math.min(temp+1,res);
                }
            }
        }
        return res;

    }

    static int minCoins(int arr[], int m, int value)
    {

        int dp[] = new int[value + 1];


        dp[0] = 0;


        for (int i = 1; i <= value; i++)
            dp[i] = Integer.MAX_VALUE;


        for (int i = 1; i <= value; i++)
        {

            for (int j = 0; j < m; j++)
                if (arr[j] <= i)
                {
                    int sub_res = dp[i - arr[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < dp[i])
                        dp[i] = sub_res + 1;


                }

        }
        return dp[value];

    }

    public static void main(String[] args) {
        int target = 200;
        int[] coins = { 25,10,5,30};

        int[] memo = new int[target+1];
        Arrays.fill(memo,-1);
        memo[0] = 0;

        System.out.println(minCoins(coins,coins.length,target));
        System.out.println(getMinMemo(target,coins,memo));
     System.out.println(getMin(target,coins));
        System.out.println(getMinSir(coins.length,target,coins));


//        System.out.println(Integer.MAX_VALUE);
    }
}
