import CodeForces.CodeForces;

import java.util.Scanner;

public class Q1 extends CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        int i = 1;
        while (i<n){
            if (gcd(i,n)==1){
                count++;
            }
            i++;
        }
        System.out.println(count);
    }

    public static int gcd(int a,int b)
    {
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
}


class Q2 {
    static int solution(int input1){
        int m = 1000000009;
        return (((input1*input1) + input1 + 2)/2)%m;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }
}
