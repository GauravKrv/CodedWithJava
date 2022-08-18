package AMAZON.INT;

import java.util.Arrays;

public class Q2MinKeypadClickCount {
    public static void main(String[] args) {
        String s = "abcghdiefjoba";
        System.out.println( solve(s));

    }

    private static int solve(String s) {

        int c[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'a']++;
        }

        Arrays.sort(c);
        int ans = 1,ct=1;
        int curr = 1;
        for (int i = 25; i >=0; i--) {
            if (c[i]==0) break;
            if (ct==3){
                ct=1;
                curr++;
            }else{
                ans+=curr;
                ct++;
            }
        }
        return ans;
    }
}
