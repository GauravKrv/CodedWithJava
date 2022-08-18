package wipro;

import java.util.HashSet;

public class Q2CC {
    public static int findPassword(int input1,int input2,int input3,int input4,int input5){

        int[] arr = {input1,input2,input3,input4,input5};
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            if (checkFreq(arr[i])){
                max = Math.max(max,arr[i]);

            }else{
                min = Math.min(min,arr[i]);

            }
        }
        return max-min;
    }

   static boolean checkFreq(int a){
        String s = String.valueOf(a);
        int[] c = new int[10];
        for (int i = 0; i < s.length(); i++) {
            c[Integer.valueOf(s.charAt(i))-48]++;

        }
        int x = -1;

        for (int i = 0; i < 10; i++) {
            if (c[i]>0 && x==-1){
                x = c[i];
            }
            else{
                if (c[i]!=x && c[i]!=0){
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(findPassword(12,1313,122,678,898));
    }

}
