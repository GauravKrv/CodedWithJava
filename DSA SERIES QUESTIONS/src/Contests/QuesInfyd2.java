package Contests;

import java.util.ArrayList;
import java.util.Scanner;

public class QuesInfyd2 {
    static void solution(String[][] M){
        ArrayList<String> ar = new ArrayList();
        for (String s :
                M[1]) {
            ar.add(s);
        }
        String[][] res = new String[2][M[0].length];
        for (int i=0;i<M[0].length;i++){
            String s = getString(M[0][i]);
            String num = getNum(M[0][i]);

            if(ar.contains(num)){
                res[0][i] = num;
                res[1][i] = s;
            }else{
                res[0][i] = "NA";
                res[1][i] = "NA";
            }
        }

        for (int i=0;i< 2;i++){
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+",");
            }
            System.out.println();
        }

    }
    static String getString(String str){
        ArrayList<Character> ar = new ArrayList();
        for (int i=0;i<str.length();i++){
            ar.add(str.charAt(i));;
        }
        int n = str.length();
        for (int i=0;i<n;i++){
            if (ar.get(i)>=48 && ar.get(i)<=57){
                ar.remove(i);
                n--;
                i--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch: ar) {
            sb.append(ch);
        }
        return sb.toString();
    }

    static String getNum(String str){
        ArrayList<Character> ar = new ArrayList();
        for (int i=0;i<str.length();i++){
            ar.add(str.charAt(i));;
        }
        int n = str.length();
        for (int i=0;i<n;i++){
            if (!(ar.get(i)>=48 && ar.get(i)<=57)){
                ar.remove(i);
                n--;
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch: ar) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String[] s1 = st.split(",");
        int len = s1.length/2;
        int c =0;
        String[][] s = new String[2][len];
        for (int i=0;i<2;i++){
            for (int j = 0; j < len; j++) {
                s[i][j] = s1[c];

//                System.out.println(s1[c]+" -> ");
                c++;
            }
        }
//        System.out.println();
//         = {{"mo3s", "t23m", "4tq5"},
//                {"13","3","45"}};
        solution(s);
    }
}
/*
mmm3s,554ggt,hyyjyjyu466,d12,sss45,45,6,12,554,12
NA,554,NA,12,45,
NA,ggt,NA,d,sss,
* */
