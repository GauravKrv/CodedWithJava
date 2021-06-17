package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import java.util.regex.Matcher;

public class RegexBasics {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(".xx.");
        Matcher matcher = pattern.matcher("AxxB");
        System.out.println("String matches the given Regex - "+matcher.matches());
    }
}

class CharacterExmple{
    public static void main(String[] args) {
        System.out.println(Pattern.matches("[xyz]*","wbcd"));//false becoz x,or,y or z is not pres in inut
        System.out.println(Pattern.matches("[xyz]","x"));//true
        System.out.println(Pattern.matches("[xyz]","xxyyyyz"));//false becoz x and y comes more than once

    }


}

class MetaCharactersExmple{
    public static void main(String[] args) {
        System.out.println(Pattern.matches("\\d","123"));//false
        System.out.println(Pattern.matches("\\d","1"));//true
        System.out.println(Pattern.matches("\\d","4443"));//false
        System.out.println(Pattern.matches("\\d","ab345"));
        System.out.println(Pattern.matches("\\d[321]","123"));//false
        System.out.println(Pattern.matches("\\d{321}","1234"));//true
        System.out.println(Pattern.matches("\\d{321}","44"));//false
        System.out.println(Pattern.matches("\\d","ab345"));


       /* System.out.println("uSE OF Metacharacter D...");

        System.out.println(Pattern.matches("\\D","abc"));//false
        System.out.println(Pattern.matches("\\D","1"));//true
        System.out.println(Pattern.matches("\\D","4443"));//false
        System.out.println(Pattern.matches("\\D","ab345"));
        System.out.println(Pattern.matches("\\D","a"));

        System.out.println("uSE OF Metacharacter W...");

        System.out.println(Pattern.matches("\\W","abc"));//false
        System.out.println(Pattern.matches("\\W","1"));//true
        System.out.println(Pattern.matches("\\W","4443"));//false
        System.out.println(Pattern.matches("\\W","ab345"));
        System.out.println(Pattern.matches("\\W","a"));

        System.out.println("uSE OF Metacharacter w...");

        System.out.println(Pattern.matches("\\w","abc"));//false
        System.out.println(Pattern.matches("\\w","1"));//true
        System.out.println(Pattern.matches("\\w","4443"));//false
        System.out.println(Pattern.matches("\\w","ab345"));
        System.out.println(Pattern.matches("\\w","a"));

        System.out.println("uSE OF Metacharacter b...");

        System.out.println(Pattern.matches("\\b","abc"));//false
        System.out.println(Pattern.matches("\\b","1"));//true
        System.out.println(Pattern.matches("\\b","4443"));//false
        System.out.println(Pattern.matches("\\b","ab345"));
        System.out.println(Pattern.matches("\\b","a"));

        System.out.println("uSE OF Metacharacter B...");

        System.out.println(Pattern.matches("\\B","abc"));//false
        System.out.println(Pattern.matches("\\B","1"));//true
        System.out.println(Pattern.matches("\\B","4443"));//false
        System.out.println(Pattern.matches("\\B","ab345"));
        System.out.println(Pattern.matches("\\B","a"));*/

    }


}

class Demo
{
    public static void main(String args[])
    {
        // Following line prints "true" because the whole
        // text "geeksforgeeks" matches pattern "geeksforge*ks"
        System.out.println (Pattern.matches("geeksforge*ks","geeksforgeeks"));

        // Following line prints "false" because the whole
        // text "geeksfor" doesn't match pattern "g*geeks*"
        System.out.println (Pattern.matches("g*geeks*","geeksfor"));
    }
}



/*LINK : https://www.geeksforgeeks.org/regular-expressions-in-java/
What are Regular Expression
    A regular expression is a special sequence of characters that helps you match or find
    other strings or sets of strings, using a specialized syntax held in a pattern.
    They can be used to search, edit, or manipulate text and data.
    ^[a-z0-9_-]{3,15}$
    ^ = start of line
    $ = end of line

What is JAVA Regex
    Java Regex is an API which is used to define a pattern for searching or manipulating Strings
    It is widely used to define te constrains on Strings such as password email validations

CLASSES :
The java.util.regex package primarily consists of the following three classes:

Class	Description
util.regex.Pattern	Used for defining patterns
util.regex.Matcher	Used for performing match operations on text using patterns
PatternSyntaxException	Used for indicating syntax error in a regular expression pattern

Matcher Class
    It is usd to match a character sequence


Pattern Class
    =>It is used to define a pattern to used by regex engine
    =>Note that Pattern.matches() checks if the whole text matches with a pattern or not.
    Other methods (demonstrated below) are mainly used to find multiple occurrences of pattern in text

Regex Character Class
    [abs] = a,b or c
    [^abc] = any hing except a,b,c
    [a-zA-Z] = A through Z or a through z (Range)
    [a-d[m-p]] = a throuh d or m through p (union)
    [a-z&&[^bc]] = a through z except b or c [Substraction]

Regex Quantifiers
    Quantifiers specifies number of occurencwc of a particular chracter
    X? X occurs once or not at all
    X+ X occurs more than nce
    X* X occurs zero or more tyms

Regex Metacharacters
     Thes work as shorcodes
     . = any characer
     d = digit
     D = any non digit
     s = white space chars
     S = not white space characters
     w = word character
     W = non word
     b = represents a word boundary
     B = represents a non word boundary
* */
