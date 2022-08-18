package AMAZON.INT;

public class Q4 {
    public static void main(String[] args) {
        String s ="abcabc";
        String t = "bca";
        System.out.println(solve(s,t));
    }

    private static int solve(String s, String t) {

        int c[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'a']++;
        }
        int ans = (int) 1e9;
        for (int i = 0; i < t.length(); i++) {
            ans = Math.min(ans,c[t.charAt(i)-'a']);
        }
        return ans;
    }
}
