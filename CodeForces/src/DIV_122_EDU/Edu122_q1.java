package DIV_122_EDU;

import CodeForces.CodeForces;

public class Edu122_q1 extends CodeForces {
    //WORKS I THINK BUT DIDNT ACCEPTED

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            System.out.println(solution(n));
        }
    }

    static int solution(int n){
        if (n%7==0){
            return n;
        }
        StringBuilder s = new StringBuilder(String.valueOf(n));

        s.setCharAt(s.length()-1,'1');
        n = Integer.parseInt(s.toString());
        while (n%7!=0){
            n+=1;
        }
        return n;
    }

}
/*
You are given an integer n. You have to change the minimum number of digits in it in such a way that the resulting number does not have any leading zeroes and is divisible by 7.

If there are multiple ways to do it, print any of them. If the given number is already divisible by 7, leave it unchanged.

Input
The first line contains one integer t (1≤t≤990) — the number of test cases.

Then the test cases follow, each test case consists of one line containing one integer n (10≤n≤999).

Output
For each test case, print one integer without any leading zeroes — the result of your changes (i. e. the integer that is divisible by 7 and can be obtained by changing the minimum possible number of digits in n).

If there are multiple ways to apply changes, print any resulting number. If the given number is already divisible by 7, just print it.

Example
inputCopy
3
42
23
377
outputCopy
42
28
777
* */
