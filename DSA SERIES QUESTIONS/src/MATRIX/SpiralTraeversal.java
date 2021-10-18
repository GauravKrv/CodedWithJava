package MATRIX;

import java.util.ArrayList;

public class SpiralTraeversal {
    //WORKS
    static ArrayList<Integer> spirallyTraverse(int mat[][], int R, int C)
    {
        // code here
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int top = 0, left = 0, bottom = R - 1, right = C - 1;

        while(top <= bottom && left <= right)
        {
            for(int i = left; i <= right; i++)
                ar.add(mat[top][i]);   //left to right -- top++

            top++;

            for(int i = top; i <= bottom; i++)
                ar.add(mat[i][right]); //top to bottom -- right--

            right--;

            if(top <= bottom){  //then print the bottom row
                for(int i = right; i >= left; i--)
                    ar.add(mat[bottom][i]);

                bottom--;
            }

            if(left <= right){  //then print the leftmost row
                for(int i = bottom; i >= top; i-- )
                    ar.add(mat[i][left]);
                left++;
            }
        }
        return ar;
    }

    //DOESNT
    static ArrayList<Integer> spirallyTraverseMine(int mat[][], int R, int C)
    {
        // code here
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int n = R;
        for(int i=0;i<=n/2;i++){
            ar = boundaryTraversal(mat,R,C,i,ar);
            R --;
            C--;
        }

        return ar;
    }

    static ArrayList<Integer> boundaryTraversal(int mat[][], int R, int C, int s, ArrayList<Integer> ar)
    {

        if(R == 1)
        {
            for(int i = s; i < C; i++)
                ar.add(mat[s][i]);
        }
        else if(C == 1)
        {
            for(int i = s; i < R; i++)
                ar.add(mat[i][s]);
        }
        else
        {
            for(int i = s; i < C; i++)
                ar.add(mat[s][i]);
            for(int i = 1+s; i < R; i++)
                ar.add(mat[i][C - 1]);
            for(int i = C - 2 - s; i >= s; i--)
                ar.add(mat[R - 1][i]);
            for(int i = R - 2 - s; i >= 1+s; i--)
                ar.add(mat[i][s]);
        }

        return ar;
    }
    public static void main(String[] args) {
        int r = 4, c = 4;
        int matrix[][] = {{1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15,16}};

        ArrayList<Integer> ar = spirallyTraverse(matrix,matrix.length,matrix[0].length);
        System.out.println(ar);


    }
}
