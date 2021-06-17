package IOPackageW9;

import java.io.*;

public class CharStreamClassConcept {
    /*
    1.CHARACTER STREAMS INTRO ==>
• In Western locales, the local character set is usually an 8-bit super set of ASCII.
• The Java platform stores character values using Unicode conventions.
• Character stream I/O automatically translates this internal format to and from the
local character set.

    2.TYPES OF CHARACTER CLASSES ==>
Character stream classes is used to read and write characters and supports a number
of input-output related methods
ØReader stream classes
    • To read characters from files.
    • In many way, identical to InputStream classes.
ØWriter stream classes
    • To write characters into files.
    • In many way, identical to OutputStream classes.
<======================================================================================>

    3.READER CLASS ==>
    1]TYPES =>
     BufferedReader,CharArrayReader,InputStreamReader[->File Reader],StringReader,PipeReader.
    FilterReader[->PushBackReader]

    2]INFORMATION =>
• Abstract class for reading character streams.
    public abstract class Reader extends Object implements Readable, Closeable
• The only methods that a sub class must implement are read(char[], int, int) and
close().
• Most sub classes, however, will override some of the methods defined here in order
to provide higher efficiency, additional functionality, or both.


    3]CLASSES ==>
BufferedReader ==>
Reads text from a character-input stream, buffering characters so as to provide for the
efficient reading of characters, arrays, and lines.
CharArrayReader ==>
This class implements a character buffer that can be used as a character-input stream.
InputStreamReader ==>
An InputStreamReader is a bridge from byte streams to character streams: It reads bytes
and decodes them into characters using a specified charset.
PipedReader==>
 Piped character-input streams.
FilterReader ==>
Abstract class for reading filtered character streams.
PushbackReader ==>
A character-stream reader that allows characters to be pushed back into the stream.
StringReader ==>
A character stream whose source is a string.
LineNumberReader ==>
A buffered character-input stream that keeps track of line numbers.
FileReader ==>
Convenience class for reading character files.

    4]CONSTRUCTORS IN READER CLASS
Reader() ==>
Creates a new character-stream reader whose critical sections will synchronize on the reader itself.

Reader(Object lock) ==>
Creates a new character-stream reader whose critical sections will synchronize on the given object.

Fields[protected (Object lock) ==> The object used to synchronize operations on this stream.]

    5]METHODS IN READER CLASS ==>
close() ===> Closes the stream and releases any system resources associated with it.
mark(int readAheadLimit) ===> Tells whether this stream supports the mark() operation.
markSupported() ===> Tells whether this stream supports the mark() operation.
read() ===> Reads a single character.
read(char[] cbuf) ===> Reads characters into an array.//cbuf is an array of characters
read(char[] cbuf, int off, int len) ===> Reads characters into a portion of an array.
read(CharBuffer target) ===> Attempts to read characters into the specified character buffer.
ready() ===> Tells whether this stream is ready to be read.//for synchro. purpose,.e if i/p source is busy then it returns false
reset() ===> Resets the stream.
skip(long n) ===> Skips characters from reading.
<======================================================================================>


        4.WRITER CLASS ==>
    1]TYPES =>Writer =>
     BufferedWriter,CharArrayWriter,OtputStreamWriter[->FileWriter],StringWriter,PipeWriter.
    FilterWriter,PrintWriter

    2]INFORMATION =>
    • Abstract class for writing character streams.
    public abstract class Writer extends Object implements Appendable, Closeable, Flushable

• The only methods that a subclass must implement are write(char[], int, int), flush(),
and close().
• Most subclasses, however, will override some of the methods defined here in order to
provide higher efficiency, additional functionality, or both.



    3]CLASSES IN WRITER =>
    Writer: Top-level abstract class to write to character streams.
    o BufferedWriter: Provides an in-between buffer for efficiency while
writing text to a character output stream.
    o CharArrayWriter: Implements an auto-increasing character buffer that
may be used as a writer.
    o FilterWriter: Abstract class for writing filtered character streams.
    o OutputStreamWriter: An instance of this class provides a bridge
between character streams and byte streams. Characters are encoded
into bytes using a specified character set.
        § FileWriter: An instance of this class is used for writing character
        files.
    o PipedWriter: Uses a pipe for character output stream.
    o PrintWriter: Prints a formatted representation of an object to a testoutput stream.
    o StringWriter: Character output stream is collected in a string buffer
and may be used for constructing a string.

    4]CONSTRUCTORS =>
Writer() ==> Creates a new character-stream writer whose critical sections will synchronize
on the writer itself.
Writer(Object lock) ==> Creates a new character-stream writer whose critical sections will synchronize
on the given object.
Fields[Field Description =>protected Object lock The object used to synchronize operations on this stream.]

    5]METHODS IN WRITER CLASS
append(char c) ==> Appends the specified character to this writer.
append(CharSequence csq) ==> Appends the specified character sequence to this writer.
append(CharSequence csq, int start, int end) ==> Appends a subsequence of the specified character sequence to this writer.
close() ==> Closes the stream, flushing it first.
flush() ==> Flushes the stream.
write(char[] cbuf) ==> Writes an array of characters.
write(char[] cbuf, int off, int len) ==> Writes a portion of an array of characters.
write(int c) ==> Writes a single character.
write(String str) ==> Writes a string.
write(String str, int off, int len) ==> Writes a portion of a string.
<======================================================================================>
   5.COPY CHARS VS COPY BYTES
   Note:
• CopyChars is very similar to CopyBytes. The most important difference is that CopyChars uses
FileReader and FileWriter for input and output in place of FileInputStream and
FileOutputStream.
• Both CopyBytes and CopyChars use an int variable to read to and write from.
• In CopyChars, the int variable holds a character value in its last 16 bits;
• In CopyBytes, the int variable holds a byte value in its last 8 bits.

<======================================================================================>



TASK

1.Performing input operations
2.Buffering input
3.Keeping track of line numbers
4.Reading from an array
5.Translating byte stream into a character stream
6.Reading from files
7.Filtering the input
8.Pushing back characters/bytes
9.Reading from a pipe
10.Reading from a string
11.Reading primitive types
12.Performing output operations
13.Buffering output
14.Writing to an array
15.Filtering the output
16.Translating character stream into a byte stream
17.Writing to a file
18.Printing values and objects
19.Writing to a pipe
20.Writing to a string
21.blWriting primitive types

Character Stream Class ==>
Char Stream is used when we want to read and write a text file,
it is good to make theapplication platform independendent

Reader
BufferedReader
LineNumberReader
CharArrayReader
InputStreamReader
FileReader
FilterReader
PushbackReader
PipedReader
StringReader
(none)
Writer
BufferedWriter
CharArrayWriter
FilterWriter
OutputStreamWriter
FileWriter
PrintWriter
PipedWriter
StringWriter
(none)

Byte Stream Class=>
DEALS RAW DATA DIRECTLY FROM INPT SOURCE=and is adv in some situations,like img,audio,video files,
 do it is then preferable to use bytestream

InputStream
BufferedlnputStream
LineNumberlnputStream
ByteArrayInputStream
(none)
FileInputStream
FilterlnputStream
PushbackInputStream
PipedInputStream
StringBufferInputStream
DataInputStream
OutputStream
BufferedOutputStream
ByteArrayOutputStream
FilterOutputStream
(none)
FileOutputStream
PrintStream
PipedOutputStream
(none)
DataOutputStream


    * */
}
//1.READING FROM KEYBOARD
class KeyboardReading2{
    public static void main(String args[]) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        //InpStrReader is a bridge whch makes a connection bw our prog and the keyboard
        System.out.println("Enter a String: ");
        String str1 = b.readLine();
        System.out.println("Entered String value is: " + str1);
        System.out.println("Enter a whole number: ");
        String str2 = b.readLine();
        int x = Integer.parseInt(str2);
        System.out.println("Enter a double value: ");
        String str3 = b.readLine();
        double y = Double.parseDouble(str3);
        if(x > y)
            System.out.println("First number " +x + " is greater than second number " + y);
        else
            System.out.println("First number " +x + " is less than second number " + y);
        b.close();
    }
}
//2.CLACULATOR USING BUFFERED READER
class InterestCalculator {
    public static void main(String args[ ] ) throws IOException {
        Float principalAmount = new Float(0);
        Float rateOfInterest = new Float(0);
        int numberOfYears = 0;
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String tempString;
        System.out.print("Enter Principal Amount: ");
        System.out.flush();
        tempString = b.readLine();
        principalAmount = Float.valueOf(tempString);
        System.out.print("Enter Rate of Interest: ");
        System.out.flush();
        tempString = b.readLine();
        rateOfInterest = Float.valueOf(tempString);
        System.out.print("Enter Number of Years:");
        System.out.flush();
        tempString = b.readLine();
        numberOfYears = Integer.parseInt(tempString);
// Input is over: calculate the interest
        float interestTotal = principalAmount*rateOfInterest*numberOfYears/100;
        System.out.println("Total Interest = " + interestTotal);
    }
}
//3.Copying files using filereader and FileWriter
class CopyChars {
    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new FileReader("D:\\JAVA\\programming OOP\\DS IN JAVA NPTL\\src\\IOPackageW9\\Gaurav.txt");
            outputStream = new FileWriter("output.txt");
            System.out.println("Reading done successfully");
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }
        }
        System.out.println("File ran successfully");
    }
}
