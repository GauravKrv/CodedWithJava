package DP;

import java.util.ArrayList;
//DOESNT GIVES CORRECT BEST SUM*****************************
public class BestSumTabul {

    static ArrayList<Integer> bestSumTabul(int target, int[] numbers){
        ArrayList<ArrayList<Integer>> table = new ArrayList<>(target+1);
        table.add(new ArrayList<>());
        for (int i = 1; i <= target; i++) {
            table.add(null);
        }

        for (int i = 0; i < target; i++) {
            if (table.get(i)!=null){
                for (int j : numbers) {

                    ArrayList<Integer> temparray = new ArrayList<>();
                    temparray.addAll(table.get(i));
                    temparray.add(j);

                    if (table.get(i+j)==null) {
                        table.add(i+j,new ArrayList<>());
                    }
                    if (table.get(i + j).size()==0 || table.get(i + j).size()>temparray.size()) {
                        table.get(i+j).addAll(temparray);
                    }
                }
            }
        }

        return table.get(target);
    }

    public static void main(String[] args) {
        int t = 300;
        int[] nums = {30,10,50};

        ArrayList<Integer> res = (ArrayList<Integer>) bestSumTabul(t, nums);

        System.out.println(res);
    }
}
