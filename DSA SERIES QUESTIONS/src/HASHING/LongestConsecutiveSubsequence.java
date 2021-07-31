package HASHING;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    static int findLongestConseqSubseq(int arr[], int N)
    {
        HashSet<Integer> h = new HashSet<>();
        for(int x : arr){
            h.add(x);
        }
        int res = 1;
        for(Integer x :h){
            if(h.contains(x-1)==false){
                int curr =1;
                while(h.contains(x+curr)){
                    curr++;
                }
                res = Math.max(res,curr);
            }

        }
        return res;
        // add your code here
    }
}
