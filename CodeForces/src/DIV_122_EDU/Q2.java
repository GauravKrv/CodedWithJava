package DIV_122_EDU;

import CodeForces.CodeForces;

public class Q2 extends CodeForces {

static void solution(String s){
        int n = s.length();
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
        if (s.charAt(i)=='1') count[1]++;
        else count[0]++;
        }

        if(count[0]<count[1]){
            System.out.println(count[0]);
        }else if (count[1]==count[0]){
            System.out.println(count[0]-1);
        }else{

        System.out.println(count[1]);
        }

        //System.out.println(0);

        }

public static void main(String[] args) {
        int t = I();
        while (t-->0){
        String s = S();
        solution(s);
        }
        }
        }
