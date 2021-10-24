package BACKTRACKING;

import java.util.Scanner;

public class NQueens {
//WORKS
    static boolean isSafe(int[][] board,int x,int y,int n){
        //check for column y in above rows
        for (int row = 0; row < x; row++) {
            if (board[row][y]==1){
                return false;
            }
        }
        int row =x, col = y;
        //check upper left diagonal
        while (row>=0&&col>=0){
            if (board[row--][col--]==1){
                return false;
            }
        }
     row = x;col=y;
        //check upper right diagonal
        while (row>=0&&col<n){
            if (board[row--][col++]==1){
                return false;
            }
        }
  return true;

    }

    static boolean nQueens(int arr[][],int x, int n){
        if (x>=n) return true;   //base case for this nQuees recursive function

        //now check recursively for each row that a column in it is safe or not
        for (int col = 0; col < n; col++) {
            if (isSafe(arr, x, col, n)) {
                arr[x][col] = 1;


                if (nQueens(arr, x + 1, n)) {
                    return true;
                }

                arr[x][col] = 0;
            }
        }
        return false;


    }

//    static ArrayList<int[][]> solutions()
//wright
    static int n = 16;
   static int[][] board = new int[n][n];
    public static void main(String[] args) {


        if (nQueens(board,0,n)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

class NQueensProblem
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=sc.nextInt();
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='-';
        if(solveNQueens(board,0,n)) solution(board,n);
        else System.out.println("No solution exists");
    }
    public static void solution(char board[][], int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(" "+board[i][j]+" ");
            System.out.println();
        }
    }
    public static boolean isSafe(char board[][], int row, int column, int n)
    {
        int i,j;
        for(i=0;i<column;i++)
        {
            if(board[row][i]=='Q') return false;
        }
        for(i=row,j=column; i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]=='Q') return false;
        }
        for(i=row,j=column; i<n && j>=0;i++,j--)
        {
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    public static boolean solveNQueens(char board[][], int column, int n)
    {
        if(column>=n) return true;
        for(int i=0;i<n;i++)
        {
            if(isSafe(board,i,column,n))
            {
                board[i][column]='Q';
                if(solveNQueens(board, column+1,n)) return true;
                board[i][column]='-';
            }
        }
        return false;
    }
}
