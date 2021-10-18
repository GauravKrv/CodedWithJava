package ARRAYS;

public class MooresVoting_MajorityElement {
    static int findMajority(int arr[], int n)
    {
        int res = 0, count = 1;

        for(int i = 1; i < n; i++)
        {
            if(arr[res] == arr[i])
                count++;
            else
                count --;

            if(count == 0)
            {
                res = i; count = 1;
            }
        }

        count = 0;

        //verifying the answer obtained
        for(int i = 0; i < n; i++)
            if(arr[res] == arr[i])
                count++;

        if(count <= n /2)
            res = -1;

        return res;
    }


    public static void main(String args[])
    {
        int arr[] = {8, 8, 6, 6, 6, 4, 6}, n = 7;

        System.out.println("index of majority element = " + findMajority(arr, n));

    }
}
