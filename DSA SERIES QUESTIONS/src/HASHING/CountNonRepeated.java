package HASHING;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountNonRepeated {

    //Function to return non-repeated elements in the array.
    static ArrayList<Integer> printNonRepeated(int arr[], int n)
    {
        // add your code here
        ArrayList<Integer> ar = new ArrayList<Integer>();
        LinkedHashMap<Integer,Integer> hash = new LinkedHashMap<>();

        for(int i=0;i<n;i++){
            hash.put(arr[i],1);
        }

        for(int i=0;i<n;i++){
            hash.put(arr[i],hash.get(arr[i])+1);}


        for(Map.Entry<Integer,Integer> e : hash.entrySet()){
            if((int)e.getValue() == 2){
                ar.add(e.getKey());
            }
        }


        return ar;
    }
}
