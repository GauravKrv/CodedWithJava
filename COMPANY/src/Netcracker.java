import java.util.Scanner;

public class Netcracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        System.out.println(solve(sc.nextLine()));
    }

    private static boolean solve(String s1, String s2) {
        int b[] = new int[26];
        int c[] = new int[26];
        if (s2.length()>s1.length()) return true;
        for (int i = 0; i < s1.length(); i++) {
            b[s1.charAt(i)-'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            c[s2.charAt(i)-'a']++;
        }
        int ct = 0;
        for (int i = 0; i < 26; i++) {
            if (c[i]>0){
                if (b[i]<c[i]) return true;
                ct++;
            }
        }
        if (ct==1) return false;

        return true;
    }


    static int solve(String s1){
        Boolean flag = true;
        while (true){
            flag = false;
            if(s1.contains("AB")){
                flag = true;
                s1 = s1.replace("AB","");
            }
            if (s1.contains("CD")) {
                flag = true;
                s1 = s1.replace("CD","");
            }
            if (flag==false) return s1.length();
        }
    }



}
