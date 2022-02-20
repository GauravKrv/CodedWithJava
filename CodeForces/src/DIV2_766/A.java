package DIV2_766;

import CodeForces.CodeForces;

public class A extends CodeForces {


    public static void main(String[] args) {
        int t= I();
        while (t-->0){
            int n = I();
            int m = I();
            int r = I();
            int c = I();
            boolean flag = false;
            char[][] bw= new char[n][m];
            for (int i = 0; i < n; i++) {

                String s = S();

                for (int j = 0; j < m; j++) {
                    bw[i][j] = s.charAt(j);
                    if (bw[i][j] == 'B'){
                        flag = true;
                    }
                }

            }


            System.out.println(solution(n,m,r,c,bw,flag));

        }
    }

    private static int solution(int n, int m, int r, int c,char[][] bw,boolean flag) {
        if (flag==false){
            return -1;
        }

        if (bw[r-1][c-1]=='B') return 0;
        for (int i = 0; i < n; i++) {


            if (bw[i][c-1]=='B'){
                return 1;
            }

        }
        for (int i = 0; i < m; i++) {


            if (bw[r-1][i]=='B'){
                return 1;
            }

        }

        return 2;
    }
}
