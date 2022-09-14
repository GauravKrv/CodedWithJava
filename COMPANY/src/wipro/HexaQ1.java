package wipro;

import java.util.Scanner;

public class HexaQ1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int curr = 0;
        while (n > 1) {
            int near = nearest(n);
            if (near!=0) {

                curr = n / near;
                System.out.println(curr);
                if (curr != 0) {
                    System.out.println("rrr");
                    n = curr;
                }
                else{
                    System.out.println("mmm");

                    n = n-1;
                }
            }else{
                n = n-1;
            }
            count++;
            if (n==1) break;

        }

        System.out.println(count);
    }

    private static int nearest(int n) {
        int i = n-1;
        while (n%i!=0 && i>0){
            i--;
        }
        return Math.max(i, 0);
    }
}

class HexaQ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        fun(a,n);
    }

    private static void fun(int[] arr, int n) {
        int b[] = new int[n];
        int B;
        for (int i = n-2; i >=0 ; i--) {
            B = i+1;
            while (B<n){
                if(arr[i]<arr[B]) {
                    b[i] = B - i;
                    break;
                }
                B++;
            }
        }
        for (int x:b) {
            System.out.print(x+" ");
        }
    }
}
