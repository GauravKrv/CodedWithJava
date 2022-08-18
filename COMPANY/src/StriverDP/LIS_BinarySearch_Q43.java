package StriverDP;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.binarySearch;

public class LIS_BinarySearch_Q43 {


    public static void main(String[] args) {
//        int ar[] = {1,3,6,7,9,4,10,5,6};
//        int ar[] = {1,4,5,2,3,7}; //WORKS
        int ar[] = {10, 9, 2, 5, 3, 7, 101, 18}; //WORKS


        int size = ar.length;
        System.out.println("Size of LIS = " +longestSubsequence(size,ar));

    }
    //striver - solutoin -- binary search

    static int longestSubsequence(int size, int arr[])
    {
        // using binary search
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        int len = 1;
        for (int i = 1; i < size; i++) {
            if (arr[i] > ans.get(ans.size() - 1)) { //if last is less than current -> smply add in the LIS
                ans.add(arr[i]);
                len++; //increase the length
            } else {
                int indx = binarySearch(ans, arr[i]);//else search its correct place i.e were it shoud be
                ans.set(indx, arr[i]); //set at that place if it is gt or et 0th index
               // else ans.set(0, arr[i]); //if is smaller than 0th index then set it at 0th index
            }
        }
        return len;
    }
    //bin search of java thing - gives upper bound [next greater index] if same element not found
    static int binarySearch(ArrayList<Integer> ans, int key) {
        int low = 0;
        int high = ans.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ans.get(mid) == key) return mid;
            else if (ans.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return high + 1;
    }
}
