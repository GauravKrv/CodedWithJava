import java.util.Scanner;

public class P1 {
    static boolean oddSet(int[] a,int n){
        for (int i=0;i+1<n;i+=2){
            if ((a[i]+a[i+1])%2==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[2*n];

            for (int i = 0; i < 2*n; i++) {
                arr[i] = sc.nextInt();
            }

            if (oddSet(arr,2*n)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
