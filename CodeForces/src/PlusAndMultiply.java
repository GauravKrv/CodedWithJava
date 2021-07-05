import java.util.Scanner;

public class PlusAndMultiply {
    static boolean set(int a,int b, int n, int i,boolean b1,boolean b2){
        if (i*a==n||i+b==n){
            return true;
        }
        else if (i+b>n || i*a>n){
            if (i+b>n) b2 = false;
            if (i*a>n){
                b1 = false;
            }
        }else {
            //if (set(a,b,i))
        }

//        if ()
//        set(a,b,n,i+b);
//        set(a,b,n,i*a);


        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
//            if (set(a,b,n,1)){
//                System.out.println("Yes");
//            }else {
//                System.out.println("No");
//            }
        }
    }
}
