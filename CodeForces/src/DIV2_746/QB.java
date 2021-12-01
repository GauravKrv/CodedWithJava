package DIV2_746;

public class QB {
    static boolean isSorted(int arr[],int s,int e){
        if (s<0) s=0;
        if (e> arr.length) e= arr.length;
        for (int i = s; i < e-1; i++) {
            if (arr[i]>arr[i+1]) return false;
        }
        return true;
    }
    static boolean solution(int n,int x,int[] arr){
        if(x<=n/2) return true;

       else return (isSorted(arr,x-1,n-x));

    }
}
