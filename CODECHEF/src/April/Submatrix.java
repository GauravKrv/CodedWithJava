package April;

import java.util.Scanner;

public class Submatrix {
    static int matrix[][];
    static int n;
    static int k,res = 0;
    static void subLength(){
        for (int i=1;i<=n;i++)
            subMatrix(i);
    }

    static void subMatrix(int l){
        int i=0;
        int j=0;
        while (i+l<n){
            while (j+l<n){
                if (calSum(i,j,l))
                    res++;
                else continue;
            }
        }
    }

    static boolean calSum(int row,int col,int len){
        int sum = 0;
        int count = len*len;
        float avg;
        for (int i = row;i<row+len;i++){
            for (int j= col;j<col+len;j++){
                sum = sum+ matrix[i][j];
            }
        }
        avg = (float)sum/count;
        if (avg>k)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // System.out.println("Enter K value and rows and col size");
        //k = sc.nextInt();
        System.out.println("Enter row and column ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        matrix = new int[row][col];
        n = row;
        System.out.println("Enter the eleements ");

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Thge enetered matrix is  : ");
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print( "[ "+matrix[i][j]+"  "+i+" "+j+" ]  ");;
            }
            System.out.println();
        }
      //  subLength();
        //System.out.println("No of submatrixes = "+res);
        res = 0;
    }
}
