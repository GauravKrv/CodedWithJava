package W12StringAndUtilities;

import java.io.IOException;

public class StringConcept {
    /*
    1.WHAT IS STRING :
     ==> A sequence of characters (e.g., alphabetic, alpha-numeric, or any printable characters,
such as !, @ #, $ % &, + , ? , / , etc.) is called string.
• In C, C++ programming languages, a string is managed as an array of data type char.
• Java also allows the same.
Example:
char aSet[10] = {‘a’, ‘e’, ‘i’, ‘o’, ‘u’, ‘ ‘, ‘5’, ‘#’};
System.out.println(aSet); // It will print aeiou 5#

 ==> As Java is a true object-oriented programming language, and hence, it treats a string
from a more greater perspective.
• It treats string as an object!
Example:
• All the following literals are actually objects in Java:These are constants btw
“NPTEL”,
“Data Structures”,
“Joy with Java”

 Java defines a class called String in java.lang package. It allows to create and
manipulate String objects.
Examples:
String myString = “Joy with Java”; //mySrting is string object here
System.out.println(myString);
System.out.println(“Welcome”);
System.out.println(“Welcome” + “ “ + myString);
String aString = “An example of string is ” + myString;


NOTES:==>
• String is probably the most commonly used class in Java’s class library.
• Java String is a powerful concept because everything is treated as a string in Java.
• The obvious reason for this is that strings are a very important part of
programming.
• Every string you create is actually an object of type String.
• Even string constants are actually String objects.
• In Java, objects of String are immutable which means a constant and cannot be
changed once created.
• Strings in Java are always represented with double quotes.

CLASS java.lang.String ==>
• Like any class, java.lang.String has its own constructors and methods.
• The java.lang.String methods to work on string can perform many
operations on strings such as
1. Trimming
2. Concatenating
3. Converting
4. Comparing
5. Replacing, etc.

CONSTRUCTORS IN STRINGS ==>
Constructor Description
String() ==>
Initializes a newly created String object so that it represents an empty
character sequence.
String(byte[] bytes) ==>
Constructs a new String by decoding the specified array of bytes using
the platform's default charset.
String(byte[] bytes, Charset charset) ==>
Constructs a new String by decoding the specified array of bytes using the specified charset.
String(byte[] ascii, int hibyte) ==>
This method does not properly convert bytes into characters. As of
JDK 1.1, the preferred way to do this is via the String constructors that
take a Charset, charset name, or that use the platform's default charset.
String(byte[] bytes, int offset, int length) ==>
 Constructs a new String by decoding the specified subarray of bytes
using the platform's default charset.
String(StringBuffer buffer) ==>
Allocates a new string that contains the sequence of characters
currently contained in the string buffer argument.
String(StringBuilder builder) ==>
 Allocates a new string that contains the sequence of characters
currently contained in the string builder argument.
String(byte[] bytes, int offset, int length, Charset charset) ==>
Constructs a new String by decoding the specified subarray of bytes
using the specified charset.

String(byte[] ascii, int hibyte, int offset, int count) =>Deprecated.==>
This method does not properly convert bytes into characters. As of
JDK 1.1, the preferred way to do this is via the String constructors that
take a Charset, charset name, or that use the platform's default charset.
String(byte[] bytes, int offset,int length, String charsetName) ==>
Constructs a new String by decoding the specified subarray of bytes
using the specified charset.
String(byte[] bytes, String charsetName) ==>
Constructs a new String by decoding the specified array of bytes using
the specified charset.
String(char[] value) ==>
Allocates a new String so that it represents the sequence of characters
currently contained in the character array argument.
String(char[] value, int offset, int count) ==>
Allocates a new String that contains characters from a subarray of the
character array argument.
String(int[] codePoints, int offset, int count) ==>
Allocates a new String that contains characters from a subarray of
the Unicode code point array argument.
String(String original) ==>
Initializes a newly created String object so that it represents the same
sequence of characters as the argument; in other words, the newly
created string is a copy of the argument string

METHODS OF STRING CLASS ==>--------------------------------------------------------
Method Description
contains(CharSequence s) Returns true if and only if this string contains the specified sequence of
char values.
contentEquals(CharSequence cs) Compares this string to the specified CharSequence.
contentEquals(StringBuffer sb) Compares this string to the specified StringBuffer.
copyValueOf(char[] data) Returns a String that represents the character sequence in the array
specified.
copyValueOf(char[] data, int offset, int count) Returns a String that represents the character sequence in the array
specified.
endsWith(String suffix) Tests if this string ends with the specified suffix.
equals(Object anObject) ==>
Compares this string to the specified object

Method Description
equalsIgnoreCase(String anotherString) Compares this String to another String, ignoring case considerations.
format(Locale l, String format, Object... args) Returns a formatted string using the specified locale, format string, and
arguments.
format(String format, Object... args) Returns a formatted string using the specified format string and
arguments.
getBytes() Encodes this String into a sequence of bytes using the platform's
default charset, storing the result into a new byte array.
getBytes(Charset charset) Encodes this String into a sequence of bytes using the given charset,
storing the result into a new byte array.
getBytes(int srcBegin, int srcEnd, byte[] dst,
int dstBegin)Deprecated.
This method does not properly convert characters into bytes. As of
JDK 1.1, the preferred way to do this is via the getBytes() method,
which uses the platform's default charset.

Method Description
getChars(int srcBegin, int srcEnd, char[] dst,
int dstBegin)
Copies characters from this string into the destination character array.
hashCode() Returns a hash code for this string.
indexOf(int ch) Returns the index within this string of the first occurrence of the
specified character.
indexOf(int ch, int fromIndex) Returns the index within this string of the first occurrence of the
specified character, starting the search at the specified index.
indexOf(String str) Returns the index within this string of the first occurrence of the
specified substring.
indexOf(String str, int fromIndex) Returns the index within this string of the first occurrence of the
specified substring, starting at the specified index.
intern() Returns a canonical representation for the string object

Method Description
isEmpty() Returns true if, and only if, length() is 0.
lastIndexOf(int ch) Returns the index within this string of the last occurrence of the
specified character.
lastIndexOf(int ch, int fromIndex) Returns the index within this string of the last occurrence of the
specified character, searching backward starting at the specified index.
lastIndexOf(String str) Returns the index within this string of the last occurrence of the
specified substring.
lastIndexOf(String str, int fromIndex) Returns the index within this string of the last occurrence of the
specified substring, searching backward starting at the specified index.
length() Returns the length of this string.
matches(String regex) Tells whether or not this string matches the given regular expression

Method Description
offsetByCodePoints(int index,
int codePointOffset)
Returns the index within this String that is offset from the
given index by codePointOffset code points.
regionMatches(boolean ignoreCase,
int toffset, String other, int ooffset, int len)
Tests if two string regions are equal.
regionMatches(int toffset, String other,
int ooffset, int len)
Tests if two string regions are equal.
replace(char oldChar, char newChar) Returns a new string resulting from replacing all occurrences
of oldChar in this string with newChar.
replace(CharSequence target, CharSequence replac
ement)
Replaces each substring of this string that matches the literal target
sequence with the specified literal replacement sequence.
replaceAll(String regex, String replacement) Replaces each substring of this string that matches the given regular
expression with the given replacement.

Method Description
replaceFirst(String regex, String replacement) Replaces the first substring of this string that matches the
given regular expression with the given replacement.
split(String regex) Splits this string around matches of the given regular expression.
split(String regex, int limit) Splits this string around matches of the given regular expression.
startsWith(String prefix) Tests if this string starts with the specified prefix.
startsWith(String prefix, int toffset) Tests if the substring of this string beginning at the specified index
starts with the specified prefix.
subSequence(int beginIndex, int endIndex) Returns a new character sequence that is a subsequence of this
sequence.
substring(int beginIndex) Returns a new string that is a substring of this string.
substring(int beginIndex, int endIndex) Returns a new string that is a substring of this string.

Method Description
toCharArray() Converts this string to a new character array.
toLowerCase() Converts all of the characters in this String to lower case using the
rules of the default locale.
toLowerCase(Locale locale) Converts all of the characters in this String to lower case using the
rules of the given Locale.
toString() This object (which is already a string!) is itself returned.
toUpperCase() Converts all of the characters in this String to upper case using the
rules of the default locale.
toUpperCase(Locale locale) Converts all of the characters in this String to upper case using the
rules of the given Locale.
trim() Returns a c








    * */
}
//1.String examples
class BasicStringDemo {
    public static void main(String args[]) {

        String strOb1 = "First String";
        String strOb2 = "Second String";

        String strOb3 = strOb1 + " and " + strOb2;
        System.out.println(strOb1);
        System.out.println(strOb2);
        System.out.println(strOb3);
        String myString = "Joy with Java";
        System.out.println(myString);
        System.out.println("Welcome");
        System.out.println("Welcome" + " " + myString);
        String aString = "An example of string is " + myString;
        System.out.println(aString.length());
    }
}
//2.COMMAND LINE EXAMPLE OF STRING PASSING
class CommandLineDemo {
    public static void main(String args[]) {
        System.out.println("Number of arguments " + args.length);
        if (args.length == 0)
            return;
        for (int i = 0; i < args.length; i++)
            System.out.println("args[" + i + "]: " + args[i]);
    }
}
//3.STRING OBJECT DEMOS WITH CONSTRUCTORS
class StringDemo {
    public static void main(String args[]) {
        String s1 = "N P T E L";
        System.out.println("length" + s1.length());
                System.out.println(s1);
        String s2 = new String ("NPTEL");
        System.out.println(s2 + "is of" + s2.length());
        String s4 = new String ("NPTEL");
        String s3 = new String (s1 + s4);
        System.out.println(s3);
    }
}

