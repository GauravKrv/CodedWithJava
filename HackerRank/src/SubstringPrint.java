import java.util.Scanner;

public class SubstringPrint {
    static void subString(String str,int b,int e){
        System.out.println(str.substring(b,e));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        S.toUpperCase();
        subString(S.toUpperCase(),start,end);
    }
}
