package TALENTLY.CV;

import java.util.*;

public class Q3MiddleOfSLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> ll = new ArrayList<>();
        int in = sc.nextInt();
        while (in!=-1){
            ll.add(in);
            in = sc.nextInt();
        }

        System.out.println(ll.get(ll.size()/2));


    }
}
