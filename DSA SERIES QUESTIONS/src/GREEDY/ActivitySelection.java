package GREEDY;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
        int start;
        int finish;
        ActivitySelection(int start, int finish){
            this.start = start;
            this.finish = finish;
        }

    static class MyCmp implements Comparator<ActivitySelection>{
        public int compare(ActivitySelection a, ActivitySelection b){
            return a.finish - b.finish;
        }
    }

    static int maxAct(ActivitySelection[] arr){
        Arrays.sort(arr, new MyCmp());
        int res = 1;
        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].start>=arr[prev].finish){
                res++;
                prev=i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        ActivitySelection[] act = new ActivitySelection[n];

        act[0] = new ActivitySelection(2,3);
        act[1] = new ActivitySelection(1,4);
        act[2] = new ActivitySelection(5,8);
        act[3] = new ActivitySelection(6,10);

        System.out.println(maxAct(act));

    }

}
