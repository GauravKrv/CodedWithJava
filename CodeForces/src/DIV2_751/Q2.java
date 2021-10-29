package DIV2_751;

import DIV_111_EDUROUND.CodeForces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
// works for testcase 1 and 2 individually
// count need to be optimised
//took 1.5hrs till here
//work on out of bounds areas , approach is good, check for optimised helper functions

//give 3hrs more to this question -- test timint 1.5hr done

public class Q2 extends CodeForces {

    static ArrayList<ArrayList<Integer>> transformsList(int[] arr, int n) {
       // System.out.println("In transformList");

        ArrayList<ArrayList<Integer>> transforms = new ArrayList<>();

        transforms.add(new ArrayList<>());
        for (int x : arr) {
            transforms.get(0).add(x);
        }
        // System.out.println(transforms.get(0));// -- works fine

        int i = 0;

        while (true) {
            transforms.add(new ArrayList<>());
            System.out.println(transforms.get(0));
            count(transforms, transforms.get(i), i + 1);
             System.out.println(transforms.get(0));
            //System.out.println(transforms.get(i-1));
             System.out.println(transforms.get(i+1));

            //ERROR IN COUNT FUNCTOIN
            if (i > 1 && Arrays.equals(transforms.get(i).toArray(), transforms.get(i - 1).toArray())) {
                break;
            }
            i++;
        }

        return transforms;
    }

    static int solution(int[] arr, int a, int k) {
        ArrayList<ArrayList<Integer>> transforms = transformsList(arr, arr.length);
        int n = transforms.size();
        System.out.println("In SOLUTION");


        if (k > n - 1) {
            k = n - 1;
        }
        System.out.println(transforms.get(k)+" k = "+k);
/*
        System.out.println("Trial  ");
        System.out.println(transforms.size());
        System.out.println(transforms.get(k).size());
        System.out.println("\n");*/
        return transforms.get(k).get(a - 1);
    }


    //O(N*N)-->O(N) & S(N)
    static void count(ArrayList<ArrayList<Integer>> transforms, ArrayList<Integer> arr, int index) {

//        System.out.println("PREVIOUS ARRAY : ");
//        System.out.println(arr);
        HashMap<Integer, Integer> hash = new HashMap<>();

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.addAll(arr);

        for (int x : arr2) {
            if (!hash.containsKey(x)) {
                hash.put(x, 1);
            } else {
                hash.put(x, hash.get(x) + 1);
            }
        }
        //TILL NOW HASH WILL BE HAVING ALL THE ELEMENTS AND THEIR FREQUENCIES

      /*  for (int x : hash.keySet()) {
            System.out.println(x + "->" + hash.get(x));
        }*/
        //PRINTED THE FREQS
        //MAP ITERATION WORKED

//SETTING THE VALUES NEEDED FOR EACH ELEMENT
        for (int x = 0; x < arr2.size(); x++) {
            arr2.set(x, hash.get(arr2.get(x)));
        }
//ADDING THESE TO OUR TRANSFORMS
        for (int j = 0; j < arr2.size(); j++) {
            transforms.get(index).add(arr2.get(j));
        }
//        System.out.println("CURRENT ARRAY : ");
//        System.out.println(arr);
//        System.out.println("\n");
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





