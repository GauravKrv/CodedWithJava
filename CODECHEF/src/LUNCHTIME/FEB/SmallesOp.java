package LUNCHTIME.FEB;
/*QUESTION
You are given two integers N and K. You may perform the following operation any number of times (including zero): change N to N−K, i.e. subtract K from N. Find the smallest non-negative integer value of N you can obtain this way.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains two space-separated integers N and K.
Output
For each test case, print a single line containing one integer — the smallest value you can get.

Constraints
1≤T≤105
1≤N≤109
0≤K≤109
Example Input
3
5 2
4 4
2 5
Example Output
1
0
2
Explanation
Example case 1:

First, we change N=5 to N−K=5−2=3.
Then, we have N=3 and we change it to N−K=3−2=1.
Since 1<K, the process stops here and the smallest value is 1.

Example case 2: We change N=4 to N−K=4−4=0. Since 0<K, the process stops here and the smallest value is 0.

Example case 3: Since 2<K initially, we should not perform any operations and the smallest value is 2.

* */
import java.util.Scanner;
/*
EZ QUESTION BUT I DIDNT THOUGHT ABOUT THE WRONG INPUTS
* */
public class SmallesOp {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long n,k,op;


        while (t-->0){
            n = sc.nextLong();
            k = sc.nextLong();
            if (n<k)
                System.out.println(n);
            else if (k==0) System.out.println(n);
            else {
                if (n%k==0) System.out.println(0);
                else

                    System.out.println(n%k);
            }

        }

    }
}
