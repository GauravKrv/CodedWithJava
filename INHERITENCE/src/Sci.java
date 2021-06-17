import java.util.Scanner;

public class Sci extends Extra {
    int physics;
    int maths;
    int chemestry;

    void getData(){
        super.getData();
        System.out.println("Enter Marks for Physics and Maths and Chemestry: ");
        Scanner sc = new Scanner(System.in);
        physics = sc.nextInt();
        maths = sc.nextInt();
        chemestry = sc.nextInt();

    }
    void putData(){
        super.putData();
        System.out.println("Physics = "+ physics);
        System.out.println("Maths = "+ maths);
        System.out.println("Chemistry = "+ chemestry);


    }

    void calculate(){
        float avg;
        //avg = (float)(sub1+sub2)/2.0f;
        avg = (physics + maths + chemestry)/3.0f;
        System.out.println("Average = "+avg);
    }












    public static void main(String[] args) {
        Arts a = new Arts();
        Sci s = new Sci();
        System.out.println("Choose your stream:\n" +
                "1.Arts\n" +
                "2.Science\n" +
                "Enter 1 or 2: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            a.getData();
            a.putData();
            a.calculate();
        }else if (choice==2) {

            s.getData();
            s.putData();
            s.calculate();
        }else {
            System.out.println("Invalid Input.");
        }
    }
}
