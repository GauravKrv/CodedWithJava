package HASHING;

import java.util.HashMap;
import java.util.Map;

public class ElectionWinner__ {
    //WORKS
    public static String[] winner2(String arr[], int n)
    {
        HashMap<String,Integer> counter = new HashMap<>();
        int max = -1;
        for(int i =0;i<n;i++){
            counter.put(arr[i],counter.getOrDefault(arr[i],0)+1);
            max = Math.max(max,counter.get(arr[i]));
        }
        int maxValueInMap = 0;
        String winner = "";
        for (Map.Entry<String,Integer> entry : counter.entrySet())
        {
            String key  = entry.getKey();
            Integer val = entry.getValue();
            if (val > maxValueInMap)
            {
                maxValueInMap = val;
                winner = key;
            }

            // If there is a tie, pick lexicographically
            // smaller.
            else if (val == maxValueInMap &&
                    winner.compareTo(key) > 0)
                winner = key;
        }


        String res2 = ""+maxValueInMap;
        String str[] = {winner,res2};
        return str;
        // add your code
        // String res = "";


        // for(Map.Entry<String,Integer> e : counter.entrySet()){
        //     if(e.getValue() == max){

        //         if(res=="") {
        //               res = res + e.getKey();
        //               System.out.print(res+" ");
        //           }
        //          else if(res != null && e.getKey().length() <= res.length() && e.getKey().compareTo(res) < 0){
        //             System.out.print(e.getKey()+" ");
        //           res = e.getKey();
        //          }

        //     }


        // }
        // String res2 = "";
        // res2 = res2+max;
        // String str[] = {res,res2};
        // return str;
        // // add your code
    }
    //NOT WORKS
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        HashMap<String,Integer> counter = new HashMap<>();

        for(int i =0;i<n;i++){
            if(counter.containsKey(arr[i])){
                counter.put(arr[i],counter.get(arr[i])+1);
            }
            else{
                counter.put(arr[i],1);
            }
        }
        int max = -1;
        String res = arr[0];
        for(Map.Entry<String,Integer> e : counter.entrySet()){
            if(e.getValue() > max){

                max = e.getValue();
                res = e.getKey();
            }
        }
        String res2 = "";
        res2 = res2+max;
        String str[] = {res,res2};
        return str;
        // add your code
    }


    public static void main(String[] args) {
        System.out.println("john".compareTo("jammey"));
    }
}
