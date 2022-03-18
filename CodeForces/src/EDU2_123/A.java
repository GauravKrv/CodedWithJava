package EDU2_123;

import CodeForces.CodeForces;

import java.util.HashSet;

public class A extends CodeForces {

    static void solution(String s){
        HashSet<Character> hs = new HashSet<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='r'||c=='g'||c=='b'){
                hs.add(c);
            }else if(c=='R'&&hs.contains('r')||
                    c=='G'&&hs.contains('g')||
                    c=='B'&&hs.contains('b')){

            }else {
                flag = false;
            }
        }

        if (flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
    public static void main(String[] args) {
        int t=I();
        while (t-->0){

            String s = S();
            solution(s);        }
    }
}
