package Z_MISCELLANEOUS;
//WORKS
//https://practice.geeksforgeeks.org/problems/20290dc4188d384ae1f17d6a14bd2c95ea7012a8/1
public class ElixierOfLife {
    static String getSubs(String s){
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0,i+1).equals(s.substring(n-(i+1),n)))
                return s.substring(0,i+1);
        }
        return s;
    }

    static int maxFrequency(String s){
        String str = getSubs(s);
        int n = s.length();
        int l = str.length();
        int count = 0;
        for (int i = 0; i < n-l; i++) {
            if (s.substring(i,i+l).equals(str)){
                count++;
            }

        }
        return count+1;
    }

    public static void main(String[] args) {
        String s = "ababaaaab";
        System.out.println(maxFrequency(s));
    }
}
/*
Flamel is making the Elixir of Life but he is missing a secret ingredient, a set of contiguous plants (substring) from the Garden of Eden.
The garden consists of various plants represented by string S, where each letter represents a different plant.  But the prophecy has predicted that the correct set of plants required to make the potion will appear in the same contiguous pattern (substring) at the beginning of the forest (prefix), the end of the forest (suffix), and will also be the most frequent sequence present in the entire forest.

Identify the substring of plants required to make the elixir and find out the number of times it appears in the forest.

Example 1:

Input: S = "ababaaaab"
Output: 3
Explanation: Substring "ab" is a prefix,
It is also a suffix and appears 3 times.

Example 2:

Input: S = "aaaa"
Output: 4
Explanation: Substring "aaaa" occurs 1 time,
Substring "aaa" occurs 2 times, substring
"aa" occurs 3 times, substring "a" occurs
4 times. All of them are proper prefixes
and suffixes. But, "a" has the maximum
frequency.
Example 3:

Input: S = "abcdef"
* */
