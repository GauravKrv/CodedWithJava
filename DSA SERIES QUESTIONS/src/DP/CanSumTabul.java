package DP;

public class CanSumTabul {
    //WORKS
    static boolean canSumTab(int target, int[] numbers){
        boolean[] table = new boolean[target+1];

        table[0] = true;

        for (int i=0;i<=target;i++){
            if (table[i]){ //if curr element is true
                for (int num:numbers){
                    if (i+num<=target)
                    table[i+num] = true; //rest each element of number array when added with current can generate the resultant sum index --think ez but tricky
                }//i.e we can generate all the elements of array from the table at least -> then we can also genrate (any index) = (curr true ele + prev true ele)
            }
        }
        return table[target];
    }

    public static void main(String[] args) {
        int t = 300;
        int[] nums = {5, 3, 4, 7};

        System.out.println(canSumTab(t,nums));
    }
}
