package ARRAYS;

public class MaximumDifference {
    //O(N) - Maximum Difference problem is to find the maximum of arr[j] - arr[i] where j>i.
    static int maxDiff(int arr[], int n)
    {
        int res = arr[1] - arr[0], minVal = arr[0];

        for(int i = 1; i < n; i++)
        {

            res = Math.max(res, arr[i] - minVal);

            minVal = Math.min(minVal, arr[i]);
        }

        return res;
    }


    public static void main(String args[])
    {
        int arr[] = {2, 3, 10, 6, 4, 8, 1}, n = 7;

        System.out.println(maxDiff(arr,n));

    }

}
