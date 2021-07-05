package SEARCHING;

import java.util.Scanner;

public class Count1sInBinaryArray {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){

            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            System.out.println(obj.countOnes(arr, n));

        }

    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function to count number of ones in the binary sorted array
    // N: size of array
    // arr[]: input array
    //TO MANY CORNER CASES WERE THERE
    public static int countOnes(int arr[], int N){

        // Your code here
        int l = 0, h= N-1;
        if(N==1){
            return arr[0];
        }
        while(h>=l){
            int m = (l + h)/2;
            if(arr[m] == 0){
                if(m-1 > N && arr[m-1]==1){
                    return m;//check for m+1
                }
                h = m-1;
            }
            else if(arr[m]==1){
                if(m+1 < N && arr[m+1]==1){
                    l = m+1;
                }else{
                    return m + 1;//check for m+1
                }
            }
        }
        return 0;
    }
}
