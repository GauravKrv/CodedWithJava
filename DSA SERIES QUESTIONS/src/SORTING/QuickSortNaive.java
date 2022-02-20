package SORTING;

public class QuickSortNaive {
    //DIFFERENCE IN QUICKDORT OF C AND JAVA
    //SAME CODE WILL WORK DIFFERENTLY AS JAVA WILL SHOW OUT OF BOUND BUT C TAKES A GARBAGE VALUE
    //so THIS LINE.. we need to handle the case of i<h in Java but not in C
    static int partitionAsc(int arr[],int l,int h){
        int pivot = arr[l];
        int i = l;
        int j = h;

        while (i<j){
            do{
                i++;
            }
            while(i<h&&arr[i]<=pivot);//THIS LINS:
            do{
                j--;
            }while(arr[j]>pivot);

            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
               //this is done so that before terminating of loop the elements are swapped only till i<j
        }

        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;

        System.out.println("L = "+arr[l]);
        System.out.println("J = "+arr[j]);
        return j;
    }

    static void quickSortAsc(int arr[],int l,int h){
        int j;
        if(l<h){
            j = partitionAsc(arr,l,h);
            quickSortAsc(arr,l,j);
            quickSortAsc(arr,j+1,h);
        }
    }

    public static void main(String[] args) {
        int arr[] = {12,11,13,15,6,7};

        quickSortAsc(arr,0,arr.length);

        for (int i =0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

}
