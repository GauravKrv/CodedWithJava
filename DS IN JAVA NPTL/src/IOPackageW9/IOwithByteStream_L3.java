package IOPackageW9;

import java.io.*;
/*TAKEAWAY => How to use fileInputStream class to insert and read a file    * */

public class IOwithByteStream_L3 {
    /*Byte Stream Class
    1.INTRO =>
    Byte Stream Classes are used to read bytes from an input stream and write bytes to
    an output stream.
• Programs use byte streams to perform input and output of 8-bit bytes.
• All byte stream classes are descended from InputStream and OutputStream.
• There are many byte stream classes. To demonstrate how byte streams work, we'll
focus on the file I/O byte streams, FileInputStream and FileOutputStream.
• Other kinds of byte streams are used in much the same way; they differ mainly in the
way they are constructed.

    2.TYPES =>
    Byte Stream classes are divided in two groups:
• InputStream classes: These classes are subclasses of an abstract class InputStream
and they are used to read bytes from a source (file, memory, or console).
• OutputStream classes: These classes are subclasses of an abstract class
OutputStream and they are used to write bytes to a destination (file, memory or
console).
<=================================================================================>
    3.INPUT STREAM CLASS
InputStream class is an abstract class. It is the superclass of all classes representing an input
stream of bytes.
public abstract class InputStream extends Object implements Closeable

    InputStream sub class       Description
BufferedInputStream ==>Reading a chunk of bytes from an internal buffer associated with a stream
ByteArrayInputStream ==> Input stream that reads from a byte array
DataInputStream ==>An input stream that contains methods for reading the Java standard data types
FileInputStream ==>Input stream that reads from a file
FilterInputStream ==> For filtering input from an existing stream
ObjectInputStream ==> For reading objects from a stream
PipedInputStream ==> For reading from a piped stream like a network socket or port
PushbackInputStream ==> Input stream that supports one-byte “unget,” which returns a byte to the input stream
SequenceInputStream ==> Input stream that is a combination of two or more input streams that will be read
                        sequentially, one after the other
       4.INPUT STREAM METHODS
available() ==>
Returns an estimate of the number of bytes that can be read (or skipped over) from
this input stream without blocking by the next invocation of a method for this input
stream.
close() ==>
Closes this input stream and releases any system resources associated with the stream.
mark(int readlimit) ==>
Marks the current position in this input stream.
markSupported() ==>
Tests if this input stream supports the mark and reset methods.
read() ==>
Reads the next byte of data from the input stream.
read(byte[] b) ==>
Reads some number of bytes from the input stream and stores them into the buffer array b.
read(byte[] b, int off,int len) ==>
Reads up to len bytes of data from the input stream into an array of bytes.
reset() Repositions this stream to the position at the time the mark method was last called
on this input stream.
skip(long n) ==>
Skips over and discards n bytes of data from this input stream.

    5.USES OF INPUT STREAM
InputStream classes is used to read 8-bit bytes and supports a number of
input-related methods
• Reading bytes
• Closing streams
• Marking positions in streams
• Skipping ahead in streams
• Finding the number of bytes in stream
• and many more…

<====================================================================================>
6.OUTPUT STREAM CLASS
OutputStream class is an abstract class. It is the superclass of all classes representing an output
stream of bytes. An output stream accepts output bytes and sends them to some sink.
public abstract class OutputStream extends Object implements Closeable, Flushable

==>JAVA BYTE STREAM CLASSES FOR OUTPUT
Output stream class             Meaning
BufferedInputStream ==>Writing a chunk of bytes to an internal buffer associated with a stream
ByteArrayOutputStream ==>Output stream that writes to a byte array
DataOutputStream ==>An output stream that contains methods for writing the Java standard data types
FileOutputStream ==>Output stream that writes to a file
FilterOutputStream ==>For filtering output to an existing stream
ObjectOutputStream ==>For writing objects to a stream
PipedOutputStream ==>For writing to a piped stream like a network socket or port
PushbackOutputStream ==>Output stream that supports one-byte “unget,” which returns a byte to the
                        output stream
SequenceOutputStream ==>Output stream that is a combination of two or more output streams that will be
                        written sequentially, one after the other


   7.METHODS IN Bye Stream[output] class
write (int b )=> Write a byte from the input stream
write (byte b[ ]) =>Write all bytes in the array b to the
output steam
write (byte b[ ], int n, int m) => Write m bytes from array b starting
from nth byte
close( ) => Close the output stream
flush( ) =>Flushes the output stream

    8.USE OF OUTPUT STREAM
OutputStream classes is used to write 8-bit bytes and supports a number of input- related methods
• Writing bytes
• Closing streams
• Flushing streams
• etc.

    * */
}
//1.READING STRING,INTEGER, AND DOUNBLE, FROM KEYBOARD
class KeyboardReading{
    public static void main(String args[]) throws IOException //or use try catch block for whole prog
    {
        DataInputStream dis = new DataInputStream(System.in);
        System.out.println("Enter a String: ");
        String str1 = dis.readLine();
        System.out.println("Entered String value is: " + str1);
        System.out.println("Enter a whole number: ");
        String str2 = dis.readLine();
        int x = Integer.parseInt(str2);
        System.out.println("Enter a double value: ");
        String str3 = dis.readLine();
        double y = Double.parseDouble(str3);
        if(x > y)
            System.out.println("First number " +x + " is greater than second number " + y);
        else
            System.out.println("First number " +x + " is less than second number " + y);
        dis.close();//To closw the input stream which we have opened
    }
}

