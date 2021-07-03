package SEARCHING;

import ARRAYS.ArrayInput;
//**********WORKS O(LOGN)
public class MinElementSortedRotated {
    static int minNumber(int a[], int l, int h)
    {
        int min = a[l];

        while(l<=h){
            min = a[l];

            int m = (l + h)/2;

            if(a[m]>=min){     //CSE 1
                if(a[m]<=a[h]){ //CASE1.1
                    return min;
                }
                else{           //CASE 1.2 & 1.3
                    l = m+1;
                }
            }
            else if(a[m]<min){  //CASE 2
                if(a[m-1]>a[m]){ //CASE 2.1
                    return a[m];
                }else{
                    h = m-1;    //CASE2.2
                }
            }
        }
        return a[l];
        // Your code here
    }

    public static void main(String[] args) {
        try {
            while (true) {
                ArrayInput ar = new ArrayInput();
                int[] arr = ar.createArray(10);
                ar.printArray(arr, 10);
                int min = minNumber(arr, 0, 9);
                System.out.println();
                System.out.println(min);
                System.out.println();
            }
        }catch (Exception e){
            System.out.println("Program terminated");
        }
//2 3 4 5 6 7 8 9 10 1.
    }
}
