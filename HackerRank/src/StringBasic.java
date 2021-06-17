import java.util.Scanner;

public class StringBasic {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        int len = A.length() + B.length();
        System.out.println(len);
        if (A.compareTo(B)>0){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
        System.out.println(A.toUpperCase().charAt(0)+A.substring(1,A.length()) + " "+
                B.toUpperCase().charAt(0)+B.substring(1,B.length()));
        /* Enter your code here. Print output to STDOUT. */

    }
}
