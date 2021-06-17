import java.util.HashMap;
import java.util.Scanner;

public class AnagramCheck {
    static boolean isAnagram(String a, String b) {
        int n =a.length();
        int val1 = 0;
        int val2 = 0;
        char key;

        if (a.length() == b.length()) {

            for (int i = 0;i<n;i++){
                key = a.toUpperCase().charAt(i);
                for (int j = 0;j<n;j++){
                    if (key == a.toUpperCase().charAt(j)) val1++;
                    if (key==b.toUpperCase().charAt(j)) val2++;
                }
                if (val1==val2) val1=val2=0;
                else {
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
