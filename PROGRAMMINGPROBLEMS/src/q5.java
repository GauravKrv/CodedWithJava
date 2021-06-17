import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        int i=1,result=1;
        System.out.println("Enter base: ");
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        System.out.println("Enter Exponent: ");


        int expo = s.nextInt();
        while (i<=expo){
            result = result*base;
            i++;
        }
        System.out.println("Result is: "+result);
    }
}
