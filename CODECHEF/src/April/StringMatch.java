package April;

import java.util.Scanner;

public class StringMatch {
    static boolean stringMatch(char c,char[] s,int len,int key){

        int cprev=0,count=0;
        for (int j=0;j<len;j++) {
            if (s[j] == c)
                count++;
            else
            {
                cprev = count;
                count = 0;
            }


            if (cprev==key)
                return true;
            else
                continue;

        }
        if(count>=key||cprev>=key)
            return true;
        else
            return false;


    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i =0;i<t;i++){

            int len = sc.nextInt();
            int match = sc.nextInt();
            char[] s = sc.next().toCharArray();

            if (stringMatch('*',s,len,match))
                System.out.println("YES");
            else
                System.out.println("NO");

        }


        // your code goes here
    }
}
/*Question
A string is said to be using strong language if it contains at least K consecutive characters '*'.

You are given a string S with length N. Determine whether it uses strong language or not.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains two space-separated integers N and K.
The second line contains a single string S with length N.
Output
Print a single line containing the string "YES" if the string contains strong language or "NO" if it does not (without quotes).

You may print each character of each string in uppercase or lowercase (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical

Constraints
1≤T≤10
1≤K≤N≤106
S contains only lowercase English letters and characters '*'
Sum of N over all testcases is atmost 106.
Subtasks
Subtask #1 (30 points): N≤104, Sum of N over all testcases is atmost 104
Subtask #2 (70 points): original constraints

Example Input
3
5 2
*a*b*
5 2
*a**b
5 1
abcde
Example Output
NO
YES
NO
Explanation
Example case 1: Since there are no two consecutive characters '*', the string does not contain strong language.

Example case 2: There are two adjacent characters '*', so the string contains strong language.

Example case 3: Since there are no characters '*' in the string, it does not contain strong language.
* */