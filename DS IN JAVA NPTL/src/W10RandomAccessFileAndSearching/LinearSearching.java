package W10RandomAccessFileAndSearching;

public class LinearSearching {
    /*
    1.TAXONOMY OF TYPES OF SEARCHING ==>INTERNAL AND EXTERNAL
    1.INTERNAL SEARCH
        1-Seachrch with key
            A]LINEAR SEARCH
                1.SEQUENTIAL SEARCH
                2.BINARY SEARCH
                3.INTERPOLATION SEARCH
            B]NONLINEAR SEARCH
                1.TREE SEARCH
                    --BST Search
                    --Fibonacci Search
                2.MULTI-WAY TREE SEARCH

        2-Search Without Key
            A]Address CALCULATION SEARCH

    2.EXTERNAL SEARCH
        1-B tree Searching
        2-B+ Tree Searching

------------------------------------------------------------------------------------------------
        2.LINEAR SEARCHING
----------------------------------------------------------------------------------
1.SEQUENTIAL SEARCH---
        • Different studies:
1. Data stored in an array in random order
2. Data stored in an array in a sorted order (ascending order)
3. Data stored in a linked list in random order
4. Data stored in a linked list in a sorted order (ascending order)


        1.Algorithm SearchArrayRandom i.e Linear Search with data stored in Random order:
Input: An array A[1….n] of size n and K is the key to be searched.
Output: A successful message and the location of the array element where K matches, otherwise an
unsuccessful message.
1. i = 1 // Begin search from the first location
2. If (k = A[i]) then
3. Print “Successful” at location i
4. Go to Stop 13 // Termination of search successfully
5. Else
6. i = i+1
7. If (i ≤ n) then
8. Go to Step 2 // Search at the next item
9. Else // Searching comes to an end
10. Print “Unsuccessful”
11. Go to Step 14 // Termination of search unsuccessfully
12. EndIf
13. EndIf
14. Stop
    TIME COMPLEXITY:
• Case 1: The key matches with the first element
T(n) = 1 = O(1)
• Case 2: Key does not exist
T(n) = n = O(n)
• Case 3: The key is present at any location in the array
T(n) = (n+1)/2 = O(n)

        2.Algorithm SearchArraySorted i.e Linear Search with data stored in Sorted order:
Input: An array A[1….n] of size n elements stored in ascending order and K is the key to be searched.
Output: A successful message and the location of the array element where K matches, otherwise an
unsuccessful message.
1. i = 1 // Begin search from the first location
2. If (K = A[i]) then
3. Print “Successful” at location i
4. Go to Stop 13 // Termination of search successfully
5. Else
6. i = i+1
7. If (i ≤ n) OR (K < A[i]) then
8. Go to Step 2 // Search at the next item
9. Else // Searching comes to an end
10. Print “Unsuccessful”
11. Go to Step 14 // Termination of search unsuccessfully
12. EndIf
13. EndIf
14. Stop

        3.Algorithm LinkedListRandomSearch i.e Linear Search with data stored in Random order:
        Input: H is the pointer to the header node and K is the key to be searched.
Output: print a message “successful” if K is present else message “unsuccessful”.
1. ptr = H→LINK // ptr is the pointer variable. Search starts from the first node
2. flag = FALSE // Status of search
3. While (ptr NULL) && (flag = FALSE) do
4. If (ptr→DATA = K) then
5. flag = TRUE // Key is matched
6. Else
7. ptr→LINK // Go to the next node
8. EndIf
9. EndWhile // Linked list traversal is finished
10. If (flag = TRUE) then // K is found
11. Print “Successful”
12. Else // K is not found
13. Print “Unsuccessful”
14. EndIf
15. Stop

        4.Algorithm LinkedListSortedSearch i.e Linear Search with data stored in Sorted order:
     Input: H is the pointer to the header node and K is the key to be searched.
Output: print a message “successful” if K is present else message “unsuccessful”.
1. i = 1 // Begin search from the first location
2. flag = TRUE // Status of search
3. While (flag ≠ FALSE) && (K A[i]) do // Don’t proceed further if K < A[i]
4. If (K = A[i]) then // K is matched
5. flag = FALSE // Search is over
6. Print “Successful at” i
7. Else // Key may be in the range of search
8. i = i + 1 // Go to the next element
If (i > n) then // Check if the next element is beyond the boundary
Break // Quit the program
EndIf
9. EndIf
10. EndWhile
11. If (flag = TRUE) then // Search is failed
12. Print “Unsuccessful”
13. EndIf
14. Stop

  TIME COMPLEXITY:
• Case 1: The key matches with the first element
T(n) = 1 = O(1)
• Case 2: Key does not exist
T(n) = n = O(n)
• Case 3: The key is present at any location in the array
T(n) = (n+1)/2 = O(n)

--------------------------------------------------------------------------------
2.BINARY SEARCH TECHNIQUE------------
        ==>ALGORITHM
Input: An array A[1…n] of n elements and K is the item of search.
Output: If K is present in the array A then print a successful message and return the index where it
is found else print an unsuccessful message and return -1.
1. l =1, u = n // Initialization of lower and upper indexes
2. flag = FALSE // Status of the search, initially false
3. While(flag ≠ TRUE) and (l ≤ u) do
4. // Calculate the index at middle
5. If (K = A[mid]) then // K matches and search is successful
6. Print “Successful”
7. flag = TRUE // Status of the search is now true
8. Return(mid)
9. EndIf
10. If (K < A[mid]) then // Let us check for possibility in left part
11. u = mid-1 // This is the rightmost index of the left-half
12. Else // K > A[mid] and chaeck the possibility at right part
13. l = mid+1 // This is the leftmost index of the right-half
14. EndIf
15. EndWhile
16. If (flag = FALSE) then // Search is failed
17. Print “unsuccessful”
18. Return(-1)
19. EndIf
20. Stop

TIME COMPLEXITY ==>
Let n be the total number of elements in the list under search and there exist an integer k such that
• For successful search:
 If ... , then the binary search algorithm requires at least one comparison and at most k comparisons.
• For unsuccessful search:
 If ..., then the binary search algorithm requires k comparisons.
 If ..., then the binary search algorithm requires either k-1 or k number of comparisons

 • Best case
T(n) = 1
 Worst Case
 T(n) = logb2(n+1)

 -------------------------------------------------------------------------------
 3.INTERPOLATION SEARCH---------
 • The binary search method probes at the center of the region of search.
• It would be better if the locations probed are not at the center rather decided by the key
element itself
• The interpolation search calculates the next probe location using the following
interpolation formula
Location = [(K - Kl)/(Ku - Kl)] x (u - l) + l

ALGORITHM FOR INTERPOLATION SEARCH
Input: An array A[1…n] of n elements and K is the item of search.
Output: If K is found in the array A then print a successful message and return the index where it is
found else print an unsuccessful message and return -1.
Remark: The array A is sorted in ascending order

1. l = 1, u = n // Initialization: Range of searching
2. flag = FALSE // Hold the status of searching
3. While (flag = FALSE) do
4.
5. If ( then // If loc is within the range of the list
6. Case: K < A[loc]
7. u = loc -1
8. Case: K = A[loc]
9. flag = TRUE
10. Case: K > A[loc]
11. l = loc +1
12. Else
13. Exit()
14. EndIf
15. EndWhile
16. If (flag) then
17. Print “Successful at” loc
18. Else
19. Print “Unsuccessful”
20. EndIf
21. Stop

------------------------------------------------------------------------------------------------
        3.NON - LINEAR SEARCHING
----------------------------------------------------------------------------------
    1.BINARY SEARCH TREE SEARCHING
ALGORITHM::Algorithm follows preorder traversal and is defined recursively
Input: A binary tree with PTR as the pointer to a node and K is the element under search.
Output: Returns 1 if K is available, otherwise returns NULL.
1. ptr = PTR // Start from the current node of the binary tree
2. If (ptr NULL) then
3. If (ptr→DATA = K) then // Visit: Check the element in the current node
4. Return (1) // Return the status of search
5. Else
6. BinaryTreeSearch (ptr→LC) // Then search eft sub tree in preorder
7. BinaryTreeSearch (ptr→RC) // Then search right sub tree in preorder
8. EndIf
9. EndIf
10. Stop

    2.FIBBONACCI SEQUENCE*********************
    Fibonacci sequence:
• The n-th Fibonacci number in a binary Fibonacci series is given by
Fn = Fn+1 + Fn-2 with F1 = 1 , F0 = 0

Rule 1:
• For all leaf nodes corresponding to F1 and F0, we denote them as external nodes
and redraw them as squares, and value of each external node is set to zero

Rule 2:
• For all nodes corresponding to Fi (i ≥ 2), each of them as a Fibonacci search tree of order i such that
 the root is Fi
 the left sub tree is a Fibonacci search tree of order i-1,
 the right sub tree is a Fibonacci search tree of order i-2 with all numbers increased by Fi.

  All elements are stored in sorted order. Number of elements n is related to a perfect Fibonacci
number Fk+1, such that Fk+1 = n+1

ALGORITHM ==>
Initialization
1. i = Fk // Start at Fk-th location
2. p = Fk-1, q = Fk-2 // Pointers to the left and right sub trees of the node Fk
            3. If (K<Ki
                   ) then // Compare the key K with the value at i-th location
4. If (q = 0) then
5. Print “Unsuccessful”
            6. Return() // Serach is over
7. Else
8. i = i-q, pold = p, p = q, q = pold -q // Go to left sub tree
9. Go to Step 3
            10. EndIf
11. EndIf
12. If (K>Ki
    ) then
13. If (p = 1) then
14. Print “Unsuccessful”
            15. Return() // Search is unsuccessfully terminated
16. Else
17. i = i+q, p = p+q, q = q-p // Go to right sub tree
18. Go to Step 3
            19. EndIf
20. EndIf
21. If (K = Ki
    ) then
22. Print “Successful at i-th location”
            23. EndIf
24. Stop



ADVANTAGE OF OPPEN HASHINGG
Overflow situation never arises. Hash table maintains lists which can contain any number of key
values.
2. Collision resolution can be achieved very efficiently if the lists maintain an ordering of keys, so
that keys can be searched quickly.
3. Insertion and deletion become quick and easy task in open hashing. Deletion proceeds in
exactly the same way as deletion of a node in single linked list.
4. Finally, open hashing is best suitable in applications where number of key values varies
drastically as it uses dynamic storage management policy.


Size of the hash table
Total number of key values /
* */

}
//1.PROGRAM FOR INEAR SEARCH ALGORITHM
/* This program search an array of elements. The program works well whether
the array elements are in sorted order or not. */
class LinearSearch<T extends Comparable<T>> { //Except user def,all data types are comparable
    public int search(T[] arr, T x, int len) {
        for(int i = 0; i < len; i++) {
            if(arr[i] == x)//simple search
                return i;
        }
        return -1;
    }

