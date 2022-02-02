package ARRAYS;

public class TrappingRainWater {
    //O(N) - S(N) - Works - efficient
    static int getWater(int arr[], int n)
    {
        int res = 0;

        int lMax[] = new int[n];
        int rMax[] = new int[n];

        lMax[0] = arr[0];
        for(int i = 1; i < n; i++)
            lMax[i] = Math.max(arr[i], lMax[i - 1]); //store the leftmax element in the array


        rMax[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--)
            rMax[i] = Math.max(arr[i], rMax[i + 1]); //store max element from rigth to that element at each index

        for(int i = 1; i < n - 1; i++)
            res = res + (Math.min(lMax[i], rMax[i]) - arr[i]); // this is the important partt in --- just visualise any example and you will get it
            //(min common height of left and right side - curr step)
        return res;

    }


    public static void main(String args[])
    {
        int arr[] = {5, 0, 6, 2, 3}, n = 5;

        System.out.println( getWater(arr, n));

    }
}
