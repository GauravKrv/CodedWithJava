package DIV2_735;

import CodeForces.CodeForces;

public class B extends CodeForces {
//TLE ON TEST TWO .. THINK A PATTERN
    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            int k = I();
            int[] a = new int[n];
            for (int i=0;i<n;i++){
               a[i] = I();
            }
            solution(a,n,k);
        }
    }

    private static void solution(int[] a, int n,int k) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int res = ((i+1)*(j+1)) - (k*(a[i]|a[j]));
                max = Math.max(max,res);
            }
        }

        System.out.println(max);
    }
}
