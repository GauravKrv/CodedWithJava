package ARRAYS;

public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];

        int max = res;
        int min = res;

        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(nums[i],nums[i]*max);
            min = Math.min(nums[i],nums[i]*min);
            res = Math.max(res,max);

        }
        return res;

    }

    static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,-1,0,3,5,-2,-1,-3};
        System.out.println((maxProduct(arr)));
    }
}
