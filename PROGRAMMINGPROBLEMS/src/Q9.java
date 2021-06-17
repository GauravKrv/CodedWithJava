import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        int count = 0,result;
        System.out.println("Enter digit: ");
        Scanner s = new Scanner(System.in);
        result = s.nextInt();
        do {
            result=result/10;
            count++;
        }while(result!=0);
        System.out.println(count);
    }
}
