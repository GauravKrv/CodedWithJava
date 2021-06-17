package SORTING;

public class BasicTheory_3 {
}
/*EXTERNAL SORTING :
External sorting is a term for a class of sorting algorithms that can handle massive
amounts of data. External sorting is required when the data being sorted do not fit
into the main memory of a computing device (usually RAM) and instead, they must reside
in the slower external memory (usually a hard drive). External sorting typically uses
 a hybrid sort-merge strategy. In the sorting phase, chunks of data small enough to fit
 in main memory are read, sorted, and written out to a temporary file. In the merge
 phase, the sorted sub-files are combined into a single larger file.

One example of external sorting is the external merge sort algorithm, which sorts
chunks that each fit in RAM, then merges the sorted chunks together. We first divide
the file into runs such that the size of a run is small enough to fit into main memory.
Then sort each run in main memory using merge sort sorting algorithm. Finally merge the
 resulting runs together into successively bigger runs, until the file is sorted.




* */
