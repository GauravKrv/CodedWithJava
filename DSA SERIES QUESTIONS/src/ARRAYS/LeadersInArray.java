package ARRAYS;

public class LeadersInArray {
    //O(N) - WORKS
    /*
    Given an array A of positive integers. Your task is to find the leaders in the array.
    An element of array is leader if it is greater than or equal to all the
    elements to its right side. The rightmost element is always a leader.
Example 1:

Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17
as it is greater than all the elements
to its right.  Similarly, the next
leader is 5. The right most element
is always a leader so it is also
included.
    * */
    static void leaders(int arr[], int n)
    {
        int curr_ldr = arr[n - 1];

        System.out.print(curr_ldr+" ");

        for(int i = n - 2; i >= 0; i--)
        {
            if(curr_ldr < arr[i])
            {
                curr_ldr = arr[i];

                System.out.print(curr_ldr+" ");
            }
        }
    }


    public static void main(String args[])
    {
        int arr[] = {7, 10, 4, 10, 6, 5, 2}, n = 7;

        leaders(arr, n);

    }
}
