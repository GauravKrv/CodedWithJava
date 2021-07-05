package SEARCHING;

import java.util.Scanner;

public class SmallestPosetiveMIssingNo_ {
/*
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing
number is 6.
* */
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int n)
    {
        int max = 0;
        for(int i =0;i<n; i++){
            max = Integer.max(max,arr[i]);
        }
        if(max>0){
            boolean[] hash = new boolean[max+1];
            for(int i =0;i<n; i++){
                if(arr[i]>=0){
                    hash[arr[i]] = true;
                }
            }

            for(int i =1;i<=max; i++){
                if(!hash[i])
                {
                    return i;
                }
                if(i==max){
                    return max+1;
                }

            }
            // Your code here
        }

        return 1;
    }

    static int firstMissingPositive(int arr[], int n)
    {
        int ptr = 0;

        // Check if 1 is present in array or not
        for(int i = 0; i < n; i++)
        {
            if (arr[i] == 1)
            {
                ptr = 1;
                break;
            }
        }

        // If 1 is not present
        if (ptr == 0)
            return (1);

        // Changing values to 1
        for(int i = 0; i < n; i++)
            if (arr[i] <= 0 || arr[i] > n)
                arr[i] = 1;

        // Updating indices according to values
        for(int i = 0; i < n; i++)
            arr[(arr[i] - 1) % n] += n;

        // Finding which index has value less than n
        for(int i = 0; i < n; i++)
            if (arr[i] <= n)
                return (i + 1);

        // If array has values from 1 to n
        return (n + 1);
    }

    public static void main (String[] args)
    {

        Scanner sc=new Scanner(System.in);

        //taking testcases
        int t=sc.nextInt();
        while(t-->0){

            //input number n
            int n=sc.nextInt();
            int[] arr=new int[n];

            //adding elements to the array
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();


            //calling missingNumber()
            int missing = missingNumber(arr,n);
            System.out.println(missing);
        }
    }
}
