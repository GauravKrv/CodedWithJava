package EDU2_121;

import CodeForces.CodeForces;

public class B extends CodeForces {


    public static void main(String[] args) {
        int t = I();

        while (t-->0){
            StringBuilder s = new StringBuilder(S());
            solution(s);
        }
    }

    private static void solution(StringBuilder s) {

        int max = 0;
        int mi = 0;
        int ssum = (s.charAt(0)-48)+(s.charAt(1)-48);
//        int n = s.length();
        for (int i = 1; i < s.length(); i++) {
            int temp = max;
            int sum = (s.charAt(i)-48)+(s.charAt(i-1)-48);
            if(sum>9){
                max = sum;
                mi = i;
            }
        }
        if(max>9)
        s.replace(mi-1,mi+1,String.valueOf(max));
        else{
            s.replace(0,2,String.valueOf(ssum));
        }
        System.out.println(s);


    }
}

class Try {
    public static void main(String[] args) {
        String s= "345";
        int sum = (s.charAt(0)-48)+(s.charAt(1)-48);
        System.out.println(sum);
    }
}

/*
112999
22999
112189
13

* */
//HANDLE EDGE CASES
class B117EDU extends CodeForces {


    public static void main(String[] args) {
        int t = I();

        while (t-->0){
            int n = I();
            int a = I();
            int b = I();
            solution(n,a,b);
            System.out.println();
        }
    }

    private static void solution(int n, int a, int b) {
        if(n==2){
            System.out.print(a+" "+b);
            return;
        }
//        if((a>=n/2&&b<n/2)||(a<n/2&&b<=n/2)){
//            System.out.print(-1);
//            return;
//        }
        int[] ar = new int[n];
        int lh =1;

        int k = n;
        ar[0] = a;
        ar[k-1] = b;
        int mina = n+1;
        int maxb = -1;
        //k = 5
//        System.out.println("b = "+ar[k-1]);
        while (lh<n/2){
            if (k==b||k==a){
              k--;
            }
           else {
                ar[lh] = k;

                k--;
                lh++;
            }

        }
        while (lh<n-1){
            if (k==a||k==b){
                k--;
            }
            else{
                ar[lh] = k;

                k--;
                lh++;
            }
        }
        int i = 0;
        for ( i = 0; i < n / 2; i++) {
            mina = Math.min(mina,ar[i]);
        }
        for ( i = n/2; i < n; i++) {
            maxb = Math.max(maxb,ar[i]);
        }
//        printArray(ar);
//        System.out.println("mina = "+mina+" maxb= "+maxb);
//        System.out.println("a = "+mina+" b= "+maxb);
        if (maxb!=b||mina!=a){
            System.out.print(-1);
            return;
        }
        for ( i =0;i<n;i++) {
            System.out.print(ar[i]+" ");
        }



    }

//    private static void solution(StringBuilder s) {
//
//        int max = 0;
//        int mi = 0;
//        int ssum = (s.charAt(0)-48)+(s.charAt(1)-48);
////        int n = s.length();
//        for (int i = 1; i < s.length(); i++) {
//            int temp = max;
//            int sum = (s.charAt(i)-48)+(s.charAt(i-1)-48);
//            if(sum>9){
//                max = sum;
//                mi = i;
//            }
//        }
//        if(max>9)
//            s.replace(mi-1,mi+1,String.valueOf(max));
//        else{
//            s.replace(0,2,String.valueOf(ssum));
//        }
//        System.out.println(s);
//
//
//    }
}