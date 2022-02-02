package DIV2_761;

import CodeForces.CodeForces;

public class A extends CodeForces {

    public static void main(String[] args) {
        int t = I();
        while(t-->0){
            String s = S();
            String compr = S();

            System.out.println(solution(s,compr));
        }
    }

    private static String solution(String s, String compr) {
//a=97
        int[] charr = new int[26];
        int b = compr.indexOf('b')+1;
        int c = compr.indexOf('c')+1;
        for (int i = 0; i < s.length(); i++)
            charr[s.charAt(i) - 97]++;


        char[] res = new char[s.length()];
        int in = 0;

        int acount = charr[0];

        for (int i = 0; i < charr.length; i++) {
            if ((char) (i + 97) == 'b' && b<c  && acount!=0 && charr[i]!=0 && charr[i+1] !=0 ){
                int temp = charr[i]; //swap the counts of b and c
                charr[i] = charr[i+1];
                charr[i+1] = temp;
//print c first and then b
                 while(charr[i]>0){
                    res[in++] = 'c';
                    charr[i]--;
                }
                i++;
                while(charr[i]>0){
                    res[in++] = 'b';
                    charr[i]--;
                }
                continue;
            }

            while(charr[i]>0){
                res[in++] = (char) (i + 97);
                charr[i]--;
            }

        }

        return String.valueOf(res);
    }
}
