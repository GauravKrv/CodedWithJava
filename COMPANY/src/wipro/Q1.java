package wipro;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        System.out.println(findPIN(a,b,c,d));
    }

    static int getmax(int a){
        int max = Integer.MIN_VALUE;
        while (a>0){
            max = Math.max(max,a%10);
            a=a/10;
        }
        return max;
    }

    static int getmin(int a){
        int min = Integer.MAX_VALUE;
        while (a>0){
            min = Math.min(min,a%10);
            a=a/10;
        }
        return min;
    }

     static int findPIN(int input1, int input2, int input3, int input4) {

        int pin = ((getmax(input1)*getmin(input1))+(getmax(input2)*getmin(input2))+(getmax(input3)*getmin(input3)))-input4;
        //         int pin = ((getmin(input1))*(getmax(input2))*(getmax(input3)))+input4; -man
        return pin;
    }
}

class Q2 {

    static boolean isPrime(int n)
    {

        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private static int sumOfNonPrimeIndexValues(int[] input1, int input2) {
        int sum = input1[0];
        for (int i = 1; i < input2; i++) {
//            if (isPrime(i)){ -man
            if (isPrime(i)==false){
                sum+=input1[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n =sc.nextInt();
    int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }

        System.out.println(sumOfNonPrimeIndexValues(a,n));
    }


}

class Q3 {

    static boolean isPrime(int n)
    {

        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int findSumOfPrimes(int[] input1, int input2) {
       int min = Integer.MAX_VALUE,minall = Integer.MAX_VALUE;
       int sum = 0,sumall=0;
       boolean flag = false;
        for (int i = 0; i < input2; i++) {
            if (isPrime(input1[i])){
                flag = true;
                min = Math.min(min,input1[i]);
                sum+=input1[i];
            }
            sumall += input1[i];
            minall = Math.min(minall,input1[i]);
        }
        if (flag==false){
            return sumall-minall;
        }
        return sum-min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }

//        System.out.println(sumOfNonPrimeIndexValues(a,n));
    }


}