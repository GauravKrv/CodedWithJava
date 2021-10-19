package DP;

import java.util.Hashtable;

public class CountConstruct {
    static int countConstruct(String target, String[] wordBank){
        if (target.equals("")) return 1;

        int totalcount = 0;

        for (String word:wordBank) {
            if (target.indexOf(word)==0){
                String rem = target.substring(word.length());
                int res = countConstruct(rem,wordBank);
                totalcount += res;
            }
        }

        return totalcount;
    }

    static int countConstructDP(String target, String[] wordBank,Hashtable<String,Integer> memo){
        if (memo.containsKey(target))
        if (target.equals("")) return 1;

        int totalcount = 0;

        for (String word:wordBank) {
            if (target.indexOf(word)==0){
                String rem = target.substring(word.length());
                int res = countConstruct(rem,wordBank);
                totalcount += res;
            }
        }

        memo.put(target,totalcount);
        return totalcount;
    }

    public static void main(String[] args) {
        String target = "abcdef";
        String[] wordBank = {"ab","abc","cd","def","abcd","c","d","e","f"};
        Hashtable<String,Integer> memo = new Hashtable<>();

        System.out.println(countConstruct(target,wordBank));
        System.out.println(countConstructDP(target,wordBank,memo));
    }
}
