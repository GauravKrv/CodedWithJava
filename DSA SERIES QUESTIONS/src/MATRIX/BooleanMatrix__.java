package MATRIX;

public class BooleanMatrix__ {
    static  void booleanMatrix(int matrix[][])
    {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean ar[] = new boolean[c];

        for(int i = r-1;i>=0; i--){
            int currcol = 0;
            while(currcol<c && (matrix[i][currcol] == 0 || ar[currcol])){
                currcol++;
            }
            if(currcol<c && matrix[i][currcol]==1 && !ar[currcol]) {
                ar[currcol] = true;
                makerowcol(matrix,i,currcol,r,c);

            }


        }
        // code here
    }

    static void makerowcol(int matrix[][], int row, int col, int r, int c){
        for(int i=0;i<c;i++){
            matrix[row][i] = 1;
        }

        for(int i=0;i<r;i++){
            matrix[i][col] = 1;
        }
    }

}
