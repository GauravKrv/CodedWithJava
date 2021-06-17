package SORTING;

public class MergeKSortedArrays {
static final int n = 4;

    static void mergeKArrays(int arr[][],int i,int j,int output[]){
        //if one array is in range
        if (i==j){
            for (int p=0;p<n;p++){
                output[p] = arr[i][p];
            }
        //if only two arrays are left then merge them
        if (j-i == 1){
            mergeArrays(arr[i],arr[j],n,n,output);
            return;
        }
        //output arrays
            int out1[] = new int[n*(((i+j)/2)-i+1)];
            int out2[] = new int[n*(j-((i+j)/2))];

            //divide the array into halves
            mergeKArrays(arr,i,(i+j)/2,out1);
            mergeKArrays(arr,(i+j)/2+1,j,out2);

            //merge the output array
            mergeArrays(out1,out2,n*(((i+j)/2)-i+1),n*(j-((i+j)/2)),output);


        }
    }

    private static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3) {
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i<n1 && j <n2)
        {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = arr2[j++];
    }


    // A utility function to print array elements
   static void printArray(int arr[], int size)
    {
        for (int i=0; i < size; i++)
            System.out.print(arr[i] + " ");
    }


    public static void main(String[] args) {

        int arr[][] =  {{2, 6, 12, 34},
            {1, 9, 20, 1000},
            {23, 34, 90, 2000}};
        int k = arr.length*n;

        int output[] = new int[n*k];

        mergeKArrays(arr,0,2,output);

        System.out.println("Merged array is : ");

        printArray(output,n*k);
    }
}//WRONGGG OUTPUT

/*THEORY :
Efficient Approach The process might begin with merging arrays into groups of two. After
the first merge, we have k/2 arrays. Again merge arrays in groups, now we have k/4 arrays.
 This is similar to merge sort. Divide k arrays into two halves containing an equal
 number of arrays until there are two arrays in a group. This is followed by merging the
 arrays in a bottom-up manner.

    Algorithm:
1.Create a recursive function which takes k arrays and returns the output array.
2.In the recursive function, if the value of k is 1 then return the array else if the value of k is 2 then merge the two arrays in linear time and return the array.
3.If the value of k is greater than 2 then divide the group of k elements into two equal halves and recursively call the function, i.e 0 to k/2 array in one recursive function and k/2 to k array in another recursive function.
4.Print the output array.
* */
