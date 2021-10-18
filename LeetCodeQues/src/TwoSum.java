import java.util.HashMap;

public class TwoSum {
    static int[] twoSum2(int[] arr,int sum){
        int res[] = new int[2];

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i]+arr[j]==sum){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }

        }
        return res;

    }

    public static int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(h.containsKey(target-nums[i])){
                arr[0] = h.get(nums[i]);
                arr[1] = i;
            }else{
                h.put(nums[i],i);

            }
        }




        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {3,3};
        int[] res = twoSum(arr,6);

        System.out.println(res[0]+" "+res[1]);
    }
}
