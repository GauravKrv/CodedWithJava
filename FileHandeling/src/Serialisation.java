import java.io.*;

public class Serialisation {
   /*
   Some boduy may want to store the data in the form of object
   --When we want to convert a bytestream or Strean to an object and vice versa
   This process are called as serialisation or deserialisation
   --To achieve this ser and deser our object must be a "serialisable"
   --to make an object serialisable we need to implement an interface clled "Serialisable
   which belong to io package of java, then we can write any object to a file"

   Why Serialisation?
   --I want to write a student information to a file in the form of object
   and retrieve the ibject from a file and then disokay the data


   * */

}

class Student implements Serializable { //Class is serialixable now
    String name;
    String branch;
    int roll;

    //I want to write an object[or enter dsta to an object] of this class to a file--or we want to do serialisation
    //Retrive data from an object stored in a file is caled deserialisation

}

class SerialDemo {
    public static void main(String[] args) throws IOException {
        Student std = new Student();
        std.name = "Sur";
        std.branch = "CSE";
        std.roll = 127;

        FileOutputStream fos = new FileOutputStream("D:\\JAVA\\programming OOP\\FileHandeling\\src\\students.txt");
        //We can give any extension but nirmally for serial we give ser extension to identify that it content an object

        //Now i want to write an object, so whatever data we give t it, it will be an object
        //So we will use another Stream called "ObjectOutputStream

        ObjectOutputStream oos = new ObjectOutputStream(fos);//Here we will specufy the object pointing to the file

        //Now we will write a whole object and not caracter by character so we will pass objName
        oos.writeObject(std);//Now our object has been serialised
        oos.close();
        fos.close();


    }
}

class DeserDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student std = null;//Assign null when we are not referencing anyting to an oobject by your own
        FileInputStream fis = new FileInputStream("D:\\JAVA\\programming OOP\\FileHandeling\\src\\students.txt");

        ObjectInputStream ois = new ObjectInputStream(fis);

        std = (Student) ois.readObject();//What object will i read =>
        // So i need to secify whatever type of object will it read by typecasting and then we will store it inthe Required Student object reference created

        System.out.println(std.name);
        System.out.println(std.branch);
        System.out.println(std.roll);

        ois.close();
        fis.close();

    }


}