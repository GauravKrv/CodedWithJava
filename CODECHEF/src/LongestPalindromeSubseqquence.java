import java.util.Scanner;

public class LongestPalindromeSubseqquence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            String in = sc.next();
            int max = longestPalindromicSub(in);
            System.out.println(max);
        }
        sc.close();
    }

     static int longestPalindromicSub(String in) {
         int max=0;
         int n = in.length();
     for (int i=0;i<n;i++){
         for (int len =i+1;len<=n;len++){
             if (isPalindrome(in.substring(i,len))){
                 int curr = len - i;
                 if (curr>max) max = curr;

                 //System.out.println("curr = "+curr);
             }
         }
     }
     return max;
    }

    private static boolean isPalindrome(String ssss) {

        int s = 0;
        int n = ssss.length();
        int e = n-1;
        while (s<e){
            if (ssss.charAt(s)==ssss.charAt(e)){
                s++;
                e--;
            }else {
                return false;
            }
            //System.out.println("s and e = "+s+" "+e);

            if (s==e) return true;
        }
        return false;
    }
}
