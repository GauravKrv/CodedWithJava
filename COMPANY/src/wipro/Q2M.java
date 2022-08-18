package wipro;

import java.util.Scanner;

public class Q2M {
    static String solution(String s){
        StringBuilder sb = new StringBuilder(s);
        if (s.length()%2==0){
            for (int i = 2; i < sb.length(); i+=1) {
                sb.delete(i,i+1);
            }
        }else{
            for (int i = 1; i < sb.length(); i+=1) {
            sb.delete(i,i+1);
        }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.next()));
    }
}