//4.STRING METHODS EXAMPLES :
class createStringDemo{
    public static void main(String args[]){
        String text = "DATA STRUCTURES AND ALGORITHMS USING JAVA";
        System.out.print(text);
    }
}
 class CharAccessDemo{
    public static void main(String args[]){
        String text = "DATA STRUCTURE WITH JAVA";
        char data = text.charAt(6);
        System.out.print(data);
    }
}

 class StringMergingDemo{
    public static void main(String args[]){
        String text1 = "DATA STRUCTURE WITH";
        String text2 = " JAVA";
        String text3 = text1.concat(text2);
        System.out.print(text3.toUpperCase());
    }
}

 class StringToLowerCaseDemo {
    public static void main(String args[]) {
        String text = "Data Structure with Java";
        String output = text.toLowerCase();
        System.out.println(output);
    }
}

class StringToUpperCaseDemo {
    public static void main(String args[]) {
        String text = "Data Structure with Java";
        String output = text.toUpperCase();
        System.out.println(output);
    }
}
class TrimStringDemo {
    public static void main(String args[]) {
        String text = " Data Structure with Java ";
        String output = text.trim();
        System.out.println(output);
    }
}

class StringReplaceDemo {
    public static void main(String args[]) {
        String text = "Data Structure with C++";
        text = text.replace("C++", "Java");
       // text = "dfefe";
        System.out.println(text);
    }
}

