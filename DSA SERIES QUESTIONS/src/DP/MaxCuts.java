package DP;

public class MaxCuts {
    static int maxCutsRec(int n,int a,int b,int c){
        if(n==0) return 0;
        if (n<0) return -1;

        return Math.max(Math.max(1+maxCutsRec(n-a,a,b,c), 1+maxCutsRec(n-b,a,b,c)),1+ maxCutsRec(n-c,a,b,c));
    }

    static int maxCutsMemo(int n,int a,int b,int c,int[] memo){

        if (n<0) return -1;
        if (memo[n]!=Integer.MAX_VALUE) return memo[n];

        memo[n] = Math.max(Math.max(1+maxCutsMemo(n-a,a,b,c,memo), 1+maxCutsMemo(n-b,a,b,c,memo)),
                1+ maxCutsMemo(n-c,a,b,c,memo));
        return memo[n];
    }

    public static void main(String[] args) {
//        int n = 5,a=1,b=2,c=3;
        int n = 23,a=12,b=11,c=13;
        System.out.println(maxCutsRec(n,a,b,c));

        int[] memo = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            memo[i] = Integer.MAX_VALUE;
                   }
        memo[0]= 0;

        int res = maxCutsMemo(n,a,b,c,memo);
        System.out.println(res);
    }
}
