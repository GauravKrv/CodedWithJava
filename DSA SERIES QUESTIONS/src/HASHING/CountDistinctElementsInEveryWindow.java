package HASHING;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInEveryWindow {
    //WORKS
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        Map<Integer,Integer> hash = new HashMap<>();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i =0;i<k;i++){
            if(hash.containsKey(arr[i])){
                hash.put(arr[i],hash.get(arr[i])+1);
            }
            else {
                hash.put(arr[i],1);
            }
        }
        ar.add(hash.size());

        for(int i=k;i<n;i++){
            int temp = hash.get(arr[i-k]);
            if(temp == 1){
                hash.remove(arr[i-k]);
            }
            else{
                hash.put(arr[i-k],--temp);
            }


            if(hash.containsKey(arr[i])){
                hash.put(arr[i],hash.get(arr[i])+1);
            }
            else {
                hash.put(arr[i],1);
            }

            ar.add(hash.size());
        }

        return ar;
        // code here
    }
}