//5.methods of comparing strings ::
 class StringEqualsDemo{
    public static void main(String args[]){
        String text1 = "DATA STRUCTURE WITH JAVA";
        String text2 = "DATA STRUCTURE WITH C++";
        String text3 = "DATA STRUCTURE WITH JAVA";
        boolean output1 = text1.equals(text2);
        boolean output2 = text1.equals(text3);
        System.out.println(output1);
        System.out.println(output2);
    }
}

class StringEqualsCaseDemo{
    public static void main(String args[]){
        String text1 = "DATA STRUCTURE WITH JAVA";
        String text2 = "DATA STRUCTURE WITH C++";
        String text3 = "DATA STRUCTURE WITH JAVA";
        String text4 = "data structure with c++";
        String text5 = "data structure with java";
        Boolean output1 = text1.equalsIgnoreCase(text2);
        //Compares string to another string, ignoring case considerations.
        Boolean output2 = text1.equalsIgnoreCase(text3);
        Boolean output3 = text1.equalsIgnoreCase(text4);
        Boolean output4 = text1.equalsIgnoreCase(text5);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
        System.out.println(output4);
    }
}

class StringCompareDemo {
    public static void main(String args[]) {
        String text1 = "DATA STRUCTURE WITH JAVA";
        String text2 = "DATA STRUCTURE WITH C++";
        String text3 = "DATA STRUCTURE WITH JAVA";
        String text4 = "data structure with c++";
        String text5 = "data structure with java";
        int output1 = text1.compareTo(text2); //Compares two string lexicographically.
        int output2 = text1.compareTo(text3);
        int output3 = text1.compareTo(text4);
        int output4 = text1.compareTo(text5);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
        System.out.println(output4);
    }
}

 class StringCompareCaseDemo{
    public static void main(String args[]){
        String text1 = "DATA STRUCTURE WITH JAVA";
        String text2 = "DATA STRUCTURE WITH C++";
        String text3 = "DATA STRUCTURE WITH JAVA";
        String text4 = "data structure with c++";
        String text5 = "data structure with java";
        int output1 = text1.compareToIgnoreCase(text2);
        //Compares two string lexicographically without case matchin
        int output2 = text1.compareToIgnoreCase(text3);
        int output3 = text1.compareToIgnoreCase(text4);
        int output4 = text1.compareToIgnoreCase(text5);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
        System.out.println(output4);
    }
}

