package ARRAYS;

public class FreqCount_ {
    //o(N) - WORKS
    /*
    Given an array A[] of N positive integers which can contain integers from 1 to P where elements can be repeated or can be absent from the array.
    Your task is to count the frequency of all elements from 1 to N.
Example 1:

Input:
N = 5
arr[] = {2, 3, 2, 3, 5}
P = 5
Output:
0 2 2 0 1
    * */
    public static void frequencyCount(int arr[], int n, int p)
    {

        for (int j =0; j<n; j++)
        {
            arr[j] = arr[j]-1;
        }


        for (int i=0; i<n; i++)
        {
            if(arr[i]%p<n){  //if rem is less than arr size then
                arr[arr[i]%p] = arr[arr[i]%p] + p; //add max size to that index(rem) again and again

            }

        }


        for (int i =0; i<n; i++)
        {
            if(arr[i] >= p) { //then it has more counts
                arr[i] = arr[i]/p;
            }
            else{
                arr[i] = 0;
            }
        }

    }
}
