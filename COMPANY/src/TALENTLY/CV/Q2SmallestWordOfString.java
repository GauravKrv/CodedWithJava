package TALENTLY.CV;

import java.util.StringTokenizer;

public class Q2SmallestWordOfString {
    public static void main(String[] args) {
        String s = "Hello I am a me";
        System.out.println(solve(s));
    }

    static String solve(String s){
        StringTokenizer st = new StringTokenizer(s);
        int min = (int) 1e9;
        String ans = "";
        while (st.hasMoreTokens()){
            String curr = st.nextToken();
            if (curr.length()<=min){
                ans = curr;
                min = curr.length();
            }
        }
        return ans;

    }
}
