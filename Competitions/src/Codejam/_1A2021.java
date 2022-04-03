package Codejam;

import java.util.Scanner;

public class _1A2021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int T = 0;
        while (++T<=t){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            solution(a,n,T);
        }
    }

    private static void solution(int[] a, int n,int T) {
        int count = 0;
        boolean flag = true;
        int s = n-1;
        while (flag){
            for (int i =s;i>0;i--){
                if (a[i]<=a[i-1]){
                    StringBuffer s1 = new StringBuffer(String.valueOf(a[i]));
                    StringBuffer s2 = new StringBuffer(String.valueOf(a[i-1]));

                    while (Integer.parseInt(String.valueOf(s1))<=Integer.parseInt(String.valueOf(s2))){
                        s1.append(9);
                        count++;
                    }
                    a[i] = Integer.parseInt(String.valueOf(s1));
                    a[i-1] = Integer.parseInt(String.valueOf(s2));
                }
            }
            flag = false;
            for (int i =s;i>0;i--){
                if (a[i]<a[i-1]){
                    s=i;
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(T+":"+count);
    }
}
