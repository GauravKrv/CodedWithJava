package RECURSION;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet_ {
    static int currIn = 0;
    static ArrayList<String> powerSet(String s)
    {
        // add your code here
        int count = (int)(Math.pow((double)2,(double)s.length()));
        String[] res = new String[count];
        powerSetUtil(s,0,"",res);
//        for (int i=0;i<al.size();i++){
//            System.out.print(al.get(i)+" ");
//        }
        Arrays.sort(res);
        ArrayList<String> al =
                new ArrayList<String>();
        for (int i=1;i<count;i++){
            al.add(res[i]);
        }
        return al;

    }

    static void powerSetUtil(String s,int i, String curr,String res[]){
        int n = s.length();
        if(i==n){
            res[currIn] = curr;
            currIn++;
            return;
        }

        powerSetUtil(s,i+1,curr+s.charAt(i),res);
        powerSetUtil(s,i+1,curr,res);
    }

    public static void main(String[] args) {
        ArrayList<String>  al= powerSet("abcdefgh");
        for (int i=0;i<al.size();i++){
            System.out.print(al.get(i)+" ");
        }
    }
}
