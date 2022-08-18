package BINARY_TREES;

import java.util.Scanner;

//ACCEPT N NO OF NODES FROM USER AND TSLL HOW MANY BT CAN BE CREATED --
//USING UNLABELLED NODES => CATALAN NO FORMULA -> (2n C n )/ (n+1) => (2N!)/((2N-N)!*(N!)*(N+1)) => (2N)!/((N)!*(N)!*(N+1))
//USING LABELLED NODE => (2n C n )*n!/ (n+1) => ((2N!)*N!)/((2N-N)!*(N!)*(N+1))  => [(2N)!/((N)!*(N)!*(N+1)) ]*N!
public class CountBT {
   static long[] factorial = new long[100];

    static void fact(){
        factorial[0] = 1;
        for (int i = 1; i < 100; i++) {
            factorial[i] = factorial[i-1] * (i+1);
        }
    }

    static int countBTUL(int n){
        return (int) ((factorial[(2*n)-1])/(factorial[n-1]*factorial[n-1]*(n+1)));
    }

    static int countBTL(int n){
        return (int) ((int) ((factorial[(2*n)-1])/(factorial[n-1]*factorial[n-1]*(n+1)))*(n));
    }

    public static void main(String[] args) {
        fact();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of unlbelled nodes");
        int ul = sc.nextInt();
        System.out.print("No of binarytrees : ");
        System.out.println(countBTUL(ul));

        System.out.println("Enter no of labelled nodes");
        int ll = sc.nextInt();
        System.out.print("No of binarytrees : ");
        System.out.println(countBTL(ul));

    }
}
