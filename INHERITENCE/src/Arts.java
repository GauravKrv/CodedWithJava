import java.util.Scanner;

public class Arts extends Extra/*STUDENT*/ {
    int History;
    int polSc;

    void getData(){
        super.getData();
        System.out.println("Enter Marks for History and Arts: ");
        Scanner sc = new Scanner(System.in);
        History = sc.nextInt();
        polSc = sc.nextInt();

    }
    void putData(){
        super.putData();
        System.out.println("History = "+ History);
        System.out.println("PolSci = "+ polSc);

    }

    void calculate(){
        float avg;
        //avg = (float)(sub1+sub2)/2.0f;
        avg = (History + polSc)/2.0f;
        System.out.println("Average = "+avg);
    }
    public static void main(String[] args) {
        Arts a = new Arts();
        Sci s = new Sci();
        System.out.println("Choose your stream:" +
                "1.Arts" +
                "2.Science" +
                "Enter 1 or 2");
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
