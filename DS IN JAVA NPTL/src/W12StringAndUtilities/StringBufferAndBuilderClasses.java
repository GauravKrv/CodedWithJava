package W12StringAndUtilities;

public class StringBufferAndBuilderClasses {
    /*
STRING VS STRING BUFFER CLASS
    • A String object is immutable, that is, once you create an object, it cannot be
modified or we cannot modified it internally; for example, cannot insert, delete and append a character into it.
• On the other hand, an object of the class StringBuffer is like a String, but can be
modified.
• At any point in time, it contains some particular sequence of characters, but the
length and content of the sequence can be changed through certain method calls.
• StringBuffer object is mutable sequence of characters.
StringBuffer class
Note:
Every string buffer has a capacity. As long as the length of the character sequence contained in
the string buffer does not exceed the capacity, it is not necessary to allocate a new internal
buffer array. If the internal buffer overflows, it is automatically made larger

2.CONSTRUCTORS IN STRING BUFFER
Constructor Description
StringBuffer() Constructs a string buffer with no characters in it and an initial capacity of 16
characters.
StringBuffer(CharSequence seq) Constructs a string buffer that contains the same characters as the specified
CharSequence.
StringBuffer(int capacity) Constructs a string buffer with no characters in it and the specified initial capacity.
StringBuffer(String str) Constructs a string buffer initialized to the contents of the specified string.

3.METHODS IN STRING BUFFER
Method Description
append(boolean b) Appends the string representation of the boolean argument to the sequence.
append(char c) Appends the string representation of the char argument to this sequence.
append(char[] str) Appends the string representation of the char array argument to this sequence.

charAt(int index) Returns the char value in this sequence at the specified index.
codePointAt(int index) Returns the character (Unicode code point) at the specified index.
codePointBefore(int index) Returns the character (Unicode code point) before the specified index.
codePointCount(int beginIndex, int endIndex)
Returns the number of Unicode code points in the specified text range of
this sequence.
delete(int start, int end) Removes the characters in a substring of this sequence.
deleteCharAt(int index) Removes the char at the specified position in this sequence.
ensureCapacity(int minimumCap
acity)
Ensures that the capacity is at least equal to the specified minimum.
getChars(int srcBegin,
int srcEnd, char[] dst,
int dstBegin)
Characters are copied from this sequence into the destination character
array dst.
toString() Returns a string representing the data in this sequence.

insert(int offset, String str) Inserts the string into this character sequence.
lastIndexOf(String str) Returns the index within this string of the rightmost occurrence of
the specified substring.
lastIndexOf(String str,
int fromIndex)
Returns the index within this string of the last occurrence of the
specified substring.
length() Returns the length (character count)
offsetByCodePoints(int index,
int codePointOffset)
Returns the index within this sequence that is offset from the
given index by codePointOffset code points.
replace(int start,
int end, String str)
Replaces the characters in a substring of this sequence with characters
in the specified String.
reverse() Causes this character sequence to be replaced by the reverse of the
sequence.
setCharAt(int index, char ch) The character at the specified index is set to ch.
setLength(int newLength) Sets the length of the character sequence.
subSequence(int start,
int end)
Returns a new character sequence that is a subsequence of this
sequence.
substring(int start) Returns a new String that contains a subsequence of characters
currently contained in this character sequence.
substring(int start, int end) Returns a new String that contains a subsequence of characters
currently contained in this sequence.

AND MANY MORE...

4.MODIFYING A STRING
Because String objects are immutable, whenever you want to modify a
string, you must either copy it into a StringBuffer or StringBuilder, or
use a String method that constructs a new copy of the string with your
modifications complete.
• On the other hand, you can modify StringBuffer object with the
methods, for example, append(), insert(), delete(), concat(), reverse(),
etc.
    * */
}


