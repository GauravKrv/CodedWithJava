package DP;

public class LongestCommonSubstring  {
    static int lcsubrecur(String s1, String s2, int i, int j, int premax){

        if (i==s1.length()||j==s2.length()){
            return premax;
        }
        if (s1.charAt(i)==s2.charAt(j)){
            premax = lcsubrecur(s1,s2,i+1,j+1,premax+1);
        }
        return Math.max(premax,Math.max(lcsubrecur(s1,s2,i+1,j,0), lcsubrecur(s1,s2,i,j+1,0)));
    }


    static int lcsubrecur_Tabulation_help(String s1,String s2,int premax){

return 0;

    }
    public static void main(String[] args) {
        System.out.println(lcsubrecur("stabcdiofgh","abcdfgh",0,0,0));
    }
}

//FOR DP SOLUTION REFER THE STRIVER COPY -D6,Q3 OR GFG//    --> sir soluton -- https://onlineccompiler/onlinegdb.com/HFio5noYr