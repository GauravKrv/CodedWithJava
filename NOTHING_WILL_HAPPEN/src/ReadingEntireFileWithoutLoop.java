// Java Program to illustrate reading from FileReader
// using Scanner Class reading entire File
// without using loop
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingEntireFileWithoutLoop
{
    public static void main(String[] args)
            throws FileNotFoundException
    {
        File file = new File("D:\\JAVA\\CodeIt\\NOTHING_WILL_HAPPEN\\src\\inputcode");
        Scanner sc = new Scanner(file);

       // ArrayList<String>
        // we just need to use \\Z as delimiter
       // sc.useDelimiter("\\Z");
        while (sc.hasNext()){
            String s = sc.next();
            System.out.println(s);
        }

       // System.out.println(sc.next());
    }
}