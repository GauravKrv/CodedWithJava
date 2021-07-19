package MATRIX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MedianInRowWiseSorted__ {
    static int median(int mat[][], int r, int c) {
        int minval = mat[0][0];
        int maxval = mat[0][c-1];
        for(int i = 1;i<r;i++){
            minval = Math.min(minval,mat[i][0]);
            maxval = Math.max(maxval,mat[i][c-1]);
        }

        int medianpos = (r*c + 1)/2;
        while(minval!=maxval){
            int midval = (minval+maxval)/2;
            int midvalpos = 0;

            for(int i=0;i<r;i++){
                //calculate the expected column for midvalue in each row
                int position_for_midval_ineachrow = Arrays.binarySearch(mat[i],midval);
                //bin search will return -ve index of where midvalue would have been  if the midval is not present


                if(position_for_midval_ineachrow < 0)//checking if elements are not distinct
                    position_for_midval_ineachrow = Math.abs(position_for_midval_ineachrow) - 1;
                else
                {
                    while(position_for_midval_ineachrow < mat[i].length &&
                            mat[i][position_for_midval_ineachrow] == midval)
                        position_for_midval_ineachrow += 1;
                }

                midvalpos = midvalpos + position_for_midval_ineachrow;
            }
            if(midvalpos<medianpos)
                minval = midval+1;//critical to understand how it helps
            else
                maxval = midval;
        }
    /*
    3 11
5 6 6 7 8 10 10 10 12 20 20 2 6 8 9 11 15 17 18 19 19 19 6 7 8 8 9 9 11 13 16 16 19
    */

    /*3 3
1 10 20 15 25 35 5 30 40
    */
        return minval;
        // code here
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            int ans = median(matrix, R, C);
            System.out.println(ans);
        }
    }

}
