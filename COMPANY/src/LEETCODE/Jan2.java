package LEETCODE;

public class Jan2 {
//WORKS
    public boolean detectCapitalUse(String word) {
        boolean flag = Character.isUpperCase(word.charAt(0));
        int i=1;
        while(i<word.length())   {
            if (Character.isLowerCase(word.charAt(i))) flag=false;
            if (!flag&&Character.isUpperCase(word.charAt(i))) return false;
            if(flag && i>1 && Character.isLowerCase(word.charAt(i))) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
