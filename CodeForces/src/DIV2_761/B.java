package DIV2_761;

import CodeForces.CodeForces;

public class B extends CodeForces {


    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            solution(n);
        }
    }

    private static void solution(int n) {
        if(n%2==0)
            System.out.println(n-3+" "+2+" "+1);
        else if(((n+1)/2)%2==0)
            System.out.println(((n+1)/2-3)+" "+((n-1)/2+2)+" "+1);
        else
            System.out.println(((n+1)/2-2)+" "+((n-1)/2+1)+" "+1);

    }
}
