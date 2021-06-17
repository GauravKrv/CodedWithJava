package MY_CUSTOMS;

import java.util.HashMap;
import java.util.Scanner;

public class Lapindrome {

    static boolean isLapindrome(String s){
        boolean flag = true;
         if (s.length()%2!=0) flag = false;

        int mid= s.length()/2 ,mid2=(s.length()/2) + 1;

        HashMap<Integer,Integer> h1 = new HashMap<>();
        HashMap<Integer,Integer> h2 = new HashMap<>();

        for (int i=0;i<s.length();i++) {
            Integer a = (int) s.toCharArray()[i];
            if (i < mid)
                if (h1.containsKey(a))
                    h1.put(a, ++a);
                else
                    h1.put(a, a);
            else {
                if (flag) {
                    if (h2.containsKey(a))
                        h2.put(a, ++a);
                    else
                        h2.put(a, a);
                }
                if (!flag && i >= mid2) {
                    if (h2.containsKey(a))
                        h2.put(a, ++a);
                    else
                        h2.put(a, a);
                }
            }
        }
        if (h1.equals(h2))
            return true;
        return false;
    }

    static boolean isLapindrome2(String s) {
        int[] arr1 = new int[27];
        int[] arr2 = new int[27];
        boolean flag = true;
        if (s.length() % 2 != 0) flag = false;

        int mid = s.length() / 2, mid2 = (s.length() / 2) + 1;

        for (int i = 0; i < s.length(); i++) {

            if (i < mid)
                arr1[((int)s.charAt(i)) - 96]++;
            else {
                if (flag) {
                    arr2[((int) s.charAt(i)) - 96]++;
                }
                if (!flag && i >= mid2) {
                    arr2[((int) s.charAt(i)) - 96]++;
                }
            }
        }
        for (int i = 0; i < 27; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();

        while (t-->0) {
            String s = sc.next();
            if (isLapindrome2(s.toLowerCase()))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
