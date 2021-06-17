import java.util.Scanner;

public class Base {
    //STUDENT CLASS
    String name;//good practie-->always declare variables in different lines
    String roll;
    String address;

    void getData(){
        System.out.println("Enter Name, Roll and Address");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        roll = sc.nextLine();// AS Roll is of single word.. As a programmer we must lnow a var will contain what constraints of values
        address = sc.nextLine();

    }
    void putData(){
        System.out.println("Name = "+ name);
        System.out.println("Roll= "+ roll);
        System.out.println("Address = "+ address);


    }
}
