package Hackwithinfy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P4 {
    static void solution(int n, List<Integer> A,List<Integer> B){
        //find index of third largest score
        ArrayList<Integer> score = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            score.add(A.get(i)*B.get(i));
        }

        Collections.sort(score);


        for (int x
                :score
             ) {
            System.out.print(x+" ");
        }

        int larger = score.get(n-1);

        int end = n-3;
        for (int i = n-2; i >=end; i--) {
            int curr = score.get(i);
            int currB = B.get(i);
            int next = B.get(i+1);
            if (larger == curr){
                if (currB>next) {
                    larger = curr;
                }
            }
            if (i>0){
                if (score.get(i-1)==larger){
                    end--;
                }
            }
        }
        System.out.println(larger);



    }

    /*
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = score.get(i);
            if (hash.containsKey(k)){
                hash.put(k,hash.getOrDefault(k,1)+1);
            }else{
                hash.put(k,1);
            }
        }
    * */
    //        int equal = isFeasible(hash);


    /*
      while (equal>1){
            int max = -1;
            for (int i = 0; i < n; i++) {
                if (score.get(i)==equal){
                   max= Math.max(B.get(i),max);
                }
            }

        }
    * */
    static int isFeasible(HashMap<Integer,Integer> h){
        for (int x :
                h.keySet()) {
            if (h.get(x)>1){

                return x;
            }
        }
        return -1;
    }
}
