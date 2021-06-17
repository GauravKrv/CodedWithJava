import java.util.Scanner;

public class ClassBasic {
    int noStu;
    int roll;
    String name;
    ClassBasic(int roll,String Studentname, int noStu){
        this.roll = roll;
        name = Studentname;
        this.noStu = noStu;
    }

    public static void main(String[] args) {
        ClassBasic objName = new ClassBasic(17,"Riya",1);

        //How to take input from user
        Scanner Cc = new Scanner(System.in); //It will connect the user from keyboard to Java program
        System.out.println("Enter name of the student: ");

        objName.name = Cc.nextLine();//To take string input from user we use nextLine()

        System.out.println("Enter roll of the student: ");

        objName.roll = Cc.nextInt();//To take integer input from user we use nextInt()

        System.out.println("Enter number of students: ");

        objName.noStu = 68;


        System.out.println("Name = " + objName.name + "Roll = " +objName.roll  + " Number of student = " + objName.noStu );

    }

}
