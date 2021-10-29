package DP;

import java.util.ArrayList;
import java.util.Hashtable;

//WORKS
public class BestSum__ {
    class Memo {
        ArrayList<Integer> ar;
        int sum;

        public Memo(ArrayList<Integer> ar, int sum) {
            this.ar = ar;
            this.sum = sum;
        }
    }
    //  static ArrayList<Memo> memo = new ArrayList<>();

    public static Object bestSumMemo(int t, int[] numbers, Hashtable<Integer, Object> memo) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (memo.containsKey(t)) return memo.get(t);

        if (t == 0) return arrayList;

        if (t < 0) return null;

        ArrayList<Integer> shortestCombination = null;

        for (int i = 0; i < numbers.length; i++) {
            int rem = t - numbers[i];

            ArrayList<Integer> remComb = (ArrayList<Integer>) bestSumMemo(rem, numbers, memo);
            if (remComb != null) {
                ArrayList<Integer> comb = remComb;
                comb.add(numbers[i]);

                if (shortestCombination == null || comb.size() < shortestCombination.size()) {
                    shortestCombination = comb;
                }
            }
        }

        memo.put(t, shortestCombination);
        // else memo.put(t,-1);
        return shortestCombination;
    }


    public static Object bestSumRec(int t, int[] numbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (t == 0) return arrayList;

        if (t < 0) return null;

        //this array list will keep on updating for the shortest arrayist
        ArrayList<Integer> shortestCombination = null;

        for (int i = 0; i < numbers.length; i++) {
            int rem = t - numbers[i];

            ArrayList<Integer> remComb = (ArrayList<Integer>) bestSumRec(rem, numbers);
            //above is same as how Sum


            if (remComb != null) {
                //taking a temp array to compare with previous shortestCombination array
                ArrayList<Integer> comb = remComb;
                comb.add(numbers[i]);
                //if current combin is less than the shortstCombin then update the shrtstComnb
                //or if shrtst combntn is null then update the shrtst combination array
                if (shortestCombination == null || comb.size() < shortestCombination.size()) {
                    shortestCombination = comb;
                }
            }
        }

        return shortestCombination;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 4, 6, 7};
        int[] number = {1, 2, 5, 25};
        int t = 100;
        int t2 = 50;
        Hashtable<Integer, Object> memo = new Hashtable();

        System.out.println(bestSumMemo(t, number, memo));
        System.out.println(bestSumRec(t2, numbers));
        // System.out.println(bestSumMemo(t,numbers,memo));

    }
}
