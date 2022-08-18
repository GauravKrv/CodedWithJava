package StriverDP;

import java.util.Arrays;

public class ShortestSupersequenceQ31 {
    public static void main(String[] args) {

        String s1 = "brute";
        String s2 = "groot";
        shortestSuperUseingLcs(s1,s2);
    }


    //strivers formula came after analysing amtrix bcwards and checking where the modif hapens --
    static int shortestSuperUseingLcs(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];

        for(int rows[]: dp) //filling -1
            Arrays.fill(rows,-1);

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        //brute
        //groot
//COFUSION ARRISES IN GUESSING WHICH INDEX IS FOR WHICH STRING -- row = s1[add on decrementing j] , col = s2[add its char on decrsng i]
        int i=n,j=m;
        StringBuilder sb = new StringBuilder("");
        while (i>0 && j>0){
            if (s1.charAt(i-1)==s2.charAt(j-1)){
                sb.insert(0,s1.charAt(i-1)); //storing curr char at 0th index always -- since we are adding reverse manner
                i--; //go to up left
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) { //check where max comes from
                sb.insert(0,s1.charAt(i-1)); //add s2.charat i-1

                i--; //go up
            }else{
                sb.insert(0,s2.charAt(j-1)); //add s1.charat j-1
                j--; //go left
            }
        }
        if (i==1) sb.insert(0,s1.charAt(i-1));
        if (j==1) sb.insert(0,s2.charAt(j-1));

        System.out.println("Longest Common SuperSequennce = "+sb);
        System.out.println();
        return dp[n][m];
    }
}
