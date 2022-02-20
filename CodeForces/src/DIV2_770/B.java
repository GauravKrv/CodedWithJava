package DIV2_770;

import CodeForces.CodeForces;

public class B extends CodeForces {
    //WORKS BUT A BRUTEFORCE
    static boolean solutionUtil(int[] arr,int x,long y,long sum,int idx){
        if (idx==0){

            if (solutionUtil(arr, x, y,x+arr[idx], idx+1)||solutionUtil(arr, x, y,x^arr[idx], idx+1)){
                return true;
            }
            else return false;
        }

        if (idx==arr.length && sum==y){
            return true;
        }
        if (idx==arr.length){
            return false;
        }
        else return
        solutionUtil(arr, x, y,sum+arr[idx], idx+1)||
        solutionUtil(arr, x, y,sum^arr[idx], idx+1);

        }

        static void solution(int[] arr,int x,long y){
        long sum = 0L;
        if (solutionUtil(arr, x, y,sum, 0)) {
            System.out.println("Alice");
        }
        else{
            System.out.println("Bob");
        }

        }

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n=I();
            long x = L();
            long y = L();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = I();
            }
            solution2(arr,x,y);
        }
    }
//works IN O(N)
    static void solution2(int[] arr,long x,long y) {
        long xorsum = 0L;
        for (int i = 0; i < arr.length; i++) {
            xorsum^=arr[i];//THE TRICK OF OBSERVATION
        }
        if ((x^xorsum)%2==(y%2)){
            System.out.println("Alice");
        }else{
            System.out.println("Bob");
        }
    }
}
