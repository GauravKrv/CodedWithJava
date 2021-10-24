package DP;

import java.util.Hashtable;
//WORKS MEMO AND TABULAITON AND RECURSION -- ALL
public class LongestCommonSubsequence {

    static int LCS(String u, String v){
        int LCS[][] = new int[u.length()+1][v.length()+1];
        for (int r = 0;r<=u.length();r++)
            LCS[r][v.length()] = 0;

        for (int c = 0;c<=v.length();c++)
            LCS[u.length()][c] = 0;

        for (int c =v.length()-1;c>=0;c--){
            for (int r =u.length()-1;r>=0;r--){
                if (u.toCharArray()[r] == v.toCharArray()[c]){
                    LCS[r][c] = 1+LCS[r+1][c+1];

                }else {
                    LCS[r][c] = Math.max(LCS[r+1][c],LCS[r][c+1]);
                }
            }
        }



            printTable(u,v,LCS);

            return LCS[0][0];
    }

    public static void main(String[] args) {
        String s1 = "aaaaaaaaaaaaaaaaaaaaabbb";
        String s2 = "bbbbbbbbbaaaaaaaaaaaaaaaaa";

/*        String s1 = "aaaaaababbb";
        String s2 = "baaaaabaa";*/
   /*     Hashtable<Pair,Integer> memo = new Hashtable<>();
        memo.put(new Pair("",""),0);
        System.out.println(LCS(s1,s2));
        System.out.println(lcsmemo(s1,s2,memo));
        System.out.println(lcs(s1,s2));
*/
        int[][] memo = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(lcssir(s1,s2,0,0,memo));
        System.out.println(lcssir(s1,s2,0,0));





    }



    //works in memoization way

    static int lcssir(String s1, String s2,int m,int n,int[][] memo){
        if (memo[m][n]!=-1) return memo[m][n];

        if (m==s1.length()||n==s2.length()){
            memo[m][n] = 0;
            return memo[m][n];
        }

        if (s1.charAt(m) == s2.charAt(n)){
            memo[m][n] =   1+lcssir(s1,s2,m+1,n+1,memo);
        }

        else {
            memo[m][n] =  Integer.max(lcssir(s1,s2,m,n+1,memo),
                    lcssir(s1,s2,m+1,n,memo));
        }

        return memo[m][n];

    }

    //works for rec - index metho - front way
    static int lcssir(String s1, String s2,int m,int n){
        if (m==s1.length()||n==s2.length()){
            return 0;
        }
        if (s1.charAt(m) == s2.charAt(n)){
            return   1+lcssir(s1,s2,m+1,n+1);
        }

        return Integer.max(lcssir(s1,s2,m,n+1),
                lcssir(s1,s2,m+1,n));

    }


    //prints LCS
    static void printTable(String u,String v, int[][] LCS){
        System.out.println();
        System.out.println("LCS TABLE : ");
        System.out.println();
        for (int i=0;i<=u.length();i++){
            for (int j=0;j<=v.length();j++){
                System.out.print(LCS[i][j]+" ");
            }
            System.out.println();
        }
    }

    //works for recursion
    static int lcs(String s1, String s2){
        if (s1.equals("") || s2.equals("")){
            return 0;
        }
        int max = 0;
        if (s1.charAt(0) == s2.charAt(0)){
            return   1+lcs(s1.substring(1),s2.substring(1));
        }

        return Integer.max(lcs(s1, s2.substring(1)) , lcs(s1.substring(1), s2));

    }
    //wont work
    static int lcsmemo(String s1, String s2, Hashtable memo){
        Pair p = new Pair(s1,s2);
        if (memo.containsKey(p)){
            return (int) memo.get(p);
        }
        if (s1.equals("") || s2.equals("")){
            memo.put(new Pair(s1,s2),0);
            return 0;
        }
        if (s1.charAt(0) == s2.charAt(0)){
            memo.put(p,1+lcs(s1.substring(1),s2.substring(1)));
        }

        else
        memo.put(p, Integer.max(lcs(s1, s2.substring(1)) , lcs(s1.substring(1), s2)));

        return (int) memo.get(p);

    }

    static class Pair{
        String s1;
        String s2;
        Pair(String s1, String s2){
            this.s1 = s1;
            this.s2 = s2;
        }
        Pair(String s1){
            this.s1 = s1;
        }
    }



}

class MatchObj{
    public static void main(String[] args) {
        // 2 objs compared will neve be same
        int[] a1 = {1,2};
        int[] a2 = {1,2};
        System.out.println(a1==a1);
    }
}
