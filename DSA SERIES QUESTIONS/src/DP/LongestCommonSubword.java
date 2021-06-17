package DP;

import java.util.Scanner;

public class LongestCommonSubword {
   static String s1, s2;
   static int lcw = 0;
   static int lcw2 = 0;
   static int LCW(int i,int j) {
       if (i == s1.length()) return 0;
       if (j == s2.length()) return 0;
       if (s1.charAt(i) == s2.charAt(j)){
           lcw = 1 + LCW(i + 1, j + 1);
          if (lcw2 < lcw) lcw2 = lcw;
   }
      else if (s1.charAt(i) != s2.charAt(j)) {
           if (lcw2 < lcw){ lcw2 = lcw;
           lcw = 0;
       }
          LCW(i,j+1);

       }



       return lcw;
   }

    static int LCWDP(String u,String v){

        for (int r=0;r<u.length();r++){


        }

        for (int c =0;c<u.length();c++){

        }
        return lcw;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         s1 = sc.next();
         s2 = sc.next();
        int resultLength=0;
        int mAXLcw = 0;
        System.out.println("String 1 = "+ s1 + " sString2 = " + s2);
        for (int i=0;i<s1.length();i++) {

                resultLength = LCW(i, 0);
                lcw = 0;
                if (resultLength > mAXLcw) mAXLcw = resultLength;

        }
        System.out.println("Longest common word = "+mAXLcw );

    }
}
