import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class TryScanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        Double d = scan.nextDouble();
        String s = scan.nextLine();//Problem occurs here becoz nextInt method does not read the newline character of our input,so when we issue the command nectLIne()
        //Scanner finds the newLine characte and gives us that as a lilne.


        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
 class TryScannerSolution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        Double d = scan.nextDouble();
        //To solve the above problem we can use following techniqu:
        scan.nextLine();//USse utit
        String s = scan.nextLine();


        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}

class TryScannerSolution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       int i = 1;
        //Another way To solve the above problem we can use following techniqu:
        try {
            i = Integer.parseInt(scan.nextLine());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        Double d = 12.2;
        //Another way To solve the above problem we can use following techniqu:
        try {
             d = Double.parseDouble(scan.nextLine());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        String s = scan.nextLine();


        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}

