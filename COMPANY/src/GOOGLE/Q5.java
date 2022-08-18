package GOOGLE;

import java.util.Scanner;

public class Q5 {
    static void solution(int[] a,int n){
        int min = a[0],max = a[0],maxp=0;
        for (int i=1;i<n;i++){
            if (a[i]<0){
                int t = min;
                min = Math.min(a[i],max*a[i]);
                max = Math.max(a[i],t*a[i]);

            }else{
                min = Math.min(a[i],min*a[i]);
                max = Math.max(a[i],max*a[i]);
            }
            maxp = Math.max(maxp,max);
        }

        System.out.println(max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr,n);
    }
}
