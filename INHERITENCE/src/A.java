import java.util.Scanner;

public class A extends Base {
    //It will extends to Base or so called STUDENT CLASS
    //SO CALLED COURSE Class--No main method reqd.
    String branch;//good practie-->always declare variables in different lines
    String sem;

    void getData(){
//Call the getdata of the student first so that when i call tis class then automatiocally data of student is asked
        super.getData();//Calling getDataa method of Base class
        System.out.println("Enter Branch and Semester: ");
        Scanner sc = new Scanner(System.in);
        branch = sc.nextLine();
        sem = sc.next();

    }
    void putData(){
        super.putData();
        System.out.println("Branch = "+ branch);
        System.out.println("Semester = "+ sem);

    }
}
