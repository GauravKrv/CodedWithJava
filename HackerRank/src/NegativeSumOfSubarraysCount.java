import java.util.ArrayList;
import java.util.Scanner;
//NOT FINISHED
public class NegativeSumOfSubarraysCount {

static void negSumOfSubarraysCount(int arr[],int size){
    int i,j,count=0,num=0,sum=0;
    ArrayList al;

    for (i=0;i<size;i++){
        if (arr[i]<0) {
            count++;
            for (j = 0; j < size; j++) {
                if (i!=j){
                   sum = arr[i] + arr[j];
                }
            }
        }

    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++){
             arr[i]= sc.nextInt();
        }


    }
}
