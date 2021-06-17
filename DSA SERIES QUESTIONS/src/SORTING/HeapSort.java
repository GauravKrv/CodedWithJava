package SORTING;

public class HeapSort {
    static void maxHeapify(int[] A,int pos,int n){
        int left = (2*pos) + 1;
        int right = (2*pos) + 2;
        int largest = pos;
        if(left<n && A[left]>A[pos]){
            largest = left;
        }else if(right<n) {
            largest = right;
        }
        if(right<n && A[right]>A[largest]){
            largest = right;
        }

        if (largest<n&&largest!=pos){
            int temp = A[pos];
            A[pos] = A[largest];
            A[largest] = temp;
            maxHeapify(A,largest,n);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr;
        //arr = new int[]{4,14,7,15,61,1};
        arr = new int[]{6,5,4,3,8,9};

        for(int i=-0;i<n;i++)
        System.out.print(arr[i]   + " "      );

        /*for(int i=n/2;i>0;i--)
        maxHeapify(arr,0,n);*/
        heapSort(arr);
        System.out.println();
        System.out.print("After Heapifying : ");
        for(int i=-0;i<n;i++)
            System.out.print(arr[i]   + " "      );

    }

    static void heapSort(int[] arr){
        int n = arr.length;
        for (int i=1;i<arr.length;i++){

            maxHeapify(arr,0,n);
            int temp = arr[n-1];
            arr[n-1] = arr[0];
            arr[0] = temp;
            n--;
        }
    }
}