//1.CREATONG STRING BUFFER OBJECTS
class StringBufferDemo {
    public static void main(String args[]) {
      /*  StringBuffer strOb1 = new StringBuffer("First String");
        StringBuffer strOb2 = new StringBuffer("Second String");
        StringBuffer strOb3 = new StringBuffer(strOb1 + " and " + strOb2);
       */ String strOb1 = "First String";
        String strOb2 = "Second String";
        String strOb3 = strOb1 + " and " + strOb2;
        //StringBuffer sb = "hello"; -->wrong method
        System.out.println(strOb1);
        System.out.println(strOb2);
        System.out.println(strOb3);
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer(strOb3);

        StringBuffer aString = new StringBuffer("An example of stringBufffer is" + sb2);
        System.out.println(aString);
    }
}
//2.MPDYFYING STRINGS FROM STRING BUFFER
class ModifyStringDemo{
    public static void main(String args[]){
        StringBuffer text = new StringBuffer("Data Structure ");
        text.append("C++");
                System.out.print(text);
        text.insert(15,"with ");
                System.out.print(text);
        text.replace(20,23,"Java");
        System.out.print(text);
        text.delete(14,19);
    }
}
class StringReverseDemo{
    public static void main(String args[]){
        StringBuffer text=new StringBuffer("Data Structure With With Java");
        StringBuffer text2=new StringBuffer("Data Structure With With Javaaaaa");

        text =  text2;
        text.reverse();
        System.out.print(text);
    }
}
//3.CONCATINATION OF STRING
class ConcatTest{
    public static String concatWithString() {
        String s = "Java";
        for (int i=0; i<10000; i++){
            s.concat("NPTEL");
        }
        return s;
    }
  //  Example 58.3: Merging of strings with String and StringBuffer methods
    public static String concatWithStringBuffer(){
        StringBuffer sb = new StringBuffer("Java");
        for (int i=0; i<10000; i++){
            //sb.concat("NPTEL");
        }
        return sb.toString();
    }
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        concatWithString();
        System.out.println("Time taken by Concating with String: "
                +(System.currentTimeMillis()-startTime)+"ms");
        startTime = System.currentTimeMillis();
        concatWithStringBuffer();
        System.out.println("Time taken by Concating with StringBuffer: "
                +(System.currentTimeMillis()-startTime)+"ms");
    }
}
/*
• The current length of a StringBuffer can be found via the length( )
method, while the total allocated capacity can be found through the
capacity( ) method.
* */
//
class StringBufferDemo2 {
    public static void main(String args[]) {
        StringBuffer sb = new StringBuffer("Hellooooooooooooooooooooooooo");
        System.out.println("buffer = " + sb);
        System.out.println("length = " + sb.length());
        System.out.println("capacity = " + sb.capacity());
    }
}

/*
• The value of a single character can be obtained from a StringBuffer via
the charAt( ) method. You can set the value of a character within a
StringBuffer using setCharAt( ).
• Their general forms are shown here:
char charAt(int where);
void setCharAt(int where, char ch)
 */




class setCharAtDemo {
    public static void main(String args[]) {

        StringBuffer sb = new StringBuffer("Hello");

        System.out.println("buffer before = " + sb);

        System.out.println("charAt(1) before = " + sb.charAt(1));

        sb.setCharAt(1, 'i');

        sb.setLength(2);

        System.out.println("buffer after = " + sb);

        System.out.println("charAt(1) after = " + sb.charAt(1));

    }

}



/*
 The hashCode() of string retunes a unique value for the object. For an
object of type String, it returns different hash code values, from one
object to another.
• On the other hand, it returns the same value irrespective of the contents
it contains.
* */


class HashCodeTest{
    public static void main(String args[]){
        System.out.println("Hashcode test of String:");
        String str="Java";
        System.out.println(str.hashCode());
        str=str+"NPTEL";
        System.out.println(str.hashCode());
        System.out.println("Hashcode test of StringBuffer:");
        StringBuffer sb=new StringBuffer("Java");
                System.out.println(sb.hashCode());
        sb.append("NPTEL");
                System.out.println(sb.hashCode());
    }
}


/*STRING BUILDER CLASS
• Introduced by JDK 5, StringBuilder is a relatively recent addition to
Java’s string handling capabilities.
• StringBuilder is similar to StringBuffer except for one important difference:
StringBuilder is not synchronized, which means that it is not thread-safe.
• The advantage of StringBuilder is faster performance. However, in cases in
which a mutable string will be accessed by multiple threads, and no external
synchronization is employed, you must use StringBuffer rather than
StringBuilder.
* */





