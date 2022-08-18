package DP;

public class maxsubsquare {

    static String dpmaxsubsq(int[][] mat){
        int m = mat.length +1;
        int n = mat.length +1;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {


                if (i==0||j==0){
                    dp[i][j] = mat[i][j];
                } else  {
                    if (mat[i][j]==0){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1+ Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
                    }
                }
            }
        }
        int count = 0,max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count+=dp[i][j];
                max = Math.max(dp[i][j],max);

            }
        }

        return String.valueOf(count+" -- "+" max size: "+max);

    }

    public static void main(String[] args) {
        int m = 3,n = 3;
        int[][] mat = new int[m][n];
        //define the mat;
        System.out.println(dpmaxsubsq(mat));
    }


}
