package Div2_768;

import CodeForces.CodeForces;
//CHECK FOR OHER CASES OTHER THAN TEST ONE TO VERIFY
public class A extends CodeForces {
    static void swap(int[] a,int[] b,int idx){
        int temp = a[idx];
        a[idx] = b[idx];
        b[idx] = temp;

    }
    static void solution(int[] a,int[] b,int n){
        int maxa = 0;
        int maxb=0;
      //  int min = Integer.MAX_VALUE;


            for (int j = 0; j < n; j++) {

                    if(a[j]<b[j]){
                         swap(a,b,j);
                    }


        }
        for (int i = 0; i < n; i++) {
            maxa = Math.max(a[i],maxa);
        }
        for (int i = 0; i < n; i++) {
            maxb = Math.max(b[i],maxb);
        }

        System.out.println(maxa*maxb);


    }

    public static void main(String[] args) {
        int t = I();
        while (t-- > 0) {
            int n = I();

            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = I();
            }
            for (int i = 0; i < n; i++) {
                b[i] = I();
            }
            solution(a, b, n);
        }
    }
    }
