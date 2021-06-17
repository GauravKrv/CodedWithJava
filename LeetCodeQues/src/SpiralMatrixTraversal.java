import java.util.ArrayList;
import java.util.Scanner;

public class SpiralMatrixTraversal {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the rows nd column of the matrix");
        int row = s.nextInt();
        int col = s.nextInt();
        int[][] arr1 = new int[row][col];
        //int[][] arr2 = new int[row][col];
        ArrayList alist = new ArrayList();

        int sr = 0, er = row-1, sc = 0, ec = col - 1, count =0;

        for (int i =0;i<row;i++){
            for (int j =0;j<col;j++){
                arr1[i][j] = s.nextInt();
            }
        }
        System.out.println("Entered matrix is : ");
        for (int i =0;i<row;i++){

            for (int j =0;j<col;j++){
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

        while (sr<=er &&  sc<=ec){
            for (int i =sc;i<=ec;i++){

                    alist.add(arr1[sr][i]);
                    count++;

            }
            sr++;
            if (count == row*col) break;

            for (int i =sr;i<=er;i++){
                    alist.add(arr1[i][ec]);
                    count++;

            }
            ec--;
            if (count == row*col) break;

            for (int i =ec;i>=sc;i--){
                    alist.add(arr1[er][i]);
                    count++;

            }
            er--;
            if (count == row*col) break;

            for (int i =er;i>=sr;i--){
                    alist.add(arr1[i][sc]);
                    count++;

            }
            sc++;
            if (count == row*col) break;
        }

        System.out.println("The spiral traversal output : "+ alist);
}
}
