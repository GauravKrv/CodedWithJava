package IOPackageW9;

public class IOStreams {
    /*TAKEAWAYS:                                      SEARCH ABOUT UNICODES

    Java Stream Class => two types :
1]Byte Stream Class =>
    1.INPT STREAM CLASS => Memory, File, Pipe
    2.OUTPUT STEAM CLASS =>Memory, File , Class
2]Character Stream Class =>
    1.Reader Class =>Memory, File, Class
    2.Writer Class =>Memory,File ,,Class

    
    * */
   /*
   1.CONCEPT OF STREAMS :
==>A stream is a sequence of data. In Java, a stream is composed of bytes. It's called a stream
because it is a continuous flow of data.This interface allows the commnication or data flow
betwenn the device and the program.

==> [Keyboard,Mouse,Disk,Memory,Network] ==> JavaProgram <== [Screen,Pintrer,Disk,Memory,Network]

SOURCE =[I/P-Stream]=> =Reads=> Program  :Reading data into a program
PROGRAM =[O/P Stream]=> ==>Source  :Writing Data into a progrm

==>Streams in java points :
1. Java treats flow of data as stream.
2. Java streams are classified into two basic types: input stream and output stream.Due to these
two streams a program can read and write data.
3. The java.io package contains a large number of stream classes to support the streams.

{
UNIVERSAL TRANFORMATION FRORMAT - 8 ==>UTF-8
There are diff ASCII code formulated as a binary sequence, java follows more smarter way
of representing code these are called UNICODES, E.g UTF-8 & UTF-16,these are basically
a character set which allows us to give many diff representation of a charecter.
==>Adv is that it makes Platform independent representation of a data.
}

    2.PACKAGE "java.io"
• This package provides system input and output through data streams,
serialization and the file system.
1. Java I/O (Input and Output) is used to process the input and produce the
output.
2. Java uses the concept of a stream to make I/O operation fast. The java.io
package contains all the classes required for input and output operations.
3. We can perform file handling in Java by java.io API

    3.INTERFACE IN package java.io
Closeable ==>
A Closeable is a source or destination of data that can be closed.
DataInput   ==>
The DataInput interface provides for reading bytes from a binary stream and reconstructing
from them data in any of the Java primitive types.
DataOutput ==>
The DataOutput interface provides for converting data from any of the Java primitive types to a
series of bytes and writing these bytes to a binary stream.
Externalizable ==>
Only the identity of the class of an Externalizable instance is written in the serialization stream
and it is the responsibility of the class to save and restore the contents of its instances.
FileFilter ==>
==>
A filter for abstract pathnames.
FilenameFilter ==>
Instances of classes that implement this interface are used to filter filenames.
Flushable ==>
A Flushable is a destination of data that can be flushed.
ObjectInput ==>
ObjectInput extends the DataInput interface to include the reading of objects.
ObjectInputValidation ==>
Callback interface to allow validation of objects within a graph.
ObjectOutput ==>
ObjectOutput extends the DataOutput interface to include writing of objects.
ObjectStreamConstants ==>
Constants written into the Object Serialization Stream.
Serializable ==>
Serializability of a class is enabled by the class implementing the java.io.Serializable interface.


    4.EXCEPTOINS IN JAVA.IO PACKAGE :All these exceptions are subclasses of IOException.
CharConversionException ==> Base class for character conversion exceptions.
EOFException ==>
Signals that an end of file or end of stream has been reached unexpectedly
during input.
FileNotFoundException ==>
Signals that an attempt to open the file denoted by a specified pathname has failed.
InterruptedIOException ==>
Signals that an I/O operation has been interrupted.
InvalidClassException ==>
Thrown when the Serialization runtime detects one of the following problems with a Class.
InvalidObjectException ==>
Indicates that one or more deserialized objects failed validation tests.
IOException ==>
Signals that an I/O exception of some sort has occurred.
NotActiveException ==>
Thrown when serialization or deserialization is not active.
NotSerializableException ==>
Thrown when an instance is required to have a Serializable interface.
ObjectStreamException ==>
Superclass of all exceptions specific to Object Stream classes.
OptionalDataException==>
 Exception indicating the failure of an object read operation due to unread
primitive data, or the end of data belonging to a serialized object in the stream.
StreamCorruptedException ==>
Thrown when control information that was read from an object stream violates
internal consistency checks.
SyncFailedException ==> Signals that a sync operation has failed.
UnsupportedEncodingException ==> The Character Encoding is not supported.
UTFDataFormatException ==>
Signals that a malformed string in modified UTF-8 format has been read in a
data input stream or by any class that implements the data input interface.
WriteAbortedException ==>
Signals that one of the ObjectStreamExceptions was thrown during a write
operation.

    5.JAVA CLASSES FOR I-O STREAMS
Java provides java.io package which contains a large number of stream
classes to process all types of data:
ØByte stream classes
• Support for handling I/O operations on bytes
ØCharacter stream classes
• Supports for handling I/O operations on characters

Java Stream Class => two types :
1]Byte Stream Class =>
    1.INPT STREAM CLASS => Memory, File, Pipe
    2.OUTPUT STEAM CLASS =>Memory, File , Class
2]Character Stream Class =>
    1.Reader Class =>Memory, File, Class
    2.Writer Class =>Memory,File ,,Class

    6.JAVA BYTE STREAM CLASSES FOR INPUT
    InputStream sub class       Description
BufferedInputStream ==>Reading a chunk of bytes from an internal buffer associated with a stream
ByteArrayInputStream ==> Input stream that reads from a byte array
DataInputStream ==>An input stream that contains methods for reading the Java standard data types
*FileInputStream ==>Input stream that reads from a file
FilterInputStream ==> For filtering input from an existing stream
*ObjectInputStream ==> For reading objects from a stream
PipedInputStream ==> For reading from a piped stream like a network socket or port
PushbackInputStream ==> Input stream that supports one-byte “unget,” which returns a byte to the input stream
*SequenceInputStream ==> Input stream that is a combination of two or more input streams that will be read
                        sequentially, one after the other

    7.METHODS IN Bye Stream[inout] class
read( ) ==>Read a byte from the input stream
read(byte b[ ]) ==>Read an array of bytes into b
read(byte b[ ], int n, int m) ==>Reads m bytes into b starting from nth byte
available( ) ==>Gives number of bytes available in the input
skip(n) ==>Skips over n bytes from the input stream
reset( ) ==>Goes back to the beginning of the stream
close( ) ==>Close the input steam

EXAMPLE =>
DataInputStream [A class in byte stream which allows following methods in addition]:
readShort( ) readDouble( )
readInt( ) readLine( )
readLong( ) readChar( )
readFloat( ) readBoolean( )
readUTF( )

    8.JAVA BYTE STREAM CLASSES FOR OUTPUT
Output stream class             Meaning
BufferedInputStream ==>Writing a chunk of bytes to an internal buffer associated with a stream
ByteArrayOutputStream ==>Output stream that writes to a byte array
DataOutputStream ==>An output stream that contains methods for writing the Java standard data types
*FileOutputStream ==>Output stream that writes to a file
FilterOutputStream ==>For filtering output to an existing stream
*ObjectOutputStream ==>For writing objects to a stream
PipedOutputStream ==>For writing to a piped stream like a network socket or port
PushbackOutputStream ==>Output stream that supports one-byte “unget,” which returns a byte to the
                        output stream
*SequenceOutputStream ==>Output stream that is a combination of two or more output streams that will be
                        written sequentially, one after the other

    9.METHODS IN Bye Stream[output] class
write (int b )=> Write a byte from the input stream
write (byte b[ ]) =>Write all bytes in the array b to the
output steam
write (byte b[ ], int n, int m) => Write m bytes from array b starting
from nth byte
close( ) => Close the output stream
flush( ) =>Flushes the output stream

Example :  DataOutputStream
writeShort( ) writeDouble( )
writeInt( ) writeLine( )
writeLong( ) writeChar( )
writeFloat( ) WriteBoolean( )
writeUTF( )
<======================================================================================>
    1.CHARACTER STREAM CLASS
1]Character stream classes for Reader ==>
• Reader: Top-level abstract class to read to character streams.
    *o BufferedReader: Provides an in-between buffer for efficiency while
reading text from character input stream.
        § LineNumberReader: Uses a buffered character input stream
that keeps track of line numbers.
    *o CharArrayReader: Implements an auto-increasing character buffer
that may be used as a reader.
    o FilterReader: An instance of this class is used for reading character
files.
        § PushbackReader: This enables a character to be pushed
back into the stream after reading.
    *o InputStreamReader: An instance of this class provides a bridge
from byte streams to character streams. Bytes are decoded into
characters using a specified character set.
        § FileReader: An instance of this class is used for reading
character files.
    o PipedReader: Uses a pipe for character input stream.
    o StringReader: Character output stream reader from source string.

2]Charscer stream classes for writer
Writer: Top-level abstract class to write to character streams.
    *o BufferedWriter: Provides an in-between buffer for efficiency while
writing text to a character output stream.
    *o CharArrayWriter: Implements an auto-increasing character buffer that
may be used as a writer.
    o FilterWriter: Abstract class for writing filtered character streams.
    *o OutputStreamWriter: An instance of this class provides a bridge
between character streams and byte streams. Characters are encoded
into bytes using a specified character set.
        § FileWriter: An instance of this class is used for writing character
        files.
    o PipedWriter: Uses a pipe for character output stream.
    *o PrintWriter: Prints a formatted representation of an object to a testoutput stream.
    o StringWriter: Character output stream is collected in a string buffer
and may be used for constructing a string.
QUESTION=>There is a class available in java calles file class,,benefit of using file class
    2.METHODS IN CHARACTER STREAM READER CLASS
close() ==>Closes the stream and releases any system resources associated with it.
mark(int readAheadLimit) ==>Tells whether this stream supports the mark() operation.
markSupported() ==>Tells whether this stream supports the mark() operation.
read() ==>Reads a single character.
read(char[] cbuf) ==>Reads characters into an array.
read(char[] cbuf, int off, int len) ==>Reads characters into a portion of an array.
read(CharBuffer target) ==> Attempts to read characters into the specified character buffer.
ready() ==> Tells whether this stream is ready to be read.
reset() ==>Resets the stream.
skip(long n) ==> Skips characters.

    2.METHODS IN CHARACTER STREAM WRITER CLASS
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






   * */
}
