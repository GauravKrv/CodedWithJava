package HASHING;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChainingUsingArrayList {
    //Function to insert elements of array in the hashTable avoiding collisions.
    public static ArrayList<ArrayList<Integer>> separateChaining(int arr[], int n, int hashSize)
    {
        //Your code here
        ArrayList<ArrayList<Integer>> hashtable = new ArrayList<ArrayList<Integer>>(hashSize);
        for(int i =0; i<hashSize;i++){
            hashtable.add(i,new ArrayList<Integer>());
        }
        for(int i = 0;i<n; i++){
            int key = arr[i]%hashSize;
            hashtable.get(key).add(arr[i]);
        }

        return hashtable;
    }


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int hashSize = Integer.parseInt(br.readLine().trim());
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            ArrayList<ArrayList<Integer>> res  = separateChaining(arr, n, hashSize);

            for(int i=0;i<res.size();i++) {
                if(res.get(i).size()>0) {
                    System.out.print(i+"->");
                    for(int j=0; j<res.get(i).size()-1; j++) {
                        System.out.print(res.get(i).get(j) + "->");
                    }
                    System.out.print(res.get(i).get(res.get(i).size()-1));
                    System.out.println();
                }
            }
        }
    }

}

/*THEORY :
What is Collision?
Since a hash function gets us a small number for a key which is a big integer or string,
 there is a possibility that two keys result in the same value. The situation where a
 newly inserted key maps to an already occupied slot in the hash table is called
 collision and must be handled using some collision handling technique.

 How to handle Collisions?
There are mainly two methods to handle collision:
1) Separate Chaining
2) Open Addressing\

Separate Chaining:
The idea is to make each cell of hash table point to a linked list of records that have
same hash function value.

Advantages:
1) Simple to implement.
2) Hash table never fills up, we can always add more elements to the chain.
3) Less sensitive to the hash function or load factors.
4) It is mostly used when it is unknown how many and how frequently keys may be inserted or deleted.

Disadvantages:
1) Cache performance of chaining is not good as keys are stored using a linked list. Open addressing
provides better cache performance as everything is stored in the same table.
2) Wastage of Space (Some Parts of hash table are never used)
3) If the chain becomes long, then search time can become O(n) in the worst case.
4) Uses extra space for links.

Performance of Chaining:
Performance of hashing can be evaluated under the assumption that each key is equally likely to be
 hashed to any slot of table (simple uniform hashing).
m = Number of slots in hash table
 n = Number of keys to be inserted in hash table
Load factor α = n/m

 Expected time to search = O(1 + α)

 Expected time to delete = O(1 + α)

Time to insert = O(1)
Time complexity of search insert and delete is
 O(1) if  α is O(1)


* */
