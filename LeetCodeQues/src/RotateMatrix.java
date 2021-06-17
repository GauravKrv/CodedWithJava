import java.util.Scanner;

public class RotateMatrix {
    //QUES:Rotate a given matrix 90 deg in clockwise direction
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows nd column of the matrix");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr1 = new int[row][col];
        int[][] arr2 = new int[row][col];
        for (int i =0;i<row;i++){
            for (int j =0;j<col;j++){
                arr1[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        for (int i =0;i<row;i++){
            int k = row-1;
            for (int j =0;j<col;j++){
                arr2[i][j] = arr1[i][k];
                k--;
            }
            System.out.println();
        }
        int l = row - 1;
        for (int i =0;i<row;i++){
            int k = row-1;
            for (int j =0;j<col;j++){
                arr1[i][j] = arr2[l][k];
                k--;
            }
            l--;
            System.out.println();
        }
        for (int i =0;i<row;i++){
            int k = row-1;
            for (int j =0;j<col;j++){
                arr2[i][j] = arr1[j][i];
                k--;
            }
            l--;
            System.out.println();
        }

        System.out.println("Resultant matrix is : ");
        for (int i =0;i<row;i++){

            for (int j =0;j<col;j++){
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }

    }
}
class RotateMatrixVid {
    //QUES:Rotate a given matrix 90 deg in clockwise direction  => Step 1 : Transpose , Step 2 : Reverse the row elements
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows nd column of the matrix");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr1 = new int[row][col];
        int[][] arr2 = new int[row][col];


        for (int i =0;i<row;i++){
            for (int j =0;j<col;j++){
                arr1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Entered matrix is : ");
        for (int i =0;i<row;i++){

            for (int j =0;j<col;j++){
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        for (int i =0;i<row;i++){
            for (int j =0;j<col;j++){
                arr2[i][j] = arr1[j][i];
            }
        }
        for (int i =0;i<row;i++){
            for (int j =0;j<col;j++){
                arr1[i][j] = arr2[i][j];
            }
        }
        arr2 = null;
        //System.out.println(arr2[0][2]);



        for (int i =0;i<row;i++) {
            int s = 0;
            int e = row - 1;
            while (s < e) {
                int temp;
                temp = arr1[i][s];
            arr1[i][s] = arr1[i][e];
            arr1[i][e] = temp;
            s++; e--;
        }
        }



        System.out.println("Resultant matrix is : ");
        for (int i =0;i<row;i++){

            for (int j =0;j<col;j++){
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

    }
}
