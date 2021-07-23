package HASHING;

import java.util.HashMap;

public class CompareArrays {
    public static boolean check(long A[],long B[],int N)
    {
        HashMap<Long,Long> h1 = new HashMap<>();
        HashMap<Long,Long> h2 = new HashMap<>();


        for(int i = 0; i<N; i++){
            if(h1.containsValue(A[i]))
            { h1.put(A[i],h1.get(A[i])+1);}
            else{
                h1.put(A[i], 1L);
            }
        }

        for(int i = 0; i<N; i++){
            if(h2.containsValue(B[i]))
            { h2.put(A[i],h2.get(B[i])+1);}
            else{
                h2.put(B[i], 1L);
            }
        }

        return h1==h2;
        //Your code here
    }
}
