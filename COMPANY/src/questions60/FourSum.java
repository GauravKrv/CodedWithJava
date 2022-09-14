package questions60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum {

   static List<List<Integer>>  ans = new ArrayList<>();

    public static void main(String[] args) {
        int arr[] = {1,0,-1,0,-2,2};

        int target = 0;
        int k = 4;
        ArrayList<Integer> clist = new ArrayList<>();

        solve(arr,0,target,k,clist);

        System.out.println(ans);

    }


    private static void solve(int[] arr, int i, int target, int k, List<Integer> clist) {
        int clistSize = clist.size();
        if (clistSize==k){
            if (target == 0){
                ans.add(clist.stream().map(e->e).collect(Collectors.toList()));
            }
            return;
        }
        if (i==arr.length){
            return;
        }

        clist.add(arr[i]);
        solve(arr, i + 1, target - arr[i], k, clist);
        clist.remove(clist.size()-1);
        solve(arr, i+1, target, k, clist);

    }



}

class Test{
    public static void main(String[] args) {
        List<List<Integer>>  ans = new ArrayList<>();
        int target = 0;
        int k = 4;
        List<Integer> clist = new ArrayList<>();
        clist.add(1);
        clist.add(1);
        clist.add(1);

        ans.add(clist);
        ans.add(clist);
        clist.remove(0);
        clist.remove(0);
        clist.remove(0);
        System.out.println(ans);
    }
}
