

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {


    Scanner s = new Scanner(System.in);
    int[] arr = new int[10];
    int large=0,small=0,i=0;
        System.out.println("Input the numbers: ");
        System.out.println();

        while (i<10){

       arr[i]=s.nextInt();
       if(i==0){
           large=arr[i];
           small=arr[i];
       }
       if (arr[i]>large){
           large=arr[i];
       }else if (small>arr[i]){
           small=arr[i];
       }
       i++;
   }
        System.out.println("Largest number is: "+large);
        System.out.println("Smallest number is: "+small);


    }
    /*OUTPUT->
Input the numbers:

2
3
4
55
66
77
77
8
66
98
Largest number is: 98
Smallest number is: 2
*/

}
