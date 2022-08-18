package SORTING;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {7,3,4,1,2,7,4};
        Solution.quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high){
        // {
        //     if (p < r) {
        //          int q = partition(arr, p, r);
        //         quickSort(arr, p, q);
        //         quickSort(arr, q + 1, r);
        //     }
        //     // code here
        if (low < high) {

            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);

            quickSort(arr, pi + 1, high);
        }

    }
    static int partition(int arr[], int low, int high)
    {
//         int pivot = arr[low];
// 		int i = low;
// 		int j = high;
//       			while (i<j){
// 			do{
// 				i++;
// 			}while(arr[i]<=pivot);

// 			do{
// 				j--;
// 			}while(arr[j]>pivot);

// 			if(i<j){
// 				int temp = arr[i];
// 		arr[i] = arr[j];
// 		arr[j] = temp;
// 			}
// 		}



// 		int temp = arr[low];
// 		arr[low] = arr[j];
// 		arr[j] = temp;


// 		return j;
//         // your code here
//     }

// choose the rightmost element as pivot
        int pivot = arr[high];


        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {

                i++;


                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;


        return (i + 1);
    }
}