//2.CALCULATOR using input stream
class InterestCalculator2 {
    public static void main(String args[ ] ) throws IOException {
        Float principalAmount = new Float(0);
        Float rateOfInterest = new Float(0);
        int numberOfYears = 0;
        DataInputStream in = new DataInputStream(System.in);
        String tempString;
        System.out.print("Enter Principal Amount: ");
        System.out.flush();
        tempString = in.readLine();
        principalAmount = Float.valueOf(tempString);
        System.out.print("Enter Rate of Interest: ");
        System.out.flush();
        tempString = in.readLine();
        rateOfInterest = Float.valueOf(tempString);
        System.out.print("Enter Number of Years:");
        System.out.flush();
        tempString = in.readLine();
        numberOfYears = Integer.parseInt(tempString);
// Input is over: calculate the interest
        float interestTotal = principalAmount*rateOfInterest*numberOfYears/100;
        System.out.println("Total Interest = " + interestTotal);
    }
}

//3.Read the file address from the Command Line
//import java.io.*;
class ReadBytesDemo {
    public static void main (String args[]) {
        FileInputStream infile = null; // Create an input file stream
        int b;
        try {
            infile = new FileInputStream(args[0]);
// Connect infile stream to the required file
            while((b = infile.read()) != -1) {
                System.out.print((char)b); // Read and display data
            }
            infile.close();
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
    }
}
//3.2.Using methods of fileInptStream Class *****************************************
class InputStreamTest {
    public static void main (String args [ ] ) throws IOException {
        int size;
// To open a file input stream.
        FileInputStream fin;
        fin = new FileInputStream ("D:\\JAVA\\programming OOP\\DS IN JAVA NPTL\\src\\IOPackageW9\\Gaurav.txt");
        size = fin.available( );
// returns the number of bytes available
        System.out.println("Total bytes ::" + size);
        System.out.println ( "Data is displayed : Using read( )");
        for (int i = 0; i < size ; i++ ) {
            System.out.println ((char) fin.read( ) );
        }
        System.out.println (" Remaining bytes :" + fin.available( ) );
        System.out.println ("Next ¼ is displayed : Using read( b[ ])");
        size = fin.available();
        byte b[] = new byte[size/4];
        if (fin.read (b) != b.length )
            System.err.println ("File reading error : ");
        else {
            String temp = new String (b, 0, 0, b.length );
// Convert the bytes into string
            System.out.println (temp) ;
// display text string.
            System.out.println (" Still available:"+fin.available( ) );
            System.out.println (" skipping ¼ : Using skip ( )" );
            fin.skip(size/4);
            System.out.println (" File remaining for read ::"+fin.available( ) );
        }
        fin.close ( ); // Close the input stream
    }
    /*OTPUT ->
    "C:\Program Files\Java\jdk-10\bin\java.exe" "-javaagent:C:\Users\gaura\KOT-ij\IntelliJ IDEA Community Edition 2019.3.2\lib\idea_rt.jar=57420:C:\Users\gaura\KOT-ij\IntelliJ IDEA Community Edition 2019.3.2\bin" -Dfile.encoding=UTF-8 -classpath "D:\JAVA\programming OOP\out\production\DS IN JAVA NPTL" IOPackageW9.InputStreamTest
Total bytes ::10
Data is displayed : Using read( )
i

a
m
g
a
u
r
a
v
 Remaining bytes :0
Next ¼ is displayed : Using read( b[ ])

 Still available:0
 skipping ¼ : Using skip ( )
 File remaining for read ::0
    * */
}
//<==================================================================================>
//1.BYTE-OUTPUT STREAM--Storing data into a file
class ReadWritePrimitive{ //*******************
    public static void main (String args[]) throws IOException{
        File primitive = new File("prim.dat");
        FileOutputStream fos = new FileOutputStream(primitive);
        DataOutputStream dos = new DataOutputStream(fos);
//Write primitive data to the "prim.dat"file

        dos.writeInt(1999);
        dos.writeDouble(375.85);
        dos.writeBoolean(false);
        dos.writeChar('X');
        dos.close();
        fos.close();
//Read data from the "prim.dat" file
        FileInputStream fis = new FileInputStream(primitive);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readInt());//Should be reaad in same manner as written
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readChar());
        dis.close();
        fis.close();
    }
}
//2.Copying bytes from one file to another
class CopyBytes {//*******************************CHECK FILE INPUT CONCEPT
    public static void main(String args[]) {
//Declare input and output file streams
        FileInputStream infile = null;
//Input stream
        FileOutputStream outfile = null;
//Output stream
//Declare a variable to hold a byte
        byte byteRead;
        try {
//Connect infile to in.dat
            infile = new FileInputStream("in.dat");//will work only when in.dat file is available to us
            //else will sthrow an error
//Connect outfile to out.dat
            outfile = new FileOutputStream("out.dat");
//Reading bytes from in.dat and writing to out.dat
            do {
                byteRead = (byte) infile.read();
                outfile.write(byteRead);
            }
            while (byteRead != -1);//-1 occurs when there is no data available in the input source
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(IOException e) {
            System.out.println(e.
                    getMessage());
        }
        finally //Close files
        {
            try {
                infile.close();
                outfile.close();
            }
            catch(IOException e){}
        }
    }
    /*OUTPUT ==>
    File not found
Exception in thread "main" java.lang.NullPointerException
	at IOPackageW9.CopyBytes.main(IOwithByteStream_L3.java:269)
    * */
}

/*
Note:
• Closing a stream when it's no longer needed is very important.
• Always make sure that each stream variable contains an object reference before invoking close.
• Using Bytes is a kind of low-level I/O that should be avoided. Since for character data, the best
approach is to use character streams. There are also streams for more complicated data types.
• Byte streams should only be used for the most primitive I/O.
• All other stream types are built on byte streams.
* */


