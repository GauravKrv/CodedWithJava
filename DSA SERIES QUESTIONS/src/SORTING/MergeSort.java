package SORTING;

public class MergeSort {
 void sort(int arr[],int l,int r){
        if(l<r)
        {
        int m = (l+r)/2;

        sort(arr,l,m);
        sort(arr,m+1,r);

        merge(arr,l,m,r);
        }
    }
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[],int l, int m, int r){
       int n1 = m-l+1;//size of array1
       int n2 = r-m;//size of array2

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i=0;i<n1;++i){
            L[i] = arr[l+i];
        }
        for (int i=0;i<n2;++i){
            R[i] = arr[m+1+i];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    /* Copy remaining elements of L[] if any */
        while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    /* Copy remaining elements of R[] if any */
        while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }


    }
    void printArray(int arr[]){
        int a =0;
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");;
        }
    }
    public static void main(String[] args) {
        int arr[] = {12,11,13,15,6,7};
        MergeSort ms = new MergeSort();
        System.out.println("Given Array : ");
        ms.printArray(arr);

        ms.sort(arr,0,arr.length-1);

        System.out.println("\nSorted array: ");
        ms.printArray(arr);

    }

}
/*
THEORY :
Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides the input array
into two halves, calls itself for the two halves, and then merges the two sorted halves.
The merge() function is used for merging two halves. The merge(arr, l, m, r) is a key
process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two
sorted sub-arrays into one.

ALGO :
MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:
             middle m = (l+r)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)

TIME COMPLEXITY :
Sorting arrays on different machines. Merge Sort is a recursive algorithm and time
complexity can be expressed as following recurrence relation.
T(n) = 2T(n/2) + θ(n)

The above recurrence can be solved either using the Recurrence Tree method or the Master
method. It falls in case II of Master Method and the solution of the recurrence is
θ(nLogn). Time complexity of Merge Sort is  θ(nLogn) in all 3 cases (worst, average and
 best) as merge sort always divides the array into two halves and takes linear time to
 merge two halves.

Auxiliary Space: O(n)
Algorithmic Paradigm: Divide and Conquer
Sorting In Place: No in a typical implementation
Stable: Yes
* */
