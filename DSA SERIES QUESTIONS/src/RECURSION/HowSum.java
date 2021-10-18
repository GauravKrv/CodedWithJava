package RECURSION;

import java.util.ArrayList;

public class HowSum {

    static Object howSum(int targetSum, int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (targetSum == 0) {
            return arr;
        }

        if (targetSum < 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            int rem = targetSum - nums[i]; //NEW SUM AFTER REMOVING CURRENT ELEMENT AND NOW AGAINCHECK FOR ALL COMBOS
            ArrayList<Integer> remResult = (ArrayList<Integer>) howSum(rem, nums); //WILL RETURN ARRAYLIST - How thinking part

            if (remResult != null) { //if null is returned check for another parent commbination
                remResult.add(nums[i]); //
                return remResult;
            }

        }

        return null;
    }

    public static void main(String[] args) {
        int t = 300;
        int[] nums = {5, 3, 4, 7};
        ArrayList<Integer> res = (ArrayList<Integer>) howSum(t, nums);

        System.out.println(res);
    }
}
