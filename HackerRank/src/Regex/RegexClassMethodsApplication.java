package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexClassMethodsApplication {
}
// A Simple Java program to demonstrate working of
// String matching in Java
class DemoCompileFindStartEnd
{
    public static void main(String args[])
    {
        // Create a pattern to be searched
        Pattern pattern = Pattern.compile("geeks");

        // Search above pattern in "geeksforgeeks.org"
        Matcher m = pattern.matcher("geeksforgeeks.org");//two geeks present so two pairs will be printed

        // Print starting and ending indexes of the pattern
        // in text
        while (m.find())
            System.out.println("Pattern found from " + m.start() +
                    " to " + (m.end()-1));
    }
}

// A Simple Java program to demonstrate working of
// String matching in Java
class Demo2
{
    public static void main(String args[])//use of star??
    {
        // Create a pattern to be searched
        Pattern pattern = Pattern.compile("geek*");

        // Search above pattern in "geeksforgeeks.org"
        Matcher m = pattern.matcher("geeksforgeeks.orgee");

        // Print starting and ending indexes of the pattern
        // in text
        while (m.find())
            System.out.println("Pattern found from " + m.start() +
                    " to " + (m.end()-1));
    }
}
