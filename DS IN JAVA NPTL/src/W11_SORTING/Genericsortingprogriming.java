package W11_SORTING;
import java.math.*;

public class Genericsortingprogriming {
}
//1.INSERTION SORT
class InsertionSort <T extends Comparable<T>> {
    public static  <T extends Comparable> void insertionSort(T[] arr, int len){
        for (int i = 0; i < len; i++){
            int j = i;
            while (j > 0 && arr[j].compareTo(arr[j-1]) > -1){
                T temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j= j-1;
            }
        }
    }
    public static <T> void printArray(T[] arr, int len) {
        for(int i=0; i<len; i++) {
            System.out.print(arr[i] + " ");

        }
    }
// Continued to next...
/* The main method to test the program. */
public static void main(String[] args) {
    Integer[] arr = {89,45,95,63,23,41,13,78};
    int n = arr.length;

    System.out.println("Given Array:");
    printArray(arr, n);
    insertionSort(arr, n);
    System.out.println("\nAfter sorting:");
    printArray(arr, n);
}
} // End of the program

//2.SELECTION SORT
class SelectionSort <T extends Comparable<T>> {
    public static <T extends Comparable>void selectionSort(T[] arr, int len){
        for(int i=0; i<(len-1); i++){
            int minIndex = i;
            for(int j=i+1; j<len; j++){
                if(arr[minIndex].compareTo((arr[j])) > 0 ){
                    minIndex = j;
                }
            }
            T temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    /* The following method is an auxiliary method to print an array. */
    public static <T> void printArray(T[] arr, int len) {
        for(int i=0; i<len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    /* The main method to test the program. */
    public static void main(String[] args) {
        Integer[] arr = {89,45,95,23,41,13,63};
        int n = arr.length;
        System.out.println("Given Array:");
        printArray(arr, n);
        selectionSort(arr, n);
        System.out.println("\nAfter sorting:");
        printArray(arr, n);
    }
} // End of the program

//3.BUBBLE SORT
class GenericArraySorting<T extends Comparable<T>> {
    T a[];
    GenericArraySorting(T x[]) { // Define a constructor
        a = x;
    }
    T getData(int i) { // To return the element stored in the i-th place
        return a[i];
    }
    void printData() { // A method to print the elements in array a
        for(int i = 0; i < a.length; i ++)
            System.out.print(this.getData(i) + " "); // Print the i-th element
        System.out.println();
    }
    /* The following method implements the Bubble sort algorithm. */
    void bubbleSort(){
        T temp;
        boolean swapped = true;
        for(int i=0;i<this.a.length-1 && swapped;i++) {
            swapped=false;
            for(int j=0;j<this.a.length-i-1;j++) {
                if(a[j].compareTo(a[j+1])>0) {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    swapped=true;
                }
            }
        }
    } // End of the Bubble sort method
} // End of the generic class definition
/* The main method to test the program. */
 class TestBubbleSort {
    public static void main(String[] args){
        Integer i[ ] = {59, 44, 79, 74, 88};
// Store the data into generic array
        GenericArraySorting<Integer> arrayInt = new GenericArraySorting<Integer>(i);
// Printing the data….
        System.out.print("Array Before Sorting : ");
        arrayInt.printData();
        arrayInt.bubbleSort();
        System.out.print("Sorted Array is : ");
        arrayInt.printData();
        System.out.println();
    }
} // End of the program

//4.HEAP SORT
/* This program defines a generic class to store a collection. */
 class MinHeap<T extends Comparable<T>> {
    private T[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 0;
    public MinHeap(T[] arr , T node)
    {
        this.maxsize = arr.length;
        this.size = 0;
        Heap = arr;
        Heap[0] = node;
    }
    /* The following are some auxiliary methods. */
// Function to return the position of the parent for the node currently at pos
    private int parent(int pos) {
        return pos / 2;
    }
    // Function to return the position of the left child for the node currently at pos
    private int leftChild(int pos) {
        return (2 * pos);
    }
    // Function to return the position of the right child for the node currently at pos
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }
    /* The following are some auxiliary methods. */
// Function that returns true if the passed node is a leaf node
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos) {
        T tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    /* The following is the method to print a heap tree. */
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }
    // Function to build the min heap using the minHeapify
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }
    /* The following is the method to heapify the tree. */
    private void minHeapify(int pos) {
// If the node is a non-leaf node and greater than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos].compareTo(Heap[leftChild(pos)]) > 0
                    || Heap[pos].compareTo(Heap[rightChild(pos)]) > 0) {
// Swap with the left child and heapify the left child
                if (Heap[leftChild(pos)].compareTo(Heap[rightChild(pos)]) < 0) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
// Swap with the right child and heapify the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    /* The following is the method to insert a node into the heap tree. */
    public void insert(T element) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;
        while (Heap[current].compareTo(Heap[parent(current)]) < 0 ){
            swap(current, parent(current));
            current = parent(current);
        }
    }
    /* Function to remove and return the minimum
element from the heap */
//
    public T remove() {
//System.out.print(size);
        T popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }
    /* Sorting with themean heap. */
    public T[] sort(T sorted[]){
//System.out.print(maxsize);
        int i = 0;
        while(size>=0){
            T a = remove();
            sorted[i] = a;
            i++;
        }
        for(int j = 0;j<i;j++) {
            System.out.print(sorted[j] + " ");
        }
        return sorted;
    }
    /* The main method to test the program. */
    public static void main(String[] arg)
    {
        System.out.println("The Min Heap is ");
        Integer[] a = new Integer[15];
        MinHeap minHeap = new MinHeap(a , 5 );
//minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();
        minHeap.print();
    }
} // End of the program

/*RADIX SORT ALGORITHM :
IT IS NOT GOOD FOR MEMORY CONSTRAINT ENVIRONMENT ::

1. For i =1 to c do // c denotes the most significant
position
2. For j =1 to n do // For all elements in the array
A
3. x = Extract(A[j], i) /. ./ Get the i-th component in the j-th
element
4. Enque(Qx, A[j])
5. EndFor
 Combine all elements from all auxiliary arrays to A (assume A is empty
6. For k = 0 to (b-1) do
        7. While Qk is not empty do
        8. y = Dequeue(Qk) // Dequeue of y from the queue
        Qk
        9. Insert(A, y) // Insert y into A
        10. EndWhile
        11. EndFor
        12. EndFor
        13. Stop
* */
//PROGRAM FOR RADIX SORT ======CHECK ITT
/* This program defines a generic class to store a collection. */
class GenericArraySorting2<T extends Comparable<T>> {
    T a[];
    GenericArraySorting2(T x[]) { // Define a constructor
        a = x;
    }
    T getData(int i) { // To return the element stored in the i-th place
        return a[i];
    }
    void printData() { // A method to print the elements in array a
        for (int i = 0; i < a.length; i++)
            System.out.print(this.getData(i) + " "); // Print the i-th element
        System.out.println();
    }
        /* This program sorts an array of data using Insertion sort technique. */
     /*   T division(T x, int y) {
            if (x == null || y == 0)
                return null;
            if (x instanceof Integer)
                return (T)new Integer(((Integer) x).intValue() / y);
            if (x instanceof Short)
                return (T)new Integer(x.shortValue() / y);
            if (x instanceof Byte)
                return (T)new Integer(x.byteValue() / y);
            if (x instanceof Long)
                return (T)new Long(x.longValue() / y);
            else
                throw new IllegalArgumentException("Type " + x.getClass() + " is not supported.");
        }*/
    /* This program find a constituent element. */
   /* T modulus(T x, int y) {
        if (x == null || y == 0)
            return null;
        if (x instanceof Integer)
            return (T)new Integer(x.intValue() % y);
        if (x instanceof Short)
            return (T)new Integer(x.shortValue() % y);
        if (x instanceof Byte)
            return (T)new Integer(x.byteValue() % y);
        if (x instanceof Long)
            return (T)new Long(x.longValue() % y);
        else
            throw new IllegalArgumentException("Type " + x.getClass() + " is not supported.");
    }*/
    /* This program is tpo do bucketing */
    T getMax(){
        T max=a[0];
        for(int i=1;i<a.length-1;i++) {
            if(a[i].compareTo(max)==1)
                max=a[i];
        }
        return max;
    }
    private static <T> T[] copyArray(T[] source) {
        return source.clone();
    }
    /* This program to sort the elements in bucket */
   /* void countSort(int exp) {
        int i,size=a.length,count[]=new int[10];
        T[] output=copyArray(a);
        for(i=0;i<size;i++)
            count[modulus(division(a[i],exp),10).intValue()]++;
        for(i=1;i<10;i++)
            count[i]+=count[i-1];
        for(i=size-1;i>=0;i--) {
            output[count[modulus(division(a[i],exp),10).intValue()]-1]=a[i];
            count[modulus(division(a[i],exp),10).intValue()]--;
        }
        for(i=0;i<size;i++)
            a[i]=output[i];
    }*/
    /* This program find a constituent element. */
   /* void radixSort(){
        int exp=1;
        T max=this.getMax();
        Long m=new Long(division(max,exp).longValue());
        for(;m>0;exp=exp*10){
            this.countSort(exp);
            m=division(max,exp).longValue();
        }
    }*/
} // End of the generic class definition
// Continued to next...
 class TestRadixSort{
    public static void main(String[] args) {
        Integer i[ ] = {59, 44, 79, 74, 88};
// Store the data into generic array
        GenericArraySorting2<Integer> arrayInt = new GenericArraySorting2<Integer>(i);
// Printing the data….
        System.out.print("Array Before Sorting : ");
        arrayInt.printData();
        //arrayInt.radixSort();
        System.out.print("Sorted Array is : ");
        arrayInt.printData();
        System.out.println();
    }
}
/*QUICK SORT ALGORITHM----------------------------------------------------
1. loc = left / / The left most element is chosen as the pivot element
2. While ((left < right) do // Repeat until the entire list is scanned
3. While(A[loc] ≤ A[right]) and (loc < right) do // Scan from right to left
4. right = right -1 // No interchange. Move from left to right
5. EndWhile
6. If (A[loc] > A[right]) then
7. Swap(A[loc], A[right]) // Interchange the pivot and the element at right
8. loc = right // The pivot is not at the location right
9. left = left +1 // Next scan (left to right) begins from this location
10. EndIf
11. While(A[loc] ≥ A[left]) and (loc > left) do // Scan from left to right
12. left = left +1 // No interchange. Move from right to left
13. EndWhile
14. If (A[loc] < A[left]) then
15. Swap(A[loc],A[left]) // Interchange the pivot and the element at left
16. loc = left // The pivot is not at the location left
17. right = right-1 // Next scan (right to left) begins from this location
18. EndIf
19. EndWhile
20. Return (loc)
21. Stop

---PARTITION ALGORITHM -- BEST ONE
1. Loc = Partition(left, right) // left and right are two pointers to locate partitions
// at left and right, respectively
2. If (left < right) then // Check for the termination condition
3. QuickSort(A, left, loc-1) // Perform quick sort over the left sub list
4. QuickSort(A, loc+1, right) / Perform quick sort over the right sub-list
5. EndIf
6. Stop

TRY ON YOUR OWN-----------------
* */

/*MERGE SORT ALGORITHM----------------------------------
1. i = 1, j = 1, k = 1 // Three pointers, initially point to first locations
2. While(i ≤ n1 and j ≤ n2) do
3. If (A[i] ≤ B[j]) then
4. C[k] = A[i]
5. i = i+1, k = k+1
6. Else // A[i] > B[j]
7. C[k] = B[j]
8. j = j+1, k = k+1
9. EndIf
10. EndWhile
11. If (i > n1) then // A is fully covered
12. For p = j to n2 do // Move the rest of the elements in B to C
13. C[k] = B[p]
14. p = p+1, k = k+1
15. EndFor
16. Else
17. If (j > n2 ) then // B is fully covered
18. For p = i to n1 do
19. C[k] = A[l] // Move the rest of the elements in A to C
20. p = p + 1, k = k + 1
21. EndFor
22. EndIf
23. EndIf
24. Stop

Input: An array A[l…r] where l and r are the lower and upper indexes of A.
Output: Array A[l…r] with all elements are arranged in ascending order.
Algorithm MergeSort(A[l…r])
1. If (r l) then
2. Return // Termination of recursion
3. Else
4.
// Divide: Find the index of the middle of the list
5. MergeSort(A[l…mid]) // Conquer for the left-part
6. MergeSort(A[mid+1…r]) // Conquer for the right-part
7. Merge(A, l, mid, r) // Combine: Merging the sorted left- and right- parts
8. EndIf
9.Stop
* */







