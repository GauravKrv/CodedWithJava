package StriverDP;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintLCS26 {
    //use lcs tabulation function 's dp matrix to print lcs
    public static void main(String[] args) {

        String s1 = "aacabdkacaa";
        String s2 = "aacakdbacaa";
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2]; //since dp cannot store 0 as a value of n -- or b ranges from 0->n-1 as value

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solveTAB(s1,s2,n1,n2));//incorrect method to print lcs -- i.e formula used after lcs calculation is incorrect
        System.out.println(lcsStriver(s1,s2));

    }

    //my doesnt wokrs -- just change the formula of printing -- as dp is correct
    private static int solveTAB(String s1, String s2, int n,int m) {
        int[][] dp = new int[n][m]; //since dp can store 0 as a value of target -- or target ranges from 0-target as value

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i)== s2.charAt(0)) dp[i][0]= 1;
        }

        for (int i = 0; i < m; i++) {
            if (s1.charAt(0)== s2.charAt(i)) dp[0][i]= 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int ans = 0;
                if (s1.charAt(i)== s2.charAt(j)) //if matches then add to current and no need to skip [think]
                    ans = 1+dp[i-1][j-1];
                else ans = Math.max(dp[i-1][j],dp[i][j-1]);

                dp[i][j] = ans;

            }
        }
        System.out.println("Printing dp : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println("Printing lcs : ");

        for (int j = m-1; j >0; j--) { //for index 1->m-1
            if (dp[n-1][j]!=dp[n-1][j-1])
            System.out.print(s2.charAt(j)+ " ");
        }
        if (m>=2 && dp[n-1][0]!=dp[n-1][1]) //for 0th index
            System.out.print(s2.charAt(0)+ " ");

        System.out.println();
        return dp[n-1][m-1];
    }

    static String reverse(String s){
        int a=0,e=s.length()-1;
        StringBuilder sb = new StringBuilder(s);

        return String.valueOf(sb.reverse());
    }

    //strivers formula came after analysing amtrix bcwards and checking where the modif hapens --
    static int lcsStriver(String s1, String s2) {

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
        
        int i=n,j=m;
        StringBuilder sb = new StringBuilder("");
        while (i>0&&j>0){
            if (s1.charAt(i-1)==s2.charAt(j-1)){
                sb.insert(0,s1.charAt(i-1)); //storing curr char at 0th index always -- since we are adding reverse manner
                i--; //go to up left
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) { //check where max comes from
                i--; //go left
            }else{
                j--; //go right
            }
        }
        System.out.println("LCS = "+sb);
        System.out.println();
        return dp[n][m];
    }
}
