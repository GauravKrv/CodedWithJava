package wipro;

import java.util.Scanner;
import java.util.StringTokenizer;

class UserMainCode2 {
    public String toggleTheString(String input1,int input2){
        StringBuilder sb = new StringBuilder();
            int i = 0;
            switch (input2){
                case 0:
                    for ( i = 0; i < input1.length(); i++) {
                    if (i%2==0){
                        char c = input1.charAt(i);
                        sb.append(Character.isLowerCase(c)?Character.toUpperCase(c):Character.toLowerCase(c));
                    }
                }
                    break;
                case 1:
                    for ( i = 0; i < input1.length(); i++) {
                        if (i%2!=0){
                            char c = input1.charAt(i);
                            sb.append(Character.isLowerCase(c)?Character.toUpperCase(c):Character.toLowerCase(c));
                        }
                    }
                    break;
                case 2: sb.append(input1).reverse();
                    for (int j = 0; j < input1.length(); j++) {
                        char c = sb.charAt(j);
                        sb.replace(j,j+1,String.valueOf(Character.isLowerCase(c)?Character.toUpperCase(c):Character.toLowerCase(c)));
                    }
                    break;
            }



        return String.valueOf(sb);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserMainCode2 uc = new UserMainCode2();
        System.out.println(uc.toggleTheString(sc.nextLine(),sc.nextInt()));
    }
}
public class UserMainCode {//Z = 122 z = 90
    public String returnTheModifiedSentence(String input1){
        StringBuilder sb = new StringBuilder(input1);
        StringTokenizer st = new StringTokenizer(input1);
        int i = 0;
        while (st.hasMoreTokens()) {
            String c = st.nextToken();
            int x = c.length();
            for (int j = i; j <i+x ; j++) {
                char ch = sb.charAt(j);
                int sz = (int)ch+x;
                if (sz>122) ch = 'z';
                else if(sz>90 && sz<96) ch = 'Z';
                else ch = (char)(sz);

                sb.replace(j,j+1,String.valueOf(ch)) ;
            }

            i = i+x+1;
        }


        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserMainCode uc = new UserMainCode();
        System.out.println(uc.returnTheModifiedSentence(sc.nextLine()));
    }
}
