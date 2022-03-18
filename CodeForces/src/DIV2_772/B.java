package DIV2_772;

import CodeForces.CodeForces;

public class B extends CodeForces {
     static void solution2(int[] a,int n) {
        boolean flag = false;
        int count = 0;
         for (int i = 0; i < n; i++) {
             if (i+1<n && !flag && a[i]<a[i+1]){
                 flag = true;
             }
            else if (flag && ((i==n-1 && a[i]<a[i-1])||
                     (i+1<n && a[i]<a[i+1] && a[i]<a[i-1]))){
                if (i!=n-1) {
                    int max = Math.max(a[i - 1], a[i + 1]);
                    a[i] = max;
                }else {
                    a[i] = a[i-1];
                }

                 count++;
                 flag = false;
             }
         }

         System.out.println(count);
         printArray(a);

     }
    static void solution(int[] a,int n) {

        int count = 0;
        for (int i = 1; i < n-1; i++) {
            if (a[i]>a[i+1]&&a[i]>a[i-1]){
              if (i+2<n && a[i+2]>a[i]){
                a[i+1]=a[i+2];
                }else {
                    a[i+1] = a[i];
                }

                count++;

            }
        }

        System.out.println(count);
        printArray(a);

    }

    public static void printArray(int a[])
    {
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
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
/*
7
5
1 2 3 4 5
0
1 2 3 4 5
5 4 3 2 1
0
0
4 3 2 1 0
5
1 2 3 2 1 -> failed here
1
1 2 3 2 2 -> ans
* */