package DP;

public class EditDistance {
    static int editDistance(String s1, String s2){

        int[][] memo = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                memo[i][j] = -1;
            }
        }

        int longestcommonsubsequence = lcs(s1,s2,0,0, memo);
        int minConversions = Integer.max(s1.length(),s2.length()) - longestcommonsubsequence;

        return minConversions;
    }

    static int lcs(String s1, String s2,int m,int n,int[][] memo){
        if (memo[m][n]!=-1) return memo[m][n];

        if (m==s1.length()||n==s2.length()){
            memo[m][n] = 0;
            return memo[m][n];
        }

        if (s1.charAt(m) == s2.charAt(n)){
            memo[m][n] =   1+lcs(s1,s2,m+1,n+1,memo);
        }

        else {
            memo[m][n] =  Integer.max(lcs(s1,s2,m,n+1,memo),
                    lcs(s1,s2,m+1,n,memo));
        }

        return memo[m][n];

    }

    static int eDsir(String s1, String s2, int m, int n)
    {

        if(m==0)
            return n;
        if(n==0)
            return m;

        if(s1.charAt(m-1)==s2.charAt(n-1))
            return eDsir(s1,s2,m-1,n-1);
        else
        {
            return 1 + Math.min(eDsir(s1,s2,m,n-1), Math.min(eDsir(s1,s2,m-1,n),
                    eDsir(s1,s2,m-1,n-1)));
        }

    }


    public static void main(String[] args) {
        String s1 = "catto";
        String s2 = "ghetto";

        System.out.println(editDistance(s1,s2));
    }
}
