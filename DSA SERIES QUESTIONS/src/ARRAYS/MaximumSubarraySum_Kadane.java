package ARRAYS;

public class MaximumSubarraySum_Kadane {
    //O(N) - WORKS
    static int maxSum(int arr[], int n)
    {
        int res = arr[0];

        int maxEnding = arr[0];

        for(int i = 1; i < n; i++)
        {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);

            res = Math.max(maxEnding, res);
        }

        return res; //
    }


    public static void main(String args[])
    {
        int arr[] = {1, -2, 3, -1, 2}, n = 5;

        System.out.println(maxSum(arr, n));

    }
}
