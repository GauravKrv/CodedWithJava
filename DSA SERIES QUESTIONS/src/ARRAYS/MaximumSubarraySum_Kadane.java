package ARRAYS;

public class MaximumSubarraySum_Kadane {
    //O(N) - WORKS
    static int maxSum(int nums[], int n)
    {
        int res = nums[0];

        int maxEnding = nums[0];

        for(int i = 1; i < n; i++)
        {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);

            res = Math.max(maxEnding, res);
        }

        return res; //
    }


    public static void main(String args[])
    {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
                //{1, -2, 3, -1, 2};
                int n = arr.length;

        System.out.println(maxSum(arr, n));

    }
}
