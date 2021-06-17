import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        int n1,n2,sum=0,product=1,j=0;
        System.out.println("Enter digit: ");
        Scanner s = new Scanner(System.in);
        n1 = s.nextInt();
        ++n1;
        n2 = s.nextInt();
        for(j=n1;j<n2;j++){
            sum = sum+j;
            product=product*j;
        }
        System.out.println("Sum of the numbers is: "+sum);
        System.out.println("And product of the numbers is: "+product);

    }
}
