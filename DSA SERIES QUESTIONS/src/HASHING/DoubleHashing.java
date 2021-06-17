package HASHING;

public class DoubleHashing {
        static final int TABLE_SIZE = 13;
        static final int PRIME = 7;
        static int currSize = 0;
    static int[] hashTable = new int[TABLE_SIZE +1];

        static boolean isFull(){
            return currSize == TABLE_SIZE;
        }

        static int hash1(int key){
            return (key % TABLE_SIZE);
        }

        static int hash2(int key){
            return PRIME - (key%PRIME);
        }

        static void doubleHash(){

        }


    static void insertHash(int key) {
        // if hash table is full
        if (isFull())
            return;
// get index from first hash
        int index = hash1(key);

        //if collision occurs
        if (hashTable[index] != 0) {
            int index2 = hash2(key);
            int i = 1;
            while (true) {
                // get newIndex
                int newIndex = (index + i * index2) % TABLE_SIZE;

                // if no collision occurs, store
                // the key

                if (hashTable[newIndex] != 0) {
                    hashTable[newIndex] = key;
                    break;
                }
                i++;

            }
        } else {
            //if no collision occurs
            hashTable[index] = key;
        }
        currSize++;
    }


  static   void search(int key){
        int index1 = hash1(key);
        int index2 = hash2(key);
        int i = 0;
        int hashIndex = (index1 + i*index2)%TABLE_SIZE;

        while (hashTable[hashIndex]!= key){
            if (hashTable[hashIndex] == 0){
                System.out.println(key+" does not exist in hashtable");
                return;
            }
            i++;
        }
        System.out.println(key+" is Present at index : "+(hashIndex-1));
    }

   static void displayHash() {
        for (int i = 0; i <TABLE_SIZE; i++) {
            if (hashTable[i] == 0){
                System.out.println("Index "+i+" = "+hashTable[i]);
            }else {
                System.out.println("Index "+i+" = "+hashTable[i]);
            }
        }

    }

            public static void main(String[] args) {
        int a[] = { 19, 27, 36, 10, 64 };
        int n = a.length;

        // inserting keys into hash table
        for (int i = 0; i < n; i++) {
            insertHash(a[i]);
        }

        // searching some keys
        search(36); // This key is present in hash table
       // search(27);
        search(100); // This key does not exist in hash table

        displayHash();



    }
}

/*THEORY
Double hashing is a collision resolving technique in Open Addressed Hash tables.
Double hashing uses the idea of applying a second hash function to key when a collision occurs.

Double hashing can be done using :
(hash1(key) + i * hash2(key)) % TABLE_SIZE
Here hash1() and hash2() are hash functions and TABLE_SIZE
is size of hash table.
(We repeat by increasing i when collision occurs)

==>First hash function is typically hash1(key) = key % TABLE_SIZE

==>A popular second hash function is : hash2(key) = PRIME – (key % PRIME)
 where PRIME is a prime smaller than the TABLE_SIZE.

==>A good second Hash function is:
It must never evaluate to zero
Must make sure that all cells can be probed



















* */

