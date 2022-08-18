package TALENTLY.CV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Q1PrintStringNumber {
    //GET A STRING FROM USER AND PRINT CORRESPONDING NUMBER TO KEYPAD
    public static void main(String[] args) {

    String s = "Hai";
        System.out.println(solve(s.toLowerCase()));
    }
    static String solve(String s){
        int[] chartoint = {2,22,222,3,33,333,4,44,444,5,55,555,6,66,666,7,77,777,7777,8,88,888,9,99,999,9999};

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            sb.append(chartoint[(s.charAt(i))-'a']);
        }
        return String.valueOf(sb);
    }
}
