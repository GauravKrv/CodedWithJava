package ARRAYS;

import java.util.Scanner;
//works
public class BinarySearch{
    static int binarySearch(int arr[], int l, int h,int item){
        if(h >= l){
            int mid = (h+l)/2;
            if (item==arr[mid]){
                return mid;
            }
            if (item>arr[mid])
                return binarySearch(arr,mid+1,h,item);
            else
                return binarySearch(arr,l,mid-1,item);
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int[] arr = {1,2,3,4,5};
        System.out.println(binarySearch(arr,0,4,6));
    }
}
