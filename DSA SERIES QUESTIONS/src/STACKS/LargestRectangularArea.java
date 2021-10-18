package STACKS;

import ARRAYS.ArrayInput;

public class LargestRectangularArea {
    static int largestRectangularArea(int[] arr){
        int mx = 0;
        for (int i=0;i<arr.length;i++){
            int curr = arr[i];
            int sum = 0;
            for(int j=i;j>=0;j--){
                if (arr[j]>=curr){
                    sum+=curr;
                }else break;
            }
            for(int j=i+1;j<arr.length;j++){
                if (arr[j]>=curr){
                    sum+=curr;
                }else break;
            }

            mx = Math.max(sum,mx);
        }

        return mx;
    }

    public static void main(String[] args) {
        int n = 7;
        ArrayInput ar = new ArrayInput();
        int arr[] = ar.createArray(n);

        System.out.println(largestRectangularArea(arr));
    }
}