//6.METHODS FOR SUBSTRING COMPUTATIONS
//1]String substring(int i) Returns the sub string starting from the character with i-th index.
 class SubstringDemo {
    public static void main(String args[]) {
        String text = "DATA STRUCTURE WITH JAVA";
        String data = text.substring(3);
        System.out.print(data);
    }
}

//2]String substring(int i, int j) Returns the substring from character with i to j-1 indices.
 class SubstringAnyDemo{
    public static void main(String args[]){
        String text = "DATA STRUCTURE WITH JAVA";
        String data = text.substring(5,14);
        System.out.print(data);
    }
}

//7.METHODS FOR SEARCHING
 class StringSearchDemo{
    public static void main(String args[]){
        String text = "DATA STRUCTURE WITH JAVA";
        int data = text.indexOf("WITH");
        //Returns the index within the string of the first occurrence of the specified string.
        System.out.print(data);
    }
}
//1]int indexOf(String s, int i) Returns the index within the string of the first occurrence of the specified string,
//starting at the specified index.
 class Example{
    public static void main(String args[]){
        String text = "DATA STRUCTURE WITH JAVA";
        int output = text.indexOf("T",4);
        System.out.print(output);
    }
}
//2]int lastIndexOf(String s) Returns the index within the string of the last occurrence of the specified string.
 class ExampleLastIndexOf{
    public static void main(String args[]){
        String text = "DATA STRUCTURE WITH JAVA";
        int output = text.lastIndexOf("T");
        System.out.print(output);
    }
}
//7.Data CONVERSION FROM STRING
 class StringToIntegerDemo{
    public static void main(String args[]){
        String number = "95";
        int num = Integer.parseInt("777");
        int output = num + 5;
        System.out.println(output);
    }
}
class StringToFloatDemo {
    public static void main(String args[]) {
        String number = "95.59";
        float num = Float.parseFloat(number);
        float output = num + 4.41f;
        System.out.println(output);
    }
}
class IntegerToStringDemo{
    public static void main(String args[]){
        int i=20;
        String s=String.valueOf(i);
        System.out.println(s);
        System.out.println(i+10); // + is binary plus operator
        System.out.println(s+20); // + is string concatenation operator
    }
}

class FloatToStringDemo{
    public static void main(String args[]){
        float f=15.5F;//F is the suffix for float
        String s = String.valueOf(f);
        System.out.println(s);
    }
}

class StringConversions {
    public static void main(String args[]) {
        int num = 19648;
        System.out.println(num + " in binary: " +
                Integer.toBinaryString(num));
        int  n = 5;
        String s  = Integer.toBinaryString(n);
        System.out.println(num + " in octal: " +
                Integer.toOctalString(num));
        System.out.println(num + " in hexadecimal: " +
                Integer.toHexString(num));
    }
}
class CommandLineDemo2 {
    public static void main(String args[]) throws IOException {
        System.out.println("Number of arguments " + args.length);
        int sum = 0;
        if(args.length == 0)
            return;
        for(int i=0; i<args.length; i++)
            sum += Integer.parseInt(args[i]);
        System.out.println("Sum = " + sum);
    }
}

