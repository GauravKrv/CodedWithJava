package DIV2_772;

import CodeForces.CodeForces;

public class A extends CodeForces {

    static void solution(int[] a,int n) {

        long sum = 0;
        for (int x :
                a) {
            sum=sum|x;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            int[] a = new int[n];
            for (int i = 0; i <n; i++) {
               a[i] = I();
            }

            solution(a,n);
        }
    }
}
