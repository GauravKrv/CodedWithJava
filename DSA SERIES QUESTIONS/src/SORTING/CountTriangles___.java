package SORTING;

import java.util.Arrays;

public class CountTriangles___ {
    //WORKS
    static int findNumberOfTriangles(int A[], int n)
    {


        Arrays.sort(A);

        int count = 0;

        for (int i = n - 1; i >= 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {

                    // If it is possible with a[l], a[r]
                    // and a[i] then it is also possible
                    // with a[l+1]..a[r-1], a[r] and a[i]
                    count += r - l;

                    // checking for more possible solutions
                    r--;
                }
                else // if not possible check for
                // higher values of arr[l]
                {
                    l++;
                }
            }
        }
        return count;
    }
    //Function to count the number of possible triangles.
    static int findNumberOfTrianglesv1(int arr[], int n)
    {
        // code here
        Arrays.sort(arr);
        int count = 0;
        for(int i=0;i<n-2;i++){
            if(arr[i]!=arr[i+1]){
                count += (fact(n-i-1))/(fact(n-i-3)*2);
            }
        }

        return count;
    }
    static int findNumberOfTrianglesv2(int arr[], int n)
    {
        Arrays.sort(arr);
        int count = 0;
        for(int i=0;i<n-2;i++){

            count += (fact(n-i-1))/(fact(n-i-3)*2);
        }
        return count;
    }

    static int findNumberOfTrianglesv3(int arr[], int n)
    {
        // code here
        Arrays.sort(arr);
        int dupli = 0;
        for(int i = 0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                dupli++;
            }
        }
       // n = n-dupli;
        int count = 0;
        for(int i=0;i<n-2;i++){

            count += (fact(n-i-1))/(fact(n-i-3)*2);


        }

        return count;
    }

/*V3
MY GIVES 165
GFG GIVES 162
 int arr[] = {6, 4,5, 9,9,9, 7, 8,8,8,8};
        int n = 11;
* */
    static int fact(int n){
        int res = 1;
        if(n==0) return 1;
        for(int i = 1;i<=n;i++){
            res *= i;
        }

        return res;
    }

    public static void main(String[] args) {
//        int arr[] = {311 ,7,8,9,71,6,5,31};
//        int n = 8;
        int arr[] = {6, 4,5, 9,9,9, 7, 8,8,8,8};
        int n = 11;
        System.out.println(findNumberOfTrianglesv3(arr,n));
    }
}
