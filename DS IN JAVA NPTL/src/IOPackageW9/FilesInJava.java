package IOPackageW9;

import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class FilesInJava {
    /*
    TAKEAWAYS ==> SHOULD BE EITHER FAMILIER WITH JAVA FX, OR JAVA SWING,OR JAVA AWT.

    1.JAVA FILE I/O
Java provides java.io package which includes numerous class definitions
and methods to manipulate file and flow of data ( called File I/O streams )
There are 4 major classes =>
File**[Sequencial Access of file]
FileInputStream
FileOutputStream
RandomAccessFile**

    2.OPENING A FILE OBJECT
• There are three constructors
• Way 1:
•File myFile;
•myFile = new File(fileName); // Constructor 1  ==>File will be created in the same working directory
• Way 2:
•File myFile;
•myFile = new File (pathName, filename); // Constructor 2  ==>Name of the directory can be given if exist
• Way 3:
•File myFile;
•File myFile = new File(myDir, fileName); // Constructor 3  ==>If working directory not exist then it will be created first in the path with the direc name

    3.USING CLASS File
Dealing with file names
• String getName()
• String getPath()
• String getAbsolutePath()
• String getParent()
• boolean renameTo(File newFilenam)

Testing a file
• boolean exists()
• boolean canWrite()
• boolean canRead()
• boolean isFile()
• boolean isDirectory()
• boolean isAbsolute()

Getting file information
• long lastModified()
• long length()
• boolean delete()

Directory utilities
•boolean mkDir(File newDir)
•boolean mkDirs(File newDir)
•String [] list()

    * */
}
//.1: Knowing information about a File object
class FileTest {
    private static File inputs;


    public static void main (String args [ ] ) throws IOException {
        //ABOVE the cmd line argument will contain the ame of the files in its argument
        File fileToCheck;
       // String inputs;
        if (args.length > 0 ) {
            for (int i = 0; i < args.length;i++ ) {
                fileToCheck = new File(args[ i ]);//will connect our new file to the argumnt file, e.g abc.text is passed
                getPaths(fileToCheck);
                getInfo(fileToCheck);
            }
        }
        else
            System.out.println (" Usage : Java FileTest <filename (s) >");
    }
    public static void getPaths (File f ) throws IOException {//it may throw
        System.out.println ("Name : " + f.getName( ) );
        System.out.println ("Path : " + f.getPath ( ) );
        System.out.println ("Parent : " + f.getParent ( ) );
    }
    public static void getInfo (File f ) throws IOException {
        if (f.exists() ) {
            System.out.print ("File exists ");
            System.out.println (f.canRead( ) ? "and is readable" : "");
            System.out.println ( f.canWrite( ) ? "and is writable" : "");
            System.out.println ("File is last modified : "+ f.lastModified( ));
                    System.out.println ("File is " + f.length( ) + "bytes" );
          //  System.out.println("File op1 = "+f.renameTo(inputs));==>Will show NPE
            System.out.println("Absolute path : "+f.getAbsolutePath());
            //System.out.println("File deleted "+f.delete());
        }
        else
            System.err.println (" File does not exist." );
    }
}
//2.STORING DATA INTO A FILE
class ReadWriteIntegers {
    public static void main(String args[]) throws IOException {
        DataInputStream dis = null; //Input stream object
        DataOutputStream dos = null; //Output stream object
        File intFile = new File("rand.txt");
        //Construct a file
//Writing integers to rand.dat file
        try { //Create output stream for intFile file
            dos = new DataOutputStream(new FileOutputStream(intFile));
            for (int i = 0; i < 20; i++)
                dos.writeInt((int) (Math.random() * 100));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            dos.close();
        }

    //Reading integers from rand.dat file
try {
//Create input stream for intFile file
        dis = new DataInputStream(new FileInputStream(intFile));
        for(int i=0;i<20;i++) {
            int n = dis.readInt();
            System.out.print(n + " "); }
    }
catch(IOException ioe) {
        System.out.println(ioe.getMessage());
    }
finally {
        dis.close();
    }
}
}
//3.MERGING TWO FILES
class MergeFilesDemo{ //*****************HOW TO INPUT FILES
    public static void main (String args[]) throws IOException{
//Declare file streams
        FileInputStream file1 = new FileInputStream(args[0]);
        FileInputStream file2 = new FileInputStream(args[1]);
        SequenceInputStream file3 = null;//A class which takes inot of twofiles and will copy the input of one file into another
//Declare file3 to store combined files
      //  file1 = new FileInputStream("insider.txt"); //Open the files to be concatenated
       // file2 = new FileInputStream("output.txt"); //Open the files to be concatenated
        file3 = new SequenceInputStream(file1,file2) ; //Concatenate filel and file2
//Create buffered input and output streams to read the created file3
        BufferedInputStream inBuffer = new BufferedInputStream(file3);
        BufferedOutputStream outBuffer = new BufferedOutputStream(System.out);
//Read and write till the end of buffers
        int ch;
        while((ch = inBuffer.read()) != -1)
            outBuffer.write((char)ch);
        inBuffer.close();
        outBuffer.close();
        file1.close();
        file2.close();
    }
}
//4.INTERACTIVE INPUT OUTPUT
//To usse StringTokenizer class
class Inventory {
    static DataInputStream din = new DataInputStream(System.in);
    static StringTokenizer st;
    public static void main (String args[]) throws IOException{
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("invent.dat"));
// Reading from console
        System.out.println("Enter code number");
        st = new StringTokenizer(din.readLine());
        int code = Integer.parseInt(st.nextToken());
        System.out.println("Enter number of items");
        st = new StringTokenizer(din.readLine());
        int items = Integer.parseInt(st.nextToken());
        System.out.println("Enter cost");
        st = new StringTokenizer(din.readLine());
        double cost = new Double(st.nextToken()).doubleValue();
        // Writing to the file "invent.dat"
        dos.writeInt(code);
        dos.writeInt(items);
        dos.writeDouble(cost);
        dos.close();
// Processing data from the file
        DataInputStream dis = new DataInputStream(new FileInputStream("invent.dat"));
        int codeNumber = dis.readInt();
        int totalItems = dis.readInt();
        double itemCost = dis.readDouble();
        double totalCost = totalItems * itemCost;
        dis.close();
// Writing to console
        System.out.println();
        System.out.println("Code Number : " + codeNumber);
        System.out.println("Item Cost : " + itemCost);
        System.out.println("Total Items : " + totalItems);
        System.out.println("Total Cost : " + totalCost);
    }
}

