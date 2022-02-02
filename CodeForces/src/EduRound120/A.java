package EduRound120;

import CodeForces.CodeForces;

public class A extends CodeForces {
    static String solution(int l1, int l2, int l3){
        int a = Math.max(l1,Math.max(l2,l3));
        int c = Math.min(l1,Math.min(l3,l2));

        int b = l1+l2+l3 - (a+c);

        System.out.println(a+" dd "+b+" ff "+c);

        if(a==b && b==c && a%2==0) return "YES";
        if(b==c && a%2==0) return "YES";
        if(a==b && c%2==0) return "YES";
        if(b!=c && a-c==b) return "YES";
        else return "NO";
    }
    public static void main(String[] args) {
        int t = I();
        while(t-->0){
            int l1 = I();
            int l2 = I();
            int l3 = I();

            System.out.println(solution(l1,l2,l3));
        }
    }
}
