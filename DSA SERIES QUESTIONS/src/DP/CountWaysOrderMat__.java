package DP;

import java.util.Hashtable;
//WORKS
public class CountWaysOrderMat__ {
    //Function to count number of ways to reach the nth stair
    //when order does not matter.
    static Long countWays(int n)
    {
        if (n==1) return 1L;
        Long count = 2L;
        //ON LOOKING AT THE SEQUENCE WE SEE THAT WAYS INCREASE IN EVERY 2 INCRMNT IN STAIR COUNT
        for (int i = 2; i <= n; i++) {
            if (i==n) return count;
            if (i%2!=0)count++;
        }
        return count;
        // your code here
    }

    public static void main(String[] args) {
        System.out.println(countWays(4));
    }

}

class Helper{
    //two same content hashmap cannot be called equal
    public static void main(String[] args) {
        Hashtable<Integer,Integer> h = new Hashtable<>();

        Hashtable<Integer,Integer> h2 = new Hashtable<>();

        for (int i = 0; i < 5; i++) {
            h.put(i,i*10);
        }

        for (int i = 0; i < 5; i++) {
            h2.put(i,i*10);
        }

        if (h==h2){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }


    }
}