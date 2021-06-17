package STRINGS;

public class SmallestWindow {
    // MY UNDERSTOOD PROGRM

    public static String smallestWindow(String s, String p)
    {

//TOMOROW WRITE WHATEVER TAUGHT FROM THIS QUESTION
        int len1 = s.length();
        int len2 = p.length();


        if (len1 < len2) {

            return "-1";
        }
        int start = 0,startI = -1,minL = Integer.MAX_VALUE;
        int count = 0;
        char[] sHash = new char[256];
        char[] pHash = new char[256];
        for(int i=0;i<len2;i++)
        {
            pHash[p.charAt(i)]++;
        }

        for(int i=0;i<len1;i++){
            sHash[s.charAt(i)]++;
            if(sHash[s.charAt(i)] <=
                    pHash[s.charAt(i)])
            {
                count++;//and Schar is never 0 here
            }
            if(count == len2){
                while((sHash[s.charAt(start)]>pHash[s.charAt(start)]) || pHash[s.charAt(start)]==0)
                {
                    if(sHash[s.charAt(start)]>pHash[s.charAt(start)])
                    {
                        sHash[s.charAt(start)]--;
                    }
                    start++;
                }
                int lenW = i - start + 1;
                if(minL>lenW){
                    minL = lenW;
                    startI = start;
                }
            }
        }

        if(startI == -1){
            return "-1";
        }

        return s.substring(startI,startI+minL);

        // Your code here
    }

    public static void main(String[] args) {
        String s = smallestWindow("this is string","it");
        System.out.println(s);
    }
}
// Java program to find smallest
// window containing
// all characters of a pattern.

 class GFG {
    static final int no_of_chars = 256;

    // Function to find smallest
    // window containing
    // all characters of 'pat'
    static String findSubString(String str, String pat)
    {
        int len1 = str.length();
        int len2 = pat.length();

        // Check if string's length is
        // less than pattern's
        // length. If yes then no such
        // window can exist
        if (len1 < len2) {
            System.out.println("No such window exists");
            return "";
        }

        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];

        // Store occurrence ofs
        // characters of pattern
        for (int i = 0; i < len2; i++)
            hash_pat[pat.charAt(i)]++;

        int start = 0, start_index = -1,
                min_len = Integer.MAX_VALUE;

        // Start traversing the string
        // Count of characters
        int count = 0;
        for (int j = 0; j < len1; j++) {

            // Count occurrence of characters
            // of string
            hash_str[str.charAt(j)]++;

            // If string's char matches
            // with pattern's char
            // then increment count
            if (hash_str[str.charAt(j)]
                    <= hash_pat[str.charAt(j)])
                count++;

            // If all the characters are matched
            if (count == len2) {

                // Try to minimize the window
                while (hash_str[str.charAt(start)]
                        > hash_pat[str.charAt(start)]
                        || hash_pat[str.charAt(start)]
                        == 0) {

                    if (hash_str[str.charAt(start)]
                            > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }

                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }

        // Return substring starting
        // from start_index
        // and length min_len
        return str.substring(start_index,
                start_index + min_len);
    }

    // Driver Method
    public static void main(String[] args)
    {
        String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :\n "
                + findSubString(str, pat));
    }
}
