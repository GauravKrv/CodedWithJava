package DIV2_777;

import CodeForces.CodeForces;

public class A extends CodeForces {


    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            solution(n);
        }
    }

    private static void solution(int n) {
        if (n==1){
            System.out.println(1);
            return;
        }
        if (n==4){
            System.out.println(121);
            return;
        }
        boolean flag = true;
        StringBuilder s = new StringBuilder("");
        while (n>0){
            if (flag){
                s.append("2");
                n-=2;
                flag = false;
            }else {
                s.append("1");
                n-=1;
                flag = true;
            }

        }
        System.out.println(s);
    }
}