//GRAPHICAL USER INTERFACE
class StudentFile extends Frame {
    // Defining window components
    TextField number, name, marks;
    Button enter, done;
    Label numLabel, nameLabel, markLabel;
    DataOutputStream dos;//CREATING THE DAT AOP STREAM , coz we want to write the dta
    // Initialize the Frame
    public StudentFile(){
        super("Create Student File");
    }
    // Setup the window
    public void setup() {
        resize(400, 200);
        setLayout(new GridLayout(4,2));
// Create the components of the Frame, or creating the UI
        number = new TextField(25);
        number = new TextField(25);
        numLabel = new Label("Roll Number");
        name = new TextField(25);
        nameLabel = new Label ("Student Name");
        marks = new TextField(25);
        markLabel = new Label("Marks");
        enter = new Button("ENTER");
        done = new Button("DONE");
// Add the components to the Frame or adding components to UI
        add(numLabel);
        add(number);
        add(nameLabel);
        add(name);
        add(markLabel);
        add(marks);
        add(enter);
        add(done);
// Show the Frame
        show();
        // Open the file
        try {
            dos = new DataOutputStream( new FileOutputStream("student.dat"));
        }
        catch(IOException e) {
            System.err.println(e.toString());
            System.exit(1);
        }
    }
    // Write to the file
    public void addRecord() {
        int num;
        Double d;
        num = (new Integer(number.getText())).intValue();
        try {
            dos.writeInt(num);
            dos.writeUTF(name.getText());
            d = new Double(marks.getText());
            dos.writeDouble(d.doubleValue());
        }
        catch(IOException e) { }
// Clear the text fields
        number.setText(" ");
        name.setText(" ");
        marks.setText(" ");
    }
    // Adding the record and clearing the TextFields
    public void cleanup() {
        if(!number.getText(). equals(" ")) {
            addRecord();
        }
        try {
            dos.flush();
            dos.close();
        }
        catch (IOException e){
        }
    }
    // Processing the event, keyboard event handeling, button- enter and done
    public boolean action(Event event,Object o) {
        if(event.target instanceof Button)
            if(event.arg.equals("ENTER")) {
                addRecord();
                return true;
            }
        return super.action(event, o);
    }
    public boolean handleEvent(Event event) {
        if(event.target instanceof Button)
            if(event.arg.equals("DONE")) {
                cleanup();
                System.exit(0);
                return true;
            }
        return super.handleEvent(event);
    }
    // Execute the program
    public static void main (String args[]) { //Main method to call
        StudentFile student = new StudentFile();
        student.setup();
    }
}



