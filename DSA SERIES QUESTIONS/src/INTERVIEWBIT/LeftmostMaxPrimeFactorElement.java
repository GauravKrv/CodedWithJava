package INTERVIEWBIT;

import java.util.Stack;

public class LeftmostMaxPrimeFactorElement {
    static int sum = 0;
    static boolean isPrime(int n){
        for (int i =2;i<=Math.sqrt(n);i++){
            if (n%i==0) return false;
        }
        return true;
    }


    static boolean isFactor(int a,int b){
        if(a%b==0) return true;
        return false;
    }

    static int solveSubarray(int A[],int n1, int B){
        int lmax = 0;
        for (int i=0;i<n1-B;i++){

         lmax = solveLeftmost(i,B,A);
            sum = sum+lmax;
        }


        return sum;
    }
     static int solveLeftmost(int strtIndex,int B,int A[]){
        int prev = 0, count = 0,max = 0,lmax=0, endEndex = strtIndex+B;
         Stack<Integer> st = new Stack<>();
        for (int i=strtIndex;i<endEndex;i++){
            if (isPrime(A[i])) st.push(A[i]);
            if (max<A[i]) max = A[i];
        }

        if (st.isEmpty()) return max;
        else {
            for (int i=strtIndex;i<endEndex;i++){
                for (Integer integer : st) {
                    if (isFactor(A[i], integer)) {
                        count++;
                        if (count==prev) {
                            if (lmax<A[i]) lmax=A[i];
                        }
                        else if (count > prev) {
                            prev = count;
                            lmax = A[i];
                        }

                    }
                }count = 0;
            }
        }


        return lmax;
     }

    public static void main(String[] args) {
        //int arr[] = {10,2,1,1,2};
        int arr[] = {18,36,15,210};
                System.out.println(solveSubarray(arr,arr.length,2));

        if (isFactor(10,36)) System.out.println("YES FACTOR");
                else System.out.println("NO FACTOR");
        if (isFactor(36,15)) System.out.println("YES FACTOR");
                else System.out.println("NO FACTOR");
        if (isFactor(15,210)) System.out.println("YES FACTOR");
             else System.out.println("NO FACTOR");


        if (isPrime(10))
            System.out.println("YES PRIME ");
        else System.out.println("NO PRIME");

        if (isPrime(2))
            System.out.println("YES PRIME ");
        else System.out.println("NO PRIME");
        if (isPrime(1))
            System.out.println("YES PRIME ");
        else System.out.println("NO PRIME");
        if (isPrime(210))
            System.out.println("YES PRIME ");
        else System.out.println("NO PRIME");
    }
}



















/*
    static int solveLeftmost(int strtIndex,int B,int A[]){
        int prev = 0, count = 0,max = 0,lmax=0, endEndex = strtIndex+B;
         Stack<Integer> st = new Stack<>();
        for (int i=strtIndex;i<endEndex;i++){
            if (isPrime(A[i])) st.push(A[i]);
            if (max<A[i]) max = A[i];
        }

        if (st.isEmpty()) return max;
        else {
            for (int i=strtIndex;i<endEndex;i++){
                Iterator itr = st.iterator();
                while(itr.hasNext()){
                    if (isFactor(A[i], (Integer) itr.next())){
                        count++;
                        if (count>prev){
                            prev = count;
                            lmax = A[i];
                        }
                    }
                }
            }
        }


        return lmax;
     }
* */
