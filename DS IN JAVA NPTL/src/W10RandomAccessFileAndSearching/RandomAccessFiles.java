package W10RandomAccessFileAndSearching;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFiles {
    /*
    1.INTRODUCTION ==>[RandomAccessFile class]
    This class is used for reading and writing to random access file.
• A random access file behaves like a large array of bytes.
• There is a cursor implied to the array called file pointer, by moving the cursor we do the read
write operations.
• If end-of-file is reached before the desired number of byte has been read than EOFException is
thrown. It is a type of IOException.
==>Other files can only work as input or output stream,i.e we can either read or write in the file
if we open it nce, but in contrast RandomAccessFile we can do both read and write operatoins at once

    2.CONSTRUCTORS ==>
1]RandomAccessFile(File file, String mode) ==>
 Creates a random access file stream to read from, and optionally to
write to, the file specified by the File argument.
2]RandomAccessFile(String name, String mode) ==>
 Creates a random access file stream to read from, and optionally to
write to, a file with the specified name.

    3.METHODS ==>
close() ==>
    It closes this random access file stream and releases any system resources
associated with the stream.
getChannel() ==>
It returns the unique FileChannel object associated with this file.
readInt() ==>
It reads a signed 32-bit integer from this file.
readUTF() ==>
It reads in a string from this file.
seek(long pos) ==>
It sets the file-pointer offset, measured from the beginning of this file, at
which the next read or write occurs.
writeDouble(double v) ==>
It converts the double argument to a long using the doubleToLongBits method
in class Double, and then writes that long value to the file as an eight-byte quantity, high byte first.
writeFloat(float v) ==>
It converts the float argument to an int using the floatToIntBits method in class
Float, and then writes that int value to the file as a four-byte quantity, high byte
first.
write(int b) ==>
It writes the specified byte to this file.
read() ==>
It reads a byte of data from this file.
length() ==>
It returns the length of this file.
seek(long pos) ==>
It sets the file-pointer offset, measured from the beginning of this file, at which
the next read or write occurs.

    4.USEFULNESS OF RANDOM ACCESS FILE ==>
• As the name implies the class RandomAccessFile allows us to handle a file randomly
in contrast to sequentially in InputStream or OutputStream classes.
• It allows to move file pointer randomly.
• Moreover, it allows read or write or read-write simultaneously

    5.METHODS TO READ IN RANDOM ACCESS FILE ==>
read() ==>
It reads a byte of data from this file.
length() ==>
It returns the length of this file.
seek(long pos) ==>
It sets the file-pointer offset, measured from the beginning of this file, at which
the next read or write occurs.
close() ==>
It closes this random access file stream and releases any system resources
associated with the stream.
getChannel() ==>
It returns the unique FileChannel object associated with this file.
readInt() ==>
It reads a signed 32-bit integer from this file.
readUTF() ==>
It reads in a string from this file.

    6.METHODS TO WRITE FROM A RAF
write(int b) ==>It writes the specified byte to this file.
length() ==> It returns the length of this file.
seek(long pos) ==> It sets the file-pointer offset, measured from the beginning of this file, at which the
next read or write occurs.
close() ==> It closes this random access file stream and releases any system resources
associated with the stream.
writeDouble(double v) ==> It converts the double argument to a long using the doubleToLongBits method in
class Double, and then writes that long value to the file as an eight-byte quantity,
high byte first.
writeFloat(float v) It converts the float argument to an int using the floatToIntBits method in class
Float, and then writes that int value to the file as a four-byte quantity, high byte first.
write(int b) It writes the specified byte to this file.


    * */
}
//1.EXAMPLE READING FROM A RANDOM ACCESS FILE
class RandomAccessFileExample {
    static final String FILEPATH = "D:\\JAVA\\programming OOP\\DS IN JAVA NPTL\\src\\W10RandomAccessFileAndSorting\\RandomAccessFiles.java\\file.txt";
    private static byte[] readFromFile(String filePath, int position, int size)
            throws IOException {

        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(position);
        byte[] bytes = new byte[size];
        file.read(bytes);
        file.close();
        return bytes;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new String(readFromFile(FILEPATH, 0, 8)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
//2.WRITING INTO A RAF PROGRAM
class RandomAccessFileExample2 {
    static final String FILEPATH ="file.txt";
    public static void main(String[] args) {
        try {
            writeToFile(FILEPATH, "Data Structures and Algorithms Using Java", 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeToFile(String filePath, String data, int position)
            throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");//both read write mode
        file.seek(position);
        file.write(data.getBytes());//to convert a string into bytes
        file.close();
    }
}
//3.READ-WRITE OPERATIONS
class RandomIO{
    public static void main (String args[]){
        RandomAccessFile file = null;
        try {
            file = new
                    RandomAccessFile("outputs.txt","rw");
// Writing to the file
            file.writeChar('X');
            file.writeInt(555);
            file.writeDouble(3.1412);
            file.seek (0);
// Go to the beginning
// Reading from the file
            System.out.println(file.readChar());
            System.out.println(file.readInt());
            System.out.println(file.readDouble());
            file.seek(2); // Go to the second item
            System.out.println(file.readInt());
// Go to the end and append false to the file
            file.seek(file.length());
            file.writeBoolean(false);
            file. seek (4) ;
            System.out.println(file.readBoolean());
            file.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}


