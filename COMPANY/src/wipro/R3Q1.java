package wipro;

import java.util.Scanner;

public class R3Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n1 = sc.next();
        String n2 = sc.next();
        String n3 = sc.next();
        System.out.println(solve(n1,n2,n3));
    }

    private static boolean solve(String n1, String n2, String n3) {
        return false;
    }


    private static int solve(int input1) {
        int sum=0;
        while(input1>0){
            sum+=(retsum(input1));

            input1=retnum(input1);
        }
        return sum;
    }
    static int retnum(int n){
        String s = String.valueOf(n);
        return Integer.parseInt(s.substring(1));
    }
    static int retsum(int n){
        int sum = 0;
        while(n>0){
            sum+=(n%10);
            n=n/10;
        }
        return sum;
    }

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



}

