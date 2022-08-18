package GOOGLE;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q3 {
    static void solution(String s){
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens())
            sb.append(st.nextToken()+" ");
        System.out.println(String.valueOf(sb).trim());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solution(s);
    }
}
