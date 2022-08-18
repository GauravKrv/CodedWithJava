import java.util.Scanner;

public class PasswordValidator {
    //works
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String password = sc.next();
            if(isValid(password)) System.out.println("YES");
            else System.out.println("NO");
        }
        //code
    }

    static boolean isValid(String password){
        boolean upper=false,lower=false,digit=false;
        for(int i =0;i<password.length();i++){
            if((int)password.charAt(i) >= 97 && (int)password.charAt(i)<=122) lower = true;
            if((int)password.charAt(i) >= 65 && (int)password.charAt(i)<=90) upper = true;
            if((int)password.charAt(i) >= 48 && (int)password.charAt(i)<=57) digit = true;
            // System.out.println(lower + " "+ upper+ " "+digit+" = "+ (int)password.charAt(i));


            if(upper&&lower&&digit) break;
        }

        return (upper&&lower&&digit);
    }
}
