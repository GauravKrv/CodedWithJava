package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0;i<n;i++) {
            arr.add(sc.nextInt());
        }

        int q = sc.nextInt();
        String str;
        for (int i=0;i<q;i++) {
           str = sc.nextLine();

            if (str.equals("Insert")) {
                 arr.add(sc.nextInt(), sc.nextInt());
            }

            if (str.equals("Delete")) {
                //System.out.println("DELETE IS INOKED");
               arr.remove(sc.nextInt());
            }


           // System.out.println("I = "+i+" AND str = "+str);
        }

        for (int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }

    }
}
