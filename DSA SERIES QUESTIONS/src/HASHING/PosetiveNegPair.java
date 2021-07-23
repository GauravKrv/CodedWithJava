package HASHING;

import java.util.ArrayList;
import java.util.HashSet;

public class PosetiveNegPair {
    public static ArrayList<Integer> findPairs(int arr[], int n)
    {
        HashSet<Integer> hash = new HashSet<>();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i =0;i<n;i++){

            if(hash.contains(-arr[i])){
                int temp = Math.abs(arr[i]);
                ar.add(-temp);
                ar.add(temp);
                hash.remove(-arr[i]);
            }
            else {
                hash.add(arr[i]);
            }
        }
        return ar;
    }
}
