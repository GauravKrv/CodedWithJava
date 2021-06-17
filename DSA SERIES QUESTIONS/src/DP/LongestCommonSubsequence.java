package DP;

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
        System.out.println(LCS("director","secretary"));
    }

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
}
