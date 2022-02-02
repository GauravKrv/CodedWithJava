package ARRAYS;

public class RemoveDuplicates {
    //O(n) WORKS
    static int remDups(int arr[], int n)
    {
        int res = 1;

        for(int i = 1; i < n; i++)
        {
            if(arr[res - 1] != arr[i])
            {
                arr[res] = arr[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String args[])
    {
        int arr[] = {10, 20, 20, 30, 30, 30}, n = 6;

        System.out.println("Before Removal");

        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i]+" ");
        }

        System.out.println();

        n = remDups(arr, n);

        System.out.println("After Removal");

        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i]+" ");
        }

    }
}
