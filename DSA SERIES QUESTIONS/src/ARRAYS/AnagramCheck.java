package ARRAYS;

import java.util.HashMap;

public class AnagramCheck {


    /*
 String s1 = "madamaaa";
       String s2 = "adamamam"; THIS EXAMPLE WILL GIVE WRONG RESULT AS YOU CAN KNOW WHY  -- MY code only checks nfor a and ++a  and if any letter occurs more than two tymes then no chk
       {97=98, 100=100, 109=110}
{97=98, 100=100, 109=110}
* */
    static boolean isAnagram(String s1,String s2){
        HashMap<Integer,Integer> hmap1 = new HashMap<>();
        HashMap<Integer,Integer> hmap2 = new HashMap<>();

        for (int i=0;i<s1.length();i++){
            Integer a = (int)s1.toCharArray()[i];
            if (hmap1.containsKey(a))
             hmap1.put(a,++a);
            else
              hmap1.put(a,a);

        }
        for (int i=0;i<s2.length();i++){
            Integer a = (int)s2.toCharArray()[i];
            if (hmap2.containsValue(a))
                hmap2.put(a,++a);
            else
                hmap2.put(a,a);

        }

        System.out.println(hmap1);
        System.out.println(hmap2);


        if (hmap1.equals(hmap2))
            return true;
        else
            return false;


    }
//THIS ANAGRAM CODE WILL WORK PERFECTLY AS WE HAVE REMOVED THE PREVCIOUS LOOPHOLE FROMN THIS CODE
    static boolean isAnagram2(String s1,String s2){
        HashMap<Integer,Integer> hmap1 = new HashMap<>();
        HashMap<Integer,Integer> hmap2 = new HashMap<>();

        for (int i=0;i<s1.length();i++){
            Integer a = (int)s1.toCharArray()[i];
            if (hmap1.containsKey(a))
                hmap1.put(a,(hmap1.get(a))+1);
            else
                hmap1.put(a,a);

        }
        for (int i=0;i<s2.length();i++){
            Integer a = (int)s2.toCharArray()[i];
            if (hmap2.containsKey(a))
                hmap2.put(a,(hmap2.get(a))+1);
            else
                hmap2.put(a,a);

        }
        System.out.println(hmap1.get(109));
        System.out.println(hmap1);
        System.out.println(hmap2);


        if (hmap1.equals(hmap2))
            return true;
        else
            return false;


    }


    public static void main(String[] args) {
       /* String s1 = "Ahkjhajhf";
        Integer a = (int)s1.toCharArray()[0];
        System.out.println(a);*/
//       String s1 = "madama";
//       String s2 = "adamam";
        String s1 = "madamaaa";
        String s2 = "adamamam";
/*
 String s1 = "madamaaa";
       String s2 = "adamamam"; THIS EXAMPLE WILL GIVE WRONG RESULT AS YOU CAN KNOW WHY  -- MY code only checks nfor a and ++a  and if any letter occurs more than two tymes then no chk
       {97=98, 100=100, 109=110}
{97=98, 100=100, 109=110}
* */
        System.out.println(isAnagram2(s1,s2));
    }
}
