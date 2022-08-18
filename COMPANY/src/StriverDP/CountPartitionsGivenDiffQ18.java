package StriverDP;

public class CountPartitionsGivenDiffQ18 {
    public static void main(String[] args) {
        int n = 4;
        int[] a = new int[]{10, 20, 30, 30};
        int target = 50;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        int[][] dp = new int[n][sum + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(a, n - 1,sum, 0,10));
        System.out.println(countWaysDiff(a, sum,10));



    }

    //recur - myy - works
    private static int solve(int[] a, int i, int sum, int s1, int d) {
        if (s1-(sum-s1)==d) return 1; //when to return 1
        if (i==0){
            if (s1-(sum-s1-a[0])==d) return 1; //Strivers way of using base case such that an extra row is not reqd in dp
            else return 0;
        }
        int take = solve(a, i-1, sum, s1+a[i], d);
        int notake = solve(a, i-1, sum, s1 ,d);
        return take+notake;

    }

    //strivers way of using cout way problem to derive the solution****
    static int mod = (int) (1e9+7);
    private static int countWaysDiff(int[] a, int sum, int d){
        if ((sum-d)%2==1 || (sum-d<0)) return 0; //check the dry run it works [sum=17,d=3, => if(17-3)%2 == 0 => if 7 exist then 10 exist,
        return findWaysQ17(a,(sum-d)/2); //so count for number of 7 as target
    }

//helper function --- modified countways as strivers & also handles if a[i] == 0 anywhere
    private static int findWaysQ17(int[] a,int target) {

        int[][] dp = new int[a.length][target + 1]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value


        if (a[0]==0)dp[0][0] = 2;
        else dp[0][0] = 1;

        if (a[0]!=0 && a[0]<=target) dp[0][a[0]]=1;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j <= target; j++) {
                int notake = dp[i-1][j];//not include curr index
                int take = 0;
                if (a[i]<=j) { //check before subtraction

                    take = dp[i-1][j-a[i]]; //include curr index element also
                }
                dp[i][j] = take+notake; //return operation of recursion
            }
        }


        return (dp[a.length-1][target])%mod;
    }
}
