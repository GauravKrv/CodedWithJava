import java.io.*;

public class FileHP1 {
/*To read some content from a file and that content i want to display in consiole
  --We will need a fiel input stream

  */

    public static void main(String[] args) throws IOException {
        FileInputStream input = null;//Alwatys assign null while creating a reference
/*
      Becoz a data is inpt from a file so we will need a file ip stream
            When we are writing something to the fiel so we will use file output stream
*/

        input = new FileInputStream("D:\\JAVA\\programming OOP\\FileHandeling\\src\\hola");//Double slash is used instead of singe forward slash
//The chars coming to us is in unicde format from any file,THen we will push the unicode to the system.out to print it

        int ch;//End of file is represented by a number "-1"

        //I want to go to eof but i dont kow how many chars are there so i can go fir for kloop
        while ((ch = input.read()) != -1) {
            //Now i got the character and i want to rint the character to System.out
            System.out.print(ch + "\t");
        }
        input.close();


    }
}

class FileHOutput {
/*To read some content from a file and that content i want to display in consiole
  --We will need a fiel input stream

  */

    public static void main(String[] args) throws IOException {
        FileInputStream input = null;//Alwatys assign null while creating a reference
/*
      Becoz a data is inpt from a file so we will need a file ip stream
            When we are writing something to the fiel so we will use file output stream
*/

        input = new FileInputStream("D:\\JAVA\\programming OOP\\FileHandeling\\src\\hola");//Double slash is used instead of singe forward slash
//The chars coming to us is in unicde format from any file,THen we will push the unicode to the system.out to print it
        FileOutputStream output;
        output = new FileOutputStream("D:\\JAVA\\programming OOP\\FileHandeling\\src\\hola2");
        int ch;//End of file is represented by a number "-1"

        //I want to go to eof but i dont kow how many chars are there so i can go fir for kloop
        while ((ch = input.read()) != -1) {
            output.write(ch);
        }
        input.close();
        output.close();


    }
}

class FileHReaderWriter {
/*To read some content from a file and that content i want to display in consiole
  --We will need a fiel input stream

  */

    public static void main(String[] args) throws IOException {
        FileReader input = null;//Alwatys assign null while creating a reference
/*
      Becoz a data is inpt from a file so we will need a file ip stream
            When we are writing something to the fiel so we will use file output stream
*/

        input = new FileReader("D:\\JAVA\\programming OOP\\FileHandeling\\src\\hola");//Double slash is used instead of singe forward slash

        int ch;//End of file is represented by a number "-1"

        //I want to go to eof but i dont kow how many chars are there so i can go fir for kloop
        while ((ch = input.read()) != -1) {
            System.out.print((char) ch);
        }
        input.close();


    }
}

class FileHReaderWriter2 {
/*To read some content from a file and that content i want to display in consiole
  --We will need a fiel input stream

  */

    public static void main(String[] args) throws IOException {
        FileReader input = null;//Alwatys assign null while creating a reference
/*
      Becoz a data is inpt from a file so we will need a file ip stream
            When we are writing something to the fiel so we will use file output stream
*/

        input = new FileReader("D:\\JAVA\\programming OOP\\FileHandeling\\src\\hola");//Double slash is used instead of singe forward slash

        FileWriter output;
        output = new FileWriter("D:\\JAVA\\programming OOP\\FileHandeling\\src\\hola2");
        int ch;//End of file is represented by a number "-1"

        //I want to go to eof but i dont kow how many chars are there so i can go fir for kloop
        while ((ch = input.read()) != -1) {
            output.write((char) ch);
        }
        input.close();
        output.close();//Always cloase else tumse na ho payi


    }

    //We can insert the filenames by the usr with the help of ommand line arguments.
}


