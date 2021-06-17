package ARRAYS;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxAndSecondMax {
    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[])
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int max = -1,secM = -1;
        if(sizeOfArray == 1){
            al.add(arr[0]);
            al.add(-1);
        }else{
            if (arr[0]>=arr[1]){
                max = arr[0];
                if(arr[0]!=arr[1]){
                    secM = arr[1];
                }
            }else{
                secM = arr[0];
                max = arr[1];
            }

            for(int i = 2;i<sizeOfArray;i++){
                if(arr[i]>max)
                {
                    max = arr[i];
                    if(arr[i-1]<max && arr[i-1]>secM){
                        secM = arr[i-1];
                    }

                }  else{
                    if(arr[i]>secM && arr[i]!=max){
                        secM = arr[i];
                    }
                }

            }

            al.add(max);
            al.add(secM);
        }
        return al;


        //code here.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> al = largestAndSecondLargest(n,arr);
        System.out.println(al.get(0)+" "+ al.get(1));
    }
}

/*
6788
15021 26963 30323 28809 6103 13168 30088 21569 24070 20509 2074 16392 6266 28324 27923 20658 9223 7841 17269 32705 20595 31692 22246 19931 12576 19475 5483 29052 24810 17388 4724 24041 15699 25833 15129 13925 23774 10892 8099 422 17592 31070 30286 12682 8605 1083 15181 21255 2042 7152 4623 31328 32591 7432 19393 16287 23768 28642 14100 24383 12652 20231 7488 21289 20133 18363 4169 30690 10049 10450 28288 4610 3784 21445 16206 18408 7279 9221 19757 25516 13629 24719 8439 29013 364 27585 1699.................
*/
