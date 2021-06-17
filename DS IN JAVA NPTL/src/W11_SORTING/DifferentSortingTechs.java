package W11_SORTING;



public class DifferentSortingTechs {
    /*
    SORTING ==> TWO TYPES, INTERNAL & EXTERNAL
        ==>1.INTERNAL
            =>1]SORTING BY COMPARISON
                1.INSERSION
                    1]SStraight insertion sort[SIMPP]
                    2]Binary insertion sort
                    3]Two-way insertion sort
                    4]List insertion sort
                2.SELECTION
                    1]Straight selection sort[SIMPP]
                    2]Tree Selection sort
                    3]Heap sort[IMPPP]
                3.EXCHANGE
                    1]Bubblee sort[SIMPP]
                    2]Shell sort
                    3]Quick SOrt [ADVV]
                4.MERGE [ADVV]
                    1]Simple MERGE SORT
                    2]2-Way MERGE SORT

            =>2]SORTING BY DISTRIBUTION
                1.RADIX SORT[IMPP]
                2.BUCKET SORT
                3.COUNTING SORT


       ==> 2.EXTERNAL
            1]EXTERNAL MERGE SORT
            2]2-WAY MERGE SORT
            3]MULTI-WAY MERGE SORT
            4]POLYPHASE MERGE SORT

SIMPP=>Simple sorting techniques,=Insertion,Selection,Bubble
IMPP=>Improved sorting techniques,=Heap,Radix
ADVV=>Advanced sorting techniques,=Merque,Quick
-----------------------------------------------------------------------------
1.Insertion sort: Algorithm
==>Here each element is compared woh all the elements, if it is foumd grreater or smaller
as given, than the element than swap it with the found element ans move each element on index forwrd

1. B[1]=A[1] // Initially first element in the input list is the first element in the output list
2. For j = 2 to N do // Continue taking one key at a time from the input list
Select the key K from the input list
3. K = A[j] // K is the key under insertion
             Search the final location i in the output list
            4. flag = TRUE // To control the number of scan in the output list
5. i = j-1 // Points the rightmost element in the output list
            6. While (flag = TRUE) do // Scan until we get the place for K
            7. If (K < B[i]) then
8. i = i-1
            9. If (i = 0) then // Stop if the list is exhausted
10. flag = FALSE
11. EndIf
12. Else
13. flag = FALSE // Stop here
14. EndIf
15. EndWhile
     Move to right one place all the keys from and after i+1
16. p = j
17. While (p>i+1) do
            18. B[p] = B[p-1]
            19. p = p-1
            20. EndWhile
     Insert the keys at i+1 th place
21. B[i+1] = K // Insert the key at the (i+1)-th place
22. EndFor
23. Stop
----------------COMPLEXITY:
Case 1: The input list is already in sorted order
T(n) = 1 + 1 + 1+ … up to (n-1)-th iteration
     = n-1
Case 2: The input list is stored but in reverse order
T(n) =1+ 2 + 3 +... + (n -1)
    =n(n-1)/2
Case 3: Input list is in random order
T (n) = (n-1)(n+4)/4
--------------------------------------------------------------------------------

2.SELECTION SORT
In each itration we find the minimum and place it in first posiontoin then again start iter from
2ns position and repeat the steps till n-1 pass is achieved

SELECTION ALGORITHM

Algortihm SelectionSort(A,n)
1. For i = 1 to (n-1) do // (n-1) iterations
2. j = SelectMin(i, n) // Select the smallest from the remaining part
of the list
3. If (i ≠ j) then // Interchange when the minimum is
in remote
4. Swap(A[i], A[j])
5. EndIf
6. EndFor
7. Stop

Algorithm SelectMin (L, R)
1. min = A[L] // Initially, the item at the starting location is chosen as the
smallest
2. minLoc = L // minLoc record the location of the
minimum
3. For i = L+1 to R do // Search the entire
part
4. If (min > A[i]) then
5. min = A[i] // Now the smallest is updated
here
6. minLoc = i // New location of the smallest so
far
7. EndIf
8. EndFor
7. Return(minLoc) // Return the location of the smallest
element
9. Stop

Algorithm Swap (X, Y)
1. X = X + Y // X holds total of the both the values
2. Y = X – Y // Y now holds the previous value of X
3. X = X – Y // X now holds the previous value of Y
4. Stop

COMPLEXITY
Case 1: The input list is already in sorted order
T(n) = (n -1) + (n - 2) + ....+ (n - (n - 2))+ (n - (n -1)) =n(n-1)/ 2 ==O(n2)

Case 2: The input list is stored but in reverse order
T(n) = n(n -1)/2  ==O(n2)
Case 3: Input list is in random order
T(n) = n(n -1)/2  ==O(n2)

---------------------------------------------------------------------------------
3.BUBBLE SORT
Lighter bubbles should go to top and heavier bubble goes down
Here in each itertion from j=0 to j=n-i, heavier bubble goes to n-i th position and loop repeates

Algorithm BubbleSort (A, n)
1. For i =1 to n-1 do // Outer loop with n-1 passes
2. For j = 1 to n-i do // Inner loop: in the i-th pass
3. If (A[j] > A[j+1] ) then // Check if two elements are out of order
4. Swap(A[j], A[j+1]) // Interchange A[j] and A[j+1]
5. EndIf
6. j = j + 1 // Move to the next elements
7. EndFor
8. EndFor
9. Stop

Algo Swap(X,Y)
1. temp = X // Store the value in X in a temporary storage space
2. X = Y // Copy the value of Y to X
3. Y = temp // Copy the value in temp to Y
4. Stop

COMPLEXITY
Case 1: The input list is already in sorted order
T(n) = (n -1) + (n - 2) + ....+ (n - (n - 2))+ (n - (n -1)) =n(n-1)/ 2 ==O(n2) ==FUNNEL SORT = O(n)
Case 2: The input list is stored but in reverse order
T(n) = n(n -1)/2  ==O(n2)
Case 3: Input list is in random order
T(n) = n(n -1)/2  ==O(n2)

    * */
}
//1.sort-my progs
class Sorting{

    static <T extends Comparable>void insertionSort(T[] arr, int size){
        T key;
                int j;
        for (int i=1;i<size;i++){
            key = arr[i];

            j = i-1;
            while( j >= 0 && arr[j].compareTo(key) == 1){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }

    }
   static void selectionSort(int[] arr, int size){
        int j;
        for (int i=1;i<size;i++){
            for (j=i+1;j<size;j++) {
                if (arr[j]<arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }


            }
       for (int i=1;i<size;i++)
           System.out.print(arr[i]+" ");

    }

    public static void main(String[] args) {
        //int[] arr = {5,3,8,89,4,2,1};
        //Integer[] arr2 = {2,7,3,7,9};
        Double[] arr2 = {1.1,9.9,8.88,8.87,7.98,9.99};
        int size = arr2.length;
        //selectionSort(arr,size);
        System.out.println("Before Calling inseriton sort : ");
        for (int i=0;i<size;i++)
        System.out.print(arr2[i]+" ");
        insertionSort(arr2,size);

        System.out.println();
        System.out.println("After sorting");
        for (int i=0;i<size;i++)
            System.out.print(arr2[i]+" ");
    }
}
