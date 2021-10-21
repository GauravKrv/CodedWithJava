package DP;

import java.util.ArrayList;

public class HowSumTabul {
static ArrayList<Integer> howSumTabul(int target,int[] numbers){
    ArrayList<ArrayList<Integer>> table = new ArrayList<>(target+1);
    table.add(new ArrayList<>());
    for (int i = 1; i <= target; i++) {
        table.add(null);
    }

     for (int i = 0; i < target; i++) {
        if (table.get(i)!=null){
            for (int j : numbers) {
                table.add(i+j,new ArrayList<>());
                table.get(i + j).addAll(table.get(i));
                table.get(i + j).add(j);
            }
        }
    }

    return table.get(target);
}

    public static void main(String[] args) {
        int t = 300;
        int[] nums = {30,10};

        ArrayList<Integer> res = (ArrayList<Integer>) howSumTabul(t, nums);

        System.out.println(res);
    }
}
