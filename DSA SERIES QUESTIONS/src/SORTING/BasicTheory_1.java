package SORTING;

public class BasicTheory_1 {
}
/*
==>What are Internal and External Sortings?
When all data that needs to be sorted cannot be placed in-memory at a time, the sorting is called external sorting. External Sorting is used for massive amount of data. Merge Sort and its variations are typically used for external sorting. Some external storage like hard-disk, CD, etc is used for external storage.
When all data is placed in-memory, then sorting is called internal sorting.

==>Stability in sorting algorithms
Stability is mainly important when we have key value pairs with duplicate keys possible (like people names as keys and their details as values). And we wish to sort these objects by keys.

What is it?
A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in the input array to be sorted.
Formally stability may be defined as,
Let A be an array, and let < be a strict weak ordering on the elements of A.
A sorting algorithm is stable if-
i < j  and  A[i]\equiv A[j] implies pi (i) < \pi (j)
where \pi is the sorting permutation ( sorting moves A[i] to position \pi(i) )
Informally, stability means that equivalent elements retain their relative positions, after sorting.

Do we care for simple arrays like array of integers?
When equal elements are indistinguishable, such as with integers, or more generally, any data where the entire element is the key, stability is not an issue. Stability is also not
an issue if all keys are different.
Here the relative order between different tuples is maintained. It may be the case that the relative order is maintained in an Unstable Sort but that is highly unlikely.

Which sorting algorithms are stable?
Some Sorting Algorithms are stable by nature, such as Bubble Sort, Insertion Sort, Merge Sort, Count Sort etc.
Comparison based stable sorts such as Merge Sort and Insertion Sort, maintain stability by ensuring that-
Element A[j] comes before A[i] if and only if A[j] < A[i], here i, j are indices and i < j.
Since i<j, the relative order is preserved if A[i]\equiv A[j] i.e. A[i] comes before A[j].
Other non-comparison based sorts such as Counting Sort maintain stability by ensuring that the Sorted Array is filled in a reverse order so that elements with equivalent keys have
the same relative position.
Some sorts such as Radix Sort depend on another sort, with the only requirement that the other sort should be stable.

Which sorting algorithms are unstable?
Quick Sort, Heap Sort etc., can be made stable by also taking the position of the elements into consideration. This change may be done in a way which does not
compromise a lot on the performance and takes some extra space, possibly \theta(n).

Can we make any sorting algorithm stable?
Any given sorting algo which is not stable can be modified to be stable. There can be sorting algo specific ways to make it stable, but in general, any comparison based sorting algorithm
which is not stable by nature can be modified to be stable by changing the key comparison operation so that the comparison of two keys considers position as a factor for objects with equal keys

* */
