package DIV2_750;

import CodeForces.CodeForces;

public class QA extends CodeForces {
    static int solution(int a,int b,int c){
        int prev = 0, curr = 0;
        curr = (c%2)*3;
        prev = curr;
        curr = ((b%2)*2);
        prev = Math.abs(prev-curr);
        if (a<=prev) prev = prev-a;

        else{
            curr = a % 2;
            prev = Math.abs(prev - curr);
        }
        return prev;
    }

    static int solution2(int a,int b,int c){
        a=a%2;
        b=b%2;
        c=c%2;
        long total = a + (2 * b) + (3 * c);
        return (int) (total % 2);
    }
    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            System.out.println(solution2(I(),I(),I()));
        }
    }
}


