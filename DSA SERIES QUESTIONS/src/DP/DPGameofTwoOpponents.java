package DP;
public class DPGameofTwoOpponents {
    //gfg optimal strategy for a game
    static int sol(int[] arr, int n)
    {
        int dp[][] = new int[n][n];

        for(int i=0;i<n-1;i++)
        {
            dp[i][i+1]= Math.max(arr[i],arr[i+1]);
        }

        for(int gap =3; gap<n; gap = gap + 2)
        {
            for(int i=0; i+gap<n; i++)
            {
                int j = gap + i;

                dp[i][j] = Math.max((arr[i] + Math.min(dp[i+1][j], dp[i+1][j-1])),
                        (arr[i] + Math.min(dp[i+1][j-1], dp[i][j-2])));
            }
        }

        return dp[0][n-1];
    }

    public static void main (String[] args) {

        int n = 4;

        int arr[] = {20, 5, 4, 6};

        System.out.println(sol(arr, n));


    }
}
