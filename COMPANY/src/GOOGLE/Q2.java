package GOOGLE;

import java.util.Scanner;

public class Q2 {
    static void solution(int n){
        int x =1;
        while (x<n){
            x=x*5;
        }
        if (x==n) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}
