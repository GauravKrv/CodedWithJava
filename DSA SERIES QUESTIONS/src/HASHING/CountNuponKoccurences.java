package HASHING;

import java.util.HashMap;
import java.util.Map;

public class CountNuponKoccurences {
    public int countOccurence(int[] arr, int n, int k)
    {
        //WORKS
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i =0;i<n;i++){
            if(hash.containsKey(arr[i])){
                hash.put(arr[i],hash.get(arr[i])+1);
            }
            else {
                hash.put(arr[i],1);
            }
        }
        int count = 0;
        int requiredcount = n/k;

        for(Map.Entry<Integer,Integer> e : hash.entrySet()){
            if(e.getValue() >= requiredcount){
                count++;
            }
        }



        return count;
    }
}
