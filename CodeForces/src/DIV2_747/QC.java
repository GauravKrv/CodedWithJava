package DIV2_747;

import CodeForces.CodeForces;

import java.util.ArrayList;
import java.util.Scanner;

public class QC extends CodeForces {

    static void solution(int n,char c,String s){

       // System.out.println("n= "+n+" c = "+c+" s= "+s);
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=c){
                t++;
                break;
            }
        }

        if (t==0) { //i.e no chars are there which is not c
            System.out.println(0);
            return;
        }
        int flag = 0;

        for (int i = 2; i < n; i++) {
            t=0;
            for (int j = 1; j < n; j+=i) {
                if (s.charAt(j)!=c){
                    t++;
                    break;
                }
            }
            if (t==0) { //A single x is present such that all multiples are c
                flag = 1;
                System.out.println(1);
                System.out.println(i);
                return;
            }
        }

        if (flag==0){//no single x is there such that all multiples are c
            System.out.println(2);
            System.out.println(n+" "+(n-1));
        }

    }



    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){

            int n = sc.nextInt();

            char c = sc.next().charAt(0);
            String s = sc.nextLine();

            //size, char, string
            solution(n,c,s);
        }*/
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int t = 0; t < N; t++) {
            int length = sc.nextInt();
            char c = sc.next().toCharArray()[0];
            String str = sc.next();
            solution(length,c,str);
        }

    }


    static void solution2(int n,char c,String s){
        int pr = -1;
        ArrayList<Integer> prime = primeSieve(n);

        for (int x :
                prime) {
            if (x>n/2 && s.charAt(x-1)!=c){
                pr = x;
                break;
            }
        }

        if (pr==-1){
            boolean f1 = checkEven(s,c);
            boolean f2 = checkOdd(s,c);
            if (f1&&f2){
                System.out.println(2);
                System.out.println(n+" "+(n-1));
                return;
            }
            else if (f1||f2){
                System.out.println(1);
                if (f1){
                    System.out.println(n);
                }
                else{
                    System.out.println(n-1);
                }

                return;
            }else{
                System.out.println(0);
            }


        }
        else {
            System.out.println(1);
            System.out.println(pr);
        }


    }

    static boolean checkOdd(String s,char c){
        for (int i = 0; i < s.length(); i++) {
            if (i+1%2==0 && s.charAt(i) != c)
                return true;
        }
        return false;
    }

    static boolean checkEven(String s,char c){
        for (int i = 0; i < s.length(); i++) {
            if (i+1%2==1 && s.charAt(i) != c)
                return true;
        }
        return false;
    }

}
/*
3
4 a
aaaa
4 a
baaa
4 b
bzyx
* */