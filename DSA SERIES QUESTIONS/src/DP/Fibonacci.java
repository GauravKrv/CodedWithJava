package DP;

import java.util.Scanner;

public class Fibonacci {

    //DP Method
    static  long[] fibo(int n){
        long fibtable[] = new long[n];
        fibtable[0] = 0;
        fibtable[1] = 1;
        for (int i=2;i<n;i++){
            fibtable[i] = fibtable[i-1] + fibtable[i-2];
        }
        return fibtable;
    }

    //Memoization method
    static  int fiboMemo(int n,int[] fibTable){

        int value;
        if (fibTable[n] != 0){
            value = fibTable[n];
        }
        else {

            if (n == 2 || n == 1)
                value = 1;
            else if (n < 0) {
                value = n;
            } else {

                value = fiboMemo(n - 1, fibTable) + fiboMemo(n - 2, fibTable);
                fibTable[n] = value;
            }
        }

        return value;

    }


    //Naive recursive
    static  int fiboNaive(int n){
        if (n==2||n==1)
            return 1;
        if (n<0)
            return n;

        return fiboNaive(n-1) + fiboNaive(n-2);

    }



    static void printArr(long[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of terms to get in fibb seq");
        int num = sc.nextInt();

        long fibSeq[] = fibo(num);
        System.out.println("The fiboSeq is : ");
        printArr(fibSeq);

        System.out.println("Nth fib sequence = " + fiboNaive(num));
        int fiboTable[] = new int[num+1];
        System.out.println("Nth fib sequence = " + fiboMemo(num,fiboTable));

    }
}
//LONG = 19
//INT = 10
//701408733 1134903170 1836311903 -1323752223 512559680 -811192543 -298632863 -11