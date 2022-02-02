package DIV2_769;

import CodeForces.CodeForces;

public class Asol extends CodeForces {
    static void solution(String s,int n){
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='1') count[1]++;
            else count[0]++;
        }

        if (count[1]>=2||count[0]>=2){
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            String s = S();
            solution(s,n);
        }
    }
}

// if use diff id ten be carefull with the palagarism of your ownn
class BsolEdu112 extends CodeForces {
    static void solution(String s){
        int n = s.length();
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='1') count[1]++;
            else count[0]++;
        }

        if (count[1]>=2||count[0]>=2){
            int min = Math.min(count[0],count[1]);
            if(count[0]==count[1]){
                min = min-1;
            }
            System.out.println(min);
        }
        else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            String s = S();
            solution(s);
        }
    }
}

class BsolDiv769 extends CodeForces {
    static void solution(int n){
        int c = 0;
        int m = n-1;
        while(m>0){
            m = m/2;
            c++;
        }
        int max = 1;
        c--;
        while(c>0){
            max*=2;
            c--;
        }

        for (int i=n-1;i>=max;i--){

            System.out.print(i+" ");

        }

        for (int i=0;i<=max-1;i++){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            solution(n);
            System.out.println();
        }
    }
}

