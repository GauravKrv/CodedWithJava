import java.util.Arrays;
import java.util.Scanner;

public class LexicographicOrderOfStrings {

    static String subString(String str,int b,int e){
       return str.substring(b,e);
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = subString(s,0,k);
        String largest = "";
        int n = s.length()-(k-1);
        String ar[] = new String[n];

        for (int i =0;i<n;i++){
            ar[i] = subString(s,i,i+k);
            if(ar[i].compareTo(smallest)<0) smallest = ar[i];
            if (ar[i].compareTo(largest)>0) largest = ar[i];
        }
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));

    }
}
