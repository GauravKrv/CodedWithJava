import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println( solve(s));


    }

    private static int solve(String s) {
    int n = s.length()+1;
    int ans = 0;
    if (n==2){
        int st = 10;
        int end = 99;
        while (st<=end){
            if (pcoun(st,s)){
                ans++;
            }
        }
    }
    else   if (n==3){
        int st = 10;
        int end = 99;
        while (st<=end){
            if (pcoun(st,s)){
                ans++;
            }
        }
    }
    else   if (n==2){
        int st = 10;
        int end = 99;
        while (st<=end){
            if (pcoun(st,s)){
                ans++;
            }
        }
    }


    return ans;
    }
// 0 1 1 0 1 0 1 1 0 0 1 1
    // 1 1 1 0 1 0 1 1 0 0 1 1

    static String count(int n){
        StringBuilder sb = new StringBuilder("");
        char[] arr = Integer.toBinaryString(n).toCharArray();
        System.out.println(String.valueOf(arr));
        Stack<Character> st = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (flag==true){
                if (arr[i]=='0')
                flag = false;

                else if (arr[i]=='1'){
                    st.push('1');
                    st.push('1');
                }
                continue;
            }
            if (st.isEmpty()==true){
                st.push(arr[i]);
            }
            else if (arr[i]=='0' && st.isEmpty()==false && st.peek()=='0'){
                sb.append('1');
                st.pop();
                st.push(arr[i]);
            }
            else if (arr[i]=='0' && st.isEmpty()==false && st.peek()=='1'){
                while (st.isEmpty()==false) {
                    sb.append('1');
                    st.pop();

                }
                st.push(arr[i]);
            }
            else if (arr[i]=='1' && st.isEmpty()==false && st.peek()=='0'){
                st.push('1');
            }
            else if (arr[i]=='1' && st.isEmpty()==false && st.peek()=='1'){

                while (!st.isEmpty()) {
                  st.pop();
                }
                flag = true;
            }
        }
        return String.valueOf(sb);

    }

    static boolean pcoun(int n,String s){
        String ns = String.valueOf(n);
        int j =0;
        for (int i = 0; i < ns.length()-1; i++) {
            if (s.charAt(j)=='-'){
                if (ns.charAt(i)<ns.charAt(i+1)) return false;
            }else if (s.charAt(j)=='+'){
                if (ns.charAt(i)>ns.charAt(i+1)) return false;
            }
            j++;
        }
        return true;
    }

}


