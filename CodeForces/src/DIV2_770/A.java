package DIV2_770;

import CodeForces.CodeForces;

public class A extends CodeForces {
    static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    static int solution(String s,int k){
        String rev = reverse(s);
        if (k==0||rev.equals(s)){
//            if (k==0||k==1||rev.equals(s)){
            return 1;
        }
        k--;
        return solution(s.concat(rev),k) + solution(rev.concat(s),k);
    }

    public static void main(String[] args) {
//        System.out.println(reverse("hello"));
        int t = I();
        while (t-->0){
            int n = I();
            int k = I();
            String s = S();
            System.out.println(solution(s,k));
        }
    }
}
