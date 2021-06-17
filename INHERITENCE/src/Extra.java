import java.util.Scanner;

public class Extra extends Base {
    String hobbies;
    String achievements;
   String awards;

    void getData(){
        super.getData();
        System.out.println("Enter Your Hobbies: ");
        Scanner sc = new Scanner(System.in);
        hobbies = sc.nextLine();
        System.out.println("Enter Your Achievements: ");
        achievements = sc.nextLine();
        System.out.println("Enter Your Awards if any: ");
        awards = sc.nextLine();
    }
    void putData(){
        super.putData();
        System.out.println("Hobbies = "+ hobbies);
        System.out.println("Achievements = "+ achievements);
        System.out.println("Awards = "+ awards);


    }
}
