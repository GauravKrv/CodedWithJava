package DP;

import java.util.ArrayList;

public class HowSum {
    static Object howSumDP(int targetSum, int[] nums, ArrayList<Object> memo) {

        ArrayList<Integer> arr = new ArrayList<>();
        if (targetSum < 0 || memo.get(targetSum) != null) {
            if (targetSum > 0)
                return memo.get(targetSum);

            if (targetSum < 0) {
                return null;
            }
        }
        if (targetSum == 0) {
            return arr;
        }

        for (int i = 0; i < nums.length; i++) {
            int rem = targetSum - nums[i];
            ArrayList<Integer> remResult = (ArrayList<Integer>) howSumDP(rem, nums, memo);

            if (remResult != null) {
                remResult.add(nums[i]);
                memo.add(targetSum, remResult);

                return memo.get(targetSum);
            }

        }
        memo.add(targetSum, null);

        return null;
    }

    //my recur -- works
    static Object howSum(int target, int[] numbers) {
        if (target < 0) return null;
        ArrayList<Integer> ar = new ArrayList<>(1);

        if (target == 0) return ar;
        for (int x :
                numbers) {
            int rem = target - x;

            ArrayList<Integer> tempArr = (ArrayList<Integer>) howSum(rem, numbers);

            if (tempArr != null) {
                ar.addAll(tempArr);
                ar.add(x);
                return ar;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int t = 70;
        int[] nums = {7, 14};
        //{5, 3, 4, 7};
        ArrayList<Object> memo = new ArrayList<>();
        for (int i = 0; i <= t; i++) {
            memo.add(null);
        }
        ArrayList<Integer> res = (ArrayList<Integer>) howSumDP(t, nums, memo);

        System.out.println(res);
        System.out.println(howSum(t, nums));
    }
}
