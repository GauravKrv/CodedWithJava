package DIV2_751;

import DIV_111_EDUROUND.CodeForces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
// works for testcase 1 and 2 individually
// count need to be optimised
//took 1.5hrs till here
//TOOK 2.5hrs till here
//work on out of bounds areas , approach is good, check for optimised helper functions

//give 2hrs more to this question -- test timint 1.5hr done + reieww 1hr done
//v3 works fine with both tests


//MANY TESTS WORKD BUT GOT TLE AS MY CODE IS > O(LOG N) -- OPTIMISE

//3hrs given -- 1.5hrs left

//30mins given again -- found an issue in code - with testcase 3

/*
1
36
1024 1024 1024 16 1024 16 128 512 512 256 512 128 1024 1024 1024 1024 512 256 256 1024 512 256 128 1024 1024 512 32 1024 1024 256 1024 512 512 1024 1024 128
2
4 5
2 --OP --??
3 0
1024 --OP X
* */

//1hr left
public class Q2 extends CodeForces {

    static ArrayList<ArrayList<Integer>> transformsList(int[] arr, int n) {  //O(N)

        ArrayList<ArrayList<Integer>> transforms = new ArrayList<>();

        transforms.add(new ArrayList<>());
        for (int x : arr) {        //O(N)
            transforms.get(0).add(x);
        }

        int i = 0;

        while (n>0) { //O(<<N)
            transforms.add(new ArrayList<>());
            count(transforms, transforms.get(i), i + 1); //O(N)

            if (i > 1 && Arrays.equals(transforms.get(i).toArray(), transforms.get(i - 1).toArray())) {
                break;
            }
            i++;
            n = n/2;
        }

        return transforms;
    }

    static int solution(int[] arr, int a, int k) { //O(N)
        ArrayList<ArrayList<Integer>> transforms = transformsList(arr, arr.length);
        int n = transforms.size();

        if (k > n - 1) {
            k = n - 1;
        }
        return transforms.get(k).get(a - 1);
    }


    //O(N*N)-->O(N) & S(N)
    static void count(ArrayList<ArrayList<Integer>> transforms, ArrayList<Integer> arr, int index) { //O(N)

        HashMap<Integer, Integer> hash = new HashMap<>();

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.addAll(arr);

        // NOW HASH WILL BE HAVING ALL THE ELEMENTS AND THEIR FREQUENCIES
        for (int x : arr2) { //O(N)
            if (!hash.containsKey(x)) {
                hash.put(x, 1);
            } else {
                hash.put(x, hash.get(x) + 1);
            }
        }
//SETTING THE VALUES NEEDED FOR EACH ELEMENT
        for (int x = 0; x < arr2.size(); x++) { //O(N)
            arr2.set(x, hash.get(arr2.get(x)));
        }
//ADDING THESE TO OUR TRANSFORMS
        for (int j = 0; j < arr2.size(); j++) {  //O(N)
            transforms.get(index).add(arr2.get(j));
        }

    }

    public static void main(String[] args) {
        int t = I();

        while (t-- > 0) {
            int n = I();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = I();
            }
            int q = I();
            while (q-- > 0) {
                System.out.println(solution(arr, I(), I()));
            }
        }
    }


}
/*


* */
class Test2 {
    static int[] frequencyCount(int arr[], int n) {
        int p = 2000;
        for (int j = 0; j < n; j++) {
            arr[j] = arr[j] - 1;
        }


        for (int i = 0; i < n; i++) {
            if (arr[i] % p < n) {  //if rem is less than arr size then
                arr[arr[i] % p] = arr[arr[i] % p] + p; //add max size to that index(rem) again and again

            }

        }


        for (int i = 0; i < n; i++) {
            if (arr[i] >= p) { //then it has more counts
                arr[i] = arr[i] / p;
            } else {
                arr[i] = 0;
            }
        }

        return arr;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 91, 1, 2, 5, 6, 2, 5};
        //frequencyCount(arr, arr.length);
        // System.out.println(Arrays.toString(arr));
        myFreqCountSol(arr, 2000);
    }

    //MY EAZY FREUENCY COUNT FUNCTION OF O(N) ANSD S(N)
    static void myFreqCountSol(int[] arr, int max) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int x :
                arr) {
            if (!hash.containsKey(x)) {
                hash.put(x, 1);
            } else {
                hash.put(x, hash.get(x) + 1);
            }
        }

        for (int x : hash.keySet()) {
            System.out.println(x + "->" + hash.get(x));
        }

        //MAP ITERATION WORKS
        for (int x = 0; x < arr.length; x++) {
            arr[x] = hash.get(arr[x]);
        }
        System.out.println(Arrays.toString(arr));

/*        for (Map.Entry<Integer,Integer> entry : hash.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());*/
    }
}





