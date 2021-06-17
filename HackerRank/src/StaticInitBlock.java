import java.util.Scanner;

public class StaticInitBlock {

    static int B, H;
    static boolean flag = true;

    static {

        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();
        sc.close();
        try {
            if (B <= 0 || H <= 0)
                throw new Exception("Breadth and height must be positive");
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}

/*THEORY:
Instance variables are initialized using initialization blocks. However, the static initialization blocks can only initialize
 the static instance variables. These blocks are only executed once when the class is loaded. There can be multiple static
  initialization blocks in a class that is called in the order they appear in the program.
* */

class StaticInit{
    static  int a,b;
    static {
         a = 20;
         b = 20;

    }

    public static void main(String[] args) {
        int res = a*b;
    }
}
