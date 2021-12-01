package DP;

public class CountWays__ {
    //WORSS
    static int countRec(int n){
        if (n<=0) return 0;
        if (n<=2) return n;
        return countRec(n-1)+countRec(n-2)%1000000007;
    }

    static int countDP(int n,int[] memo){
        if (memo[n]!= Integer.MAX_VALUE) return memo[n];
        if (n<=0) return 0;
        memo[n] = (countRec(n-1)+countRec(n-2));
        return memo[n];
    }
//WORKSSS -- BEST
    static int countWays(int n){
        long m = 1000000007;
        if(n<=1){
            return 1;
        }
        long a=1,b=1,c=0;
        for (int i = 2; i <= n; i++) {
            c = (a+b)%m;
            a = b;
            b = c;
        }

        return (int) (c%m);
    }

    public static void main(String[] args) {
      //  int n = 100;
//        int[] memo = new int[n+1];
//        for (int i = 0; i <= n; i++) {
//            memo[i] = Integer.MAX_VALUE;
//        }
//        memo[0] = 0;
//        memo[1] = 1;
//        memo[2] = 2;
//        System.out.println(countDP(n,memo));

        int n = 10000;
        System.out.println(countWays(n));
        System.out.println(countRec(n));


    }
}
