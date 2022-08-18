package AMAZON.StriverBinSearch;

import java.util.Arrays;

public class MedianInAMatrix {
    public static void main(String[] args) {
        int mat[][] = {
                {1,3,6},
                {2,6,9},
                {3,6,9}
        };
        count(mat[0]);
        int m = mat.length;
        int n = mat[0].length;
        System.out.println(Findmedian(mat,m,n)); //works
        System.out.println(findMedian(mat,m,n)); //works
        System.out.println(medianmatrix(mat,m,n));
    }

    //Striver -- brute force --- works
    public static int Findmedian(int[][] arr, int row, int col) {
        int[] median = new int[row * col];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                median[index] = arr[i][j];
                index++;
            }
        }
        return median[(row * col) / 2];
    }
    //Striver binary search -- woks  -- BUT HAVE TO DRY RUN WHIE REVISION TO UNDERSTAND
    public static int findMedian(int[][] A, int row, int col) {
        int low = 1;
        int high = 1000000000;
        int n = row;
        int m = col;
        while (low <= high) {
            int mid = (low + high) / 2; //calculate the new refrence point to check
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += countLesThanMid(A[i], mid); //ount total no of elements less than "mid" in each row and add them
            }
            if (cnt <= (n * m) / 2) //if count is less than median number then increase the low's index
                low = mid + 1;
            else
                high = mid - 1; //else decrease the high's index
        }
        return low;
    }

    static void count(int[] A){
        int cnt=0;
        cnt = cnt+ Arrays.binarySearch(A,A[1]); //ount total no of elements less than "mid" in each row and add them
        System.out.println(cnt);
    }
    //fails
    private static int medianmatrix(int[][] mat, int m, int n) {
        int median =  (m*n)/2;
        int mid = median;

        int l = 0;
        int h = n-1;
        int currcount = 0;
        int r = 0;

        while(l<=h){
            mid = (l+h)/2;
            currcount=0;
            for (int i = 0; i < m; i++) {
                currcount = currcount+countLesThanMid(mat[i],mid);
            }
            if (currcount<median) l = mid+1;
            else if (currcount>median) h = mid-1;

        }

        return l;
    }

    private static int countLesThanMid(int[] mat, int mid) { // 1 2 3 3 3 4 9 | mid = 4
        int h = mat.length-1;
        int l = 0;
        while (l<=h){
            int m  = (l+h)/2;
            if (mat[m]<=mid) l=m+1;
            else if (mat[m]>mid) h=m-1;
        }
        return l;
    }


    //write function to get mdian of rowise sorted matrix , i.e each row only should be sorted
    private static int getmedianStBSearch(int[][] mat, int m, int n) {
        return 0;
    }

        //WORKS -- BUT FOR Colum wise and rowise sorted marix -->

    private static int getmedian(int[][] mat, int m, int n) {
        int j =0,c=1,k=((m*n)/2) +1;
        while (j<n){
            for (int i = 0; i < m; i++) {
                if (c==k) {
//                    System.out.println("C = "+c);
//                    System.out.println("i= "+i+" & j ="+j);
                    return mat[i][j];

                }
                c++;
            }
            j++;
        }
        return -1;
    }
}
