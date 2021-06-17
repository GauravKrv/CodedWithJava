import java.util.Scanner;

public class StringPalindrome {

    static boolean palindromeCheck(String str){
        char arr[] = str.toCharArray();
        int s=0;
        boolean flag = true;
        int e=arr.length-1;
        while(s<e){
            if (arr[s] == arr[e]){
                s++;
                e--;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        boolean res = palindromeCheck(A);

        if (res) System.out.println("Yes");
        else System.out.println("No");
    }


}
