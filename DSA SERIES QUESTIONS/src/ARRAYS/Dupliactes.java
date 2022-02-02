package ARRAYS;

import java.util.ArrayList;

public class Dupliactes {
    public static void getDuplicates(int arr[], int n) {
        // code here

        ArrayList<Integer> dup = new ArrayList<>(n + 1);
        for (int i = 0; i < n; i++) {
            //if (dup.lastIndexOf(arr[i])!=i)
            //dup.add(arr[i]%n,arr[i]);
            arr[arr[i] % n] = arr[arr[i] % n] + n;

        }
        for (int i = 0; i < n; i++) {

            if (arr[i] / n > 1) {
                //dup.add(arr[i]);
                System.out.print(arr[i]/n+" ");

            }
        }
     /*   for (int i = 0;i<dup.size();i++)

    }
*/
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,9,5,2,3,9,3,3};
        getDuplicates(arr,arr.length);
    }
}
