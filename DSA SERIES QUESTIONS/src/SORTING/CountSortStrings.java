package SORTING;

import java.util.Arrays;
import java.util.Scanner;

public class CountSortStrings {
    public static String countSort(String arr)
    {
        int k = 26;
        int[] count = new int[26];
        for(int i = 0; i<arr.length();i++){
            count[(int)arr.charAt(i) - 97]++;
        }

        int index = 0;

        char ar2[] = new char[arr.length()];
        for(int i = 0; i<k;i++){
            for(int j = 0; j<count[i];j++){
                ar2[index] = (char)(i+97);
                index++;

            }
        }
     /*   for(int i = 0; i<arr.length();i++)
                System.out.print(ar2[(i)] + " ");*/
        return Arrays.toString(ar2);
    }

    public static String countSort2(String arr)
    {
        int k = 26;
        int[] count = new int[26];
        for(int i = 0; i<arr.length();i++){
            count[(int)arr.charAt(i) - 97]++;
        }
        for(int i = 1; i<k;i++){
            count[i] = count[i]+count[i-1];
        }

        int op[] = new int[arr.length()];
        String  res = "";
        for(int i = arr.length()-1; i>=0;i--){
           op[count[((int)arr.charAt(i) - 97)] - 1] = (int)arr.charAt(i) - 97;
            count[((int)arr.charAt(i) - 97)]--;

        }

        for(int i = 0; i<arr.length();i++){
            res = res+ (char)(op[i]+97);
        }





     /*   for(int i = 0; i<arr.length();i++)
                System.out.print(ar2[(i)] + " ");*/
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
           // long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            System.out.println(countSort2(arr));
        }
    }
}
