import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class FizzBuzz {

    public static void main(String[] args) {
       // HashSet<String> ans = new HashSet<>();-->>HASHSET is not suitable to print indexx wise i thnk
      //  Vector<String> ans = new Vector<>();-->Vector is also god for storig and retrieving the values.
        ArrayList<String> ans = new ArrayList<>();//-->Works Same as vector class
       //HASHtabel and HASHMaps will require a key with value to be tored.

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");

            } else {
                // ans.add(String.valueOf(i));-->to convert na int to a string


                ans.add(String.valueOf(i));
            }


        }
        System.out.println("Given fizzbuzz answer is : ");

        System.out.print(ans + " ");//-->can print all the elements directly like this
        //Or can iterate over them

    }
}
