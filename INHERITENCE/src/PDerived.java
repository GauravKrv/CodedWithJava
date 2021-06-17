import java.util.Scanner;

public class PDerived extends A {
    //Main method will always be present in derived class only
    //Marks class
    int sub1;
    int sub2;

    void getData(){
        super.getData();
        System.out.println("Enter Marks for Subejct1 and Subject2: ");
        Scanner sc = new Scanner(System.in);
        sub1 = sc.nextInt();
        sub2 = sc.nextInt();

    }
    void putData(){
        super.putData();
        System.out.println("Subejct1 = "+ sub1);
        System.out.println("Subejct1 = "+ sub2);

    }

    void calculate(){
        float avg;
        //avg = (float)(sub1+sub2)/2.0f;
        avg = (sub1+sub2)/2.0f;
        System.out.println("Average = "+avg);
    }

    public static void main(String[] args) {
        PDerived marks = new PDerived();
        marks.getData();
        marks.putData();
        marks.calculate();

    }

}
