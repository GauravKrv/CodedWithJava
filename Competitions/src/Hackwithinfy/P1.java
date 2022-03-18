package Hackwithinfy;

public class P1 {

    static int solution(int n,int d){
        if (d==n){
            return 1;
        }
        int k = 2;

        int l  = d/k;;

        int[] a = new int[n];
        a[n-1] = d/k;

        if (d%k!=0)
            a[n-1] = d/k +1;

        for (int j = 0; j < n; j++) {
            k++;
        for (int i=n-2;i>=0;i--){
            if (l<=1&&i!=0){
                a[n-1]--;
                l++;
            }else {
                a[i] = l/k;
                d--;
            }
            }
        }

        return 1;
    }
}