    public int sortedsearch(T[] arr, T x, int len) {
        for(int i = 0; i < len; i++) {
            if((arr[i] == x))
                return i;
            if((arr[i].compareTo(x) > 0))//simple ascending sorted search
                return -1;

         }
        return -1;
    }
}

class LinearSearchDemo {
    public static void main(String args[]) {
        LinearSearch<Integer> l = new LinearSearch<Integer>();
        Integer arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        Integer x = 11;
// Integer result = search(arr, x, n);
        if(l.sortedsearch(arr, x, n) == -1)
            System.out.print("Element is not present in array");
        else
            System.out.print("Element is present at index " + l.sortedsearch(arr, x, n));
    }
}

//2.PROGRAM FOR BINARY SEARCH
/* This program implements the Binary Search Algorithm over an array of sorted numbers. */
class BinarySearch<T extends Comparable<T>> {
    int binarySearch(T[] arr, int l, int r, T x,boolean b) {

        if (r >= l) {
            int mid = l + (r - l) / 2;
// If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;
            if (b == true) {
// If element is smaller than mid, then it can only be present in left subarray
                if (arr[mid].compareTo(x) == 1)
                    return binarySearch(arr, l, mid - 1, x, b);
// Else the element can only be present in right subarray
                return binarySearch(arr, mid + 1, r, x, b);
            }
            if (b==false){
 // If element is greater than mid, then it can only be present in left subarray
                if (arr[mid].compareTo(x) == -1)
                    return binarySearch(arr, l, mid - 1, x, b);
// Else the element can only be present in right subarray
                return binarySearch(arr, mid + 1, r, x, b);
            }
        }
// We reach here when element is not present in array
        return -1;
    }
}
class BinarySearchDemo{
    // Driver method to test above
    public static void main(String args[])
    {
        BinarySearch<Integer> ob = new BinarySearch<Integer>();
        Integer arr[] = { 2, 3, 4, 10, 40 };
        Integer arr2[] = {40,10,4,3,2};
        int n = arr.length;
        Integer x = 10;
        boolean b = false;//ascending == true
        int result = ob.binarySearch(arr2, 0, n - 1, x, b);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}

/*• The binary search method probes at the center of the region of search.
• It would be better if the locations probed are not at the center rather decided by the key
element itself.
* */
//3.INTERPOLATION SEARCH PROGRSSM
/* Interpolation Search with Generic type. */
class InterpolationSearch<T extends Number & Comparable<T>>{
    //Declaring an array, which should store any type T of data
    T a[ ]; // Define that the array a[ ] can store any type of data
    InterpolationSearch(T x[]) { // Define a constructor
        a = x;
    }
    T getData(int i) { // To return the element stored in the i-th place in the array
        return a[i];
    }
    void printData() { // A generic method to print the elements in array a
        for(int i = 0; i < a.length; i ++)
            System.out.print(getData(i) + " "); // Print the i-th element in a
        System.out.println(); // Print a new line
    }
    T sub(T x, T y) {
        if (x == null || y == null)
            return null;
        if (x instanceof Double)
            return (T) new Double(x.doubleValue() - y.doubleValue());
        if (x instanceof Integer)
            return (T) new Integer(x.intValue() - y.intValue());
        if (x instanceof Short)
            return (T)new Integer(x.shortValue() - y.shortValue());
        if (x instanceof Byte)
            return (T)new Integer(x.byteValue() - y.byteValue());
        if (x instanceof Float)
            return (T)new Float(x.floatValue() - y.floatValue());
        if (x instanceof Long)
            return (T)new Long(x.longValue() - y.longValue());
        else
            throw new IllegalArgumentException("Type " + x.getClass() + " is not supported");
    }
    int interpolationSearch(T k) {
        int l=0,u=a.length-1;
        while(l<=u && k.compareTo(a[l])>=0 && k.compareTo(a[u])<=0) {
            if (l == u) {
                if (a[l].compareTo(k)==0) return l;
                return -1;
            }
//int loc=((k-a[l])/(a[u]-a[l]))*(u-l)+l;
            int n=sub(k,a[l]).intValue();
            int d=sub(a[u],a[l]).intValue();
            int loc=(n/d)*(u-l)+l;
            int result=k.compareTo(a[loc]);
            if(result==-1) u=--loc;
            else if (result==0) return loc;
            else l=++loc;
        }
        return -1;
    } // End of the method interpolationSerach
} // End of the class InterpolationSerach

//DRIVER OROGRAM
 class InterpolationSearchDemo {
    public static void main(String[] args){
// Searching with integer data
        Integer i[ ] = {10, 20, 30, 40, 50};
// Store the data into generic array
        InterpolationSearch<Integer> arrayInt = new InterpolationSearch<Integer>(i);
// Printing the data….
        arrayInt.printData();
        int searchInt=20;
        int pos=arrayInt.interpolationSearch(searchInt);
        if(pos==-1)
            System.out.println(searchInt+" not found in the array");
        else
            System.out.println(searchInt+" found at position "+pos);
        System.out.println();
// Continued to next...
// Searching with float values
        Double d[ ] = {10.5, 20.5, 30.5, 40.5, 50.5};
// Store the data into generic array
        InterpolationSearch<Double> arrayDouble = new InterpolationSearch<Double>(d);
// Printing the data….
        arrayDouble.printData();
        Double searchDouble=30.5;
        pos=arrayDouble.interpolationSearch(searchDouble);
        if(pos==-1)
            System.out.println(searchDouble+" not found in the array");
        else
            System.out.println(searchDouble+" found at position "+pos);
        System.out.println();
// Continued to next...
        // Searching with short values
        Short s[ ] = {10, 20, 30, 40, 50};
// Store the data into generic array
        InterpolationSearch<Short> arrayShort = new InterpolationSearch<Short>(s);
// Printing the data….
        arrayShort.printData();
        Short searchShort=40;
        pos=arrayShort.interpolationSearch(searchShort);
        if(pos==-1)
            System.out.println(searchShort+" not found in the array");
        else
            System.out.println(searchShort+" found at position "+pos);
        System.out.println();
// Continued to next...
        // Searching with byte values
        Byte b[ ] = {10, 20, 30, 40, 50};
// Store the data into generic array
        InterpolationSearch<Byte> arrayByte = new InterpolationSearch<Byte>(b);
// Printing the data….
        arrayByte.printData();
        Byte searchByte=50;
        pos=arrayByte.interpolationSearch(searchByte);
        if(pos==-1) System.out.println(searchByte+" not found in the array");
        else System.out.println(searchByte+" found at position "+ pos);
        System.out.println();
    } // End of the main method
} // End of the class InerpolationSearchDemo
