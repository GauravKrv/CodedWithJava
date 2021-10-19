package DP;

import java.util.Hashtable;
//WORKS
public class CanConstruct {
    static boolean canConstructRec(String target,String[] wordBank){
        if (target.equals("")) return true;
        for (String word:wordBank) {
            if (target.indexOf(word)==0){
                String newtarget = target.substring(word.length());

                if (canConstructRec(newtarget,wordBank)) return true;
            }
        }

        return false;
    }

    static boolean canConstructDP(String target,String[] wordBank,Hashtable<String,Boolean> memo){
       if (memo.containsKey(target)) return memo.get(target);
        if (target.equals("")) return true;
        for (String word:wordBank) {
            if (target.indexOf(word)==0){
                String newtarget = target.substring(word.length());

                if (canConstructDP(newtarget,wordBank,memo)) {
                    memo.put(target,true);
                    return true;
                }
            }
        }
        memo.put(target,false);

        return false;
    }

    public static void main(String[] args) {
        String target = "abcdef";
        String[] wordBank = {"ab","abc","cd","def","abcd"};

        Hashtable<String,Boolean> memo = new Hashtable<>();

        System.out.println(canConstructRec(target,wordBank));

        System.out.println(canConstructDP(target,wordBank,memo));

    }
}
