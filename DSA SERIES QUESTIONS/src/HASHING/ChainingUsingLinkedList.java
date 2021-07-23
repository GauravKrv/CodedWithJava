package HASHING;

import java.util.ArrayList;
import java.util.LinkedList;

class ChainHash {
       int BUCKET;
        ArrayList<LinkedList<Integer>> table;
       ChainHash(int b){
             BUCKET = b;
             table = new ArrayList<LinkedList<Integer>>();
             for (int i = 0; i<b;i++){
                 table.add(new LinkedList<>());
             }

         }


    void insert(Integer k){
        int i = k%BUCKET;
        table.get(i).add(k);
    }

    boolean search(Integer k){
        int i = k%BUCKET;
        return table.get(i).contains(k);
    }

    void delete(Integer k){
        int i = k%BUCKET;
        table.get(i).remove(k);
    }

    public static void main(String[] args) {
        ChainHash hash = new ChainHash(7);

        int arr[] = {5,66,33,88,22,33,55};
        for (int i =0;i<arr.length;i++){
            hash.insert(arr[i]);
        }

    }
}
