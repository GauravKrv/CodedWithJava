package wipro;

import java.util.Scanner;

public class Q1M {

    static int solution(int input1,int input2){
        int occ = 0;
        String s1 =String.valueOf(input1);
        char c = s1.charAt(0);
        for (int i = 0; i < input2; i++) {
            String s2 = String.valueOf(i+1);
            int j = 0;
            while (j<s2.length()){
                if (c == s2.charAt(j)){
                    occ++;
                }
                j++;
            }

        }
        return occ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextInt(),sc.nextInt()));
    }
}
