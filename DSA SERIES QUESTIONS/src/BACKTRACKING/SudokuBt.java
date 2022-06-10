package BACKTRACKING;
//WORKS -- BOTH FUNCTIONS ARE SAME IN WORKING
//Only gives a single Solution
public class SudokuBt {
    static boolean isSafe(int[][] board,int x, int y,int num){
        for (int i = 0; i < board.length; i++) {
            if (board[x][i]==num)
                return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][y]==num)
                return false;
        }

        int sqrt = (int) Math.sqrt(board.length);
        int startRow = x - x%sqrt;
        int startCol = y - y%sqrt;

        for (int i = startRow; i < startRow + sqrt; i++) {
            for (int j = startCol; j < startCol + sqrt; j++) {
                if (board[i][j]==num) return false;
            }
        }

//OTHER WAY
        /*
        x = x/3 * 3;//int startRow = x - x%sqrt; //
        y = y/3 * 3;// int startCol = y - y%sqrt; //

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j]==num) return false;
            }
        }

         */

        return true;
    }

    static boolean sudokuSolver(int[][] board,int n){
        int row = -1, col = -1;
        boolean isEmpty = true;

        for (int i = 0; i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]==0){

                    row = i;
                    col = j;

                    isEmpty = false; //// We still have some remaining missing values in Sudoku
                    break;
                }
            }
            if (!isEmpty) break;
        }
        if (isEmpty) return true;// No empty space left

        for (int num=1;num<=n;num++){
            if (isSafe(board,row,col,num)){
                board[row][col] = num;
                if (sudokuSolver(board, n))
                {
                    return true;
                }
                else
                {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
}
    public static boolean solveSudoku(int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    col = j;

                    // We still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // No empty space left
        if (isEmpty)
        {
            return true;
        }

        // Else for each-row backtrack
        for (int num = 1; num <= n; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board[row][col] = num;
                if (solveSudoku(board, n))
                {
                    // print(board, n);
                    return true;
                }
                else
                {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(
            int[][] board, int N)
    {

        // We got the answer, just print it
        for (int r = 0; r < N; r++)
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }

    // Driver Code
    public static void main(String args[])
    {

        int[][] board2 = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        int[][] board = new int[][] {
                { 1,0,0,0,0,2,0,9,0 },
                { 0,0,0,0,4,0,0,0,8},
                { 0,0,4,1,9,0,0,5,0 },
                { 0,0,2,0,0,4,5,0,0 },
                { 8,0,1,0,0,7,6,0,0 },
                { 5,4,0,0,0,3,0,0,7},
                { 0,0,0,3,0,0,0,0,0},
                { 0,6,0,0,0,0,1,0,0},
                { 0,2,0,0,6,0,3,7,4}
        };
        int N = board.length;

        if (sudokuSolver(board, N))
        {
            // print solution
            print(board, N);
        }
        else {
            System.out.println("No solution");
        }
    }
}
/*T.C = O(9^(N*N))
S.C = O(N*N)

* */

