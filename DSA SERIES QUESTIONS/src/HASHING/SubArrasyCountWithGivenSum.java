package HASHING;

import java.util.HashSet;

public class SubArrasyCountWithGivenSum {
    //Function to count the number of subarrays which adds to the given sum.
    //WORKS FOR POSETIVE NUMBERS
    static int subArraySum(int arr[], int n, int sum)
    {
        // add your code here
        HashSet<Integer> hash = new HashSet<>();
        int presum = 0;
        int count =0;
        for(int i =0;i<n;i++){
            presum += arr[i];
            if(presum == sum){
                count++;
            }
            if(hash.contains(presum-sum)){
                count++;
            }
            hash.add(presum);
        }
        return count;
    }
}
