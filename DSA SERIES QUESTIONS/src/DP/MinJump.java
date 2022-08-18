package DP;

public class MinJump {
   static int getminjump(int[] a)
    {
        int currreach = 0, currmax=0,jumps=0;
        for (int i = 0; i < a.length; i++) {
            if (i+a[i]>currmax){
                currmax=i+a[i];
            }
            if (currreach==i){
                if (i!=a.length-1){
                    jumps++;
                }
                currreach = currmax;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int a[] = {2,4,1,4,2,1};
        System.out.println(getminjump(a));
    }

}
